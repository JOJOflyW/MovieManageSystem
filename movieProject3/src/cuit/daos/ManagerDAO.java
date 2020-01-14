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
	 * ����ÿһ�����������õ����������ʹ�������
	 *  �����ڴ������ʱ��ͼ��������� 
	 *  ����һ�������õ�c
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
	 * �����Ƕ��û����һЩ����
	 *  1.��ѯ�����û�
	 *  2.��ѯĳ���û��� 
	 *  //3.ɾ��ĳ�û�
	 *  4.���ĳ�û�
	 *  5.����ĳ�û���Ϣ
	 */
	
	/*��ѯ�����û�*/
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
			System.out.println("��ѯ�����û���Ϣʧ��");
		}
		return userList;
	}
	
	/*��ѯĳ���û�id�µ��� */
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
			System.out.println("ʧ��");
		}
		return manager;
	}
	
	/*��ѯĳ���û����µ��� */
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
			System.out.println("ʧ��");
		}
		return manager;
	}
	/*����û���Ϣ*/
	public void addManager(Manager manager) {
		Connection c;
		try {
			System.out.println("������Ϣ"+manager.toString());
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
	
	/*�����û���Ϣ*/
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
