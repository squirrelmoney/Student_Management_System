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
		Class.forName("com.mysql.jdbc.Driver");//ע��jdbc��������
		conn=DriverManager.getConnection//JDBC�����ݿ⽨������
		("jdbc:mysql://localhost:3306/association","root","123");
		//stat=conn.createStatement();//����SQL������
	   //rs=stat.executeQuery("select * from user");//ִ��SQl��䲢���ؽ����ResultSet����
		//������
		prep=conn.prepareStatement("insert into department values(?,?)");
		prep.setString(1, "003");
		prep.setString(2, "����Ժ");
		prep.addBatch();
		prep.setString(1, "004");
		prep.setString(2, "2Ժ");
		prep.addBatch();
		prep.setString(1, "005");
		prep.setString(2, "3Ժ");
		prep.addBatch();
		int[] a=prep.executeBatch();
		for(int b:a)
		{
			System.out.println(b);
		}
		//������
		
		
		prep.executeUpdate();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally//����ر����ݿ��������
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

