package cn.edu.lingnan.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginout extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
        HttpSession s=req.getSession();
        s.invalidate();
        System.out.println("1111111");
        resp.sendRedirect(req.getContextPath()+"/login.html");
}
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 doGet(req,resp);
	}
}
