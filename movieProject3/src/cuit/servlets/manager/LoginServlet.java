package cuit.servlets.manager;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cuit.pojos.Manager;
import cuit.services.ManagerService;


@WebServlet("/managelogin.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("managername");
		String password = request.getParameter("password");
		System.out.println(name+password);
		String logininfo = null;
		HttpSession session = request.getSession();
		
		Manager manager = new Manager();
		ManagerService managerService  = new ManagerService();
		
		if(managerService.getManagerByName(name)!=null) {
			manager = managerService.getManagerByName(name);
			if(password.equals(manager.getPassword())) {
				session.setAttribute("manager", manager);
				response.sendRedirect("manageorder.do");
				//request.getRequestDispatcher("index.jsp").forward(request, response);
				System.out.println("³É¹¦");
			}else {
				System.out.println("Ê§°Ü");
				request.getRequestDispatcher("managerlogin.jsp").forward(request, response);
			}
		}else {
			System.out.println("Ê§°Ü");
			request.getRequestDispatcher("managerlogin.jsp").forward(request, response);
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
