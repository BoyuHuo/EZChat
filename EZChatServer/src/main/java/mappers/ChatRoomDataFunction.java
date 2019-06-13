package mappers;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSession;
import java.io.Reader;
import java.util.List;

import entity.*;


public class ChatRoomDataFunction{
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

    public ChatRoomDataFunction(){
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }

    public void addChatRoom(ChattingRoom room){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ChatRoomMapper roomMapper  = session.getMapper(ChatRoomMapper.class);
            roomMapper.insertRoom(room);
            session.commit();
            System.out.println("add room completed");
        } finally {
            session.close();
        }
    }

    public List<Message> selectAllMessage(ChattingRoom room){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ChatRoomMapper roomMapper  = session.getMapper(ChatRoomMapper.class);
            List<Message> list= roomMapper.selectAllMessage(room);
            UserMapper userMapper= session.getMapper(UserMapper.class);
            for(Message msg:list){
                User user=userMapper.selectUserByID(msg.getUser_id());
                msg.setName(user.getUsername());
            }
            room.setMessageList(list);
            System.out.println("select messages completed");
            return list;
        } finally {
            session.close();
        }
    }

    public ChattingRoom selectRoomByID(String id){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ChatRoomMapper roomMapper  = session.getMapper(ChatRoomMapper.class);
            ChattingRoom newroom= roomMapper.selectRoomByID(id);
            System.out.println("select room completed");
            return newroom;
        } finally {
            session.close();
        }
    }


}
