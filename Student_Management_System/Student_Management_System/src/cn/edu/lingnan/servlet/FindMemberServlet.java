package cn.edu.lingnan.servlet;
import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.lingnan.DAO.memberDAO;
import cn.edu.lingnan.dto.memberDTO;

public class FindMemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        //调用DAO查找所有用户信息
		memberDAO md=new memberDAO();
		Vector<memberDTO> v=md.findAllMember();
		HttpSession s=req.getSession();
		s.setAttribute("allMem",v);
		//返回到member.jsp并显示查找到的所有用户信息
		resp.sendRedirect(req.getContextPath()+"/admin/allMem.jsp");
	}
}
