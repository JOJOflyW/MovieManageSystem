package cuit.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cuit.pojos.User;
import cuit.services.UserService;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(name+password);
		String logininfo = null;
		HttpSession session = request.getSession();
		
		User user = new User();
		UserService userService  = new UserService();
		
		if(userService.getUserByName(name)!=null) {
			user = userService.getUserByName(name);
			if(password.equals(user.getPassword())) {
				session.setAttribute("user", user);
				request.getRequestDispatcher("allmovie.do").forward(request, response);
				//request.getRequestDispatcher("index.jsp").forward(request, response);
				System.out.println("³É¹¦");
			}else {
				System.out.println("Ê§°Ü");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}else {
			System.out.println("Ê§°Ü");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
