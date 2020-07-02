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
	System.out.println("-------��ӭ���������Ź���ϵͳ---------");
	System.out.println("-------��ѡ����Ӧ���ֽ��в���---------");
     
	while(true){
		System.out.println("---------1.�鿴��Ϣ-----------");
		System.out.println("---------2.���ӿγ�-----------");
		System.out.println("---------3.�޸���Ϣ-----------");
		System.out.println("---------4.ɾ����Ϣ-----------");
		System.out.println("---------0.�˳�-----------");
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
	    System.out.println("-------��ѡ����Ӧ���ֽ��в�ѯ---------");
		System.out.println("---------1.�鿴��Ա��-----------");
		System.out.println("---------2.�鿴���ű�-----------");
		System.out.println("---------3.�鿴���-----------");
		System.out.println("---------4.�鿴ѧԺ��-----------");
		System.out.println("---------5.�鿴�����-----------");
		System.out.println("---------0.����-----------");
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
	    System.out.println("-------��ѡ����Ӧ���ֽ������---------");
		System.out.println("---------1.��ӻ�Ա��Ϣ-----------");
		System.out.println("---------2.���������Ϣ-----------");
		System.out.println("---------3.��ӻ��Ϣ-----------");
		System.out.println("---------4.���ѧԺ��Ϣ-----------");
		System.out.println("---------5.��Ӳ�����Ϣ-----------");
		System.out.println("---------0.����-----------");
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
	    System.out.println("-------��ѡ����Ӧ���ֽ��и���---------");
		System.out.println("---------1.���»�Ա��Ϣ-----------");
		System.out.println("---------2.����������Ϣ-----------");
		System.out.println("---------3.���»��Ϣ-----------");
		System.out.println("---------4.����ѧԺ��Ϣ-----------");
		System.out.println("---------5.���²�����Ϣ-----------");
		System.out.println("---------0.����-----------");
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
	    System.out.println("-------��ѡ����Ӧ���ֽ��и���---------");
		System.out.println("---------1.ɾ����Ա��Ϣ-----------");
		System.out.println("---------2.ɾ��������Ϣ-----------");
		System.out.println("---------3.ɾ�����Ϣ-----------");
		System.out.println("---------4.ɾ��ѧԺ��Ϣ-----------");
		System.out.println("---------5.ɾ��������Ϣ-----------");
		System.out.println("---------0.����-----------");
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




