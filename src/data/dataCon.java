package data;
import java.sql.*;

public class dataCon {
	static Connection conn=null;
	
	public static Connection getCon(){
		try{
		   Class.forName("com.mysql.jdbc.Driver");
	       String url="jdbc:mysql://localhost:3306/supermarket?characterEncoding=utf-8";
	       conn= DriverManager.getConnection(url, "root", "123456");
		}catch(Exception e){
			System.out.print("数据添加异常");
			e.printStackTrace();
		}
		return conn;
	}
}
