/**
 * 
 */
function check(){
	if(form.No.value==""){
		alert("��Ų���Ϊ��");
		form.No.focus();
		return false;
	}
	var Nocheck=/^[d]*[0-9]{3}$/;
	if(form.No.value!=""&&!form.No.value.match(Nocheck)){
		alert("���ֻ����d��ͷ��4λ��");
		form.No.focus();
		return false;
	}
	if(form.Name.value==""){
		alert("ѧԺ�Ų���Ϊ��");
		form.Name.focus();
		return false;
	}
}
function check1(){
	if(form.Fno.value==""){
		alert("��Ų���Ϊ��");
		form.Fno.focus();
		return false;
	}
	var Fnocheck=/^[f]*[0-9]{3}$/;
	if(form.Fno.value!=""&&!form.Fno.value.match(Fnocheck)){
		alert("���ֻ����f��ͷ��4λ��");
		form.Fno.focus();
		return false;
	}
	if(form.Budget.value==""){
		alert("Ԥ�㲻��Ϊ��");
		form.Budget.focus();
		return false;
	}

}


function check2(){
	if(form.Acno.value==""){
		alert("��Ų���Ϊ��");
		form.Acno.focus();
		return false;
	}
	var Acnocheck=/^[ac]*[0-9]{2}$/;
	if(form.Acno.value!=""&&!form.Acno.value.match(Acnocheck)){
		alert("���ֻ����ac��ͷ��4λ��");
		form.Acno.focus();
		return false;
	}
	if(form.Acname.value==""){
		alert("�������Ϊ��");
		form.Acname.focus();
		return false;
	}
}

function check3(){
	if(form.Ano.value==""){
		alert("���ű�Ų���Ϊ��");
		form.Ano.focus();
		return false;
	}
	var Anocheck=/^[a]*[0-9]{3}$/;
	if(form.Ano.value!=""&&!form.Ano.value.match(Anocheck)){
		alert("���ֻ����a��ͷ��4λ��");
		form.Ano.focus();
		return false;
	}
	if(form.Aname.value==""){
		alert("����������Ϊ��");
		form.Acname.focus();
		return false;
	}
}


function check4(){
	if(form.Mno.value==""){
		alert("�û�����Ų���Ϊ��");
		form.Mno.focus();
		return false;
	}
	var Mnocheck=/^[0-9]{8}$/;
	if(form.Mno.value!=""&&!form.Mno.value.match(Mnocheck)){
		alert("ѧ����ֻ���ɰ�λ�������");
		form.Mno.focus();
		return false;
	}
	if(form.Username.value==""){
		alert("�û�������Ϊ��");
		form.Username.focus();
		return false;
	}
//	var regm=/^[a-z0-9]+$/;
//	if(form.Username.value!=""&&!form.Username.value.match(regm)){
//		alert("�û�����ʽ���ԣ�ֻ����Сд��ĸ���������");
//		form.Username.focus();
//		return false;
//	}
	if(form.Password1.value==""){
		alert("����������");
		form.Password1.focus();
		return false;
	}
	if(form.Password2.value==""){
		alert("���ٴ���������");
		form.Password1.focus();
		return false;
	}
	if(form.Password1.value!=form.Password2.value){
		alert("������������벻һ��");
		form.password2.focus();
		return false;
	}
	

}