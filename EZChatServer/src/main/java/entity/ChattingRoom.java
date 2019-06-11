package entity;

public class ChattingRoom {
    private String id;
    private String token;
    private String name;

    public ChattingRoom(String token,String roomname){
        this.token=token;
        this.name= roomname;
    }

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
}
