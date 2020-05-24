package servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class drawcode
 */
@WebServlet("/drawcode")
public class drawcode extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public drawcode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		BufferedImage ima=new BufferedImage(100,100,BufferedImage.TYPE_3BYTE_BGR);
		String arr="QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm123456789";
		Random a=new Random();
		Graphics g=ima.getGraphics();
		g.setColor(Color.PINK);
		g.fillRect(0, 0, 100, 100);
		g.setColor(Color.BLACK);
		StringBuilder build=new StringBuilder();
		for(int i=1;i<=4;i++) {	
			int index=a.nextInt(arr.length());
			build.append(arr.charAt(index));
			String temp=arr.charAt(index)+"";
			g.drawString(temp, (i-1)*25+5, 50);	
		}	
		HttpSession session=request.getSession();
		session.setAttribute("check", build.toString());
		
	    for(int i=1;i<10;i++) {
	    int x=a.nextInt(100);
	    int y=a.nextInt(100);
	    int x1=a.nextInt(100);
	    int y1=a.nextInt(100);
	    g.drawLine(x, y, x1, y1);
	    
	    }		
		ImageIO.write(ima, "jpg", response.getOutputStream());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
