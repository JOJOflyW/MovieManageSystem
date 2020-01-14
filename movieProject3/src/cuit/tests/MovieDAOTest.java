package cuit.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cuit.daos.MovieDAO;
import cuit.pojos.Movie;

public class MovieDAOTest {

	/*
	@Test	
	public void TestFindAllStudent() {
		List<Movie> movies = new ArrayList<Movie>();
		MovieDAO movieDAO = new MovieDAO();
		movies = movieDAO.findAllMovie();
		for (Movie movie : movies) {
			System.out.println(movie.toString());
		}
	}
	
	
	
	@Test	
	public void TestAddMovie() {
		List<Movie> movies = new ArrayList<Movie>();
		Movie movie = new Movie(3,"����6","2019-12-08 16:49:35",66,36,"��������");
		MovieDAO movieDAO = new MovieDAO();
		movieDAO.addMovie(movie);
		for (Movie movie1 : movies) {
			System.out.println(movie1.toString());
		}
	}*/
	/*
	@Test	
	public void TestUpdateMovie() {
		Movie movie = new Movie(3,"妇联5","2019-12-08 16:49:35",88,10,"这是续集");
		MovieDAO movieDAO = new MovieDAO();
		
		movieDAO.updateMovie(movie);
		
		List<Movie> movies = movieDAO.findAllMovie();
		for (Movie movie2 : movies) {
			System.out.println(movie2.toString());
		}
	}*/
	@Test	
	public void TestGetMovieById() {
		Movie movie = new Movie();
		MovieDAO movieDAO = new MovieDAO();
		movie = movieDAO.getMovieById(3);
			System.out.println(movie.toString());
	}
	
}
