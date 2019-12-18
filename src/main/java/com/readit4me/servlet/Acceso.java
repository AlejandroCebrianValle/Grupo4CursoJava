package com.readit4me.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.readit4me.loginBeanDAO.*;

/**
 * Servlet implementation class Acceso
 */
public class Acceso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginDAO loginDao;
	
	public void init() {
        loginDao = new LoginDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("userName");
        String password = request.getParameter("contrasenna");
        LoginBean loginBean = new LoginBean();
        loginBean.setUsername(username);
        loginBean.setPassword(password);
        
        try {
        	int codUser = loginDao.validate(loginBean);
        	
            if (codUser != -1) {
                HttpSession session = request.getSession();
                session.setAttribute("codUser", codUser);
                response.sendRedirect("principal.jsp");
            } else {
                //HttpSession session = request.getSession();
                //session.setAttribute("user", username);
                response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
