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
//-----------------------------------��ѯ-----------------------------
public class financingDAO {
	   public Vector<financingDTO> findAllfinancing(){
		   Vector<financingDTO> v=new Vector<financingDTO>();
		   Connection conn=null;//
			  Statement stat=null;
			  ResultSet rs=null;
		      try {
					Class.forName("com.mysql.jdbc.Driver");//ע��jdbc��������
					conn=DriverManager.getConnection//JDBC�����ݿ⽨������
				      ("jdbc:mysql://localhost:3306/association","root","123");
				     stat=conn.createStatement();//����SQL������
				    String sql="select *from financing";
				    rs=stat.executeQuery(sql);//ִ��SQl��䲢���ؽ����ResultSet����
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
							System.out.println("�����ţ�"+v.get(i).getFno()+" ��ţ�"+v.get(i).getAcno()+ 
			             " �����ˣ�"+v.get(i).getMno()+" ���ѣ�"+v.get(i).getBudget());
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
	//-----------------------------------����---------------------------------
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
		//�������Ų����ڷ���2
		prep2=conn.prepareStatement("select * from activities where acno=?");
		prep2.setString(1,Acno);
		rs2=prep2.executeQuery();
		while(rs2.next()){
		//�����Ա�����ڸ�Э�᷵��2
		prep1=conn.prepareStatement("select * from members where Mno=? and Ano=?");
		prep1.setString(1,Mno);
		prep1.setString(2,rs2.getString("Ano"));
		rs1=prep1.executeQuery();
		while(!rs1.next()){
			flag=2;
			System.out.println("��ѧ��ѧ�������ڸ�����");
			return flag;
		}
		}
		//��ѧ�������źŶ�����ʱִ�в������
		prep=conn.prepareStatement("insert into financing values(?,?,?,?,?)");
		prep.setString(1, Fno);
		prep.setString(2, Acno);	
		prep.setString(3, Mno);
		prep.setInt(4, Budget);
		prep.setString(5, Access);
        int n=prep.executeUpdate();
		if(n!=0){
        flag=1;
		System.out.println("�ɹ�");
		}
			}catch (SQLException e)
	     {
				e.printStackTrace();
			}finally//����ر����ݿ��������
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
		    	   System.out.println("��������ʧ��");
		       }
     }
	        return flag;
     }
 //----------------------------------����--------------------------------------
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
		 System.out.println("���³ɹ�");
		    }
     }catch (SQLException e) {
			e.printStackTrace();
		}finally//����ر����ݿ��������
		{
			DataAccess.closeConnection(prep,conn);
		}
 	     
 	    if(flag==false)
        {
        	System.out.println("����ʧ��");
        }
    return flag;
}
     //------------------------------ɾ��-------------------------------
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
  	 		}finally//����ر����ݿ��������
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
  	    	   System.out.println("ɾ��ʧ��");
  	       }
  	  	 return flag;	   
     }

}
