package cuit.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cuit.pojos.Wishlist;
import cuit.servlets.user.wishList;
import cuit.pojos.User;
import cuit.pojos.Movie;

public class WishlistDAO {
	Movie movie = new Movie();
	User user = new User();
	MovieDAO movieDAO = new MovieDAO();
	UserDAO userDAO = new UserDAO();
	public WishlistDAO(){
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
	
	//鏌ヨ蹇冩効鍗�
	public List<Wishlist> getWishlistByid(int user_id) {
		List<Wishlist> wishList = new ArrayList<Wishlist>();
		Connection c;
		try {
			c = getConnection();
			/*
			String sql1="select * from user where id =" + user_id;
			PreparedStatement ps1 = c.prepareStatement(sql1);
			*/
			String sql2="select * from wishlist where user_id =" + user_id;
			PreparedStatement ps2 = c.prepareStatement(sql2);
			
			//ResultSet rs1 = ps1.executeQuery();
			ResultSet rs2 = ps2.executeQuery();
	
			
			/*
			while(rs1.next()) {
				user.setId(rs1.getInt(1));
				user.setName(rs1.getString(2));
				user.setPassword(rs1.getString(3));
			}
			*/
			while (rs2.next()) {
				Wishlist wishlist = new Wishlist();
		
				wishlist.setId(rs2.getInt(1));	
				
				movie = movieDAO.getMovieById(rs2.getInt(2));
				System.out.println(movie.toString());
				user = userDAO.getUserById(rs2.getInt(3));
				wishlist.setMovie(movie);
				wishlist.setUser(user);
				
				/*
				 * movie.setId(rs2.getInt(2)); wishlist.setMovie(movie);
				 * 
				 * user.setId(rs2.getInt(3)); wishlist.setUser(user);
				 */
				
				wishList.add(wishlist);
			}
			
			//rs1.close();
			rs2.close();
			//rs3.close();

			c.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return wishList;
	}
	
	//娣诲姞蹇冩効鍗�
	public int addWishlist(Wishlist wishlist) {
		Connection c;
		try {
			String sql = "insert into wishlist(movie_id,user_id) values(?,?)";
			c = getConnection();
			PreparedStatement ps = c.prepareStatement(sql);
			
			//ps.setInt(1, wishlist.getId());
			ps.setInt(1, wishlist.getMovie().getId());
			ps.setInt(2, wishlist.getUser().getId());
			
			ps.execute();
			c.close();
            ps.close();
            return 1;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	//鍒犻櫎蹇冩効鍗�
	public int deletWishlist(int wishlistid) {
		Wishlist wishlist = null;
		Connection c;
		try {
			String sql = "delete from wishlist where id = " + wishlistid;
			c = getConnection();
			Statement s = c.createStatement();
			s.execute(sql);

			s.close();
			c.close();
			return 1;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
