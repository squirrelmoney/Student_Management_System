<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://lingnan.edu.cn" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<t:hello/>
<sql:setDataSource
var="mydb"
driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost:3306/association"
user="root"
password="123"
/>
<sql:query var="result" dataSource="${mydb}" sql="select * from members"/>
<c:forEach var="re" items="${result.rows}">
<tr><c:out value="${re.Mno}"></c:out></tr>
</c:forEach>
</body>
</html>














