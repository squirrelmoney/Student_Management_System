package cn.edu.lingnan.test;

import java.util.Scanner;
import java.util.Vector;
import java.util.*;
import cn.edu.lingnan.DAO.associationsDAO;
import cn.edu.lingnan.DAO.memberDAO;
import cn.edu.lingnan.dto.associationsDTO;
import cn.edu.lingnan.dto.memberDTO;

public class DaoTestDemo {
 

public static void main(String[] args) {
	Scanner scanf=new Scanner(System.in);
	System.out.println("-------欢迎你来到社团管理系统---------");
	System.out.println("-------请选择相应数字进行测试---------");
     
	while(true){
		System.out.println("---------1.查看信息-----------");
		System.out.println("---------2.增加课程-----------");
		System.out.println("---------3.修改信息-----------");
		System.out.println("---------4.删除信息-----------");
		System.out.println("---------0.退出-----------");
		scanf.hasNextLine();
		String str=scanf.nextLine();
		if(str.equals("1")) {
			find();
		}
		else if(str.equals("2")) {
			insert();
		}
		else if(str.equals("3")) {
			update();
		}
		else if(str.equals("4")) {
			delete();
		}
		else break; 
	}
	
}

 public static void find(){
	   int id=-1;
	  Scanner scanf=new Scanner(System.in);
	    System.out.println("-------请选择相应数字进行查询---------");
		System.out.println("---------1.查看会员表-----------");
		System.out.println("---------2.查看社团表-----------");
		System.out.println("---------3.查看活动表-----------");
		System.out.println("---------4.查看学院表-----------");
		System.out.println("---------5.查看财务表-----------");
		System.out.println("---------0.返回-----------");
		while(id!=0){
			scanf.hasNextLine();
			 id=scanf.nextInt();
        	//String str=scanf.nextLine();
			switch(id){
			  case 1:
			       memberTest.findmember();
			       break;
			   case 2:
			       associationsTest.findassociations();
			        break;
			   case 3:
			        activitiesTest.findactivities();
			        break;
			   case 4:
			        departmentTest.finddepartment();
			       break;
			   case 5:
			        financingTest.findfinancing();
			        	 break;
			   case 0:break;
			         }
			
	}
	
}
 public static void insert(){
	 int id=-1;
	  Scanner scanf=new Scanner(System.in);
	    System.out.println("-------请选择相应数字进行添加---------");
		System.out.println("---------1.添加会员信息-----------");
		System.out.println("---------2.添加社团信息-----------");
		System.out.println("---------3.添加活动信息-----------");
		System.out.println("---------4.添加学院信息-----------");
		System.out.println("---------5.添加财务信息-----------");
		System.out.println("---------0.返回-----------");
		while(id!=0){
			scanf.hasNextLine();
			 id=scanf.nextInt();
      
			switch(id){
			  case 1:
			       memberTest.InsertIntomember();
			       break;
			   case 2:
			       associationsTest.insertIntoassociations();
			        break;
			   case 3:
			        activitiesTest.insertIntoactivities();
			        break;
			   case 4:
			        departmentTest.insertintodepartment();
			       break;
			   case 5:
			        financingTest.insertIntoFinancing();
			        	 break;
			         }
	}
 }
 public static void update(){
	 int id=-1;
	  Scanner scanf=new Scanner(System.in);
	    System.out.println("-------请选择相应数字进行更新---------");
		System.out.println("---------1.更新会员信息-----------");
		System.out.println("---------2.更新社团信息-----------");
		System.out.println("---------3.更新活动信息-----------");
		System.out.println("---------4.更新学院信息-----------");
		System.out.println("---------5.更新财务信息-----------");
		System.out.println("---------0.返回-----------");
		while(id!=0){
			//scanf.hasNextLine();
			 id=scanf.nextInt();
			switch(id){
			  case 1:
			       memberTest.updatemember();
			       break;
			   case 2:
			       associationsTest.updateassociations();
			        break;
			   case 3:
			        activitiesTest.updateactivities();
			        break;
			   case 4:
			        departmentTest.updatedepartment();
			       break;
			   case 5:
			        financingTest.updateFinancing();
			        	 break;
			         }
		}
		
 }
 

 public static void delete(){
	 int id=-1;
	  Scanner scanf=new Scanner(System.in);
	    System.out.println("-------请选择相应数字进行更新---------");
		System.out.println("---------1.删除会员信息-----------");
		System.out.println("---------2.删除社团信息-----------");
		System.out.println("---------3.删除活动信息-----------");
		System.out.println("---------4.删除学院信息-----------");
		System.out.println("---------5.删除财务信息-----------");
		System.out.println("---------0.返回-----------");
		while(id!=0){
      		scanf.hasNextLine();
		    id=scanf.nextInt();
			switch(id){
			  case 1:
			       memberTest.deletemember();
			       break;
			   case 2:
			       associationsTest.deleteassociations();
			        break;
			   case 3:
			        activitiesTest.deleteactivities();
			        break;
			   case 4:
			        departmentTest.deletedepartment();
			       break;
			   case 5:
			        financingTest.deleteFinancing();
			        break;
			         }
		}
		
 }
 
}	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




