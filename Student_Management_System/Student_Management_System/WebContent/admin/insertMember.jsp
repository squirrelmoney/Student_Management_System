<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ page import="java.util.*,cn.edu.lingnan.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加成员</title>
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

    <title>社团成员</title>
	
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
<a href="allMem.jsp" class="made-with-mk">
	<div class="brand">返回</div>
	<div class="made-with"><strong>上一页</strong>(社团会员)</div>
</a>
    <div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
        <div class="nano">
            <div class="nano-content">
                <ul>
					<li class="label">Main</li>
					<li><a class="sidebar-sub-toggle"><i class="ti-layout-grid4-alt"></i> Table <span class="sidebar-collapse-icon ti-angle-down"></span></a>
                        <ul>
                            <li><a href="findmember">社团成员管理</a></li>
                            <li><a href="findassociations">社团管理</a></li>
                            <li><a href="findactivities">社团活动管理</a></li>
                            <li><a href="findfinancing">社团财务管理</a></li>
                            <li><a href="finddepartment">学院管理</a></li>
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
                  <a href="index.html">
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
                                <li><a href="#"><i class="ti-user"></i> <span>massage</span></a></li>
                                <li><a href="#"><i class="ti-power-off"></i> <span>Logout</span></a></li>
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
							<form name="form" action="insertMember" >
                          
								<div class="col-sm-5 col-sm-offset-1">
                              	<div class="form-group label-floating">
									<label>学生编号：</label>
									<input type="text" name="Mno" id="Mno" class="form-control">
								</div>	
								</div>
								<div class="col-sm-5">
                              	<div class="form-group label-floating">
									<label>用户名：</label>
									<input type="text" name="Username" id="Username" class="form-control">
								</div>
								</div>
								<div class="col-sm-5 col-sm-offset-1" >
                              	<div class="form-group label-floating">
									<label>密码：</label>
									<input type="password" name="Password1" id="Password1" class="form-control">
								</div>
								</div>
								<div class="col-sm-5" >
                              	<div class="form-group label-floating">
									<label>密码确认：</label>
									<input type="password" name="Password1" id="Password1"  class="form-control">						
                                 </div>
                                 </div>
								<div class="col-sm-5 col-sm-offset-1" >
                              	<div class="form-group label-floating">
									<label>年龄：</label>
									<input type="text" name="Age" id="Age"  class="form-control">						
                                 </div>
                                 </div>
	                                <div class="col-sm-5 "  >
                              	    <div class="form-group label-floating">
                                    	<label >性别</label>
                                    	<select class="form-control" name="Gender">
								        <option selected value="男">男</option>
								        <option selected value="女">女</option>
                                    	</select>
	                                </div>   
	                                </div>                
                                <div class="col-sm-5 col-sm-offset-1">
                              	<div class="form-group label-floating">
                                    	<sql:query var="result" dataSource="${mydb}" sql="select * from department"/>
                                    	<label>请选择学生所在的学院</label>
                                    	<select class="form-control" name="Depart">
								<c:forEach var="re" items="${result.rows}">
								<option selected value="${re.No}"><c:out value="${re.Name}"></c:out></option>
								</c:forEach>
								<option disabled="" selected=""></option>
                                    	</select>
                                	</div>
                                </div>
                                <div class="col-sm-5 " >
                              	<div class="form-group label-floating">
                                 	<sql:query var="result" dataSource="${mydb}" sql="select * from department"/>
                                 	<label >请选择要把学生添加进入的社团</label>
                                 	<select class="form-control" name="Ano">
									<sql:query var="result1" dataSource="${mydb}" sql="select * from associations"/>
									<c:forEach var="re1" items="${result1.rows}">
									<option selected value="${re1.Ano}"><c:out value="${re1.Aname}"></c:out></option>
									</c:forEach>
									<option disabled="" selected=""></option>
                                	</select>
                                	</div>
                                </div>
                               
                                
                               <div class="col-sm-5 col-sm-offset-1">
                              	<div class="form-group label-floating">
                                    	<label >职位</label>
                                    	<select class="form-control" name="Title">
										<option selected value="普通会员">普通会员
										<option selected value="社团干部">社团干部
										<option selected value="会长">会长
										</select>
                                	</div>
                               	</div>
                              <div class="col-sm-5" >
                              	<div class="form-group label-floating">
                                    	<label >权限</label>
                                    	<select  class="form-control" name="sSuper">
                                    	<option selected value="2">会长
                                    	<option selected value="3">社团干部
										<option selected value="4">普通用户
										</select>
                                	</div>
                             
                                </div>
                                
								<button type="submit" class="btn btn-primary btn-flat m-b-30 m-t-30" onclick="return check4();">添加成员</button>
								
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
