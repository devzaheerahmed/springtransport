package com.entities;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


 
@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Integer user_id;
 
    @Column(name = "user_name")
    private String user_name;
 
    @Column(name = "email")
    private String email;
    
    @Column(name = "level")
    private String level;
    
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "userlogin", unique=true)
    private String user_login;
    
  
   

	public Integer getUser_id() {
        return user_id;
    }

	public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }
 
    public String getUser_name() {
        return user_name;
    }
 
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getPassword() {  
    	
		return password;
	}

	public void setPassword(String password) {
		
		this.password = password;
		
	}

	public String getUser_login() {
		return user_login;
	}

	public void setUser_login(String user_login) {
		this.user_login = user_login;
	}

	
}