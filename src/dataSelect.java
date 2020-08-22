import java.sql.*;
import java.util.*;

import data.dataCon;
public class dataSelect {

	public static Vector comdSele(String cname){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Vector vdata=new Vector();

		if(conn==null)
			conn=dataCon.getCon();
		String sql1="select*from tablecomd where cname=?";

		try{
		ps=conn.prepareStatement(sql1);
		ps.setString(1,cname);
		rs=ps.executeQuery();

		while(rs.next()){
			Vector vdata1=new Vector();
			vdata1.add(new Integer(rs.getInt(1)));
			vdata1.add(rs.getString(2));
			vdata1.add(rs.getString(3));
			vdata1.add(rs.getString(4));
			vdata1.add(new Double(rs.getDouble(5)));
			vdata1.add(rs.getString(6));
			vdata1.add(rs.getString(7));
			vdata1.add(new Double(rs.getDouble(8)));
			vdata1.add(rs.getString(9));
			vdata1.add(rs.getString(10));

			vdata.add(vdata1);

		}
		    ps.close();
		    rs.close();
			conn.close();
	}catch(Exception e){
			System.out.print("数据添加异常");
			e.printStackTrace();
		}


	      return vdata;

	}
	public static Vector comdbianhao(String cnum){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Vector vdata=new Vector();

		if(conn==null)
			conn=dataCon.getCon();
		String sql1="select*from tablecomd where cnum=?";

		try{
		ps=conn.prepareStatement(sql1);
		ps.setString(1,cnum);
		rs=ps.executeQuery();

		while(rs.next()){
			Vector vdata1=new Vector();
			vdata1.add(new Integer(rs.getInt(1)));
			vdata1.add(rs.getString(2));
			vdata1.add(rs.getString(3));
			vdata1.add(rs.getString(4));
			vdata1.add(new Double(rs.getDouble(5)));
			vdata1.add(rs.getString(6));
			vdata1.add(rs.getString(7));
			vdata1.add(new Double(rs.getDouble(8)));
			vdata1.add(rs.getString(9));
			vdata1.add(rs.getString(10));

			vdata.add(vdata1);

		}
		    ps.close();
		    rs.close();
			conn.close();
	}catch(Exception e){
			System.out.print("数据添加异常");
			e.printStackTrace();
		}


	      return vdata;

	}

	public static Vector comdtiaoxingma(String code){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Vector vdata=new Vector();

		if(conn==null)
			conn=dataCon.getCon();
		String sql1="select*from tablecomd where code=?";

		try{
		ps=conn.prepareStatement(sql1);
		ps.setString(1,code);
		rs=ps.executeQuery();

		while(rs.next()){
			Vector vdata1=new Vector();
			vdata1.add(new Integer(rs.getInt(1)));
			vdata1.add(rs.getString(2));
			vdata1.add(rs.getString(3));
			vdata1.add(rs.getString(4));
			vdata1.add(new Double(rs.getDouble(5)));
			vdata1.add(rs.getString(6));
			vdata1.add(rs.getString(7));
			vdata1.add(new Double(rs.getDouble(8)));
			vdata1.add(rs.getString(9));
			vdata1.add(rs.getString(10));

			vdata.add(vdata1);

		}
		    ps.close();
		    rs.close();
			conn.close();
	}catch(Exception e1){
			System.out.print("数据添加异常");
			e1.printStackTrace();
		}


	      return vdata;

	}

	public static Vector comdquanbu(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Vector vdata=new Vector();

		if(conn==null)
			conn=dataCon.getCon();
		String sql1="select*from tablecomd ";

		try{
		ps=conn.prepareStatement(sql1);

		rs=ps.executeQuery();

		while(rs.next()){
			Vector vdata1=new Vector();
			vdata1.add(new Integer(rs.getInt(1)));
			vdata1.add(rs.getString(2));
			vdata1.add(rs.getString(3));
			vdata1.add(rs.getString(4));
			vdata1.add(new Double(rs.getDouble(5)));
			vdata1.add(rs.getString(6));
			vdata1.add(rs.getString(7));
			vdata1.add(new Double(rs.getDouble(8)));
			vdata1.add(rs.getString(9));
			vdata1.add(rs.getString(10));

			vdata.add(vdata1);

		}
		    ps.close();
		    rs.close();
			conn.close();
	}catch(Exception e1){
			System.out.print("数据添加异常");
			e1.printStackTrace();
		}


	      return vdata;

	}









}
