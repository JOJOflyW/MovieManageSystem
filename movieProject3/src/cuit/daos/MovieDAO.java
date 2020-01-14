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


public class MovieDAO {

	public MovieDAO() {
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
	
	
	public List<Movie> findAllMovie() {
		List<Movie> movieList = new ArrayList<Movie>();
		Connection c;
		try {
			c = getConnection();
			String sql="select * from movie";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie();
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp(3));
				//Date date = rs.getTime(3);
				int price = rs.getInt(4);
				System.out.println(price);
				int amount = rs.getInt(5);
				String info = rs.getString(6);
				
				movie.setName(name);
				movie.setId(id);
				movie.setDate(date);
				movie.setPrice(price);
				movie.setAmount(amount);
				movie.setInfo(info);
				movieList.add(movie);
			}
			ps.close();

			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movieList;
	}
	

	public Movie getMovieById(int movieid) {
		Movie movie = null;
		Connection c;
		try {
			String sql = "select * from movie where id = "+movieid;
			System.out.println(sql);
			c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				movie = new Movie();
				int id = movieid;
				String name = rs.getString(2);
				
				String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp(3));
				//Date date = rs.getTime(3);
				int price = rs.getInt(4);
				int amount = rs.getInt(5);
				String info = rs.getString(6);
				
				movie.setName(name);
				movie.setId(id);
				movie.setDate(date);
				movie.setPrice(price);
				movie.setAmount(amount);
				movie.setInfo(info);
			}
			ps.close();

			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movie;
	}
	/*锟斤拷拥锟接帮拷锟较�*/
	public int addMovie(Movie movie) {
		Connection c;
		try {
			System.out.println("鐢靛奖鐨勪俊鎭�:"+movie.toString());
			String sql = "insert into movie values(?,?,?,?,?,?)";
			c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			
			ps.setInt(1, movie.getId());
			ps.setString(2, movie.getName());
			//String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ps.getTimestamp(3));
            ps.setString(3,movie.getDate());
            ps.setInt(4,movie.getPrice());
            ps.setInt(5, movie.getAmount());
            ps.setString(6, movie.getInfo());
            
            
            ps.execute();
            
            c.close();
            ps.close();
            return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public int updateMovie(Movie movie) {
		Connection c;
		
		String sql = "update movie set name= ?, date= ?, price= ?, amount=?, info=? where id= "+movie.getId();
		System.out.println(movie.toString());
		System.out.println(sql);
		try {
			c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			
			//ps.setInt(1, movie.getId());
			ps.setString(1, movie.getName());
			ps.setString(2,movie.getDate());
            ps.setInt(3,movie.getPrice());
            ps.setInt(4, movie.getAmount());
            ps.setString(5, movie.getInfo());
            
            ps.execute();
            
            c.close();
            ps.close();
            
            return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	
	public int deleteMovie(int movieid) {
		Order order = null;
		Connection c;
		try {
			String sql = "delete from movie where id = " + movieid;
			c = getConnection();
			Statement s = c.createStatement();
			s.execute(sql);
			System.out.println("删锟斤拷锟缴癸拷:"+movieid);
			s.close();
			c.close();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("删锟斤拷失锟斤拷");
			return 0;
		}
	}
	
}
