package cuit.servlets.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cuit.pojos.Movie;
import cuit.services.MovieService;

/**
 * Servlet implementation class SearchMovie
 */
@WebServlet("/movie01.do")
public class MovieInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int movieid = Integer.parseInt(request.getParameter("id"));
		MovieService  movieService = new MovieService();
		Movie movie = new Movie();
		movie = movieService.getMovieById(movieid);
		System.out.println(movie.toString());
		request.setAttribute("movie", movie);
		request.getRequestDispatcher("Movie01.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
