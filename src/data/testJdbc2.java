package data;
import java.sql.*;

public class testJdbc2 {

	public static void main(String[] args)  throws Exception{
		   // TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
       Class.forName("com.mysql.jdbc.Driver");
       String url="jdbc:mysql://localhost:3306/database1";
       conn= DriverManager.getConnection(url, "root", "977900");
       
       /*  ps ��������
       String sql="insert into table1(snum,sname,ssex)values(?,?,?)";   //1.
       ps=conn.prepareStatement(sql);
       
       ps.setInt(1, 100107);     //2.
       ps.setString(2, "xiaozhao");
       ps.setString(3, "nan");
       
       ps.executeUpdate();    //3.
       */
       
       /*    ps ɾ������                                            
       String sql="delete from table1 where snum=?";
       ps=conn.prepareStatement(sql);
       
       ps.setInt(1,103100);
       
       ps.executeUpdate();
      */ 
       
       
       String sql="update table1 set sname=?,ssex=? where snum=?";     //ps  ��������
       ps=conn.prepareStatement(sql);
       
       ps.setString(1, "zhaoli");
       ps.setString(2, "nan");
       ps.setInt(3, 100200);  
       
       ps.executeUpdate();
       ps.close();
       
           //ps ��ѯ
       String sql1="select * from table1 ";
       ps=conn.prepareStatement(sql1);
       rs=ps.executeQuery();
       
       System.out.println("    ѧ��                        ����                         �Ա�  ");
       while(rs.next()){
    	   System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"   "+rs.getString(3));
       }       
       
      rs.close();
      ps.close();
      conn.close();
      	
	}

}
