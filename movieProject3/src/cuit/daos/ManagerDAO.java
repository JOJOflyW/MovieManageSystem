package cuit.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cuit.pojos.Manager;

public class ManagerDAO {
	
	/*
	 * 由于每一部操作都会用到加载驱动和创建连接
	 *  所以在创建类的时候就加载驱动， 
	 *  并用一个函数得到c
	 */
	public ManagerDAO() {
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
	public List<Manager> findAllManager() {
		List<Manager> userList = new ArrayList<Manager>();
		Connection c;
		try {
			c = getConnection();
			String sql="select * from manager";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Manager manager = new Manager();
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String password = rs.getString(3);

				manager.setName(name);
				manager.setId(id);
				manager.setPassword(password);
				userList.add(manager);
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
	public Manager getManagerById(int userid) {
		Manager manager = null;
		Connection c;
		try {
			String sql = "select * from manager where id = "+userid;
			c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				manager = new Manager();
				int id = rs.getInt(1);
                String name = rs.getString(2);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
                String password = rs.getString(3);
                
                manager.setId(id);
                manager.setName(name);
                manager.setPassword(password);
			}
			ps.close();

			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("失败");
		}
		return manager;
	}
	
	/*查询某个用户名下的人 */
	public Manager getManagerByName(String username) {
		Manager manager = null;
		Connection c;
		try {
			String sql = "select * from manager where name = '" + username + "'";
			c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				manager = new Manager();
				int id = rs.getInt(1);
                String name = rs.getString(2);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
                String password = rs.getString(3);
                
                manager.setId(id);
                manager.setName(name);
                manager.setPassword(password);
			}
			ps.close();

			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("失败");
		}
		return manager;
	}
	/*添加用户信息*/
	public void addManager(Manager manager) {
		Connection c;
		try {
			System.out.println("插入信息"+manager.toString());
			String sql = "insert into manager values(?,?)";
			c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			
			//ps.setInt(1, manager.getId());
            ps.setString(1,manager.getName());
            ps.setString(2,manager.getPassword());
 
            ps.execute();
            
            c.close();
            ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*更新用户信息*/
	public void updateManager(Manager manager) {
		Connection c;
		String sql = "update manager set name= ?, password= ? where id= ?";
		try {
			c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setString(1,manager.getName());
            ps.setString(2,manager.getPassword());
            ps.setInt(3,manager.getId());
            ps.execute();
            
            c.close();
            ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
