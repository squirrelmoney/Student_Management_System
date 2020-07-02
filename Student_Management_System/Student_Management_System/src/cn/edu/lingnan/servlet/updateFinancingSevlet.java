package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.DAO.financingDAO;
import cn.edu.lingnan.dto.financingDTO;


public class updateFinancingSevlet extends HttpServlet {
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	boolean flag=false;
	String f=req.getParameter("f");
	financingDAO fd=new financingDAO();
	financingDTO ft=new financingDTO();
	if(f==null){
		 //1.获取从页面传来的参数
    	String Fno=req.getParameter("Fno"); 
    	String Acno=req.getParameter("Acno"); 
    	String Mno=req.getParameter("Mno");
    	int Budget=Integer.parseInt(req.getParameter("Budget"));
    	String Access=req.getParameter("Access");
    	ft.setFno(Fno);
    	ft.setAcno(Acno);
    	ft.setMno(Mno);
    	ft.setBudget(Budget);
    	ft.setAccess(Access);
    	//2.处理数据，调用业务逻辑
    	flag=fd.updatefiancing(ft);
	}else{//删除一条
		if(f.equals("delete")){
			//1.获取参数
			String Fno=req.getParameter("Fno");
			ft.setFno(Fno);
			//2.调用业务逻辑
			flag=fd.deleteFinancing(Fno);
			//
		}else{//批量删除
				String[] allFno=req.getParameterValues("Fno");
				System.out.println(allFno);
				String[] temp=allFno[0].split(",");
				for(String a:temp){
			    flag=fd.deleteFinancing(a);
				   }
			   }
		}
		
	//调用DAO查找所有用户信息，更新页面信息
	Vector<financingDTO> v=fd.findAllfinancing();
	    HttpSession s=req.getSession();
	    s.setAttribute("allFn",v);
	//3、返回页面
	   if(flag)
   {
	   resp.sendRedirect(req.getContextPath()+"/admin/allFinancing.jsp");
   }
   else
   {
	   resp.sendRedirect(req.getContextPath()+"/admin/admin.jsp");
   }
}
}
