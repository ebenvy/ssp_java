package dap;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class MyServlet2 extends HttpServlet{
	private static final long serialVersionUID =1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res )throws ServletException,IOException{
		res.setStatus(200);
		res.getWriter().write("Server2: Hello!");
	}

}
