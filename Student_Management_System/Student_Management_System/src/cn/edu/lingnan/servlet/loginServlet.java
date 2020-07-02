package cn.edu.lingnan.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import cn.edu.lingnan.DAO.memberDAO;

public class loginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//1����ȡ�ͻ����ύ�Ĳ���
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String Ano=req.getParameter("Ano");
		System.out.println("loginservlet:"+username+"   "+password+"  "+Ano);
		//2���������������ҵ���߼�
		memberDAO m=new memberDAO();
		int sSuper=m.findMemberByNameAndPassword(username,password,Ano);
		System.out.println(" "+username+" "+password+"  "+Ano);
		HttpSession s=req.getSession();
		s.setAttribute("sSuper",sSuper);
		HttpSession s1=req.getSession();
		s1.setAttribute("Ano",Ano);
		HttpSession s2=req.getSession();
		s2.setAttribute("Mno",username);
		//3�����ݷ��صĽ������
		if(sSuper==3){
			resp.sendRedirect(req.getContextPath()+"/admin/admin.jsp");
		}else if(sSuper==1){
			resp.sendRedirect(req.getContextPath()+"/chairman/chairmam.jsp");
		}
		else if(sSuper==2){
			resp.sendRedirect(req.getContextPath()+"/chairman/core.jsp");
		}
		else{
			resp.sendRedirect(req.getContextPath()+"/error.html");
		}
	}
	

}
