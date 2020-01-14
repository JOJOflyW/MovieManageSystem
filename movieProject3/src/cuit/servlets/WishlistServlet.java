package cuit.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import cuit.services.WishlistService;

/**
 * Servlet implementation class WishlistServlet
 */
@WebServlet("/wishlistServlet")
public class WishlistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		String id = request.getParameter("id");
		int wishlistid =  Integer.parseInt(id);
		
		WishlistService wishlistService = new WishlistService();
		
		if(action.equals("del")) {
			wishlistService.deletWishlist(wishlistid);
			request.getRequestDispatcher("listwish.do").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
