package cn.edu.lingnan.servlet1;
import java.util.Vector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.DAO.activitiesDAO;
import cn.edu.lingnan.dto.activitiesDTO;

public class insertActivitiesSevlet extends HttpServlet {
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) 
			throws javax.servlet.ServletException ,java.io.IOException {
		activitiesDAO ac=new activitiesDAO();
    	activitiesDTO a=new activitiesDTO();
    	String Acno=req.getParameter("Acno"); 
    	String Acname=new String(req.getParameter("Acname").getBytes("ISO-8859-1"));
    	String Ano=req.getParameter("Ano");
    	String Mno=req.getParameter("Mno");
    	String Access=req.getParameter("Access");
	    a.setAcno(Acno);
		a.setAcname(Acname);
		a.setAno(Ano);
		a.setMno(Mno);
		a.setAccess(Access);
	    int flag=ac.insertIntoactivities(a);
    	Vector<activitiesDTO> v=ac.findAllactivities();
 	    HttpSession s=req.getSession();
 	    s.setAttribute("allAc",v);
	    HttpSession s1=req.getSession();
	    s1.setAttribute("flag",flag);
    	//3°¢∑µªÿ“≥√Ê
 	   if(flag==1)
	   {
		   resp.sendRedirect(req.getContextPath()+"/chairman/Cactivities.jsp");
	   }
	   else
	   {
		   resp.sendRedirect(req.getContextPath()+"/chairman/gobackAc.jsp");
	   }
}
}
