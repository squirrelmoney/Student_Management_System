/**
 * 
 */
function allcheck(){
	//����ⲿ�жϣ��������ʱvalueΪ1��ȫ��ѡ������ȫѡ����˿����ڷ�ѡ��ȫѡ������������ѡ��ķ���
	var checkbox = document.getElementById('btn1');
	//value��ʼ��Ϊ1���˴�����Ŀִ�к�valueһ����Ϊ1����ҳ���ʼ��ʱcheckbox��Ϊδѡ��״̬������valueΪ1ʱȫ��ѡ
	checkbox.value==1?checkbox.value=2 : checkbox.value=1;
	var oCheck=document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(checkbox.value==1){
			oCheck[i].checked=false;//ȫ��ѡ
			}else{
				oCheck[i].checked=true;//ȫѡ
			}
			//************
			//checkboxs[i].checked?checkboxs[i].checked=false:checkboxs[i].checked=true;//��ѡ
}
}
function allcheck1(){
	//����ⲿ�жϣ��������ʱvalueΪ1��ȫ��ѡ������ȫѡ����˿����ڷ�ѡ��ȫѡ������������ѡ��ķ���
	var checkbox = document.getElementById('btn1');
	//value��ʼ��Ϊ1���˴�����Ŀִ�к�valueһ����Ϊ1����ҳ���ʼ��ʱcheckbox��Ϊδѡ��״̬������valueΪ1ʱȫ��ѡ
	checkbox.value==1?checkbox.value=2 : checkbox.value=1;
	var oCheck=document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
			oCheck[i].checked=true;//ȫѡ
			//************
			//checkboxs[i].checked?checkboxs[i].checked=false:checkboxs[i].checked=true;//��ѡ
}
}
function allcheck2(){
	//����ⲿ�жϣ��������ʱvalueΪ1��ȫ��ѡ������ȫѡ����˿����ڷ�ѡ��ȫѡ������������ѡ��ķ���
	var checkbox = document.getElementById('btn1');
	//value��ʼ��Ϊ1���˴�����Ŀִ�к�valueһ����Ϊ1����ҳ���ʼ��ʱcheckbox��Ϊδѡ��״̬������valueΪ1ʱȫ��ѡ
	checkbox.value==1?checkbox.value=2 : checkbox.value=1;
	var oCheck=document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
			oCheck[i].checked=false;//ȫ��ѡ
			//************
			//checkboxs[i].checked?checkboxs[i].checked=false:checkboxs[i].checked=true;//��ѡ
}
}
function allcheck3(){
	//����ⲿ�жϣ��������ʱvalueΪ1��ȫ��ѡ������ȫѡ����˿����ڷ�ѡ��ȫѡ������������ѡ��ķ���
	var checkbox = document.getElementById('btn1');
	//value��ʼ��Ϊ1���˴�����Ŀִ�к�valueһ����Ϊ1����ҳ���ʼ��ʱcheckbox��Ϊδѡ��״̬������valueΪ1ʱȫ��ѡ
	checkbox.value==1?checkbox.value=2 : checkbox.value=1;
	var oCheck=document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		oCheck[i].checked?oCheck[i].checked=false:oCheck[i].checked=true;//��ѡ
}
}
function deleteMem(){
	var MnoAno=new Array();
	var flag=false;
	var oCheck=document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
			MnoAno.push(oCheck[i].value);//��¼ѡ�е�mno
           flag=true;
		}
	}
	if(flag){
		if(confirm("��ȷ��Ҫɾ����Щ��¼��")){
			location.href="updatemem?f=delall&MnoAno="+MnoAno;
		}
	}else{
		alert("��������Ҫѡ��һ����¼���ܽ�������ɾ��");
	}

}


function deleteAsso(){
	var allano=new Array();
	var flag=false;
	var oCheck=document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked)
		allano.push(oCheck[i].value);//��¼ѡ�е�Ano
        flag=true;
	}
	if(flag){
		if(confirm("��ȷ��Ҫɾ����Щ��¼��")){
			location.href="updateasso?f=del&Ano="+allano;
		}else{
			alert("��������Ҫѡ��һ����¼���ܽ�������ɾ��");
		}
	}

}

function deleteAc(){
	var allacno=new Array();
	var flag=false;
	var oCheck=document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked)
		allacno.push(oCheck[i].value);//��¼ѡ�е�Acno
        flag=true;
	}
	if(flag){
		if(confirm("��ȷ��Ҫɾ����Щ��¼��")){
			location.href="updateactivities?f=del&Acno="+allacno;
		}else{
			alert("��������Ҫѡ��һ����¼���ܽ�������ɾ��");
		}
	}

}
function deleteFn(){
	var allfno=new Array();
	var flag=false;
	var oCheck=document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked)
		allfno.push(oCheck[i].value);//��¼ѡ�е�Acno
        flag=true;
	}
	if(flag){
		if(confirm("��ȷ��Ҫɾ����Щ��¼��")){
			location.href="updatefinancing?f=del&Fno="+allfno;
		}else{
			alert("��������Ҫѡ��һ����¼���ܽ�������ɾ��");
		}
	}

}