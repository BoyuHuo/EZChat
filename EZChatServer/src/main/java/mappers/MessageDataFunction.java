package mappers;

import entity.Message;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class MessageDataFunction {
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

    public MessageDataFunction(){
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }

    public void addMessage(Message msg){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MessageMapper msgMapper  = session.getMapper(MessageMapper.class);
            msgMapper.insertMessage(msg);
            session.commit();
            System.out.println("add message completed");
        } finally {
            session.close();
        }
    }

    public List<Message> selectMessage(String id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MessageMapper msgMapper  = session.getMapper(MessageMapper.class);
            List<Message> messages = new ArrayList<>();
            messages = msgMapper.selectMessage(id);
            return messages;
        } finally {
            session.close();
        }
    }

    public void updateMessage(Message msg) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            MessageMapper msgMapper  = session.getMapper(MessageMapper.class);
            msgMapper.updateMessage(msg);
            session.commit();
        } finally {
            session.close();
        }
    }

}
