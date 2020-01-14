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
@WebServlet("/wish.del")
public class WishDel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int wishlistid = Integer.parseInt(request.getParameter("id"));
		
		
		WishlistService wishlistService = new WishlistService();
		wishlistService.deletWishlist(wishlistid);
		
		request.getRequestDispatcher("wishlist.do").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
