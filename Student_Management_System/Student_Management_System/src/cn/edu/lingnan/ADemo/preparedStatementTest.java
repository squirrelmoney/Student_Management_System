package cn.edu.lingnan.ADemo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class preparedStatementTest {
     public static void main(String[] args) {
    	Connection conn=null;//
		PreparedStatement prep=null;
		ResultSet rs=null;
	     try {
		Class.forName("com.mysql.jdbc.Driver");//注册jdbc驱动程序
		conn=DriverManager.getConnection//JDBC与数据库建立连接
		("jdbc:mysql://localhost:3306/association","root","123");
		//stat=conn.createStatement();//创建SQL语句对象
	   //rs=stat.executeQuery("select * from user");//执行SQl语句并返回结果给ResultSet对象
		//批处理
		prep=conn.prepareStatement("insert into department values(?,?)");
		prep.setString(1, "003");
		prep.setString(2, "物理院");
		prep.addBatch();
		prep.setString(1, "004");
		prep.setString(2, "2院");
		prep.addBatch();
		prep.setString(1, "005");
		prep.setString(2, "3院");
		prep.addBatch();
		int[] a=prep.executeBatch();
		for(int b:a)
		{
			System.out.println(b);
		}
		//批处理
		
		
		prep.executeUpdate();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally//倒叙关闭数据库相关连接
			{
			try 
			{
			if(rs!=null)
			rs.close();
			if(prep!=null)
			prep.close();
			if(conn!=null)
			conn.close();
			} catch (SQLException e) {
					
			e.printStackTrace();
			}
			   
			}
	       
		
	}	
	}

