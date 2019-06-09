package entity;

public class User {
    private String username;
    private String password;
    private String gender;
    private String email;
    private int id;
    
    
    public User() {
		
	}
	
	
	public User(int ID,String name,String password,String email,String gender) {
		this.id= ID;
		this.username= name;
		this.password= password;
		this.email= email;
		this.gender= gender;
	}
    
    /**
	 * This method returns the value of the database column USER.user_id
	 * @return  the value of USER.user_id
	 */
	public int getId(){
		return id;   
	}     
	
	
	/**
	 * This method sets the value of the database column USER.user_id
	 */
	public void setId(int id){
		this.id = id;
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
}
