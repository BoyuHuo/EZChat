package entity;

public class Message {
    // 用户名
    String client;
    // 消息
    String message;

    public Message() {
        super();
    }

    public Message(String client, String message) {
        super();
        this.client = client;
        this.message = message;
    }

    public String getName() {
        return client;
    }

    public void setName(String name) {
        this.client = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message [client=" + client + ", message=" + message + "]";
    }

}