<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<%@ page import="java.util.*,cn.edu.lingnan.dto.*,javax.servlet.http.HttpServlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<script type="text/javascript">

var flag=0;
flag=<%=session.getAttribute("flag") %>;
if(flag==2)
{
	alert("��ѧ�����ڸ����ţ�����ѡ������");
	history.back();
}
else{
	alert("�ò������Ѵ��ڣ��������ı��");
	history.back();
}

  </script>
</head>

</html>