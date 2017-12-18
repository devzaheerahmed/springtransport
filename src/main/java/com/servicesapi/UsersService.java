package com.servicesapi;

import java.util.List;
import com.entities.Users;

public interface UsersService {
	public boolean saveOrUpdate(Users users);
	
	public List<Users> resultcount();

	public List<Users> list(int firstresult);

	public boolean delete(Users users);
}