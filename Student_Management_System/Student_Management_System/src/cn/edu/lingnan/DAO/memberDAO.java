package cn.edu.lingnan.DAO;

import java.sql.*;
import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.dto.*;
import cn.edu.lingnan.util.DataAccess;
public class memberDAO {
	//---------------------------����������Ĳ�ѯ------------------------------------------------
      public int findMemberByNameAndPassword(String _mno,String _password,String _ano){
      int flag=0;
//      String Mno=m.getMno();
//   	  String Password=m.getPassword();
      Connection conn=null;//
	  PreparedStatement prep=null;
	  PreparedStatement prep1=null;
	  ResultSet rs=null;
	  ResultSet rs1=null;
      try {
		    conn=DataAccess.getConnection();
    	    prep=conn.prepareStatement("select * from members where Mno=? and Password=? and Ano=?" );
		    prep.setString(1,_mno);
		    prep.setString(2,_password);
		    prep.setString(3,_ano);
		    rs=prep.executeQuery();
			if(rs.next())
		        {
		        	flag=rs.getInt("sSuper");
		        }
			else{
				 prep1=conn.prepareStatement("select * from admin where name=? and password=? " );
				 prep1.setString(1,_mno);
				 prep1.setString(2,_password);
				 rs1=prep1.executeQuery();
				 if(rs1.next())
			        {
			        	flag=rs1.getInt("sSuper");
			        }
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally//����ر����ݿ��������
		{
			DataAccess.closeConnection(rs, prep, conn);
		   
		}
      return flag;
}
      
//-----------------------------------�����������ų�Ա��¼---------------------------------
   public Vector<memberDTO> findAllMember(){
	   Vector<memberDTO> v=new Vector<memberDTO>();
	   Connection conn=null;//
		  Statement stat=null;
		  ResultSet rs=null;
	      try {
				Class.forName("com.mysql.jdbc.Driver");//ע��jdbc��������
				conn=DriverManager.getConnection//JDBC�����ݿ⽨������
			      ("jdbc:mysql://localhost:3306/association","root","123");
			     stat=conn.createStatement();//����SQL������
			    String sql="select *from members";
			    rs=stat.executeQuery(sql);//ִ��SQl��䲢���ؽ����ResultSet����
			        while(rs.next())
			        {
			        	memberDTO m=new memberDTO();
			        	m.setMno(rs.getString("Mno"));
			        	m.setPassword(rs.getString("Password"));
			        	m.setSname(rs.getString("Sname"));
			        	m.setAge(rs.getInt("Age"));
			        	m.setGender(rs.getString("Gender"));
			        	m.setAno(rs.getString("Ano"));
			        	m.setTitle(rs.getString("Title"));
			        	m.setDepart(rs.getString("Depart"));
			        	m.setsSuper(rs.getInt("sSuper"));
			        	v.add(m);
			        	
			        }
			        for(int i =0;i<v.size();i++)
					{
						System.out.println("ѧ�ţ�"+v.get(i).getMno()+" ���룺"+v.get(i).getPassword()+" ������"+v.get(i).getSname()
						+" ���䣺"+v.get(i).getAge()+" �Ա�"+v.get(i).getGender()+"  ���ź�"+v.get(i).getAno()
						+" ְ�ƣ�"+v.get(i).getTitle()+" ѧԺ�ţ�"+v.get(i).getDepart()+" Ȩ�ޣ�"+v.get(i).getsSuper());
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
//-----------------------------------����----------------------------------
   public int insertIntomember(memberDTO m)
   {
		int flag=0;
	  	 String Mno=m.getMno();
	  	 String Password=m.getPassword();
	  	 String Sname= m.getSname();
		 int Age=m.getAge();
		 String Gender=m.getGender();
		 String Ano=m.getAno();
		 String Title=m.getTitle();
		 String Depart=m.getDepart();
		 int sSuper=m.getsSuper();
		Connection conn=null;
		PreparedStatement prep=null;
		PreparedStatement prep1=null;
		PreparedStatement prep2=null;
		ResultSet rs1=null;
		ResultSet rs2=null;
	     try {
		conn=DataAccess.getConnection();
		//�������źŲ����ڷ���2
		prep1=conn.prepareStatement("select * from associations where Ano=?");
		prep1.setString(1,Ano);
		rs1=prep1.executeQuery();
		while(!rs1.next()){
			flag=2;
			System.out.println("���źŲ�����");
			return flag;
		}
		//����ѧԺ�Ų����ڷ���3
		prep2=conn.prepareStatement("select * from department where No=?");
		prep2.setString(1,Depart);
		rs2=prep2.executeQuery();
		while(!rs2.next()){
			flag=3;
			System.out.println("ѧԺ�Ų�����");
			return flag;
		}
		//��ѧ�������źŶ�����ʱִ�в������
		prep=conn.prepareStatement("insert into members values(?,?,?,?,?,?,?,?,?)");
		prep.setString(1, Mno);
		prep.setString(2, Ano);	
		prep.setString(3, Sname);
		prep.setString(4, Password);	
		prep.setInt(5, Age);
		prep.setString(6, Gender);
		prep.setString(7, Title);
		prep.setString(8, Depart);
		prep.setInt(9, sSuper);
		prep.executeUpdate();
		flag=1;
		System.out.println("��ӳɹ�");
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
//-----------------------------------------����-----------------------------------------------
   public boolean updatemember(memberDTO m)
   {
  	 boolean flag=false;
  	 String Mno=m.getMno();
  	 String Password=m.getPassword();
  	 String Sname= m.getSname();
	 int Age=m.getAge();
	 int sSuper=m.getsSuper();
	 String Gender=m.getGender();
	 String Ano=m.getAno();
	 String Title=m.getTitle();
	 String Depart=m.getDepart();
  	 Connection conn=null;
  	 PreparedStatement prep=null;
  	 ResultSet rs=null;
       try {
            conn=DataAccess.getConnection();
     	    prep=conn.prepareStatement
     ("update members set Sname=?, Password=?,Age=?,Gender=?,Title=?,Depart=?,sSuper=? where Mno=? and Ano=?" );
 		    prep.setString(1,Sname);
 		    prep.setString(2,Password);
 		    prep.setInt(3,Age);
 		    prep.setString(4, Gender);
 		    prep.setString(5, Title);
 		    prep.setString(6, Depart);
 		   prep.setInt(7, sSuper);
 		    prep.setString(8, Mno);
 		    prep.setString(9, Ano);
 		   int n=prep.executeUpdate();
 		   if(n!=0)
  		    {
  		     flag=true;
   		     System.out.println("���³ɹ�");
  		    }
 		} catch (SQLException e) {
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
   
   //------------------------------------ɾ��---------------------------------------
   public boolean deletemember(String _mno,String _ano)
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
	  	ResultSet rs2=null;
	  	//String _mno=m.getMno();
	       try {
	            conn=DataAccess.getConnection();
	             Vector<String> v=new Vector<String>();
	             prep1=conn.prepareStatement
	          	  ("select count(*) as num from members where Ano=?");
	          	  prep1.setString(1,_ano);
	          	  rs1=prep1.executeQuery();
	          	  rs1.next();
	          	   if(Integer.parseInt(rs1.getString("num"))==1)
	          	    {//�ж��ǲ���ֻ��һλ��Ա
	          	       v.add(_ano);
	          	    } 
	        	 conn.setAutoCommit(false);
	             clearMno(_mno,_ano);//��ɾ���᳤������ʱ�������ű������������ػ᳤�븺������Ϊ��
	             //-------------------ɾ���-------------
//	             prep2=conn.prepareStatement
//	     	    	    ("select * from activities where Mno=? and Ano=?");
//	     	            prep2.setString(1, _mno);
//	     	           prep2.setString(1, _ano);
//	     	            rs2=prep2.executeQuery();
//	     	           Vector<String> v1=new Vector<String>();
//			      	    while(rs2.next())
//			      	    {
//			      	    	v1.add(rs2.getString("Acno"));
//			      	    }
//			      	    for(String a:v1){
//			      	    	activitiesDAO ac=new activitiesDAO();
//			      	    	ac.deleteactivities(a);
//			      	    }
			    //--------------------ɾ����Ա-------------
	     	    prep3=conn.prepareStatement("delete from members where Mno=? and Ano=?" );
	 		    prep3.setString(1,_mno);
	 		   prep3.setString(2,_ano);
	 		    int n=prep3.executeUpdate();
	 		    //-------------------ɾ������--------------
	 		 	for(String a:v){ 
		  		   	prep4=conn.prepareStatement("delete from associations where Ano=?" );
				    prep4.setString(1,a);
				    int n1=prep4.executeUpdate();		
				    if(n1!=0)
				    System.out.println("��Ҫɾ���ĳ�Ա������ֻ��һλ��Ա���Ѱ����ź���ػɾ��");
		  		   	}
	 		 	conn.commit();
	 		 	conn.setAutoCommit(true);
	  	 		    if(n!=0)
				    {
				     flag=true;
				     System.out.println("ɾ����Ա�ɹ�");
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
  	    	   System.out.println("ɾ��ʧ��");
  	       }
	  	 return flag;	   
        }
   //-----------��ɾ���᳤������ʱ�������ű������������ػ᳤�븺������Ϊ��--------------
   public static boolean clearMno(String _mno,String _ano){
	   boolean flag=false;
	  	 Connection conn=null;
	  	 ResultSet rs=null;
	  	ResultSet rs1=null;
	  	ResultSet rs2=null;
	  	 PreparedStatement prep=null;
	  	PreparedStatement prep1=null;
	  	PreparedStatement prep2=null;
	  	PreparedStatement prep3=null;
	  	PreparedStatement prep4=null;
	  	PreparedStatement prep5=null;
	  	
	  	try {
	  		 conn=DataAccess.getConnection();
	        prep=conn.prepareStatement
	        		("select * from associations where Mno=? and Ano=?");
            prep.setString(1,_mno);
            prep.setString(2,_ano);
	        rs=prep.executeQuery();
	       while(rs.next())
	       {
	    	prep1=conn.prepareStatement("update associations set Mno=null where Mno=? and Ano=?" );
	    	prep1.setString(1,_mno);
	    	 prep1.setString(2,_ano);
		    int n=prep1.executeUpdate();
		    if(n!=0){
		    	System.out.println("��Ҫɾ����Ϊ�᳤���ѰѸø�������Ż᳤��Ϊ��");
		    }
	       }
	       prep4=conn.prepareStatement("select * from activities where Mno=? and Ano=?");
           prep4.setString(1,_mno);
           prep4.setString(2,_ano);
	       rs2=prep4.executeQuery();
	       while(rs2.next())
	       {
	    	prep5=conn.prepareStatement("update activities set Mno=null where Mno=?" );
		    prep5.setString(1,_mno);
		    int n1=prep5.executeUpdate();
		    if(n1!=0){
		    System.out.println("��Ҫɾ����Ϊ������ˣ��ѰѸø���Ļ��������Ϊ��");
		    }
		    prep2=conn.prepareStatement("select * from financing where Mno=? and Acno=?");
	           prep2.setString(1,_mno);
	           prep2.setString(2,rs2.getString("Acno"));
		       rs1=prep2.executeQuery();
		       while(rs1.next())
		       {
		    	prep3=conn.prepareStatement("update financing set Mno=null where Mno=? and Acno=?" );
			    prep3.setString(1,_mno);
			    prep3.setString(2,rs1.getString("Acno"));
			    int n3=prep3.executeUpdate();
			    if(n3!=0){
			    System.out.println("��Ҫɾ����Ϊ���Ų������ˣ��ѰѸø�������Ų����������Ϊ��");

			    }
		       } 
	       } 
	      
		    flag=true;
    }catch (SQLException e) {
		e.printStackTrace();
	}finally//����ر����ݿ��������
	{
		try 
		{
		if(rs!=null)
		rs.close();
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
		if(prep3!=null)
		    prep3.close();
		if(prep4!=null)
			prep4.close();
		if(prep5!=null)
		    prep5.close();
		if(conn!=null)
		conn.close();
		} catch (SQLException e) {
				
		e.printStackTrace();
		}
  
}
	  	 return flag;
}
}