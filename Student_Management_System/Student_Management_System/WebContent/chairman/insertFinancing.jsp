<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ page import="java.util.*,cn.edu.lingnan.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加财务</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script type="text/javascript" src="check.js"></script>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

	
	<!-- ================= Favicon ================== -->
    <!-- Standard -->
    <link rel="shortcut icon" href="http://placehold.it/64.png/000/fff">
    <!-- Retina iPad Touch Icon-->
    <link rel="apple-touch-icon" sizes="144x144" href="http://placehold.it/144.png/000/fff">
    <!-- Retina iPhone Touch Icon-->
    <link rel="apple-touch-icon" sizes="114x114" href="http://placehold.it/114.png/000/fff">
    <!-- Standard iPad Touch Icon--> 
    <link rel="apple-touch-icon" sizes="72x72" href="http://placehold.it/72.png/000/fff">
    <!-- Standard iPhone Touch Icon--> 
    <link rel="apple-touch-icon" sizes="57x57" href="http://placehold.it/57.png/000/fff">
	
	<!-- Styles -->
    <link href="assets/css/lib/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/lib/themify-icons.css" rel="stylesheet">
    <link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/lib/simdahs.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
    
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../assets/css/material-bootstrap-wizard.css" rel="stylesheet" />

 <link title="style1" rel="stylesheet" href="assets/css/1/style.css" type="text/css" />
 <link title="style2" rel="alternate stylesheet" href="assets/css/1/style2.css" type="text/css" />
 <link title="style3" rel="alternate stylesheet" href="assets/css/1/style3.css" type="text/css" />
 <script type="text/javascript" src="delete.js"></script>
 <meta http-equiv="Content-Type" content="text/html; charset=gb2312">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>社团财务</title>
	
	<!-- ================= Favicon ================== -->
    <!-- Standard -->
    <link rel="shortcut icon" href="http://placehold.it/64.png/000/fff">
    <!-- Retina iPad Touch Icon-->
    <link rel="apple-touch-icon" sizes="144x144" href="http://placehold.it/144.png/000/fff">
    <!-- Retina iPhone Touch Icon-->
    <link rel="apple-touch-icon" sizes="114x114" href="http://placehold.it/114.png/000/fff">
    <!-- Standard iPad Touch Icon--> 
    <link rel="apple-touch-icon" sizes="72x72" href="http://placehold.it/72.png/000/fff">
    <!-- Standard iPhone Touch Icon--> 
    <link rel="apple-touch-icon" sizes="57x57" href="http://placehold.it/57.png/000/fff">
	
	<!-- Styles -->
    <link href="assets/css/lib/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/lib/themify-icons.css" rel="stylesheet">
    <link href="assets/css/lib/mmc-chat.css" rel="stylesheet" />
    <link href="assets/css/lib/sidebar.css" rel="stylesheet">
    <link href="assets/css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="assets/css/lib/simdahs.css" rel="stylesheet">
    <link href="assets/css/style.css" rel="stylesheet">
</head>
<body >

	<sql:setDataSource
	var="mydb"
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/association"
	user="root"
	password="123"
	/>
	<!--  Made With Material Kit  -->
<a href="Cfinancing.jsp" class="made-with-mk">
	<div class="brand">返回</div>
	<div class="made-with"><strong>上一页</strong>(财务)</div>
