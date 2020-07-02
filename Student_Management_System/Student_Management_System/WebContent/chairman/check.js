/**
 * 
 */
function check(){
	if(form.No.value==""){
		alert("编号不能为空");
		form.No.focus();
		return false;
	}
	var Nocheck=/^[d]*[0-9]{3}$/;
	if(form.No.value!=""&&!form.No.value.match(Nocheck)){
		alert("编号只能是d开头的4位数");
		form.No.focus();
		return false;
	}
	if(form.Name.value==""){
		alert("学院号不能为空");
		form.Name.focus();
		return false;
	}
}
function check1(){
	if(form.Fno.value==""){
		alert("编号不能为空");
		form.Fno.focus();
		return false;
	}
	var Fnocheck=/^[f]*[0-9]{3}$/;
	if(form.Fno.value!=""&&!form.Fno.value.match(Fnocheck)){
		alert("编号只能是f开头的4位数");
		form.Fno.focus();
		return false;
	}
	if(form.Budget.value==""){
		alert("预算不能为空");
		form.Budget.focus();
		return false;
	}

}


function check2(){
	if(form.Acno.value==""){
		alert("编号不能为空");
		form.Acno.focus();
		return false;
	}
	var Acnocheck=/^[ac]*[0-9]{2}$/;
	if(form.Acno.value!=""&&!form.Acno.value.match(Acnocheck)){
		alert("编号只能是ac开头的4位数");
		form.Acno.focus();
		return false;
	}
	if(form.Acname.value==""){
		alert("活动名不能为空");
		form.Acname.focus();
		return false;
	}
}

function check3(){
	if(form.Ano.value==""){
		alert("社团编号不能为空");
		form.Ano.focus();
		return false;
	}
	var Anocheck=/^[a]*[0-9]{3}$/;
	if(form.Ano.value!=""&&!form.Ano.value.match(Anocheck)){
		alert("编号只能是a开头的4位数");
		form.Ano.focus();
		return false;
	}
	if(form.Aname.value==""){
		alert("社团名不能为空");
		form.Acname.focus();
		return false;
	}
}


function check4(){
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
//	if(form.Username.value!=""&&!form.Username.value.match(regm)){
//		alert("用户名格式不对，只能由小写字母与数字组成");
//		form.Username.focus();
//		return false;
//	}
	if(form.Password1.value==""){
		alert("请输入密码");
		form.Password1.focus();
		return false;
	}
	if(form.Password2.value==""){
		alert("请再次输入密码");
		form.Password1.focus();
		return false;
	}
	if(form.Password1.value!=form.Password2.value){
		alert("两次输入的密码不一致");
		form.password2.focus();
		return false;
	}
	

}