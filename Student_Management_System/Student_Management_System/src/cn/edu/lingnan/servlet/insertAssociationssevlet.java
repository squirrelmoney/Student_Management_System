package cn.edu.lingnan.servlet;

import java.util.Vector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.DAO.associationsDAO;
import cn.edu.lingnan.DAO.financingDAO;
import cn.edu.lingnan.dto.associationsDTO;
import cn.edu.lingnan.dto.financingDTO;

public class insertAssociationssevlet extends HttpServlet {
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) 
			throws javax.servlet.ServletException ,java.io.IOException {
		String Ano=req.getParameter("Ano"); 
    	String Aname=new String(req.getParameter("Aname").getBytes("ISO-8859-1"));
    	String Mno=req.getParameter("Mno");
    	String Depart=req.getParameter("depart");
    	associationsDTO a=new associationsDTO();
    	a.setAno(Ano);
    	a.setAname(Aname);
    	a.setMno(Mno);
    	a.setDepart(Depart);
    	associationsDAO ad=new associationsDAO();
	   int flag=ad.insertIntoassociations(a);
		   System.out.println(flag);
	   	//调用DAO查找所有用户信息，更新页面信息
	   	Vector<associationsDTO> v=ad.findAllassociations();
		    HttpSession s=req.getSession();
		    s.setAttribute("allAsso",v);
		    HttpSession s1=req.getSession();
		    s1.setAttribute("flag",flag);
	   	//3、返回页面
	   if(flag==1)
	   {
		   resp.sendRedirect(req.getContextPath()+"/admin/allAssociations.jsp");
	   }
	   else
	   {
		   resp.sendRedirect(req.getContextPath()+"/admin/gobackAssociation.jsp");
	   }
}
}
