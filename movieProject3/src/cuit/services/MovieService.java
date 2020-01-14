package cuit.services;

import java.util.List;

import cuit.daos.MovieDAO;
import cuit.pojos.Movie;

public class MovieService {
	private MovieDAO movieDAO = new MovieDAO();
	
	public List<Movie> findAllMovie(){
		return movieDAO.findAllMovie();
	}
	
	public Movie getMovieById(int movieid) {
		Movie movie = null;
		if(movieDAO.getMovieById(movieid)!=null) {
			movie = movieDAO.getMovieById(movieid);
			return movie;
		}else {
			System.out.println("数据库中没有这个用户："+movieid);
			return null;
		}
		
	}
	
	public void addMovie(Movie movie) {
		movieDAO.addMovie(movie);
	}
	
	public int deleteMovie(int movieid) {
		int flag = movieDAO.deleteMovie(movieid);
		return flag;
	}
	
	public void updateMovie(Movie movie) {
		movieDAO.updateMovie(movie);
	}
}
