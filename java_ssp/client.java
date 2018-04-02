package java_ssp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client {

	public static void main(String[] args) {
		Socket s;
		
		try {
			
			s = new Socket("127.0.0.1",1234);
			Thread sender = new ClientSender(s);
			Thread receiver = new ClientRead(s);
			sender.start();
			receiver.start();
		
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
