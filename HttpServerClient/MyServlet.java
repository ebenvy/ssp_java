package HttpServerClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.gson.Gson;

public class MyServlet extends HttpServlet{
	private static final long serialVersionUID =1L;
	private Gson gson; 
	private String name;
	
	@Override
	public void init() {
		this.gson = new Gson();
		this.name = (String) getServletContext().getAttribute("server.name");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res )throws ServletException,IOException{
		
		
		String url = req.getScheme()+"://"+req.getRemoteAddr()+":"+req.getLocalPort()+req.getRequestURI();
		System.out.println(url);
		HashMap<Object, Object> headers = new HashMap<Object, Object>();
		Enumeration<String> headerNames =req.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String key = headerNames.nextElement();
			headers.put(key, req.getHeader(key));
			
		}
		
		res.setStatus(200);
		res.getWriter().write("Server: "+ this.name);
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
	    String body = buffer.toString();
		res.getWriter().write("Server:"+body);
	}

}
