package cn.edu.lingnan.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorityFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
          
		  //如果登陆用户的权限不为3（普通用户）某些页面不能访问，给一个不能访问的页面
		HttpServletRequest req=(HttpServletRequest) arg0;
		HttpServletResponse resp=(HttpServletResponse) arg1;
		HttpSession s=req.getSession();
		Integer flag=(Integer)s.getAttribute("sSuper");
		if(flag!=null){
		if(flag==3){//如果登陆用户权限为3（管理员）你可以访问你想访问的页面
			 arg2.doFilter(arg0, arg1);
		}//else if(flag==1){//如果登陆用户权限为1（会长）你可以访问部分页面
//			resp.sendRedirect(req.getContextPath()+"/admin/chairman/*");
//		}else if(flag==2){//如果登陆用户权限为2（会员）你可以访问部分页面
//			resp.sendRedirect(req.getContextPath()+"/admin/member/*");
//		}
		else if(flag==1){
			resp.sendRedirect(req.getContextPath()+"/chairman/chairmam.jsp");
		}else if(flag==2){
			 
			resp.sendRedirect(req.getContextPath()+"/members/members.jsp");
		}else{
			resp.sendRedirect(req.getContextPath()+"/members/authority.html");
		}
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		

	}

}