</a>
    <div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
        <div class="nano">
            <div class="nano-content">
                <ul>
					<li class="label">Main</li>
					<li><a class="sidebar-sub-toggle"><i class="ti-layout-grid4-alt"></i> Table <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                        <ul>
                             <li><a href="Cmember.jsp">社团成员管理</a></li>
                            <li><a href="Cassociations.jsp">社团管理</a></li>
                            <li><a href="Cactivities.jsp">社团活动管理</a></li>
                            <li><a href="Cfinancing.jsp">社团财务管理</a></li>
                        </ul>
                    </li>
					<li class="label">Form</li>
				
					<li><a class="sidebar-sub-toggle"><i class="ti-target"></i> Pages <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                        <ul>
                            <li><a href="../login.html">Login</a></li>
                            <li><a href="../register.jsp">Register</a></li>
                            
                        </ul>
                    </li>
					
                    
                    <li><a href="../loginout"><i class="ti-close"></i> Logout</a></li>
                </ul>
            </div>
        </div>
    </div><!-- /# sidebar -->



    <div class="header">
        <div class="pull-left">
            <div class="logo" id="sideLogo">
                  <a href="../homepage.html">
                    <img class="full-logo" src="assets/images/logo-big.png" alt="SimDahs">
                    <img class="small-logo" src="assets/images/logo-small.png" alt="SimDahs">
                </a>
            </div>
            <div class="hamburger sidebar-toggle">
                <span class="ti-menu"></span>
            </div>
        </div>

        <div class="pull-right p-r-15">
            <ul>
                <li class="header-icon dib"><i class="ti-bell"></i>
                    <div class="drop-down">
                        <div class="dropdown-content-heading">
                            <span class="text-left">Recent Notifications</span>
                        </div>
                        <div class="dropdown-content-body">
                            <ul>
                                <li><a href="../massage.jsp"><i class="ti-user"></i> <span>massage</span></a></li>
                                <li><a href="../logout"><i class="ti-power-off"></i> <span>Logout</span></a></li>
                            </ul>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
<div class="unix-login">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-lg-offset-3"  style="width:80%;float:none;margin:auto;" >
					<div class="login-content">
						<div class="login-form">
							<h4>Register to Administration</h4>
							<div class="form_content"  style="width:100%;margin-top:0;">
							<form name="form" action="insertFinancing1">
                                            
								<div class="col-sm-5 col-sm-offset-1">
                              	<div class="form-group label-floating">
									<label>财务表编号：</label>
									<input type="text" name="Fno" id="Fno" class="form-control">
								</div>	
								</div>
								 <div class="col-sm-5">
                              	<div class="form-group label-floating">
									<label>活动编号:</label>
								 <sql:query var="result" dataSource="${mydb}" >
			                         select * from activities where Ano='<%=session.getAttribute("Ano")%>';
			                       </sql:query>
								<select name="Acno" class="form-control">
								<c:forEach var="re" items="${result.rows}">
								<option selected value="${re.Acno}"><c:out value="${re.Acname}(${re.Acno})"></c:out></option>
								</c:forEach>
								</select>
								</div>
								</div>
								<div class="col-sm-5 col-sm-offset-1">
                              	<div class="form-group label-floating">
									<label>负责人：</label>
									 <sql:query var="result1" dataSource="${mydb}" >
			                       select * from members where Ano='<%=session.getAttribute("Ano")%>'
			                       </sql:query>
									<select name="Mno" class="form-control">
									<c:forEach var="re1" items="${result1.rows}">
									<option selected value="${re1.Mno}"><c:out value="${re1.Mno}(${re1.Ano})"></c:out></option>
									</c:forEach>
									</select>
								</div>
								</div>
                              	
                                <div class="col-sm-5">
                              	<div class="form-group label-floating">
									<label>预算：</label>
									<input type="text" name="Budget" id="Budget" class="form-control">
								</div>
								</div>
								<div class="col-sm-5 col-sm-offset-1">
                              	<div class="form-group label-floating">
									<label>是否通过审核：</label>
								<input type="text" name="Access" readonly="true" value="undercheck" class="form-control">
								</div>
								</div>
								<button type="submit" class="btn btn-primary btn-flat m-b-30 m-t-30" onclick="return check1();">添加</button>
								
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
    </div>
    

    <script src="assets/js/lib/jquery.min.js"></script><!-- jquery vendor -->
    <script src="assets/js/lib/jquery.nanoscroller.min.js"></script><!-- nano scroller -->
    <script src="assets/js/lib/sidebar.js"></script><!-- sidebar -->
    <script src="assets/js/lib/bootstrap.min.js"></script><!-- bootstrap -->
    <script src="assets/js/lib/mmc-common.js"></script>
    <script src="assets/js/lib/mmc-chat.js"></script>
    <script src="assets/js/scripts.js"></script><!-- scripit init-->
    
</body>

</html>
