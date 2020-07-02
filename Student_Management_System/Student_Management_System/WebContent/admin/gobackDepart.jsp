<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
<script type="text/javascript">
var flag1=0;
flag1=<%=session.getAttribute("flag1") %>;
if(flag1==0)
{
	alert("学院编号已存在");
	history.back();
}

  </script>
</head>
<body>

</body>
</html>