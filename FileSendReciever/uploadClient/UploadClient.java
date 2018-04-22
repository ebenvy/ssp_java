import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteOrder;
import java.util.ArrayList;

public class UploadClient {
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UploadClient client = new UploadClient();
		client.InitClient();
		client.uploadFiles("./Files");
		client.closeClient();
	}
	public void InitClient()
	{
		Socket socket = null;
		try {
			socket = new Socket("127.0.0.1",1234);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void uploadFiles(String folder)
	{
		File[] fileList =getFolderFiles(folder);
		
		for(File f: fileList)
		{
			uploadFileHeader(f);
		}
		
	}
	public void uploadFileHeader(File file)
	{
		/*STX (0x02) 1byte,
		OPCODE (0x01) 1byte,
		Length (file¿« ±Ê¿Ã) 2byte,
		File name  10byte
		
		 */
		int maxSize =1024;
		byte [] sendData = new byte[14];
		byte[] bodySize;
		DataInputStream file_dis;
		bodySize = TypeUtil.convertToBytes((int)file.length(),2, ByteOrder.LITTLE_ENDIAN);
		sendData[0] = (byte)0x02;
		sendData[1] = (byte)0x01;
		sendData[2] = (byte)bodySize[0];
		sendData[3] = (byte)bodySize[1];
	
		byte [] filename = file.getName().getBytes();
		System.arraycopy(filename, 0, sendData, 4, filename.length);
		try {
			dos.write(sendData);
			System.out.println(file.getName()+"send");
			dos.flush();
			byte [] sendBody = new byte[1024];
			file_dis= new DataInputStream(new FileInputStream(file));
			int totalSize =0;
			int readSize;
				
			while(totalSize < file.length())
			{
				if( file.length()-totalSize>= 1024)
					readSize = file_dis.read(sendBody,0,1024);
				else
					readSize = file_dis.read(sendBody,0,(int)(file.length()-totalSize));
				if(readSize <= 0 )
					break;
				totalSize += readSize;
				dos.write(sendBody,0,readSize);
				dos.flush();
				
			}
			file_dis.close();
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		
	}
	private void closeClient()
	{
		try {
			dos.close();
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public File[] getFolderFiles(String folder)
	{
		File file = new File(folder);
		File[] fileList = file.listFiles();
		return fileList;
		
	}

}
