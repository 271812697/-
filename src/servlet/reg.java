package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class reg
 */
@WebServlet("/reg")
public class reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String checkcode=request.getParameter("checkcode");
		HttpSession session=request.getSession();
		String check=(String)session.getAttribute("check");
		request.setAttribute("error", "");
		if(check.equalsIgnoreCase(checkcode)) {
			
			try { 
				
				
				Connection con=connect.connectmysql.getconnection();
				if(con==null) {
					System.out.println("连接为空");
				}
				 
				 PreparedStatement pre=con.prepareStatement("select password from username where user=?");
				
				 pre.setString(1, username);
				 ResultSet res=pre.executeQuery();
				 if(res.next()) {
					 String pass=res.getString(1); 
					 if(pass.equals(password)) {//密码正确
						
						response.sendRedirect(request.getContextPath()+"/list.jsp");
						
					 }
					 else {//密码错误
						
						 request.setAttribute("error", "密码错误");
						 request.setAttribute("flg", true);
						 request.getRequestDispatcher("/login.jsp").forward(request, response);
						 
					 }
				 }
				 else {//用户表种没有这个用户
					 
					 request.setAttribute("error", "用户不存在");
					 request.setAttribute("flg", true);
					 request.getRequestDispatcher("/login.jsp").forward(request, response);
					 
				 }
				 
				 
				 
				 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		else {
			 request.setAttribute("flg", true);
			request.setAttribute("error", "验证码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
