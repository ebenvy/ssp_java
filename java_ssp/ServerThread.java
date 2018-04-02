package java_ssp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServerThread extends Thread{
	private Socket socket;
	 private BufferedReader br = null;
	 private PrintWriter pw = null;
	 private String userIP =null;

	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
	ServerThread(Socket s)
	{
		socket =s;
		userIP= socket.getInetAddress().toString();
		pw = new PrintWriter(socket.getOutputStream(), true);
		list.add(pw);
	}
	public void run(){
		try {
			
			service();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 System.out.println("**"+userIP+"님 접속 종료.");
		}finally {
			try {
				
				list.remove(pw);
				sendAll()
				closeAll();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}
	private void service()throws IOException{
	   br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	   
	   String str = null;
	   while(true){
	    str = br.readLine();
	    if(str == null){
	     System.out.println(userIP+"님이 연결을 종료했습니다.");
	     break;
	    }
	   
	    System.out.println(userIP+"님: "+str);
	    sendAll(str);
	   }
	  }
	private void sendAll(String str) {
		for(PrintWriter writer: list)
		{
			writer.println(str);
			writer.flush();
		}
	}
	  public void closeAll()throws IOException{
	   if (pw != null)
	    pw.close();
	   if (br != null)
	    br.close();
	   if (socket != null)
	    socket.close();
	  }

	

}
