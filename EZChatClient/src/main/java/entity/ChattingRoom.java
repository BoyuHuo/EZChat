package entity;

import java.util.List;

public class ChattingRoom {
    private int id;
    private String token;
    private String name;
    private List<Message> messageList;

    public ChattingRoom(String token,String roomname){
        this.token=token;
        this.name= roomname;
    }

    public ChattingRoom(){}

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



    public void setId(int id) {
        this.id = id;
    }
    public int getId(){
        return id;
    }

    public String toString(){
        return ""+id+","+token+","+name;
    }
}
