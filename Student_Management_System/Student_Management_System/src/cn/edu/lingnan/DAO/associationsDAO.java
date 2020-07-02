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
//-----------------------------查询------------------------------------
	public Vector<associationsDTO> findAllassociations(){
		   Vector<associationsDTO> v=new Vector<associationsDTO>();
		   Connection conn=null;//
			  Statement stat=null;
			  ResultSet rs=null;
		      try {
					Class.forName("com.mysql.jdbc.Driver");//注册jdbc驱动程序
					conn=DriverManager.getConnection//JDBC与数据库建立连接
				      ("jdbc:mysql://localhost:3306/association","root","123");
				     stat=conn.createStatement();//创建SQL语句对象
				    String sql="select *from associations";
				    rs=stat.executeQuery(sql);//执行SQl语句并返回结果给ResultSet对象
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
							System.out.println("社团号："+v.get(i).getAno()+" 社团名："+v.get(i).getAname()+
									" 管理人："+v.get(i).getMno()+" 学院号："+v.get(i).getDepart());
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
	//--------------------------------------插入-------------------------------------------
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
			//假设学院号不存在返回3
			prep2=conn.prepareStatement("select * from department where No=?");
			prep2.setString(1,Depart);
			rs2=prep2.executeQuery();
			while(!rs2.next()){
				flag=3;
				System.out.println("学院号不存在");
				return flag;
			}
			//社团号存在时执行插入操作
			prep=conn.prepareStatement("insert into associations values(?,?,?,?)");
			prep.setString(1, Ano);
			prep.setString(2, Aname);
			prep.setString(3, Mno);	
			prep.setString(4, Depart);
			int n=prep.executeUpdate();
			if(n!=0){
			flag=1;
			}
			System.out.println("成功");
				}catch (SQLException e)
		     {
					e.printStackTrace();
				}finally//倒叙关闭数据库相关连接
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
			    	   System.out.println("插入数据失败");
			       }
		   
	   }
		     return flag;
	   }
//---------------------------------更新----------------------------------------------
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
		//假设学生号不存在返回
		prep1=conn.prepareStatement("select * from members where Mno=?");
		prep1.setString(1,Mno);
		rs=prep1.executeQuery();
		while(!rs.next()){
			System.out.println("学生号不存在");
			return flag;
		}
		//假设学院号不存在返回
				prep1=conn.prepareStatement("select * from department where No=?");
				prep1.setString(1,Depart);
				rs=prep1.executeQuery();
				while(!rs.next()){
					System.out.println("学院号不存在");
					return flag;
				}
		prep=conn.prepareStatement("update associations set Aname=?,Mno=?,depart=? where Ano=?");
        prep.setString(1, Aname);
        prep.setString(2, Mno);
        prep.setString(3, Depart);
        prep.setString(4, Ano);
        int n=prep.executeUpdate();//返回更新条数
		    if(n!=0)
		    {
		     flag=true; 
		    System.out.println("更新成功");
		    }
		  
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		DataAccess.closeConnection(prep, conn);
	}
	   if(flag==false)
       {
       	System.out.println("更新失败");
       }
	  return flag;
   }
   
   
   //------------------------------------删除---------------------------------------
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
	           
	            //-------------------删除活动------------
	            for(String a:v){
	            	activitiesDAO ac=new activitiesDAO();
	            	ac.deleteactivities(a);
	            }

	            //-------------------删除成员------------
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

			    //--------------------删除社团-------------
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
	 		}finally//倒叙关闭数据库相关连接
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
	    	   System.out.println("删除失败");
	       }
  	  	 return flag;   
   }
   
}
