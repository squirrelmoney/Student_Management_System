package cn.edu.lingnan.test;

import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.DAO.financingDAO;
import cn.edu.lingnan.DAO.memberDAO;
import cn.edu.lingnan.dto.financingDTO;
import cn.edu.lingnan.dto.memberDTO;

public class financingTest {
	public static void main(String[] args) {
		updateFinancing();
		//deleteFinancing();
	}
  public static void findfinancing() {
	financingDTO f=new financingDTO();
	financingDAO fd=new financingDAO();
//	f.setFno("a07");
//	f.setAno("0001");
//	f.setMno("20190323");
//	f.setBudget(900);
//	f.setBudget(1000);
//	f.setFno("a06");
	//System.out.println(fd.insertIntoFinancing(f));
	Vector<financingDTO> v=new Vector<financingDTO>();
	v=fd.findAllfinancing();
}
  public static void insertIntoFinancing()
  {
		financingDTO f=new financingDTO();
		financingDAO fd=new financingDAO();
		Scanner in=new Scanner(System.in);
		System.out.println("---��Ӳ��������---");
		System.out.println("�����ţ�");
		f.setFno(in.nextLine());
		System.out.println("��ţ�");
		f.setAcno(in.nextLine());
		System.out.println("ѧ�ţ�");
		f.setMno(in.nextLine());
		System.out.println("���ѣ�");
		f.setBudget(in.nextInt());
		fd.insertIntoFinancing(f);
		//in.close();
  }
  public static void updateFinancing(){
	  findfinancing();
	  financingDTO f=new financingDTO();
		financingDAO fd=new financingDAO();
		Scanner in=new Scanner(System.in);
		System.out.println("---��������Ҫ�޸ĵĲ�����---");
		System.out.println("�����ţ�");
		f.setFno(in.nextLine());
		System.out.println("��ţ�");
		f.setAcno(in.nextLine());
		System.out.println("ѧ�ţ�");
		f.setMno(in.nextLine());
		System.out.println("���ѣ�");
		f.setBudget(in.nextInt());
		fd.updatefiancing(f);
		//in.close();
  }
  public static void deleteFinancing(){
	  financingDAO fd=new financingDAO();
	  financingDTO f=new financingDTO();
		Scanner in =  new Scanner(System.in);
		System.out.println("��������Ҫɾ���Ĳ�����");
		String str = in.nextLine();
		fd.deleteFinancing(str);
		//in.close();
	}
}
