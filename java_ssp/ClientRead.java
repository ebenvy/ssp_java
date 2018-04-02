package java_ssp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientRead extends Thread{
	
	private Socket socket;
	 private BufferedReader br = null;
	 ClientRead(Socket s)
	 {
		 socket = s;
	 }
	 public void run()
	 {
		 try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 while(true)
		 {
			String answer;
			try {
				answer = br.readLine();
				System.out.println(answer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		 }
	 }

}
