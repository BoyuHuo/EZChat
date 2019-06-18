package entity;

public class Message {


    private String id = "";
    // 消息
    private String message="";
    private int room_id;

    private int user_id;
    private String createTime="";

    private String user_name="";

    private String client;

    private int type_flag = 0;




    public Message() {
        super();
    }

    public Message(String username,String message){
        super();
        this.user_name=username;
        this.message= message;
    }

    public Message(String roomID, String userID, String message) {
        super();
        this.room_id= Integer.parseInt(roomID);
        this.user_id= Integer.parseInt(userID);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getId(){ return this.id; }

    public void setId(String id){ this.id= id; }

    public int getRoom_id(){ return room_id; }

    public void setRoom_id(int roomID){ this.room_id= roomID; }

    public int getUser_id(){ return this.user_id; }

    public void setUser_id(int userID){ this.user_id= userID; }

    public String getCreateTime(){ return this.createTime; }

    public void setCreateTime(String time){ this.createTime= time; }


    @Override
    public String toString() {
        return id+"@"+room_id+"@"+user_id+"@"+user_name+"@"+message.replace("@","*");
    }
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getType_flag() {
        return type_flag;
    }

    public void setType_flag(int type_flag) {
        this.type_flag = type_flag;
    }
}