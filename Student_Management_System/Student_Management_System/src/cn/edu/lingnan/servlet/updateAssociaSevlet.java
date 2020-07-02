package cn.edu.lingnan.servlet;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.DAO.associationsDAO;
import cn.edu.lingnan.dto.associationsDTO;
import cn.edu.lingnan.dto.memberDTO;


public class updateAssociaSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	boolean flag=false;
    	String f=req.getParameter("f");
    	associationsDAO ad=new associationsDAO();
    	if(f==null){
    		 //1.获取从页面传来的参数
        	String Ano=req.getParameter("Ano"); 
        	String Aname=new String(req.getParameter("Aname").getBytes("ISO-8859-1"));
        	String Mno=req.getParameter("Mno");
        	String Depart=req.getParameter("Depart");
        	associationsDTO a=new associationsDTO();
        	a.setAno(Ano);
        	a.setAname(Aname);
        	a.setMno(Mno);
        	a.setDepart(Depart);
        	//2.处理数据，调用业务逻辑
        	flag=ad.updateAssociations(a);
    	}else{//删除一条
    		if(f.equals("delete")){
    			//1.获取参数
    			String Ano=req.getParameter("Ano");
    			associationsDTO a=new associationsDTO();
    			a.setAno(Ano);
    			//2.调用业务逻辑
    			flag=ad.deleteassociations(Ano);
    			//
    		}else{//批量删除
    				String[] allAno=req.getParameterValues("Ano");
    				String[] temp=allAno[0].split(",");
    				for(String a:temp){
    			    flag=ad.deleteassociations(a);
    				   }
    			   }
    		}
    		
    	//调用DAO查找所有用户信息，更新页面信息
    	Vector<associationsDTO> v=ad.findAllassociations();
 	    HttpSession s=req.getSession();
 	    s.setAttribute("allAsso",v);
    	//3、返回页面
 	   if(flag)
	   {
		   resp.sendRedirect(req.getContextPath()+"/admin/allAssociations.jsp");
	   }
	   else
	   {
		   resp.sendRedirect(req.getContextPath()+"/admin/admin.jsp");
	   }
       
    }
}
