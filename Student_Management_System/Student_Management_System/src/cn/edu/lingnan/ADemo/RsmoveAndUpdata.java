package cn.edu.lingnan.ADemo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import cn.edu.lingnan.util.DataAccess;

public class RsmoveAndUpdata {
//	---------------------2019.3.20-------结果集的更新与移动
	public static void main(String[] args) 
	{
         Connection conn=null;//
		  Statement stat=null;
		  ResultSet rs=null;
	      try {
	    	  //----1-----
			    conn=DataAccess.getConnection();
		        stat=conn.createStatement
		    		   (ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
				//----2-----
		        rs=stat.executeQuery("select * from members");
				System.out.println(rs.isBeforeFirst());
				rs.first();
				System.out.println(rs.isBeforeFirst());
				//rs.last();
				rs.relative(7);
				System.out.println(rs.isLast());
				System.out.println(rs.getString("Sname"));
			    rs.absolute(8);
			    rs.previous();
			    rs.previous();
			    rs.previous();
			    System.out.println(rs.getString("Sname"));
			    rs.first();
			    System.out.println(rs.getRow());
			    rs.last();
			    System.out.println(rs.getRow());
	      
			    //-------3-------
//			    rs.moveToInsertRow();
//			    rs.updateString("Sname", "Sary");
//			    rs.updateString("Mno", "20190324");
//			    rs.updateString("Age", "20");
//			    rs.updateInt("Password", 123456);
//			    rs.insertRow();
//			    rs.absolute(3);
//			    rs.updateString("Password", "12345");
//			    rs.updateRow();
			   
					 rs.last();
					 rs.deleteRow();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			finally//倒叙关闭数据库相关连接
			{
				DataAccess.closeConnection(rs, stat, conn);
			   
			}
	      }
	}

	



