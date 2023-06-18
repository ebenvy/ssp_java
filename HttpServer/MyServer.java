package HttpServer;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.servlet.ServletHandler;
public class MyServer {
	

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		new MyServer().start();

	}
	public void start() throws Exception{
		Server server = new Server();
		ServerConnector http = new ServerConnector(server);
		http.setHost("127.0.0.1");
		http.setPort(8081);
		server.addConnector(http);
		
		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(MyServlet.class, "/mypath");
		servletHandler.addServletWithMapping(MyServlet2.class, "/mypath2");
		server.setHandler(servletHandler);
		
		server.start();
		server.join();
		
		
		
		
	}

}
