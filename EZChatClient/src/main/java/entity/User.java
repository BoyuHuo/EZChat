package entity;

public class User {
    private String id;
    private String account;
    private String username;
    private String password;
    private String gender;
    private String email;

    public User(){}
    public User(String id, String account, String username, String password, String gender, String email){
        this.id = id;
        this.account = account;
        this.username = username;
        this.password = password;
        this.gender = gender;
        this.email = email;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String toString(){
        String result = ""+id+","+account+","+username+","+password+","+gender+","+email;
        return result.replace("@","*"); //Since the "@" is indentifier of the our TCP header, we replace it with "*"
    }

}
