function check(){
	if(form.Mno.value==""){
		alert("用户名编号不能为空");
		form.Mno.focus();
		return false;
	}
	var Mnocheck=/^[0-9]{8}$/;
	if(form.Mno.value!=""&&!form.Mno.value.match(Mnocheck)){
		alert("学生号只能由八位数字组成");
		form.Mno.focus();
		return false;
	}
	if(form.Username.value==""){
		alert("用户名不能为空");
		form.Username.focus();
		return false;
	}
//	var regm=/^[a-z0-9]+$/;
//	if(form.username.value!=""&&!form.username.value.match(regm)){
//		alert("用户名格式不对，只能由小写字母与数字组成");
//		form.username.focus();
//		return false;
//	}
	if(form.password1.value==""){
		alert("请输入密码");
		form.password1.focus();
		return false;
	}
	if(form.password2.value==""){
		alert("请再次输入密码");
		form.password2.focus();
		return false;
	}
	if(form.password1.value!=form.password2.value){
		alert("两次输入的密码不一致");
		form.password2.focus();
		return false;
	}
	if(form.Age.value==""){
		alert("请输入年龄");
		form.Age.focus();
		return false;
	}

	if(form.Depart.value==""){
		alert("请选择你所在的学院");
		form.Depart.focus();
		return false;
	}
	
	if(form.Ano.value==""){
		alert("请选择要进入的社团");
		form.Ano.focus();
		return false;
	}




}