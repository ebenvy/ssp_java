package java_ssp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSender extends Thread{
	private Socket socket;
	 private PrintWriter pw = null;
	 private BufferedReader br = null;
	 ClientSender(Socket s)
	 {
		 socket = s;
	 }
	 public void run()
	 {
		 try {
			pw = new PrintWriter(socket.getOutputStream());
			br= new BufferedReader( new InputStreamReader(System.in));
			while(true)
			{
				String sendStr =br.readLine();
				pw.println(sendStr);
				pw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
}
