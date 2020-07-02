
<%@ page language="java" contentType="text/html; charset=gb2312"
    pageEncoding="gb2312"%>
<%@ page import="java.util.*,cn.edu.lingnan.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<script type="text/javascript" src="register.js"></script>
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png" />
	<link rel="icon" type="image/png" href="assets/img/favicon.png" />

	<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />

<!-- CSS Files -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="assets/css/material-bootstrap-wizard.css" rel="stylesheet" />

<!-- CSS Just for demo purpose, don't include it in your project -->
	<link href="assets/css/demo.css" rel="stylesheet" />
</head>

<body>

<sql:setDataSource
var="mydb"
driver="com.mysql.jdbc.Driver"
url="jdbc:mysql://localhost:3306/association"
user="root"
password="123"
/>

<div class="image-container set-full-height" style="background-image: url('assets/img/wizard-profile.jpg')">
<!--   Creative Tim Branding   -->
<a href="#">
     <div class="logo-container">
        <div class="logo">
            <img src="assets/img/new_logo.png">
        </div>
        <div class="brand">
            register 
        </div>
    </div>
</a>

<!--  Made With Material Kit  -->
<a href="homepage.html" class="made-with-mk">
	<div class="brand">返回</div>
	<div class="made-with"><strong>上一页</strong>(登陆页面)</div>
</a>

   <!--   Big container   -->
<div class="container">
    <div class="row">
     <div class="col-sm-8 col-sm-offset-2">
         <!--      Wizard container        -->
        <div class="wizard-container">
            <div class="card wizard-card" data-color="green"  id="wizard">
            
          
           <!--        You can switch " data-color="rose" "  with one of the next bright colors: "blue", "green", "orange", "purple"        -->

              	<div class="wizard-header">
                  	<h3 class="wizard-title">
                  		注册
                  	</h3>
	<h5></h5>
              	</div>
					<div class="wizard-navigation" >
						<ul>
					                       <li><a href="#location" data-toggle="tab">第一页</a></li>
					                                 <li><a href="#type" data-toggle="tab">第二页</a></li>
					                                 
					                   </ul>
					</div>
               <form action="register" name="form">
                  <div class="tab-content">
                      <div class="tab-pane" id="location">
                      	<div class="row">
                          	<div class="col-sm-12">
                              	<h4 class="info-text"></h4>
                          	</div>
                          	<div class="col-sm-5 col-sm-offset-1">
                              	<div class="form-group label-floating">
                                  	<label class="control-label">学生号</label>
                                  	<input type="text" name="Mno"  class="form-control" id="exampleInputEmail1">
                              	</div>
                          	</div>
                          	
                          	<div class="col-sm-5">
                              	<div class="form-group label-floating">
                                      <label class="control-label">学生名</label>
                               	<input type="text" name="Username"  class="form-control" id="exampleInputEmail1">
                                 	</div>
                          	</div>
                          	<div class="col-sm-5 col-sm-offset-1">
                              	<div class="form-group label-floating">
                                  	<label class="control-label">密码</label>
                         <input type="text" name="password1"  class="form-control" id="exampleInputEmail1">
                              	</div>
                          	</div>
                          	<div class="col-sm-5">
                              	<div class="form-group label-floating">
                                  	<label class="control-label">密码确认</label>
                                  	 <input type="text" name="password2"  class="form-control" id="exampleInputEmail1">
                                  	</div>
                              	</div>
                              	
                              	<div class="col-sm-5 col-sm-offset-1">
                                <div class="form-group label-floating">
                                      <label class="control-label">年龄</label>
                               	    <input type="text" name="Age"  class="form-control" id="exampleInputEmail1">
                                </div>
                               	</div> 
                               	<div class="col-sm-5 ">
                                	<div class="form-group label-floating">
                                    	<label class="control-label">性别</label>
                                    	<select class="form-control" name="Gender">
								        <option selected value="男">男</option>
								        <option selected value="女">女</option>
                                		
                                    	</select>
                                </div>
						</div>
                      	</div>
                         </div>
                             
                        <div class="tab-pane" id="type">
                           
                            <div class="row">
                                <div class="col-sm-5 col-sm-offset-1">
                                  <div class="form-group label-floating">
                                    	<sql:query var="result" dataSource="${mydb}" sql="select * from department"/>
                                    	<label class="control-label">请选择你所在的学院</label>
                                    	<select class="form-control" name="Depart">
								<c:forEach var="re" items="${result.rows}">
								<option selected value="${re.No}"><c:out value="${re.Name}"></c:out></option>
								</c:forEach>
								<option disabled="" selected=""></option>
                                    	</select>
                                	</div>
                                </div>
                                <div class="col-sm-5">
                                	<div class="form-group label-floating">
                                 	<sql:query var="result" dataSource="${mydb}" sql="select * from department"/>
                                 	<label class="control-label">请选择要进入的社团</label>
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
                                    	<label class="control-label">职位</label>
                                    	<select class="form-control" name="Title">
										<option selected value="普通会员">普通会员
										</select>
                                	</div>
                               	</div>
                               <div class="col-sm-5 ">
                                <div class="form-group label-floating">
                                    	<label class="control-label">权限</label>
                                    	<select  class="form-control" name="sSuper">
										<option selected value="4">普通用户
										</select>
                                	</div>
                                </div>
                                </div>
                        </div>
                    <div class="wizard-footer">
                       	<div class="pull-right">
                               <input type='button' class='btn btn-next btn-fill btn-primary btn-wd' name='next' value='Next' />
                               <input type='submit'  class='btn btn-finish btn-fill btn-primary btn-wd' name='finish' value='Finish' onclick="return check();" />
                           </div>
                           <div class="pull-left">
                               <input type='button' class='btn btn-previous btn-fill btn-default btn-wd' name='previous' value='Previous' />
                           </div>
                        <div class="clearfix"></div>
                    </div>
             </form>
            </div>
        </div> <!-- wizard container -->
    </div>
   </div> <!-- row -->
</div> <!--  big container -->

	    <div class="footer">
	        <div class="container text-center">
	         
	        </div>
	    </div>
	</div>

</body>
	<!--   Core JS Files   -->
<script src="assets/js/jquery-2.2.4.min.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/js/jquery.bootstrap.js" type="text/javascript"></script>

<!--  Plugin for the Wizard -->
<script src="assets/js/material-bootstrap-wizard.js"></script>

<!--  More information about jquery.validate here: http://jqueryvalidation.org/	 -->
	<script src="assets/js/jquery.validate.min.js"></script>

</html>

