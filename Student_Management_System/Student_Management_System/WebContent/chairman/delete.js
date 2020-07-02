/**
 * 
 */
function allcheck(){
	//添加外部判断：奇数点击时value为1，全不选，否则全选，如此可以在反选与全选间衍生出极端选择的方案
	var checkbox = document.getElementById('btn1');
	//value初始化为1，此处的三目执行后value一定不为1，而页面初始化时checkbox都为未选中状态，所以value为1时全不选
	checkbox.value==1?checkbox.value=2 : checkbox.value=1;
	var oCheck=document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(checkbox.value==1){
			oCheck[i].checked=false;//全不选
			}else{
				oCheck[i].checked=true;//全选
			}
			//************
			//checkboxs[i].checked?checkboxs[i].checked=false:checkboxs[i].checked=true;//反选
}
}
function allcheck1(){
	//添加外部判断：奇数点击时value为1，全不选，否则全选，如此可以在反选与全选间衍生出极端选择的方案
	var checkbox = document.getElementById('btn1');
	//value初始化为1，此处的三目执行后value一定不为1，而页面初始化时checkbox都为未选中状态，所以value为1时全不选
	checkbox.value==1?checkbox.value=2 : checkbox.value=1;
	var oCheck=document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
			oCheck[i].checked=true;//全选
			//************
			//checkboxs[i].checked?checkboxs[i].checked=false:checkboxs[i].checked=true;//反选
}
}
function allcheck2(){
	//添加外部判断：奇数点击时value为1，全不选，否则全选，如此可以在反选与全选间衍生出极端选择的方案
	var checkbox = document.getElementById('btn1');
	//value初始化为1，此处的三目执行后value一定不为1，而页面初始化时checkbox都为未选中状态，所以value为1时全不选
	checkbox.value==1?checkbox.value=2 : checkbox.value=1;
	var oCheck=document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
			oCheck[i].checked=false;//全不选
			//************
			//checkboxs[i].checked?checkboxs[i].checked=false:checkboxs[i].checked=true;//反选
}
}
function allcheck3(){
	//添加外部判断：奇数点击时value为1，全不选，否则全选，如此可以在反选与全选间衍生出极端选择的方案
	var checkbox = document.getElementById('btn1');
	//value初始化为1，此处的三目执行后value一定不为1，而页面初始化时checkbox都为未选中状态，所以value为1时全不选
	checkbox.value==1?checkbox.value=2 : checkbox.value=1;
	var oCheck=document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		oCheck[i].checked?oCheck[i].checked=false:oCheck[i].checked=true;//反选
}
}
function deleteMem(){
	var MnoAno=new Array();
	var flag=false;
	var oCheck=document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked){
			MnoAno.push(oCheck[i].value);//记录选中的mno
           flag=true;
		}
	}
	if(flag){
		if(confirm("你确定要删除这些记录吗？")){
			location.href="updatemem?f=delall&MnoAno="+MnoAno;
		}
	}else{
		alert("你至少需要选择一条记录才能进行批量删除");
	}

}


function deleteAsso(){
	var allano=new Array();
	var flag=false;
	var oCheck=document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked)
		allano.push(oCheck[i].value);//记录选中的Ano
        flag=true;
	}
	if(flag){
		if(confirm("你确定要删除这些记录吗？")){
			location.href="updateasso?f=del&Ano="+allano;
		}else{
			alert("你至少需要选择一条记录才能进行批量删除");
		}
	}

}

function deleteAc(){
	var allacno=new Array();
	var flag=false;
	var oCheck=document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked)
		allacno.push(oCheck[i].value);//记录选中的Acno
        flag=true;
	}
	if(flag){
		if(confirm("你确定要删除这些记录吗？")){
			location.href="updateactivities?f=del&Acno="+allacno;
		}else{
			alert("你至少需要选择一条记录才能进行批量删除");
		}
	}

}
function deleteFn(){
	var allfno=new Array();
	var flag=false;
	var oCheck=document.getElementsByName('check');
	for(var i=0;i<oCheck.length;i++){
		if(oCheck[i].checked)
		allfno.push(oCheck[i].value);//记录选中的Acno
        flag=true;
	}
	if(flag){
		if(confirm("你确定要删除这些记录吗？")){
			location.href="updatefinancing?f=del&Fno="+allfno;
		}else{
			alert("你至少需要选择一条记录才能进行批量删除");
		}
	}

}