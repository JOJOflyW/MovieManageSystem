package cuit.pojos;

public class Wishlist {
	
	private int id;
	private User user;
	private Movie movie;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Wishlist [id=" + id + ", user=" + user + ", movie=" + movie + "]";
	}
	
}
