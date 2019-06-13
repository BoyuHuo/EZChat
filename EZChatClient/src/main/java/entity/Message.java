package entity;

public class Message {

    private String id = "";
    private String client;
    // 消息
    private String message;
    private String room_id;
    private String user_id = "";
    private String user_name;
    private String createTime;


    public Message() {
        super();
    }

    public Message(String username, String message){
        super();
        this.client=username;
        this.message= message;
    }

    public Message(String roomID, String userID, String message) {
        super();
        this.room_id= roomID;
        this.user_id= userID;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName(){ return this.client; }

    public void setName(String username){ this.client= username; }

    public String getId(){ return this.id; }

    public void setId(String id){ this.id= id; }

    public String getRoom_id(){ return room_id; }

    public void setRoom_id(String roomID){ this.room_id= roomID; }

    public String getUser_id(){ return this.user_id; }

    public void setUser_id(String userID){ this.user_id= userID; }

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
}