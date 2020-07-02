<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ page import="java.util.*,cn.edu.lingnan.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>添加活动</title>
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

    <title>活动</title>
	
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

<body>

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

 


    <div class="content-wrap">
        <div class="main">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8 p-0">
                        <div class="page-header">
                            <div class="page-title">
                                <h1>社团活动管理</h1>
                            </div>
                        </div>
                        </div>
                       </div>
                    </div><!-- /# column -->

                        <div class="col-lg-6">
                            <div class="card alert">
                                <div class="card-header">
                                    <h4>Table Bordered </h4>
									<div class="card-header-right-icon">
										<ul>
											<li class="card-close" data-dismiss="alert"><i class="ti-close"></i></li>
											<li class="card-option drop-menu"><i class="ti-settings" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" role="link"></i>
												<ul class="card-option-dropdown dropdown-menu">
													<li><a href="insertActivities.jsp"><i class="ti-loop"></i> 添加</a></li>
													<li> <th><a href="#" id="btn1" type="button" value="全选" onclick="allcheck1();">全选</a></th></li>
													<li> <th><a href="#" id="btn1" type="button" value="反选" onclick="allcheck3();">反选</a></th></li>
													<li> <th><a href="#" id="btn1" type="button" value="取消" onclick="allcheck2();">取消</a></th></li>
												</ul>
											</li>
											<li class="doc-link"><a href="#"><i class="ti-link"></i></a></li>
										</ul>
									</div>
                                </div>
                                <div class="card-body">
                                    <table class=" table-responsive table-bordered">
                                        <thead>
                                            <tr>
						
									      <th></th>
									        <th>活动号</th>
									        <th>社团号</th>
									        <th>活动名称</th>
									        <th>活动负责人</th>
									        <th>是否通过审核</th>
									         <th></th>
									        <th><a id="btn2" type="button" value="批量删除" onclick="deleteAc();">删除所选</a></th>
                                             <th></th>
									          
                                            </tr>
                                        </thead>
                                        <tbody>
                                        
				                 <%
									   Vector<activitiesDTO> v=(Vector<activitiesDTO>)session.getAttribute("allAc");
									   Iterator<activitiesDTO> it=v.iterator();
									   activitiesDTO a=null;
									   while(it.hasNext()){
										   a=it.next();
									%>

									 <thead>
									         <tr>
										        <td><input type="checkbox" name="check" value=<%=a.getAcno() %>></td>
										        <td><%=a.getAcno() %></td>
										        <td><%=a.getAno() %></td>
										        <td><%=a.getAcname() %></td>
										        <td><%=a.getMno() %></td>
										        <td><%=a.getAccess() %></td>
										        <td><a href="updateActivities.jsp?Acno=<%=a.getAcno() %>">修改</a></td>
										        <td><a href="updateactivities?f=delete&Acno=<%=a.getAcno() %>"
										               onclick="return confirm('你确定要删除这条记录吗？');">删除</a></td>
										       </tr>
									       </thead>
									<%
									   }
									   
									 %>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div><!-- /# column -->
                     
					</div><!-- /# row -->     </div>







    <script src="assets/js/lib/jquery.min.js"></script><!-- jquery vendor -->
    <script src="assets/js/lib/jquery.nanoscroller.min.js"></script><!-- nano scroller -->
    <script src="assets/js/lib/sidebar.js"></script><!-- sidebar -->
    <script src="assets/js/lib/bootstrap.min.js"></script><!-- bootstrap -->
    <script src="assets/js/lib/mmc-common.js"></script>
    <script src="assets/js/lib/mmc-chat.js"></script>
    <script src="assets/js/scripts.js"></script><!-- scripit init-->


    


</body>

</html>