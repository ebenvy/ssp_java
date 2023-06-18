package HttpServerClient;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.*;
import com.google.gson.*;

import HttpServerClient.MyServlet;
public class MyHttpServer {
	public void start() {
		Server server = new Server();
		ServerConnector http = new ServerConnector(server);
		http.setHost("127.0.0.1");
		http.setPort(8081);
		server.addConnector(http);
//		ServletHandler servletHandler = new ServletHandler();
//		servletHandler.addServletWithMapping(MyServlet.class, "/");
	
//		server.setHandler(servletHandler);
		ServletContextHandler context = new ServletContextHandler();
		context.setContextPath("/");
		context.setAttribute("server.name", "myServer");
		context.addServlet(MyServlet.class, "/");
		server.setHandler(context);
		
		
		
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
