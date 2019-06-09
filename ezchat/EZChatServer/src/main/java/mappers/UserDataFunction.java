package mappers;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import entity.User;


public class UserDataFunction {
	private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader; 
 
    static{
        try{
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
    
    
    /**
     * Select user by ID
     */
    public User selectUserByID(int ID) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper  = session.getMapper(UserMapper.class);
            User user= userMapper.selectUserByID(ID);
            return user;
        } finally {
            session.close();
        }
    }
     
    
    public void addUser(User user){
        SqlSession session = sqlSessionFactory.openSession();
        try {
        	UserMapper userMapper  = session.getMapper(UserMapper.class);
            userMapper.insert(user);
            session.commit();
            System.out.println("add completed");
        } finally {
            session.close();
        }
    }
    
    
    public void updateUser(User user){
        SqlSession session = sqlSessionFactory.openSession();
        try {
        	UserMapper userMapper  = session.getMapper(UserMapper.class);
            userMapper.updateByPrimaryKey(user);
            session.commit();
            System.out.println("update completed");
        } finally {
            session.close();
        }
    }
    
    
    public List<User> findUserByName(String name) {
        SqlSession session = sqlSessionFactory.openSession();
         
        try{
        	UserMapper userMapper  = session.getMapper(UserMapper.class);
            List<User> userList = userMapper.findUserByName(name);   
            session.commit();
            return userList;
        }finally {
            session.close();
        }       
    }
    
    
    public void deleteUserByID(int ID) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper  = session.getMapper(UserMapper.class);
            userMapper.deleteUserByID(ID);
            session.commit();
            System.out.println("delete completed");
        } finally {
            session.close();
        }
    } 
    
}
