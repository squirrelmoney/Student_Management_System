package cn.edu.lingnan.servlet;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.DAO.departmentDAO;
import cn.edu.lingnan.dto.departmentDTO;

public class updateDepartSevlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	boolean flag=false;
    	String f=req.getParameter("f");
    	departmentDAO dt=new departmentDAO();
    	departmentDTO d=new departmentDTO();
    	if(f=="update"){
    		 //1.获取从页面传来的参数
        	String No=req.getParameter("No"); 
        	String Name=new String(req.getParameter("Name").getBytes("ISO-8859-1"));
        	d.setNo(No);
        	d.setName(Name);
        	//2.处理数据，调用业务逻辑
        	flag=dt.updatedepartment(d);
    	}else{//删除一条
    			//1.获取参数
    			String No=req.getParameter("No");
    			d.setNo(No);
    			//2.调用业务逻辑
    			flag=dt.deletedepartment(No);
    		
    			   }
    		
    	//调用DAO查找所有用户信息，更新页面信息
    	Vector<departmentDTO> v=dt.findAlldepartment();
 	    HttpSession s=req.getSession();
 	    s.setAttribute("allDepart",v);
    	//3、返回页面
 	   if(flag)
	   {
		   resp.sendRedirect(req.getContextPath()+"/admin/allDepart.jsp");
	   }
	   else
	   {
		   resp.sendRedirect(req.getContextPath()+"/admin/admin.jsp");
	   }
       
    }
}
