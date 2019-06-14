package entity;

import java.util.ArrayList;
import java.util.Observable;

public class ChatManager extends Observable {
    private String message ="";
    private ArrayList<String> users = new ArrayList<>();

    private static ChatManager instance = new ChatManager();



    private ChatManager(){}


    public static ChatManager getInstance(){
        return instance;
    }


    synchronized public String getMessage() {
        return message;
    }

    synchronized public void setMessage(String message) {
        this.message = message;

        setChanged();

        notifyObservers(this);
    }

    synchronized public ArrayList<String> getUsers() {
        return users;
    }

    synchronized public void setUsers(ArrayList<String> users) {
        this.users = users;
        setChanged();
        notifyObservers(this);
    }
}
