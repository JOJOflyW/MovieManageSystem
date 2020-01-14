package cuit.servlets.user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cuit.pojos.Movie;
import cuit.pojos.Order;
import cuit.pojos.User;
import cuit.services.MovieService;
import cuit.services.OrderService;

/**
 * Servlet implementation class UserDoServlet
 */
@WebServlet("/buy.do")
public class BuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String  id = request.getParameter("movieid");
		
		int movieid = Integer.parseInt(id);
		Movie movie = new Movie();
		User user = new User();
		Order order = new Order();
		HttpSession session = request.getSession(false);
		if(session!=null) {
			user = (User) session.getAttribute("user");
			//System.out.println(user.toString());
			order.setUser(user);
			}
		
		
		MovieService movieService = new MovieService();
		movie = movieService.getMovieById(movieid);
		order.setMovie(movie);
		
		String date;
		Date ndate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date = dateFormat.format(ndate);
		order.setDate(date);
		
		String seat = request.getParameter("movieseat");
		int amount = Integer.parseInt(request.getParameter("movieticket")) ;
		int sum = Integer.parseInt(request.getParameter("moviemoney"));
		
		order.setSeat(seat);
		order.setAmount(amount);
		order.setMovieid(movie.getId());
		order.setUserid(user.getId());
		
		System.out.println(user.toString());
		OrderService orderService = new OrderService();
		orderService.addOrder(order);
		//System.out.println(order.toString());
		request.getRequestDispatcher("order.do").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
