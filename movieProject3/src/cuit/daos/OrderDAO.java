package cuit.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cuit.pojos.Movie;
import cuit.pojos.Order;
import cuit.pojos.User;

public class OrderDAO {

	MovieDAO movieDAO = new MovieDAO();
	UserDAO userDAO = new UserDAO();
	
	Movie movie = new Movie();
	User user = new User();
	public OrderDAO() {
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
	
	public List<Order> findAllOrder() {
		List<Order> orderList = new ArrayList<Order>();
		Connection c;
		try {
			c = getConnection();
			String sql="select * from `order`";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				
				int id = rs.getInt(1);
				int movie_id = rs.getInt(2);
				int user_id = rs.getInt(3);
				String seat = rs.getString(4);
				int amount = rs.getInt(5);
				String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp(6));

				movie = movieDAO.getMovieById(movie_id);
				System.out.println(movie.toString());
				user = userDAO.getUserById(user_id);
				order.setMovie(movie);
				order.setUser(user);
				order.setId(id);
				order.setMovieid(movie_id);
				order.setUserid(user_id);
				order.setSeat(seat);
				order.setAmount(amount);
				order.setDate(date);
				
				orderList.add(order);
			}
			c.close();
			ps.close();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}
	
	public List<Order> getOrderByUserNo(int userid) {
		List<Order> orderList = new ArrayList<Order>();
		Connection c;
		try {
			String sql = "select * from `order` where user_id = "+userid;
			c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				
				int id = rs.getInt(1);
				int movie_id = rs.getInt(2);
				int user_id = rs.getInt(3);
				String seat = rs.getString(4);
				int amount = rs.getInt(5);
				String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp(6));
				System.out.println(movie_id);
				movie = movieDAO.getMovieById(movie_id);
				user = userDAO.getUserById(user_id);
				System.out.println(movie.toString());
				order.setMovie(movie);
				order.setUser(user);
				order.setId(id);
				order.setMovieid(movie_id);
				order.setUserid(user_id);
				
				
				
				order.setSeat(seat);
				order.setAmount(amount);
				order.setDate(date);
				
				orderList.add(order);
			}
			ps.close();

			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderList;
	}
	/*锟斤拷佣锟斤拷锟�*/
	public void addOrder(Order order) {
		Connection c;
		try {
			String sql = "insert into `order` values(?,?,?,?,?,?)";
			c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1,order.getId());
            ps.setInt(2,order.getMovieid());
            ps.setInt(3,order.getUserid());
            ps.setString(4,order.getSeat());
            ps.setInt(5,order.getAmount());
            ps.setString(6,order.getDate());
            ps.execute();
            
            c.close();
            ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*删锟斤拷锟斤拷锟斤拷*/
	public void deleteOrder(int orderid) {
		Order order = null;
		Connection c;
		try {
			String sql = "delete from `order` where id = " + orderid;
			c = getConnection();
			Statement s = c.createStatement();
			s.execute(sql);
			System.out.println("璁㈠崟鐨刬d:"+orderid);
			s.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
