function check(){
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
//	if(form.username.value!=""&&!form.username.value.match(regm)){
//		alert("�û�����ʽ���ԣ�ֻ����Сд��ĸ���������");
//		form.username.focus();
//		return false;
//	}
	if(form.password1.value==""){
		alert("����������");
		form.password1.focus();
		return false;
	}
	if(form.password2.value==""){
		alert("���ٴ���������");
		form.password2.focus();
		return false;
	}
	if(form.password1.value!=form.password2.value){
		alert("������������벻һ��");
		form.password2.focus();
		return false;
	}
	if(form.Age.value==""){
		alert("����������");
		form.Age.focus();
		return false;
	}

	if(form.Depart.value==""){
		alert("��ѡ�������ڵ�ѧԺ");
		form.Depart.focus();
		return false;
	}
	
	if(form.Ano.value==""){
		alert("��ѡ��Ҫ���������");
		form.Ano.focus();
		return false;
	}




}