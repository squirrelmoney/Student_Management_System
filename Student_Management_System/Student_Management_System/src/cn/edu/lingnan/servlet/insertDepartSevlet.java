package cn.edu.lingnan.servlet;

import java.util.Vector;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.DAO.departmentDAO;
import cn.edu.lingnan.dto.departmentDTO;

public class insertDepartSevlet extends HttpServlet {
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) 
			throws javax.servlet.ServletException ,java.io.IOException {
	   String No=req.getParameter("No");
	   String Name=new String(req.getParameter("Name").getBytes("ISO-8859-1"));
	   departmentDTO dt=new departmentDTO();
	   dt.setNo(No);
	   dt.setName(Name);
	   departmentDAO d=new departmentDAO();
	   int flag=d.insertIntodepartment(dt);
	   Vector<departmentDTO> v=d.findAlldepartment();
	    HttpSession s=req.getSession();
	    s.setAttribute("allDepart",v);
	    HttpSession s1=req.getSession();
	    s1.setAttribute("flag1",flag);
	   if(flag==1)
	   {
		   resp.sendRedirect(req.getContextPath()+"/admin/allDepart.jsp");
	   }
	   else
	   {
		   resp.sendRedirect(req.getContextPath()+"/admin/gobackDepart.jsp");
	   }
}
}
