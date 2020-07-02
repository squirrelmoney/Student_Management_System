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
//         at.setAname("社团5");
//         at.setAno("0004");
//         System.out.println(a.updateAssociations(at));
		 Vector<associationsDTO> v=new Vector<associationsDTO>();
		 v=a.findAllassociations();
	}
	public static void insertIntoassociations() {
		 associationsDAO a=new associationsDAO();
		 associationsDTO at=new associationsDTO();
		 Scanner in=new Scanner(System.in);
		 System.out.println("---增加社团表数据---");
		System.out.println("社团名:");
         at.setAname(in.nextLine());
         System.out.println("社团号:");
         at.setAno(in.nextLine());
         System.out.println("会长:");
         at.setMno(in.nextLine());
         System.out.println("学院号:");
         at.setDepart(in.nextLine());
         a.insertIntoassociations(at);
        // in.close();
	}
	public static void updateassociations() {
		findassociations() ;
		 associationsDAO a=new associationsDAO();
		 associationsDTO at=new associationsDTO();
		 Scanner in=new Scanner(System.in);
		 System.out.println("---请输入你要修改的社团号---");
         System.out.println("社团号:");
         at.setAno(in.nextLine());
         System.out.println("社团名:");
         at.setAname(in.nextLine());
         System.out.println("会长:");
         at.setMno(in.nextLine());
         System.out.println("学院号:");
         at.setDepart(in.nextLine());
         a.updateAssociations(at);
        // in.close();
	}
	public static void deleteassociations() {
		   associationsDAO a=new associationsDAO();
			Scanner in=new Scanner(System.in);
			System.out.println("请输入你要删除的社团号");
			String str = in.nextLine();
			a.deleteassociations(str);
			//in.close();
	    
	}
}
