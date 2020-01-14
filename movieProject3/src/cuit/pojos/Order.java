package cuit.pojos;

import java.util.Date;

public class Order {
	
	
	private int id;
	private int movieid;
	private int userid;
	
	private User user; 
	private Movie movie;
	 
	
	//private String moviename;
	
	private String seat;
	private int amount;
	private String date;
	
	public Order(int id,int movieid,int userid,
			String seat,int amount,String date,Movie movie,User user) {
		this.id = id;
		this.movieid = movieid;
		this.userid = userid;
		this.seat = seat;
		this.amount = amount;
		this.date = date;
		//this.moviename = moviename;
		this.movie = movie;
		this.user = user;
	}
	
    public Order() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	/*
	 * public String getMoviename() { return moviename; }
	 * 
	 * public void setMoviename(String moviename) { this.moviename = moviename; }
	 */
	
	
	
}
