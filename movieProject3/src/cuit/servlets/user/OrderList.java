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

import cuit.pojos.Order;
import cuit.pojos.User;
import cuit.pojos.Wishlist;
import cuit.services.OrderService;
import cuit.services.WishlistService;

/**
 * Servlet implementation class OrderList
 */
@WebServlet("/order.do")
public class OrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User user = new User();
		List<Order> orders = new ArrayList<Order>();
		user = (User) session.getAttribute("user");
		OrderService orderService = new OrderService();
		
		orders = orderService.getOrderByUserNo(user.getId());
		
		System.out.println("oders:"+orders.toString());
		request.setAttribute("order", orders);
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
