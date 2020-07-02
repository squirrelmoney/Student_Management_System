package cn.edu.lingnan.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.dto.activitiesDTO;
import cn.edu.lingnan.dto.associationsDTO;
import cn.edu.lingnan.dto.departmentDTO;
import cn.edu.lingnan.dto.financingDTO;
import cn.edu.lingnan.util.DataAccess;

public class activitiesDAO {
	//-------------------------------��ѯ-----------------------------------
	 public Vector<activitiesDTO> findAllactivities(){	 
		Vector<activitiesDTO> v=new Vector<activitiesDTO>();
	   Connection conn=null;//
		  Statement stat=null;
		  ResultSet rs=null;
	      try {
				Class.forName("com.mysql.jdbc.Driver");//ע��jdbc��������
				conn=DriverManager.getConnection//JDBC�����ݿ⽨������
			      ("jdbc:mysql://localhost:3306/association","root","123");
			     stat=conn.createStatement();//����SQL������
			    String sql="select *from activities";
			    rs=stat.executeQuery(sql);//ִ��SQl��䲢���ؽ����ResultSet����
			        while(rs.next())
			        {
			        	activitiesDTO ac=new activitiesDTO();
			        	ac.setAcno(rs.getString("Acno"));
			        	ac.setAno(rs.getString("Ano"));
			        	ac.setAcname(rs.getString("Acname"));
			        	ac.setMno(rs.getString("Mno"));
			        	ac.setAccess(rs.getString("Access"));
			        	v.add(ac);
			        	
			        }
			        for(int i =0;i<v.size();i++)
					{
					System.out.println("��ţ�"+v.get(i).getAcno()+" ���źţ�"+v.get(i).getAno()+
					" �����"+v.get(i).getAcname()+" �����ˣ�"+v.get(i).getMno()+" ��ˣ�"+v.get(i).getAccess());
					}      
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally//����ر����ݿ��������
			{
				 DataAccess.closeConnection(rs, stat, conn);
			     
			}
	   return v;
	}
	 
	//--------------------------------------����-------------------------------------------
	   public int insertIntoactivities(activitiesDTO ac)
	   {
			int flag=0;
		   	 String Acno=ac.getAcno();
	    	 String Ano=ac.getAno();
	    	 String Acname=ac.getAcname();
	    	 String  Mno=ac.getMno();
	    	 String  Access=ac.getAccess();
			Connection conn=null;
			PreparedStatement prep=null;
			PreparedStatement prep1=null;
			PreparedStatement prep2=null;
			ResultSet rs1=null;
			ResultSet rs2=null;
		     try {
			conn=DataAccess.getConnection();
			//����ѧ���Ų����ڷ���2
			prep1=conn.prepareStatement("select * from members where Mno=? and Ano=?");
			prep1.setString(1,Mno);
			prep1.setString(2, Ano);
			rs1=prep1.executeQuery();
			while(!rs1.next()){
				flag=2;
				System.out.println("��ѧ�����ڸ�����");
				return flag;
			}
			//�������Ų����ڷ���3
			prep2=conn.prepareStatement("select * from Associations where Ano=?");
			prep2.setString(1,Ano);
			rs2=prep2.executeQuery();
			while(!rs2.next()){
				flag=3;
				System.out.println("���źŲ�����");
				return flag;
			}
			//������ʱִ�в������
			prep=conn.prepareStatement("insert into activities values(?,?,?,?,?)");
			prep.setString(1, Acno);
			prep.setString(2, Ano);
			prep.setString(3, Acname);	
			prep.setString(4, Mno);
			prep.setString(5, Access);
			int n=prep.executeUpdate();
			if(n!=0){
				flag=1;
			}
			
			System.out.println("�ɹ�");
				}catch (SQLException e)
		     {
					e.printStackTrace();
				}finally//����ر����ݿ��������
				{
				try 
				{
				if(rs1!=null)
				rs1.close();
				if(rs2!=null)
					rs2.close();
				if(prep!=null)
					prep.close();
				if(prep1!=null)
				    prep1.close();
				if(prep2!=null)
					prep2.close();
				if(conn!=null)
				conn.close();
				} catch (SQLException e) {
						
				e.printStackTrace();
				}
				  if(flag==0)
			       {
			    	   System.out.println("��������ʧ��");
			       }
				}
		      return flag;
	   
	   }
	   
	   
	   
//---------------------------------����------------------------------------------------
	 public boolean updateactivities(activitiesDTO ac)
     {
    	 boolean flag=false;
    	 String Acno=ac.getAcno();
    	 String Ano=ac.getAno();
    	 String Acname=ac.getAcname();
    	 String  Mno=ac.getMno();
    	 String  Access=ac.getAccess();
    	 Connection conn=null;
    	 PreparedStatement prep=null;
    	 PreparedStatement prep1=null;
    	 PreparedStatement prep2=null;
    	 ResultSet rs=null;
    	 ResultSet rs1=null;
    	 ResultSet rs2=null;
         try {
          conn=DataAccess.getConnection();
           //����ѧ���Ų����ڷ���2
			prep1=conn.prepareStatement("select * from members where Mno=? and Ano=?");
			prep1.setString(1,Mno);
			prep1.setString(2, Ano);
			rs1=prep1.executeQuery();
			while(!rs1.next()){
				System.out.println("��ѧ�����ڸ�����");
				return flag;
			}
			//�������Ų����ڷ���3
			prep2=conn.prepareStatement("select * from Associations where Ano=?");
			prep2.setString(1,Ano);
			rs2=prep2.executeQuery();
			while(!rs2.next()){
				System.out.println("���źŲ�����");
				return flag;
			}
       	    prep=conn.prepareStatement("update activities set Ano=?, Acname=? ,Mno=? ,Access=? where Acno=?" );
   		    prep.setString(1,Ano);
   		    prep.setString(2,Acname);
   		    prep.setString(3,Mno);
		    prep.setString(4,Access);
		    prep.setString(5,Acno);
   		    int n=prep.executeUpdate();//���ظ�������
		    if(n!=0)
		    {
		     flag=true; 
 		     System.out.println("���³ɹ�");
		    }
		  
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}finally//����ر����ݿ��������
   		{
   			DataAccess.closeConnection(prep, conn);
   		   
   		}
         if(flag==false)
         {
         	System.out.println("����ʧ��");
         }
    	 return flag;
     }
	 
	 //------------------------------------ɾ��---------------------------------------
	   public boolean deleteactivities(String _acno)
	   {
		     boolean flag=false;
		  	 Connection conn=null;
		  	 PreparedStatement prep=null;
		  	 PreparedStatement prep1=null;
		  	 PreparedStatement prep2=null;
		  	 ResultSet rs=null;
		  	//String _mno=m.getMno();
		       try {
		            conn=DataAccess.getConnection();
		            prep=conn.prepareStatement
		      	    ("select * from financing where Acno=?");
		      	    prep.setString(1, _acno);
		      	    rs=prep.executeQuery();
		      	    Vector<String> v=new Vector<String>();
		      	    while(rs.next())
		      	    {
		      	    	v.add(rs.getString("fno"));
		      	    }
		        	conn.setAutoCommit(false);
		           
		            //-------------------ɾ������------------
		            for(String a:v){
		            	financingDAO fd=new financingDAO();
		          		fd.deleteFinancing(a);
		    
		            }
				    //--------------------ɾ���-------------
		     	    prep2=conn.prepareStatement("delete from activities where Acno=?" );
		 		    prep2.setString(1,_acno);
		 		   int n=prep2.executeUpdate();
		 		 	conn.commit();
		 		 	conn.setAutoCommit(true);
		  	 		    if(n!=0)
					    {
					     flag=true;
					    }
		 		 }catch (SQLException e) {
		 			try {
						conn.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		 			e.printStackTrace();
		 		}finally//����ر����ݿ��������
		 		{

		 			try 
		 			{
		 			if(rs!=null)
		 			rs.close();
	             	if(prep!=null)
		 				prep.close();
		 			if(prep1!=null)
		 			    prep1.close();
		 			if(prep2!=null)
		 				prep2.close();
		 			if(conn!=null)
		 			conn.close();
		 			} catch (SQLException e) {
		 					
		 			e.printStackTrace();
		 			}
		 		}
		       if(flag==false)
	  	       {
	  	    	   System.out.println("ɾ��ʧ��");
	  	       }
		  	 return flag;	   
	   }
	   
}
