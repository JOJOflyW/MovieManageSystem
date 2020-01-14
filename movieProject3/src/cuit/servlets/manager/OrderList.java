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
import cuit.pojos.Order;
import cuit.pojos.User;
import cuit.pojos.Wishlist;
import cuit.services.OrderService;
import cuit.services.WishlistService;

/**
 * Servlet implementation class OrderList
 */
@WebServlet("/manageorder.do")
public class OrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Manager manager = new Manager();
	
		List<Order> orders = new ArrayList<Order>();
		manager = (Manager) session.getAttribute("manager");
		OrderService orderService = new OrderService();
		
		orders = orderService.findAllOrder();
		
		//System.out.println("oders:"+orders.toString());
		request.setAttribute("order", orders);
		request.getRequestDispatcher("manageorder.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
