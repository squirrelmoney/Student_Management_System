package cn.edu.lingnan.ADemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread.State;
import java.sql.*;

import com.mysql.jdbc.Blob;

import cn.edu.lingnan.util.DataAccess;

public class BlobTest {
       public static void main(String[] args) {
		PreparedStatement prep=null;
		Connection conn=null;
	    ResultSet rs=null;
	    Statement stat=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection//JDBC与数据库建立连接
				      ("jdbc:mysql://localhost:3306/association","root","123");
			//----BLOB存------
//			File f=new File("C:\\01.jpg");
//			FileInputStream fis=new FileInputStream(f);
//		    prep=conn.prepareStatement("insert into blobtable values(?,?)");
//			prep.setInt(1, 1);
//			prep.setBinaryStream(2, fis, (int)f.length());
//			prep.executeUpdate();
			//------BLOB取-------
//			stat=conn.createStatement();
//			rs=stat.executeQuery("select * from blobtable where Id=1");
//			//Blob b= rs.getBlob("Binaryfile");
//			rs.next();
//			InputStream is=rs.getBinaryStream("Binaryfile"); 
//			File f=new File("c:\\p1.jpg");
//			FileOutputStream fos =new FileOutputStream(f);
//			int i=0;
//			while((i=is.read())!=-1){
//					fos.write(i);
//				}
			//----CLOB存------
//			File f=new File("C:\\file.txt");
//			FileInputStream fis=new FileInputStream(f);
//		    prep=conn.prepareStatement("insert into clobtable values(?,?)");
//			prep.setInt(1, 2);
//			//prep.setBinaryStream(2, fis, (int)f.length());
//			prep.setAsciiStream(2, fis, (int)f.length());
//			prep.executeUpdate();
			//-------ClOB取-----
			stat=conn.createStatement();
			rs=stat.executeQuery("select * from clobtable where Id=2");
			//Blob b= rs.getBlob("Binaryfile");
			rs.next();
			InputStream is=rs.getBinaryStream("Textfile"); 
			File f=new File("c:\\file1.txt");
			FileOutputStream fos =new FileOutputStream(f);
			int i=0;
			while((i=is.read())!=-1){
					fos.write(i);
				}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		  catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}finally{
		DataAccess.closeConnection(rs,prep, conn);
	}
		
	}
    }

