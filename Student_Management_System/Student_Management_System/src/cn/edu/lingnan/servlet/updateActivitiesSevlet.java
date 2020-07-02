package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.edu.lingnan.DAO.activitiesDAO;
import cn.edu.lingnan.dto.activitiesDTO;


public class updateActivitiesSevlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	boolean flag=false;
    	String f=req.getParameter("f");
    	activitiesDAO ac=new activitiesDAO();
    	activitiesDTO a=new activitiesDTO();
    	if(f==null){
    		 //1.��ȡ��ҳ�洫���Ĳ���
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
        	//2.�������ݣ�����ҵ���߼�
        	flag=ac.updateactivities(a);
    	}else{//ɾ��һ��
    		if(f.equals("delete")){
    			//1.��ȡ����
    			String Acno=req.getParameter("Acno");
    			a.setAcno(Acno);
    			//2.����ҵ���߼�
    			flag=ac.deleteactivities(Acno);
    			//
    		}else{//����ɾ��
    				String[] allAcno=req.getParameterValues("Acno");
    				System.out.println(allAcno);
    				String[] temp=allAcno[0].split(",");
    				for(String b:temp){
    			    flag=ac.deleteactivities(b);
    				   }
    			   }
    		}
    		
    	//����DAO���������û���Ϣ������ҳ����Ϣ
    	Vector<activitiesDTO> v=ac.findAllactivities();
 	    HttpSession s=req.getSession();
 	    s.setAttribute("allAc",v);
	    HttpSession s1=req.getSession();
	    s1.setAttribute("flag",flag);
    	//3������ҳ��
 	   if(flag)
	   {
		   resp.sendRedirect(req.getContextPath()+"/admin/allActivities.jsp");
	   }
	   else
	   {
		   resp.sendRedirect(req.getContextPath()+"/admin/admin.jsp");
	   }
    }
}
