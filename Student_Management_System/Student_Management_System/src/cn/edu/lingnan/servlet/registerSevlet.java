package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.DAO.memberDAO;
import cn.edu.lingnan.dto.memberDTO;

public class registerSevlet extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	 //1、获取页面传递过来的参数
	   String mno=req.getParameter("Mno");
	   String sname=new String(req.getParameter("Username").getBytes("ISO-8859-1"));
	   String password=req.getParameter("password1");
	   int age=Integer.parseInt(req.getParameter("Age"));
	   String gender=new String(req.getParameter("Gender").getBytes("ISO-8859-1"));
	   String depart=req.getParameter("Depart");
	   String title=new String(req.getParameter("Title").getBytes("ISO-8859-1"));
	   String ano=req.getParameter("Ano");
	   int sSuper=Integer.parseInt(req.getParameter("sSuper"));
	   memberDTO m=new memberDTO();
	   m.setMno(mno);
	   m.setSname(sname);
	   m.setPassword(password);
	   m.setAge(age);
	   m.setGender(gender);
	   m.setDepart(depart);
	   m.setTitle(title);
	   m.setAno(ano);
	   m.setsSuper(sSuper);
	   //2、处理参数、调用业务逻辑
	   memberDAO md=new memberDAO();
	   int flag= md.insertIntomember(m);
	   if(flag==1)
		   resp.sendRedirect(req.getContextPath()+"/homepage.html");
	   else
		   resp.sendRedirect(req.getContextPath()+"/goback.jsp");
		   
	  
}
}
