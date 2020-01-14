package cuit.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cuit.daos.UserDAO;
import cuit.pojos.User;
public class UserDAOTest {

	/*
	@Test	
	public void TestFindAllUser() {
		List<User> users = new ArrayList<User>();
		UserDAO userDAO = new UserDAO();
		users = userDAO.findAllUser();
		for (User user : users) {
			System.out.println(user.toString());
		}
	}
	
	@Test	
	public void TestGetUserByName() {
		User user = new User();
		UserDAO userDAO = new UserDAO();
		user = userDAO.getUserByName("wfj");
			System.out.println(user.toString());
	}
	
	@Test	
	public void TestAddUser() {
		List<User> users = new ArrayList<User>();
		User user = new User(5,"jj","11341");
		UserDAO userDAO = new UserDAO();
		userDAO.addUser(user);
		for (User user1 : users) {
			System.out.println(user1.toString());
		}
	}
	*/
	@Test	
	public void TestUpdateUser() {
		User user = new User(5,"jj","11389");
		UserDAO userDAO = new UserDAO();
		
		userDAO.updateUser(user);
		List<User> users = userDAO.findAllUser();
		for (User user2 : users) {
			System.out.println(user2.toString());
		}
	}
}
