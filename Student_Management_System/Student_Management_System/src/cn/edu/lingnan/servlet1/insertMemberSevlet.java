package cn.edu.lingnan.servlet1;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.DAO.memberDAO;
import cn.edu.lingnan.dto.memberDTO;

public class insertMemberSevlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		 //1、获取页面传递过来的参数
		   String mno=req.getParameter("Mno");
		   String sname=new String(req.getParameter("Username").getBytes("ISO-8859-1"));
		   String password=req.getParameter("Password1");
		   int age=Integer.parseInt(req.getParameter("Age"));
		   String gender=new String(req.getParameter("Gender").getBytes("ISO-8859-1"));
		   String depart=req.getParameter("Depart");
		   String title=new String(req.getParameter("Title").getBytes("ISO-8859-1"));
		   String ano=req.getParameter("Ano");
		   int sSuper=Integer.parseInt(req.getParameter("sSuper"));
		   memberDTO m=new memberDTO();
		   HttpSession s2=req.getSession();
		   s2.setAttribute("Ano",ano);
		   m.setMno(mno);
		   m.setSname(sname);
		   m.setPassword(password);
		   m.setAge(age);
		   m.setGender(gender);
		   m.setDepart(depart);
		   m.setTitle(title);
		   m.setAno(ano);
		   m.setsSuper(sSuper);
		   memberDAO md=new memberDAO();
		   int flag=md.insertIntomember(m);
		   Vector<memberDTO> v=md.findAllMember();
		   HttpSession s=req.getSession();
		   s.setAttribute("allMem",v);
		    HttpSession s1=req.getSession();
		    s1.setAttribute("flag",flag);
		    
		   //3、返回页面
		   if(flag==1)
		   {
			   resp.sendRedirect(req.getContextPath()+"/chairman/Cmember.jsp");
		   }
		   else
		   {
			   resp.sendRedirect(req.getContextPath()+"/chairman/gobackmember.jsp");
		   }
		   
	}

}
