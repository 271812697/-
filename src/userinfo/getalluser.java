package userinfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class getalluser {
	static List<user> E;
	public static Connection con=null;
	
	public static int getid() {
		for(int i=1;i<E.size()+2;i++) {
			boolean flag=false;
			   for(user a: E) {
				   if(a.getId()==i) {
					   flag=true;
					   break;
				   }
			   }
			   if(!flag)return i;
		}
		return -1;
	}
public static List<user>get(){
	
	E=new ArrayList<user>();
	try {
		if(con==null) {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day16?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "123456");
		}
		Statement sta=con.createStatement();
		ResultSet res= sta.executeQuery("select * from user");
		while(res.next()) {
			int id=Integer.parseInt(res.getString(1));
			
			String name=res.getString(2);
			String gender=res.getString(3);
			int age=Integer.parseInt(res.getString(4));
			String address=res.getString(5);
			String qq=res.getString(6);
			String email=res.getString(7);
			E.add(new user(id,name,gender,age,address,qq,email));
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return E;
}
public static List<user> getselect(String nam,String cit,String emai){
	
	E=new ArrayList<user>();
	try {
		if(con==null) {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day16?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "123456");
		}
		Statement sta=con.createStatement();
		String sql="select * from user where ";
		
		if(!"".equals(nam))
			sql+="name=\'"+nam+"\'";
		if(!"".equals(cit))
		{
			if(sql.contains("name")) {
				sql+=" and address=\'"+cit+"\'";
			}
			else {
				sql+="address=\'"+cit+"\'";
			}
			
			
		}
		if(!"".equals(emai))
		{
			
			if(sql.contains("name")||sql.contains("address")) {
				
				sql+=" and email=\'"+emai+"\'";
			}
			else {
				sql+="email=\'"+emai+"\'";
			}
			
		}		
		
		System.out.println(sql);
		ResultSet res= sta.executeQuery(sql);
		while(res.next()) {
			int id=Integer.parseInt(res.getString(1));
			
			String name=res.getString(2);
			String gender=res.getString(3);
			int age=Integer.parseInt(res.getString(4));
			String address=res.getString(5);
			String qq=res.getString(6);
			String email=res.getString(7);
			E.add(new user(id,name,gender,age,address,qq,email));
		}
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	return E;
}

}
