package cn.edu.lingnan.test;

import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.DAO.activitiesDAO;
import cn.edu.lingnan.DAO.associationsDAO;
import cn.edu.lingnan.dto.associationsDTO;

public class associationsTest {
    public static void main(String[] args) {
    	deleteassociations() ;
    	//findassociations();
	}
	public static void findassociations() {
		 associationsDAO a=new associationsDAO();
		 associationsDTO at=new associationsDTO();
//         at.setAname("����5");
//         at.setAno("0004");
//         System.out.println(a.updateAssociations(at));
		 Vector<associationsDTO> v=new Vector<associationsDTO>();
		 v=a.findAllassociations();
	}
	public static void insertIntoassociations() {
		 associationsDAO a=new associationsDAO();
		 associationsDTO at=new associationsDTO();
		 Scanner in=new Scanner(System.in);
		 System.out.println("---�������ű�����---");
		System.out.println("������:");
         at.setAname(in.nextLine());
         System.out.println("���ź�:");
         at.setAno(in.nextLine());
         System.out.println("�᳤:");
         at.setMno(in.nextLine());
         System.out.println("ѧԺ��:");
         at.setDepart(in.nextLine());
         a.insertIntoassociations(at);
        // in.close();
	}
	public static void updateassociations() {
		findassociations() ;
		 associationsDAO a=new associationsDAO();
		 associationsDTO at=new associationsDTO();
		 Scanner in=new Scanner(System.in);
		 System.out.println("---��������Ҫ�޸ĵ����ź�---");
         System.out.println("���ź�:");
         at.setAno(in.nextLine());
         System.out.println("������:");
         at.setAname(in.nextLine());
         System.out.println("�᳤:");
         at.setMno(in.nextLine());
         System.out.println("ѧԺ��:");
         at.setDepart(in.nextLine());
         a.updateAssociations(at);
        // in.close();
	}
	public static void deleteassociations() {
		   associationsDAO a=new associationsDAO();
			Scanner in=new Scanner(System.in);
			System.out.println("��������Ҫɾ�������ź�");
			String str = in.nextLine();
			a.deleteassociations(str);
			//in.close();
	    
	}
}
