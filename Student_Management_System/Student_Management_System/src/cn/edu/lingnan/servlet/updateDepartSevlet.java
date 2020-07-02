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
    		 //1.��ȡ��ҳ�洫���Ĳ���
        	String No=req.getParameter("No"); 
        	String Name=new String(req.getParameter("Name").getBytes("ISO-8859-1"));
        	d.setNo(No);
        	d.setName(Name);
        	//2.�������ݣ�����ҵ���߼�
        	flag=dt.updatedepartment(d);
    	}else{//ɾ��һ��
    			//1.��ȡ����
    			String No=req.getParameter("No");
    			d.setNo(No);
    			//2.����ҵ���߼�
    			flag=dt.deletedepartment(No);
    		
    			   }
    		
    	//����DAO���������û���Ϣ������ҳ����Ϣ
    	Vector<departmentDTO> v=dt.findAlldepartment();
 	    HttpSession s=req.getSession();
 	    s.setAttribute("allDepart",v);
    	//3������ҳ��
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
