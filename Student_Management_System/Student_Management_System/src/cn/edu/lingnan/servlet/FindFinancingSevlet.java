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


public class FindFinancingSevlet extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		 //����DAO���������û���Ϣ
		financingDAO f=new financingDAO();
		Vector<financingDTO> v=f.findAllfinancing();
		HttpSession s=req.getSession();
		s.setAttribute("allFn",v);
		//���ص�member.jsp����ʾ���ҵ��������û���Ϣ
		resp.sendRedirect(req.getContextPath()+"/admin/allFinancing.jsp");
}
}
