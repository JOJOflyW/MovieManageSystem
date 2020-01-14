package cuit.servlets.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cuit.pojos.Movie;
import cuit.pojos.User;
import cuit.pojos.Wishlist;
import cuit.services.MovieService;
import cuit.services.WishlistService;

/**
 * Servlet implementation class WishDo
 */
@WebServlet("/wish.add")
public class WishAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int movieid = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession(false);
		User user = new User();
		Movie movie = new Movie();
		Wishlist wishlist = new Wishlist();
		if(session!=null) {
			user = (User) session.getAttribute("user");
			wishlist.setUser(user);
		}
		MovieService movieService = new MovieService();
		movie = movieService.getMovieById(movieid);
		wishlist.setMovie(movie);
		
		WishlistService wishlistService = new WishlistService();
		wishlistService.addWishlist(wishlist);
		
		request.getRequestDispatcher("wishlist.do").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
