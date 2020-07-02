package cn.edu.lingnan.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import cn.edu.lingnan.dto.financingDTO;
import cn.edu.lingnan.dto.memberDTO;
import cn.edu.lingnan.util.DataAccess;
//-----------------------------------查询-----------------------------
public class financingDAO {
	   public Vector<financingDTO> findAllfinancing(){
		   Vector<financingDTO> v=new Vector<financingDTO>();
		   Connection conn=null;//
			  Statement stat=null;
			  ResultSet rs=null;
		      try {
					Class.forName("com.mysql.jdbc.Driver");//注册jdbc驱动程序
					conn=DriverManager.getConnection//JDBC与数据库建立连接
				      ("jdbc:mysql://localhost:3306/association","root","123");
				     stat=conn.createStatement();//创建SQL语句对象
				    String sql="select *from financing";
				    rs=stat.executeQuery(sql);//执行SQl语句并返回结果给ResultSet对象
				        while(rs.next())
				        {
				        	financingDTO f=new financingDTO();
				        	f.setFno(rs.getString("Fno"));
				        	f.setAcno(rs.getString("Acno"));
				        	f.setMno(rs.getString("Mno"));
				        	f.setBudget(rs.getInt("Budget"));
				        	f.setAccess(rs.getString("Access"));
				        	v.add(f);
				        	
				        }
				        for(int i =0;i<v.size();i++)
						{
							System.out.println("财务表号："+v.get(i).getFno()+" 活动号："+v.get(i).getAcno()+ 
			             " 负责人："+v.get(i).getMno()+" 经费："+v.get(i).getBudget());
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
	//-----------------------------------插入---------------------------------
     public int insertIntoFinancing(financingDTO f)
     {
		int flag=0;
		String Fno=f.getFno();
		String Acno=f.getAcno();
		String Mno=f.getMno();
		int Budget=f.getBudget();
		String  Access=f.getAccess();
		Connection conn=null;
		PreparedStatement prep=null;
		PreparedStatement prep1=null;
		PreparedStatement prep2=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
	     try {
		conn=DataAccess.getConnection();
		//假设社团不存在返回2
		prep2=conn.prepareStatement("select * from activities where acno=?");
		prep2.setString(1,Acno);
		rs2=prep2.executeQuery();
		while(rs2.next()){
		//假设成员不存在该协会返回2
		prep1=conn.prepareStatement("select * from members where Mno=? and Ano=?");
		prep1.setString(1,Mno);
		prep1.setString(2,rs2.getString("Ano"));
		rs1=prep1.executeQuery();
		while(!rs1.next()){
			flag=2;
			System.out.println("该学生学生不存在该社团");
			return flag;
		}
		}
		//当学号与社团号都存在时执行插入操作
		prep=conn.prepareStatement("insert into financing values(?,?,?,?,?)");
		prep.setString(1, Fno);
		prep.setString(2, Acno);	
		prep.setString(3, Mno);
		prep.setInt(4, Budget);
		prep.setString(5, Access);
        int n=prep.executeUpdate();
		if(n!=0){
        flag=1;
		System.out.println("成功");
		}
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
 //----------------------------------更新--------------------------------------
     public boolean updatefiancing(financingDTO f)
     {
 		boolean flag=false;
 		String Fno=f.getFno();
 		String Acno=f.getAcno();
 		String Mno=f.getMno();
 		int Budget=f.getBudget();
 		String  Access=f.getAccess();
 		Connection conn=null;
 		PreparedStatement prep=null;
 	     try {
 		conn=DataAccess.getConnection();
 		prep=conn.prepareStatement("update financing set Budget=?,Acno=?,Mno=? ,Access=? where Fno=?");
 		prep.setInt(1, Budget);
 		prep.setString(2, Acno);
 		prep.setString(3, Mno);
 		prep.setString(4,Access);
 		prep.setString(5, Fno);
 		int n=prep.executeUpdate();
 		if(n!=0)
		    {
		     flag=true;
		 System.out.println("更新成功");
		    }
     }catch (SQLException e) {
			e.printStackTrace();
		}finally//倒叙关闭数据库相关连接
		{
			DataAccess.closeConnection(prep,conn);
		}
 	     
 	    if(flag==false)
        {
        	System.out.println("更新失败");
        }
    return flag;
}
     //------------------------------删除-------------------------------
     public boolean deleteFinancing(String _fno)
     {
  	     boolean flag=false;
  	  	 Connection conn=null;
  	  	 PreparedStatement prep=null;
	  	 PreparedStatement prep1=null;
	  	 ResultSet rs=null;
	  	ResultSet rs1=null;
  	  	//String _mno=m.getMno();
  	       try {
  	            conn=DataAccess.getConnection();
  	           conn.setAutoCommit(false);
  	     	    prep=conn.prepareStatement("delete from financing where Fno=?" );
  	 		    prep.setString(1,_fno);
  	 		 	conn.commit();
  	 		 	conn.setAutoCommit(true);
   	 		   int n=prep.executeUpdate();
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
  	 		}finally//倒叙关闭数据库相关连接
	 		{

	 			try 
	 			{
             	if(prep!=null)
	 				prep.close();
	 			if(prep1!=null)
	 			    prep1.close();
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
