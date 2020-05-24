package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import userinfo.user;

public class contomysql {
public static Connection con=null;
public static Connection getCon() {
	if(con!=null)return con;
	try {
		if(con==null) {
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/day16?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "123456");
		}
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
}
public static void insert(user a,Connection con) {
	
try {
	Statement sta=	con.createStatement();
	String sql="insert into user values("+"\'"+a.getId()+"\',"+"\'"+a.getName()+"\',"+"\'"+a.getGender()+"\',"+"\'"+a.getAge()+"\',"+"\'"+a.getAddress()+"\',"+"\'"+a.getQq()+"\',"+"\'"+a.getEmial()+"\')";
	//
	boolean flag=sta.execute(sql);
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
public static void update(user a,Connection con) {
	try {
		Statement sta=	con.createStatement();
		String sql="update user set gender=\'"+a.getGender()+"\',"+"age="+a.getAge()+",address=\'"+a.getAddress()+"\',qq=\'"+a.getQq()+"\',email=\'"+a.getEmial()+"\' where id="+a.getId();
		//System.out.println(sql);
		sta.executeUpdate(sql);
		// update user set name='µ«ÎÄÔÂ' ,gender='female' where id=1;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
public static void dele(int id,Connection con) {
	
	try {
		Statement sta=	con.createStatement();
		String sql="delete from user where id="+id;
		sta.execute(sql);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

}
