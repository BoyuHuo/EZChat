package entity;

import java.util.ArrayList;
import java.util.Observable;

public class ChatManager extends Observable {
    static private String message;
    static private ArrayList<User> users;

    synchronized public String getMessage() {
        return message;
    }

    synchronized public void setMessage(String message) {
        ChatManager.message = message;
        setChanged();
        notifyObservers();
    }

    synchronized public ArrayList<User> getUsers() {
        return users;
    }

    synchronized public void setUsers(ArrayList<User> users) {
        ChatManager.users = users;
        setChanged();
        notifyObservers();
    }
}
