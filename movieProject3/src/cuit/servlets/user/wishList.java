package cuit.servlets.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cuit.pojos.Wishlist;
import cuit.pojos.User;
import cuit.pojos.Wishlist;
import cuit.services.WishlistService;
import cuit.services.WishlistService;

/**
 * Servlet implementation class WishlistList
 */
@WebServlet("/wishlist.do")
public class wishList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User user = new User();
		List<Wishlist> wishlists = new ArrayList<Wishlist>();
		user = (User) session.getAttribute("user");
		WishlistService wishlistService = new WishlistService();
		
		wishlists = wishlistService.getWishlistByid(user.getId());
		
		System.out.println("wishes:"+wishlists.toString());
		request.setAttribute("movieList", wishlists);
		request.getRequestDispatcher("wishlist.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
