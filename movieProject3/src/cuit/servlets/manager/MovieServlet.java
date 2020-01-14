package cuit.servlets.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import cuit.services.MovieService;
import cuit.pojos.Movie;

/**
 * Servlet implementation class MovieServlet
 */
@WebServlet("/movie.do")
public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MovieService service = new MovieService();
		String action = request.getParameter("action");
		
		//添加电影信息
		if(action.equals("add")) {
			response.setContentType("text/html;charset=utf-8");
			String ID = request.getParameter("id");
			int id = Integer.parseInt(ID);
			String name= request.getParameter("name");
			String date = request.getParameter("date");
			String Price = request.getParameter("price");
			int price = Integer.parseInt(Price);
			String Amount = request.getParameter("amount");
			int amount = Integer.parseInt(Amount);
			String info = request.getParameter("info");
			
			Movie movie = new Movie();
			movie.setId(id);
			movie.setName(name);
			movie.setDate(date);
			movie.setPrice(price);
			movie.setAmount(amount);
			movie.setInfo(info);
			MovieService movieservice = new MovieService();
			System.out.println(movie.toString());
			movieservice.addMovie(movie);
			request.getRequestDispatcher("managemovie.do").forward(request, response);
		}else 
			//更新电影信息
			if(action.equals("update")) {
				response.setContentType("text/html;charset=utf-8");
				String ID = request.getParameter("id");
				int id = Integer.parseInt(ID);
				String name= request.getParameter("name");
				String date = request.getParameter("date");
				String Price = request.getParameter("price");
				int price = Integer.parseInt(Price);
				String Amount = request.getParameter("amount");
				int amount = Integer.parseInt(Amount);
				String info = request.getParameter("info");
				
				Movie m = new Movie();
				m.setId(id);
				m.setName(name);
				m.setDate(date);
				m.setPrice(price);
				m.setAmount(amount);
				m.setInfo(info);
				MovieService movieservice = new MovieService();
				
				movieservice.updateMovie(m);
				Movie updatemovie = service.getMovieById(id);
				request.setAttribute("updatemovie", updatemovie);
				request.getRequestDispatcher("Movie.jsp").forward(request, response);
				/*
				PrintWriter out = response.getWriter();
				out.print("更新成功");
				*/
			}
			else
				//删除电影信息
				if(action.equals("delete")) {
					//Movie movie = new Movie();
				String ID = request.getParameter("id");
				int id = Integer.parseInt(ID);
				service.deleteMovie(id);
									
				request.getRequestDispatcher("managemovie.do").forward(request, response);
			}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
