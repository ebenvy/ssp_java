package dap;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class MyServlet extends HttpServlet{
	private static final long serialVersionUID =1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res )throws ServletException,IOException{
		res.setStatus(200);
		res.getWriter().write("Server: Hello!");
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res )throws ServletException,IOException{
		res.setStatus(200);
		 StringBuilder buffer = new StringBuilder();
	    BufferedReader reader = req.getReader();
		String line;
	    while ((line = reader.readLine()) != null) {
	        buffer.append(line);
	        buffer.append(System.lineSeparator());
	    }
	    String data = buffer.toString();
		res.getWriter().write("Server:"+data);
	}

}
