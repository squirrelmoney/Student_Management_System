package cn.edu.lingnan.servlet1;

import java.util.Vector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.DAO.departmentDAO;
import cn.edu.lingnan.DAO.financingDAO;
import cn.edu.lingnan.dto.departmentDTO;
import cn.edu.lingnan.dto.financingDTO;

public class insertFinancingsevlet1 extends HttpServlet {
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) 
			throws javax.servlet.ServletException ,java.io.IOException {
	   String Fno=req.getParameter("Fno");
	   String Acno=req.getParameter("Acno");
	   String Mno=req.getParameter("Mno");
	   String Access=req.getParameter("Access");
	   int Budget=Integer.parseInt(req.getParameter("Budget"));
	   financingDTO f=new financingDTO();
	   f.setFno(Fno);
	   f.setAcno(Acno);
	   f.setMno(Mno);
	   f.setBudget(Budget);
	   f.setAccess(Access);
	   financingDAO ft=new financingDAO();
	   int flag=ft.insertIntoFinancing(f);
	   System.out.println(flag);
	   Vector<financingDTO> v=ft.findAllfinancing();
	    HttpSession s=req.getSession();
	    s.setAttribute("allFn",v);
	    HttpSession s1=req.getSession();
	    s1.setAttribute("flag",flag);
	//3°¢∑µªÿ“≥√Ê
	   if(flag==1)
      {
	   resp.sendRedirect(req.getContextPath()+"/chairman/Gfinancing.jsp");
       }
	  else
	  {
		   resp.sendRedirect(req.getContextPath()+"/chairman/gobackFinancing.jsp");
	  }
}
}
