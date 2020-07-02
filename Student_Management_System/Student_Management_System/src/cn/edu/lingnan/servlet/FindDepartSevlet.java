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


public class FindDepartSevlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        //����DAO���������û���Ϣ
		departmentDAO dt=new departmentDAO();
		Vector<departmentDTO> v=dt.findAlldepartment();
		HttpSession s=req.getSession();
		s.setAttribute("allDepart",v);
		//���ص�member.jsp����ʾ���ҵ��������û���Ϣ
		resp.sendRedirect(req.getContextPath()+"/admin/allDepart.jsp");
	}
}
