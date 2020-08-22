package data;
import java.sql.*;

public class dataInsert {
	//public static int comdInsert(String cnum,String code,String knum,String cname,double price,String guige,String danwei,double jinjia,String baozhiqi,String beizhu)
	public static int comdInsert(String cnum,String code,String knum,String cname,double price,String guige,String danwei,double jinjia,String baozhiqi,String beizhu)
	{
		Connection conn=null;
		PreparedStatement ps=null;
		int i=0;
		if(conn==null)
		  conn=dataCon.getCon();
		 
		
		String sql="insert into tablecomd(cnum,code,knum,cname,price,guige,danwei,jinjia,baozhiqi,beizhu)values(?,?,?,?,?,?,?,?,?,?)";
		try{
		   ps=conn.prepareStatement(sql);
	       
	       ps.setString(1,cnum);     //2.
	       ps.setString(2,code);
	       ps.setString(3,knum);
	       ps.setString(4,cname);
	       ps.setDouble(5,price);
	       ps.setString(6,guige);
	       ps.setString(7,danwei);
	       ps.setDouble(8,jinjia);
	       ps.setString(9,baozhiqi);
	       ps.setString(10,beizhu);
	       
	       i=ps.executeUpdate();
	       ps.close();
			conn.close();
		}catch(Exception e1){
			System.out.print("数据添加异常");
			e1.printStackTrace();
		}
		return i;
		}
		
}
