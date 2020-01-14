package cuit.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cuit.pojos.User;

public class UserDAO {
	
	/*
	 * 由于每一部操作都会用到加载驱动和创建连接
	 *  所以在创建类的时候就加载驱动， 
	 *  并用一个函数得到c
	 */
	public UserDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error loading Mysql Driver!");
		}
	}
	
	public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/mvdb?serverTimezone=CTT&useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false","root","123456");
    }
	
	/*
	 * 以下是对用户表的一些操作
	 *  1.查询所有用户
	 *  2.查询某个用户名 
	 *  //3.删除某用户
	 *  4.添加某用户
	 *  5.更新某用户信息
	 */
	
	/*查询所有用户*/
	public List<User> findAllUser() {
		List<User> userList = new ArrayList<User>();
		Connection c;
		try {
			c = getConnection();
			String sql="select * from user";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);

				user.setName(name);
				user.setId(id);
				user.setPassword(password);
				userList.add(user);
			}
			ps.close();

			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询所有用户信息失败");
		}
		return userList;
	}
	
	/*查询某个用户id下的人 */
	public User getUserById(int userid) {
		User user = null;
		Connection c;
		try {
			String sql = "select * from user where id = "+userid;
			c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				int id = rs.getInt(1);
                String name = rs.getString(2);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
                String password = rs.getString(3);
                
                user.setId(id);
                user.setName(name);
                user.setPassword(password);
			}
			ps.close();

			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("失败");
		}
		return user;
	}
	
	/*查询某个用户名下的人 */
	public User getUserByName(String username) {
		User user = null;
		Connection c;
		try {
			String sql = "select * from user where name = '" + username + "'";
			c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				int id = rs.getInt(1);
                String name = rs.getString(2);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
                String password = rs.getString(3);
                
                user.setId(id);
                user.setName(name);
                user.setPassword(password);
			}
			ps.close();

			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("失败");
		}
		return user;
	}
	/*添加用户信息*/
	public void addUser(User user) {
		Connection c;
		try {
			System.out.println("插入信息"+user.toString());
			String sql = "insert into user values(?,?)";
			c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			
			//ps.setInt(1, user.getId());
            ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
 
            ps.execute();
            
            c.close();
            ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*更新用户信息*/
	public void updateUser(User user) {
		Connection c;
		String sql = "update user set name= ?, password= ? where id= ?";
		try {
			c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1,user.getName());
            ps.setString(2,user.getPassword());
            ps.setInt(3,user.getId());
            ps.execute();
            
            c.close();
            ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
