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
         System.out.println("---��ӻ�Ա---");
         System.out.println("ѧ�ţ�");
         m.setMno(in.nextLine());
         System.out.println("������");
         m.setSname(in.nextLine());
         System.out.println("���źţ�");
 		 m.setAno(in.nextLine());
 		 System.out.println("ѧԺ�ţ�");
 		 m.setDepart(in.nextLine());
 		 System.out.println("�Ա�");
 		 m.setGender(in.nextLine());
 		 System.out.println("ְ�ƣ�");
 		 m.setTitle(in.nextLine());
 		 System.out.println("���룺");
		 m.setPassword(in.nextLine());
         System.out.println("���䣺");
 		 m.setAge(in.nextInt());
         md.insertIntomember(m);
         //in.close();
	        }
		 
//	public static boolean MnoandPassword(){
//		boolean flag;
//		memberDAO md=new memberDAO();
//		memberDTO m=new memberDTO();
//		Scanner in=new Scanner(System.in);
//		 System.out.println("---�޸Ļ�Ա��Ϣ---");
//         System.out.println("��������Ҫ�޸ĵ�ѧ��ѧ�������룺");
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
			    // System.out.println("������ȷ���������Ϣ");
			     System.out.println("�������Ϣ");
			     System.out.println("��������Ҫ�޸�ѧ����ѧ�ţ�");
		         m.setMno(in.nextLine());
		         System.out.println("������");
		         m.setSname(in.nextLine());
		         System.out.println("���źţ�");
		 		 m.setAno(in.nextLine());
		 		 System.out.println("ѧԺ�ţ�");
		 		 m.setDepart(in.nextLine());
		 		 System.out.println("�Ա�");
		 		 m.setGender(in.nextLine());
		 		 System.out.println("ְ�ƣ�");
		 		 m.setTitle(in.nextLine());
		 		 System.out.println("���룺");
				 m.setPassword(in.nextLine());
		         System.out.println("���䣺");
		 		 m.setAge(in.nextInt());
		 		 System.out.println("Ȩ�ޣ�");
		 		 m.setsSuper(in.nextInt());
	         	 md.updatemember(m);
	         	  //in.close();
	             }


	public static void deletemember(){
		memberDAO md=new memberDAO();
		memberDTO m=new memberDTO();
//		Scanner in =  new Scanner(System.in);
//		System.out.println("��������Ҫɾ���Ļ�Աѧ��");
//		String str1 = in.nextLine();
//		System.out.println("��������Ҫɾ���Ļ�Ա��������");
//		String str2 = in.nextLine();
		md.deletemember("20190316","a001");
		
	}
}














//switch(str){
//case "����":
//	 System.out.println("���룺");
//	 m.setPassword(in.nextLine());
//	 break;
//case "����":
//	 System.out.println("������");
//    m.setSname(in.nextLine());
//    break;
//case "���ź�":
//	 System.out.println("���źţ�");
//	 m.setAno(in.nextLine());
//	break;
//case "ѧԺ��":
//	 System.out.println("ѧԺ�ţ�");
//	 m.setDepart(in.nextLine());
//	break;
//case "�Ա�":
//	 System.out.println("�Ա�");
//	 m.setGender(in.nextLine());
//	break;
//case "ְ��":
//	 System.out.println("ְ�ƣ�");
//	 m.setTitle(in.nextLine());
//	break;
//case "����":
//	 System.out.println("���䣺");
//	 m.setAge(in.nextInt());
//	break;
