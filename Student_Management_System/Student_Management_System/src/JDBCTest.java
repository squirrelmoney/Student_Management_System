import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCTest {

	public static void main(String[] args) {
		    Connection conn=null;//
			Statement stat=null;
			ResultSet rs=null;
	        try {
				Class.forName("com.mysql.jdbc.Driver");//注册jdbc驱动程序
				conn=DriverManager.getConnection//JDBC与数据库建立连接
			      ("jdbc:mysql://localhost:3306/test","root","123");
			    stat=conn.createStatement();//创建SQL语句对象
			    rs=stat.executeQuery("select * from user");//执行SQl语句并返回结果给ResultSet对象
			        while(rs.next())
			        {
			        	System.out.println(rs.getString("name"));
			        	System.out.println(rs.getString("age"));
			        }
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
						 if(stat!=null)
						 stat.close();
						 if(stat!=null)
						 conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			   
			}
	       
		
	}
}

