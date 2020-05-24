package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connect.contomysql;
import userinfo.user;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
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
		Connection con=contomysql.getCon();
		String name=(String)request.getParameter("name");
		String gender=(String)request.getParameter("sex");
		int age=Integer.parseInt((String)request.getParameter("age"));
		String address=(String)request.getParameter("address");
		String qq=(String)request.getParameter("qq");
		String email=(String)request.getParameter("email");
		//System.out.println(name+" "+gender+" "+age+" "+address+" "+qq+" "+email);
		int id=(int)request.getSession().getAttribute("num");
		System.out.println(id);
		user a=new user(id,name,gender,age,address,qq,email);
		contomysql.insert(a, con);
		request.getRequestDispatcher("/list.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
