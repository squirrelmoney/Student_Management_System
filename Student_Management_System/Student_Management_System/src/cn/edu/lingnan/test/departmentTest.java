package cn.edu.lingnan.test;

import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.DAO.associationsDAO;
import cn.edu.lingnan.DAO.departmentDAO;
import cn.edu.lingnan.dto.departmentDTO;

public class departmentTest {
    public static void main(String[] args) {
    	deletedepartment();
    }
    
        public static void finddepartment() {
    		departmentDTO d=new departmentDTO();
    		departmentDAO dm=new departmentDAO();
    		d.setNo("001");
    		d.setName("�����ѧԺ");
//    		System.out.println(dm.updatedepartment(d));
    		Vector<departmentDTO> v=new Vector<departmentDTO>();
    		v=dm.findAlldepartment();
    		
    	}
        public static void insertintodepartment() {
        	departmentDTO d=new departmentDTO();
    		departmentDAO dm=new departmentDAO();
    		Scanner in=new Scanner(System.in);
    		System.out.println("---����ѧԺ������---");
    		System.out.println("ѧԺ��:");
    		d.setNo(in.nextLine());
    		System.out.println("ѧԺ��:");
    		d.setName(in.nextLine());
    		dm.insertIntodepartment(d);
        }
        public static void updatedepartment(){
        	finddepartment();
        	departmentDTO d=new departmentDTO();
    		departmentDAO dm=new departmentDAO();
    		Scanner in=new Scanner(System.in);
    		System.out.println("---��������Ҫ�޸ĵ�ѧԺ��---");
    		System.out.println("ѧԺ��:");
    		d.setNo(in.nextLine());
    		System.out.println("ѧԺ��:");
    		d.setName(in.nextLine());
    		dm.updatedepartment(d); 
        }
    	public static void deletedepartment() {
    		departmentDAO d=new departmentDAO();
 			Scanner in=new Scanner(System.in);
 			System.out.println("��������Ҫɾ���Ĳ��ź�");
 			String str = in.nextLine();
 			d.deletedepartment(str);
 			//in.close();
 	    
 	}
    }

