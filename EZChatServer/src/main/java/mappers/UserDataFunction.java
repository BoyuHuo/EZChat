package mappers;

import entity.Message;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;


public class UserDataFunction {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UserDataFunction() {
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }


    /**
     * User validation
     *
     * @param newuser the user info need to validate
     * @return the validated user info
     */
    public User checkUser(User newuser) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            User user = userMapper.checkUser(newuser);
            return user;
        } finally {
            session.close();
        }
    }

    /**
     * Add a new User into database
     *
     * @param user the new user waiting to be added
     */
    public void addtUser(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            userMapper.insertUser(user);
            session.commit();
        } finally {
            session.close();
        }
    }


    public void deleteUserByID(int ID) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            userMapper.deleteUserByID(ID);
            session.commit();
        } finally {
            session.close();
        }
    }


    /**
     * Update the user info
     *
     * @param user the user waiting to be updated
     */
    public boolean updateUser(User user) {
        SqlSession session = sqlSessionFactory.openSession();
        int result = 0;
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            result = userMapper.updateUser(user);
            session.commit();
        } finally {
            session.close();
            return result > 0 ? true : false;
        }
    }

    public User selectUserByID(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        User user = null;
        try {
            UserMapper userMapper = session.getMapper(UserMapper.class);
            user = userMapper.selectUserByID(id);
        } finally {
            session.close();
            return user;
        }
    }

}
