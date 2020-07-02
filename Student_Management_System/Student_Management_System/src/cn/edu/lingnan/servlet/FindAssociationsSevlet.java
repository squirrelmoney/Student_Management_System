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

public class FindAssociationsSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	 //����DAO���������û���Ϣ
		associationsDAO ad=new associationsDAO();
		Vector<associationsDTO> v=ad.findAllassociations();
		HttpSession s=req.getSession();
		s.setAttribute("allAsso",v);
		//���ص�member.jsp����ʾ���ҵ��������û���Ϣ
		resp.sendRedirect(req.getContextPath()+"/admin/allAssociations.jsp");
    }
}
