package cn.edu.lingnan.servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.DAO.activitiesDAO;
import cn.edu.lingnan.DAO.associationsDAO;
import cn.edu.lingnan.dto.activitiesDTO;
import cn.edu.lingnan.dto.associationsDTO;

public class FindActivitiesSevlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	  throws ServletException, IOException {
			
			 //����DAO���������û���Ϣ
			activitiesDAO ad=new activitiesDAO();
			Vector<activitiesDTO> v=ad.findAllactivities();
			HttpSession s=req.getSession();
			s.setAttribute("allAc",v);
			//���ص�member.jsp����ʾ���ҵ��������û���Ϣ
			resp.sendRedirect(req.getContextPath()+"/admin/allActivities.jsp");
	}
}
