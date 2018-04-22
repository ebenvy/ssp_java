import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteOrder;

public class ReceiveServer {

	private ServerSocket listener= null;
	private Socket socket = null;
	
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReceiveServer server = new ReceiveServer();
		server.InitServer(1234);
		server.ReceiveFiles();
		server.closeServer();
	}
	public void InitServer(int port)
	{
		try {
			listener = new ServerSocket(port);
			socket = listener.accept();
			
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ReceiveFiles()
	{
		String fileName=null;
		String data;
		
		
		/*STX (0x02) 1byte,
			OPCODE (0x01) 1byte,
			Length (file¿« ±Ê¿Ã) 2byte,
			File name  10byte.
		*/
		byte[] reciveData = null;
		byte[] headerBuffer = new byte[14];
		byte[] body = new byte[1024];
		while(true)
		{
			try {
				int result =dis.read(headerBuffer);
				if(result<=0)
					break;
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			byte[] lengthChk = new byte[2];
			lengthChk[0] = headerBuffer[2];
			lengthChk[1] = headerBuffer[3];
			int returnLength = TypeUtil.constructIntFromByteArray(lengthChk,ByteOrder.LITTLE_ENDIAN);
			byte[] file = new byte[10];
			System.arraycopy(headerBuffer, 4, file, 0, file.length);
			System.out.println(new String(file)+ "filesize: "+returnLength);
			DataOutputStream dos_file = null;
			String writeFileName = "./Files/"+new String(file).trim();
			try {
				dos_file = new DataOutputStream(new FileOutputStream( writeFileName));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			int receiveSize = 0;
			try {
				while(receiveSize <returnLength)
				{
					
					int readSize;
					if( returnLength -receiveSize >= 1024)
						readSize = dis.read(body,0,1024);
					else
						readSize = dis.read(body,0,returnLength -receiveSize);
					if(readSize <=0)
						break;
					receiveSize += readSize;
					System.out.println(receiveSize);
					dos_file.write(body,0,readSize);
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				dos_file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	public void closeServer()
	{
		try {
			dis.close();
			dos.close();
			listener.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	



}
