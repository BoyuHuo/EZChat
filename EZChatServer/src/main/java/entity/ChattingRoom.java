package entity;

import java.util.List;

public class ChattingRoom {
    private String id;
    private String token;
    private String name;
    private List<Message> messageList;

    public ChattingRoom(String token,String roomname){
        this.token=token;
        this.name= roomname;
    }

    public ChattingRoom(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessageList(){ return messageList; }

    public void setMessageList(List<Message> list){ this.messageList= list; }

    public String toString(){
        return ""+id+","+token+","+name;
    }
}
