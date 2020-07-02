package cn.edu.lingnan.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;
import cn.edu.lingnan.DAO.*;
import cn.edu.lingnan.dto.*;

import cn.edu.lingnan.util.DataAccess;

public class associationsDAO {
//-----------------------------��ѯ------------------------------------
	public Vector<associationsDTO> findAllassociations(){
		   Vector<associationsDTO> v=new Vector<associationsDTO>();
		   Connection conn=null;//
			  Statement stat=null;
			  ResultSet rs=null;
		      try {
					Class.forName("com.mysql.jdbc.Driver");//ע��jdbc��������
					conn=DriverManager.getConnection//JDBC�����ݿ⽨������
				      ("jdbc:mysql://localhost:3306/association","root","123");
				     stat=conn.createStatement();//����SQL������
				    String sql="select *from associations";
				    rs=stat.executeQuery(sql);//ִ��SQl��䲢���ؽ����ResultSet����
				        while(rs.next())
				        {
				        	associationsDTO a=new associationsDTO();
				        	a.setAno(rs.getString("Ano"));
				        	a.setAname(rs.getString("Aname"));
				        	a.setMno(rs.getString("Mno"));
				        	a.setDepart(rs.getString("Depart"));
				        	v.add(a);
				        	
				        }
				        for(int i =0;i<v.size();i++)
						{
							System.out.println("���źţ�"+v.get(i).getAno()+" ��������"+v.get(i).getAname()+
									" �����ˣ�"+v.get(i).getMno()+" ѧԺ�ţ�"+v.get(i).getDepart());
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
	   public int insertIntoassociations(associationsDTO a)
	   {
			int flag=0;
			 String Ano=a.getAno();
			 String Aname=a.getAname();
			 String Mno=a.getMno();
			 String Depart=a.getDepart();
			
			Connection conn=null;
			PreparedStatement prep=null;
			PreparedStatement prep1=null;
			PreparedStatement prep2=null;
			ResultSet rs1=null;
			ResultSet rs2=null;
		     try {
			conn=DataAccess.getConnection();
			//����ѧԺ�Ų����ڷ���3
			prep2=conn.prepareStatement("select * from department where No=?");
			prep2.setString(1,Depart);
			rs2=prep2.executeQuery();
			while(!rs2.next()){
				flag=3;
				System.out.println("ѧԺ�Ų�����");
				return flag;
			}
			//���źŴ���ʱִ�в������
			prep=conn.prepareStatement("insert into associations values(?,?,?,?)");
			prep.setString(1, Ano);
			prep.setString(2, Aname);
			prep.setString(3, Mno);	
			prep.setString(4, Depart);
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
//---------------------------------����----------------------------------------------
   public boolean updateAssociations(associationsDTO a)
   {
	   boolean flag=false;
	   String Ano=a.getAno();
	   String Aname=a.getAname();
	   String Mno=a.getMno();
	   String Depart=a.getDepart();
	   Connection conn=null;
	   PreparedStatement prep=null;
	   PreparedStatement prep1=null;
	   ResultSet rs=null;
	   try {
		conn=DataAccess.getConnection();
		//����ѧ���Ų����ڷ���
		prep1=conn.prepareStatement("select * from members where Mno=?");
		prep1.setString(1,Mno);
		rs=prep1.executeQuery();
		while(!rs.next()){
			System.out.println("ѧ���Ų�����");
			return flag;
		}
		//����ѧԺ�Ų����ڷ���
				prep1=conn.prepareStatement("select * from department where No=?");
				prep1.setString(1,Depart);
				rs=prep1.executeQuery();
				while(!rs.next()){
					System.out.println("ѧԺ�Ų�����");
					return flag;
				}
		prep=conn.prepareStatement("update associations set Aname=?,Mno=?,depart=? where Ano=?");
        prep.setString(1, Aname);
        prep.setString(2, Mno);
        prep.setString(3, Depart);
        prep.setString(4, Ano);
        int n=prep.executeUpdate();//���ظ�������
		    if(n!=0)
		    {
		     flag=true; 
		    System.out.println("���³ɹ�");
		    }
		  
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		DataAccess.closeConnection(prep, conn);
	}
	   if(flag==false)
       {
       	System.out.println("����ʧ��");
       }
	  return flag;
   }
   
   
   //------------------------------------ɾ��---------------------------------------
   public boolean deleteassociations(String _ano)
   {
	     boolean flag=false;
	  	 Connection conn=null;
	  	 PreparedStatement prep=null;
	  	 PreparedStatement prep1=null;
	  	 PreparedStatement prep2=null;
	  	 ResultSet rs=null;
	  	ResultSet rs1=null;
	  	//String _mno=m.getMno();
	       try {
	            conn=DataAccess.getConnection();
	            prep=conn.prepareStatement
	      	    ("select * from activities where Ano=?");
	      	    prep.setString(1, _ano);
	      	    rs=prep.executeQuery();
	      	    Vector<String> v=new Vector<String>();
	      	    while(rs.next())
	      	    {
	      	    	v.add(rs.getString("Acno"));
	      	    }
	        	conn.setAutoCommit(false);
	           
	            //-------------------ɾ���------------
	            for(String a:v){
	            	activitiesDAO ac=new activitiesDAO();
	            	ac.deleteactivities(a);
	            }

	            //-------------------ɾ����Ա------------
	            prep1=conn.prepareStatement
	      	    ("select * from members where Ano=?");
	      	    prep1.setString(1, _ano);
	      	    rs1=prep1.executeQuery();
	      	    Vector<String> v1=new Vector<String>();
    	      	 while(rs1.next())
 	      	    {
 	      	    	v1.add(rs1.getString("Mno"));
 	      	    	
 	      	    }
    	      	memberDAO ad=new memberDAO();
	            	for(String b:v1){
	            	ad.deletemember(b,_ano);
	            	flag=true;
	            }

			    //--------------------ɾ������-------------
	     	    prep2=conn.prepareStatement("delete from associations where Ano=?" );
	 		    prep2.setString(1,_ano);
	 		    int n=prep2.executeUpdate();
	 		 	if(n!=0){
	 		 		 flag=true;
	 		 	}
	 		 	conn.commit();
	 		 	conn.setAutoCommit(true);
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
