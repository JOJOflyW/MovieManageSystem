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

import cuit.pojos.Order;
import cuit.services.OrderService;
import cuit.services.WishlistService;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/nageorder.do")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String action = request.getParameter("action");
		
	
		int orderid =  Integer.parseInt(id);
		
		OrderService odOrderService = new OrderService();
		if(action.equals("del")) {
			odOrderService.deleteOrder(orderid);
			request.getRequestDispatcher("listuserorder.do").forward(request, response);
		}
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
