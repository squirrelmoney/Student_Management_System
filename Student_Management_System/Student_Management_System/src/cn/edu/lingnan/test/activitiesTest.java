package cn.edu.lingnan.test;

import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.DAO.activitiesDAO;
import cn.edu.lingnan.dto.activitiesDTO;

public class activitiesTest {
    public static void main(String[] args) {
    	//updateactivities();
    	deleteactivities();
	}
    
	public static void findactivities() {
		activitiesDAO ac=new activitiesDAO();
		activitiesDTO ad=new activitiesDTO();
		Vector<activitiesDTO> v=new Vector<activitiesDTO>();
		v=ac.findAllactivities();
	}
	public static void insertIntoactivities(){
		activitiesDAO ac=new activitiesDAO();
		activitiesDTO ad=new activitiesDTO();
		Scanner in=new Scanner(System.in);
		System.out.println("---���ӻ������---");
		System.out.println("���:");
		ad.setAcno(in.nextLine());
		System.out.println("���ź�:");
		ad.setAno(in.nextLine());
		System.out.println("�����:");
    	ad.setAcname(in.nextLine());
    	System.out.println("������:");
    	ad.setMno(in.nextLine());
    	ac.insertIntoactivities(ad);
	}
	public static void updateactivities(){
		findactivities();
		activitiesDAO ac=new activitiesDAO();
		activitiesDTO ad=new activitiesDTO();
		Scanner in=new Scanner(System.in);
		System.out.println("---��������Ҫ�޸Ļ��Ϣ�Ļ��---");
		System.out.println("���:");
		ad.setAcno(in.nextLine());
		System.out.println("���ź�:");
		ad.setAno(in.nextLine());
		System.out.println("�����:");
    	ad.setAcname(in.nextLine());
    	System.out.println("������:");
    	ad.setMno(in.nextLine());
    	ac.updateactivities(ad);
	}
	public static void deleteactivities(){
		activitiesDAO ac=new activitiesDAO();
		Scanner in=new Scanner(System.in);
		System.out.println("��������Ҫɾ���Ļ��");
		String str = in.nextLine();
    	ac.deleteactivities(str);
    	//in.close();
	}
}
