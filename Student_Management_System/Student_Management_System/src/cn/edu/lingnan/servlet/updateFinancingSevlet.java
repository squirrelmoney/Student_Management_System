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
		 //1.��ȡ��ҳ�洫���Ĳ���
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
    	//2.�������ݣ�����ҵ���߼�
    	flag=fd.updatefiancing(ft);
	}else{//ɾ��һ��
		if(f.equals("delete")){
			//1.��ȡ����
			String Fno=req.getParameter("Fno");
			ft.setFno(Fno);
			//2.����ҵ���߼�
			flag=fd.deleteFinancing(Fno);
			//
		}else{//����ɾ��
				String[] allFno=req.getParameterValues("Fno");
				System.out.println(allFno);
				String[] temp=allFno[0].split(",");
				for(String a:temp){
			    flag=fd.deleteFinancing(a);
				   }
			   }
		}
		
	//����DAO���������û���Ϣ������ҳ����Ϣ
	Vector<financingDTO> v=fd.findAllfinancing();
	    HttpSession s=req.getSession();
	    s.setAttribute("allFn",v);
	//3������ҳ��
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
