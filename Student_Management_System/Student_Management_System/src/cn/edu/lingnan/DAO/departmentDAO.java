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
	//-------------------------------查询-----------------------------------
		   public Vector<departmentDTO> findAlldepartment(){
			   Vector<departmentDTO> v=new Vector<departmentDTO>();
			   Connection conn=null;//
				  Statement stat=null;
				  ResultSet rs=null;
			      try {
						Class.forName("com.mysql.jdbc.Driver");//注册jdbc驱动程序
						conn=DriverManager.getConnection//JDBC与数据库建立连接
					      ("jdbc:mysql://localhost:3306/association","root","123");
					     stat=conn.createStatement();//创建SQL语句对象
					    String sql="select *from department";
					    rs=stat.executeQuery(sql);//执行SQl语句并返回结果给ResultSet对象
					        while(rs.next())
					        {
					        	departmentDTO d=new departmentDTO();
					        	d.setNo(rs.getString("No"));
					        	d.setName(rs.getString("Name"));
					        	v.add(d);
					        	
					        }
					        for(int i =0;i<v.size();i++)
							{
								System.out.println("学院号："+v.get(i).getNo()+" 学院名："+v.get(i).getName());
							}      
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally//倒叙关闭数据库相关连接
					{
						 DataAccess.closeConnection(rs, stat, conn);
					     
					}
			   return v;
		}
		   
	//-------------------------------------插入-----------------------------------	   
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
					}finally//倒叙关闭数据库相关连接
					{
					DataAccess.closeConnection(prep, conn);

		             }
			     if(flag==0)
			       {
			    	   System.out.println("插入数据失败");
			       }
		        return flag;
		   }
//------------------------------更新---------------------------------------
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
   		   int n=prep.executeUpdate();//返回更新条数
   		    if(n!=0)
   		    {
   		     flag=true; 
    		 System.out.println("更新成功");
   		    }
   		  
   		} catch (SQLException e) {
   			e.printStackTrace();
   		}finally//倒叙关闭数据库相关连接
   		{
   			DataAccess.closeConnection(prep, conn);
   		   
   		}
         if(flag==false)
	       {
	    	   System.out.println("更新失败");
	       }
      return flag;
     }
     //------------------------------------删除---------------------------------------
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
  	            //-------------------删除社团------------
//  	            prep1=conn.prepareStatement("delete from associations where Depart=?" );
//  			    prep1.setString(1,_no);
//  			    prep1.executeUpdate();
  	    	    	  for(String c:v){
  	    	    		 associationsDAO a=new associationsDAO();
  	    				a.deleteassociations(c);
    		  		   	}
  			    //--------------------删除成员-------------
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
  	 		    //-------------------删除学院--------------
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
  	 		}finally//倒叙关闭数据库相关连接
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
	    	   System.out.println("删除失败");
	       }
  	  	 return flag;	   
     }
     private void deletemember(String a) {
		// TODO Auto-generated method stub
		
	}
}
