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
		System.out.println("---增加活动表数据---");
		System.out.println("活动号:");
		ad.setAcno(in.nextLine());
		System.out.println("社团号:");
		ad.setAno(in.nextLine());
		System.out.println("活动名称:");
    	ad.setAcname(in.nextLine());
    	System.out.println("负责人:");
    	ad.setMno(in.nextLine());
    	ac.insertIntoactivities(ad);
	}
	public static void updateactivities(){
		findactivities();
		activitiesDAO ac=new activitiesDAO();
		activitiesDTO ad=new activitiesDTO();
		Scanner in=new Scanner(System.in);
		System.out.println("---请输入你要修改活动信息的活动号---");
		System.out.println("活动号:");
		ad.setAcno(in.nextLine());
		System.out.println("社团号:");
		ad.setAno(in.nextLine());
		System.out.println("活动名称:");
    	ad.setAcname(in.nextLine());
    	System.out.println("负责人:");
    	ad.setMno(in.nextLine());
    	ac.updateactivities(ad);
	}
	public static void deleteactivities(){
		activitiesDAO ac=new activitiesDAO();
		Scanner in=new Scanner(System.in);
		System.out.println("请输入你要删除的活动号");
		String str = in.nextLine();
    	ac.deleteactivities(str);
    	//in.close();
	}
}
