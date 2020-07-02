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
				Class.forName("com.mysql.jdbc.Driver");//ע��jdbc��������
				conn=DriverManager.getConnection//JDBC�����ݿ⽨������
			      ("jdbc:mysql://localhost:3306/test","root","123");
			    stat=conn.createStatement();//����SQL������
			    rs=stat.executeQuery("select * from user");//ִ��SQl��䲢���ؽ����ResultSet����
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
			}finally//����ر����ݿ��������
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

