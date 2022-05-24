package com.lgcns.test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;

public class RunManager {

	private static final String host="127.0.0.1";
	private static final int port =8080;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		new RunManager().start();

	}
	public void start() throws Exception{
		Server server= new Server();
		ServerConnector http = new ServerConnector(server);
		http.setHost(host);
		http.setPort(port);
		server.addConnector(http);
		ServletHandler servletHandler = new ServletHandler();
		servletHandler.addServletWithMapping(MyServlet.class, "/");
		server.setHandler(servletHandler);
		
		server.start();
		server.join();
	}

}
