package java_ssp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket listener = null;
		
		try {
			listener = new ServerSocket(1234);
			while(true)
			{
				Socket socket = listener.accept();
				ServerThread st = new ServerThread(socket);
				st.start(); 
				System.out.println(socket.getInetAddress()+"¥‘ ¿‘¿Â");

		
			}
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
			
				if(listener!=null)
					listener.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
