package cuit.services;

import java.util.List;

import cuit.daos.UserDAO;
import cuit.pojos.User;

public class UserService {
	private UserDAO userDAO = new UserDAO();
	
	public List<User> findAllUser(){
		return userDAO.findAllUser();
	}
	
	public User getUserByName(String name) {
		User user = null;
		if(userDAO.getUserByName(name)!=null) {
			user = userDAO.getUserByName(name);
			return user;
		}else {
			System.out.println("数据库中没有这个用户："+name);
			return null;
		}
		
	}
	public User getUserById(int userid) {
		User user = null;
		if(userDAO.getUserById(userid)!=null) {
			user = userDAO.getUserById(userid);
			return user;
		}else {
			System.out.println("数据库中没有这个用户："+userid);
			return null;
		}
		
	}
	
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
}
