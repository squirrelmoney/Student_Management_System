package cn.edu.lingnan.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.dto.departmentDTO;
import cn.edu.lingnan.dto.financingDTO;
import cn.edu.lingnan.dto.memberDTO;
import cn.edu.lingnan.util.DataAccess;

public class departmentDAO {
	//-------------------------------��ѯ-----------------------------------
		   public Vector<departmentDTO> findAlldepartment(){
			   Vector<departmentDTO> v=new Vector<departmentDTO>();
			   Connection conn=null;//
				  Statement stat=null;
				  ResultSet rs=null;
			      try {
						Class.forName("com.mysql.jdbc.Driver");//ע��jdbc��������
						conn=DriverManager.getConnection//JDBC�����ݿ⽨������
					      ("jdbc:mysql://localhost:3306/association","root","123");
					     stat=conn.createStatement();//����SQL������
					    String sql="select *from department";
					    rs=stat.executeQuery(sql);//ִ��SQl��䲢���ؽ����ResultSet����
					        while(rs.next())
					        {
					        	departmentDTO d=new departmentDTO();
					        	d.setNo(rs.getString("No"));
					        	d.setName(rs.getString("Name"));
					        	v.add(d);
					        	
					        }
					        for(int i =0;i<v.size();i++)
							{
								System.out.println("ѧԺ�ţ�"+v.get(i).getNo()+" ѧԺ����"+v.get(i).getName());
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
		   
	//-------------------------------------����-----------------------------------	   
		   public int insertIntodepartment(departmentDTO d)
		   {
				int flag=0;
				String No=d.getNo();
		    	String Name=d.getName();
				
				Connection conn=null;
				PreparedStatement prep=null;
			     try {
				conn=DataAccess.getConnection();
				prep=conn.prepareStatement("insert into department values(?,?)");
				prep.setString(1, No);
				prep.setString(2, Name);
				int n=prep.executeUpdate();
				if(n!=0){
				flag=1;
				}
					}catch (SQLException e)
			     {
						e.printStackTrace();
					}finally//����ر����ݿ��������
					{
					DataAccess.closeConnection(prep, conn);

		             }
			     if(flag==0)
			       {
			    	   System.out.println("��������ʧ��");
			       }
		        return flag;
		   }
//------------------------------����---------------------------------------
     public boolean updatedepartment(departmentDTO d)
     {
    	 boolean flag=false;
    	 String No=d.getNo();
    	 String Name=d.getName();
    	 Connection conn=null;
    	 PreparedStatement prep=null;
         try {
            conn=DataAccess.getConnection();
       	    prep=conn.prepareStatement("update department set Name=? where No=?" );
   		    prep.setString(1,Name);
   		    prep.setString(2,No);
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
     public boolean deletedepartment(String _no)
     {
  	     boolean flag=false;
  	  	 Connection conn=null;
  	  	 PreparedStatement prep=null;
  	  	 PreparedStatement prep1=null;
  	  	 PreparedStatement prep2=null;
  	  	 PreparedStatement prep3=null;
  	  	 PreparedStatement prep4=null;
  	  	 PreparedStatement prep5=null;
  	  	 ResultSet rs=null;
  	  	ResultSet rs1=null;
  	  	//String _mno=m.getMno();
  	       try {
  	              conn=DataAccess.getConnection();
  	        	  
  	        	  prep=conn.prepareStatement
  	    	    ("select * from associations where Depart=?");
  	    	        prep.setString(1, _no);
  	    	        rs=prep.executeQuery();
  	    	        Vector<String> v=new Vector<String>();
  	    	        while(rs.next())
  	    	        {
  	    	        	v.add(rs.getString("Ano"));
  	    	        }
  	    	       prep1=conn.prepareStatement
  	    	    	 ("select * from members where Depart=?");
  	    	    	  prep1.setString(1, _no);
  	    	    	  rs1=prep1.executeQuery();
  	    	    	  Vector<String> v1=new Vector<String>();
  	    	    	  while(rs1.next())
  	    	    	  {
  	    	    	     v1.add(rs1.getString("Mno"));
  	    	    	   }
  	    	    	conn.setAutoCommit(false);
  	            //-------------------ɾ������------------
//  	            prep1=conn.prepareStatement("delete from associations where Depart=?" );
//  			    prep1.setString(1,_no);
//  			    prep1.executeUpdate();
  	    	    	  for(String c:v){
  	    	    		 associationsDAO a=new associationsDAO();
  	    				a.deleteassociations(c);
    		  		   	}
  			    //--------------------ɾ����Ա-------------
//  	     	    prep2=conn.prepareStatement("delete from members where Depart=?" );
//  	 		    prep2.setString(1,_no);
//  	 		    prep2.executeUpdate();
  	    	    	 for(String b:v1){
  	    	    		 for(String a:v)
  	    	    		 {
  	    	    		 memberDAO md=new memberDAO();
  	    	   		     md.deletemember(b,a);
  	    	    		 }
  	    		     }
  	 		    //-------------------ɾ��ѧԺ--------------
  	 		    prep3=conn.prepareStatement("delete from department where No=?" );
	 		    prep3.setString(1,_no);
	 		    int n=prep3.executeUpdate();
  	 		 	conn.commit();
  	 		 	conn.setAutoCommit(true);
  	 		 	if(n!=0){
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
  	 			if(rs1!=null)
  		 			rs1.close();
               	if(prep!=null)
  	 				prep.close();
  	 			if(prep1!=null)
  	 			    prep1.close();
  	 			if(prep2!=null)
  	 				prep2.close();
  	 			if(prep3!=null)
  	 			    prep3.close();
  	 			if(prep4!=null)
  	 				prep4.close();

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
     private void deletemember(String a) {
		// TODO Auto-generated method stub
		
	}
}
