package cuit.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cuit.pojos.User;
import cuit.pojos.Wishlist;
import cuit.services.WishlistService;

/**
 * Servlet implementation class Listwish
 */
@WebServlet("/listwish.do")
public class Listwish extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		//int id = Integer.parseInt((String) session.getAttribute("user"));
		User user = new User();
		List<Wishlist> Wishlists= new ArrayList<Wishlist>(); 
		user = (User) session.getAttribute("user");
		WishlistService wishlistService = new WishlistService();
		Wishlists = wishlistService.getWishlistByid(user.getId());
		request.setAttribute("wishlists", Wishlists);
		request.getRequestDispatcher("listwishs.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
