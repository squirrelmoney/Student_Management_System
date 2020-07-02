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
        //调用DAO查找所有用户信息
		departmentDAO dt=new departmentDAO();
		Vector<departmentDTO> v=dt.findAlldepartment();
		HttpSession s=req.getSession();
		s.setAttribute("allDepart",v);
		//返回到member.jsp并显示查找到的所有用户信息
		resp.sendRedirect(req.getContextPath()+"/admin/allDepart.jsp");
	}
}
