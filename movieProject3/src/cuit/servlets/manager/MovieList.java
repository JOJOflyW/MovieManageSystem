package cuit.servlets.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cuit.pojos.Manager;
import cuit.pojos.Movie;
import cuit.pojos.User;
import cuit.pojos.Wishlist;
import cuit.services.MovieService;
import cuit.services.WishlistService;

/**
 * Servlet implementation class MovieList
 */
@WebServlet("/managemovie.do")
public class MovieList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Manager manager = new Manager();
	
		List<Movie> movies = new ArrayList<Movie>();
		manager = (Manager) session.getAttribute("manager");
		MovieService movieService = new MovieService();
		
		movies = movieService.findAllMovie();
		
		//System.out.println("oders:"+movies.toString());
		request.setAttribute("movie", movies);
		request.getRequestDispatcher("managemovie.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
