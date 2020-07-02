package cn.edu.lingnan.servlet1;

import java.awt.List;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.DAO.memberDAO;
import cn.edu.lingnan.dto.memberDTO;

public class updateMemServlet extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	   boolean flag=false;
	   memberDAO md=new memberDAO();
	   String f=req.getParameter("f");
	   if(f==null)
	    {//更新
		 //1、获取页面传递过来的参数
		   String Mno=new String(req.getParameter("Mno").getBytes("ISO-8859-1"));
		   String Ano=new String(req.getParameter("Ano").getBytes("ISO-8859-1"));
		  // String sname=req.getParameter("Sname");
		   String sname=new String(req.getParameter("Sname").getBytes("ISO-8859-1"));
		   String password=req.getParameter("password");
		   int age=Integer.parseInt(req.getParameter("Age"));
		   String gender=new String(req.getParameter("Gender").getBytes("ISO-8859-1"));
		   String depart=req.getParameter("Depart");
		   String title=new String(req.getParameter("Title").getBytes("ISO-8859-1"));
		   int sSuper=Integer.parseInt(req.getParameter("sSuper"));
		   HttpSession s1=req.getSession();
		   s1.setAttribute("Ano",Ano);
		   memberDTO m=new memberDTO();
		   m.setMno(Mno);
		   m.setSname(sname);
		   m.setPassword(password);
		   m.setAge(age);
		   m.setGender(gender);
		   m.setDepart(depart);
		   m.setTitle(title);
		   m.setAno(Ano);
		   m.setsSuper(sSuper);
		   //2、处理参数、调用业务逻辑
		   flag=md.updatemember(m);
		   
	   } else {
		   if(f.equals("delall")){
			   Vector<String> v1=new Vector<String>();
		     	 String[] temp=req.getParameterValues("MnoAno");
		     	 String[] MA=temp[0].split(",");
		     	 for(String a:MA){
		     		   v1.add(a);
		     	   }
		     	 for(int i=0;i<v1.size();i=i+2){
		     		md.deletemember(v1.firstElement(),v1.lastElement());
		     	   }
		   }
	   
	  else{//删除一条记录
			   //1获取页面传递过来的参数
			    Vector<String> v1=new Vector<String>();
		     	 String[] temp=req.getParameterValues("MnoAno");
		     	 String[] MA=temp[0].split(",");
		     	   for(String a:MA){
		     		   v1.add(a);
		     	   }
		     	  //2处理传递过来的参数，调用业务逻辑
		     	  flag=md.deletemember(v1.firstElement(),v1.lastElement());
		     	 HttpSession s1=req.getSession();
				   s1.setAttribute("Ano",v1.lastElement());
				   flag=true;
		   }
	   }

	   Vector<memberDTO> v=md.findAllMember();
	   HttpSession s=req.getSession();
	   s.setAttribute("allMem",v);
	   
	   //3、返回页面
	   if(flag)
	   {
		   resp.sendRedirect(req.getContextPath()+"/chairman/Cmember.jsp");
	   }
	   else
	   {
		   resp.sendRedirect(req.getContextPath()+"/chairman/admin.jsp");
	   }
	   
   }
      
}
