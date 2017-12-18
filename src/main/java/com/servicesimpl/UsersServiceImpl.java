package com.servicesimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.daoapi.UsersDao;
import com.entities.Users;
import com.servicesapi.UsersService;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDao userDao;

	public boolean saveOrUpdate(Users users) {
		return userDao.saveOrUpdate(users);
	}
	
	public List<Users> resultcount() {
		// TODO Auto-generated method stub
		return userDao.resultcount();
	}

	public List<Users> list(int firstresult) {
		// TODO Auto-generated method stub
		return userDao.list(firstresult);
	}

	public boolean delete(Users users) {
		// TODO Auto-generated method stub
		return userDao.delete(users);
	}

}
