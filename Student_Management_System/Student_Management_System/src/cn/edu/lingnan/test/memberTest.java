package cn.edu.lingnan.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.DAO.memberDAO;
import cn.edu.lingnan.dto.memberDTO;
import cn.edu.lingnan.util.DataAccess;

public class memberTest {
	public static void main(String[] args) {
		memberDAO md=new memberDAO();
		memberDTO m=new memberDTO();
		//InsertIntomember();
		//updatemember();
		//MnoandPassword();
		//deletemember();
		//findmember();
		System.out.println(md.findMemberByNameAndPassword("admin", "admin","null"));
	}

	public static void findmember()
	{
		memberDAO md=new memberDAO();
		memberDTO m=new memberDTO();
		Vector<memberDTO> v=new Vector<memberDTO>();
		v=md.findAllMember();	
	}
	
	
	public static void InsertIntomember(){
		memberDAO md=new memberDAO();
		memberDTO m=new memberDTO();
		 Scanner in=new Scanner(System.in);
         System.out.println("---添加会员---");
         System.out.println("学号：");
         m.setMno(in.nextLine());
         System.out.println("姓名：");
         m.setSname(in.nextLine());
         System.out.println("社团号：");
 		 m.setAno(in.nextLine());
 		 System.out.println("学院号：");
 		 m.setDepart(in.nextLine());
 		 System.out.println("性别：");
 		 m.setGender(in.nextLine());
 		 System.out.println("职称：");
 		 m.setTitle(in.nextLine());
 		 System.out.println("密码：");
		 m.setPassword(in.nextLine());
         System.out.println("年龄：");
 		 m.setAge(in.nextInt());
         md.insertIntomember(m);
         //in.close();
	        }
		 
//	public static boolean MnoandPassword(){
//		boolean flag;
//		memberDAO md=new memberDAO();
//		memberDTO m=new memberDTO();
//		Scanner in=new Scanner(System.in);
//		 System.out.println("---修改会员信息---");
//         System.out.println("请输入你要修改的学生学号与密码：");
//         //String str=in.nextLine();
// //		 String[] s = str.trim().split(" ");
//         m.setMno(in.nextLine());
//		 m.setPassword(in.nextLine());
//         flag=md.findMemberByNameAndpassword(m);
//        // in.close();
//		return flag;
//	}
	public static void updatemember(){
		memberDAO md=new memberDAO();
		memberDTO m=new memberDTO();
		 Scanner in=new Scanner(System.in);
		 //boolean flag=MnoandPassword();
			     findmember();
			    // System.out.println("密码正确，请更新信息");
			     System.out.println("请更新信息");
			     System.out.println("请输入你要修改学生的学号：");
		         m.setMno(in.nextLine());
		         System.out.println("姓名：");
		         m.setSname(in.nextLine());
		         System.out.println("社团号：");
		 		 m.setAno(in.nextLine());
		 		 System.out.println("学院号：");
		 		 m.setDepart(in.nextLine());
		 		 System.out.println("性别：");
		 		 m.setGender(in.nextLine());
		 		 System.out.println("职称：");
		 		 m.setTitle(in.nextLine());
		 		 System.out.println("密码：");
				 m.setPassword(in.nextLine());
		         System.out.println("年龄：");
		 		 m.setAge(in.nextInt());
		 		 System.out.println("权限：");
		 		 m.setsSuper(in.nextInt());
	         	 md.updatemember(m);
	         	  //in.close();
	             }


	public static void deletemember(){
		memberDAO md=new memberDAO();
		memberDTO m=new memberDTO();
//		Scanner in =  new Scanner(System.in);
//		System.out.println("请输入你要删除的会员学号");
//		String str1 = in.nextLine();
//		System.out.println("请输入你要删除的会员所在社团");
//		String str2 = in.nextLine();
		md.deletemember("20190316","a001");
		
	}
}














//switch(str){
//case "密码":
//	 System.out.println("密码：");
//	 m.setPassword(in.nextLine());
//	 break;
//case "姓名":
//	 System.out.println("姓名：");
//    m.setSname(in.nextLine());
//    break;
//case "社团号":
//	 System.out.println("社团号：");
//	 m.setAno(in.nextLine());
//	break;
//case "学院号":
//	 System.out.println("学院号：");
//	 m.setDepart(in.nextLine());
//	break;
//case "性别":
//	 System.out.println("性别：");
//	 m.setGender(in.nextLine());
//	break;
//case "职称":
//	 System.out.println("职称：");
//	 m.setTitle(in.nextLine());
//	break;
//case "年龄":
//	 System.out.println("年龄：");
//	 m.setAge(in.nextInt());
//	break;
