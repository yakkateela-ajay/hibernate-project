package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;


@WebServlet("/signup")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/registerview.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fullname = request.getParameter("fullname"); //  get the email value from the jsp/html page
		String email = request.getParameter("email"); //  get the password value from the jsp/html page
		String password = request.getParameter("password"); //  get the confirm password value from the jsp/html page
		System.out.println("check dopost 1");

		
		User user=new User();
		user.setFullName(fullname);
		user.setEmail(email);
		user.setPassword(password);
		System.out.println("check dopost 2");
		
		UserDao userdao=new UserDao();
		System.out.println("check userdao");
		int checkUser = userdao.signUp(user);
		if(checkUser!=0)
		{
			request.setAttribute("message", "Registration Successful");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/LoginView.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("message", "Check your email and password");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/registerview.jsp");
			rd.forward(request, response);
		}
	}

}
