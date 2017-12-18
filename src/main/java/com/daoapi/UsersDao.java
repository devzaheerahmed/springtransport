package com.daoapi;
 
import java.util.List;
 
import com.entities.Users;
 
public interface UsersDao {
    public boolean saveOrUpdate(Users users);
    
    public List<Users> resultcount();
 
    public List<Users> list(int firstresult);
 
    public boolean delete(Users users);
}