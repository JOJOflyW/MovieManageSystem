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
	 * ����ÿһ�����������õ����������ʹ�������
	 *  �����ڴ������ʱ��ͼ��������� 
	 *  ����һ�������õ�c
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
	 * �����Ƕ��û����һЩ����
	 *  1.��ѯ�����û�
	 *  2.��ѯĳ���û��� 
	 *  //3.ɾ��ĳ�û�
	 *  4.���ĳ�û�
	 *  5.����ĳ�û���Ϣ
	 */
	
	/*��ѯ�����û�*/
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
			System.out.println("��ѯ�����û���Ϣʧ��");
		}
		return userList;
	}
	
	/*��ѯĳ���û�id�µ��� */
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
			System.out.println("ʧ��");
		}
		return user;
	}
	
	/*��ѯĳ���û����µ��� */
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
			System.out.println("ʧ��");
		}
		return user;
	}
	/*����û���Ϣ*/
	public void addUser(User user) {
		Connection c;
		try {
			System.out.println("������Ϣ"+user.toString());
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
	
	/*�����û���Ϣ*/
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
