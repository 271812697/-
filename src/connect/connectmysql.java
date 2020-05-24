package connect;
import java.sql.Connection;
import java.sql.DriverManager;
public class connectmysql {
	public static Connection con=null;
	public static Connection getconnection() throws Exception {
		if(con!=null)return con;
		Class.forName("com.mysql.jdbc.Driver");
		 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "123456");
		return con;
	}

}