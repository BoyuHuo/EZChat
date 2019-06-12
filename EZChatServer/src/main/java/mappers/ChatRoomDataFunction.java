package mappers;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.SqlSession;
import java.io.Reader;
import entity.*;
import java.util.List;


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
    public  List<ChattingRoom> selectChatroom(String userID){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ChatRoomMapper roomMapper = session.getMapper(ChatRoomMapper.class);
            List <ChattingRoom> chattingRooms = roomMapper.selectRoom(userID);
            System.out.println("List");
            return chattingRooms;
        }finally {
            session.close();
        }
    }
}
