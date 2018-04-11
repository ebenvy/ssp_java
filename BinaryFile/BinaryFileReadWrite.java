package BinaryFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFileReadWrite {

	private String fileName = null;
	BinaryFileReadWrite(String name)
	{
		fileName = name;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryFileReadWrite binaryFileManager= new BinaryFileReadWrite("out.txt");
		binaryFileManager.writeFile();
		binaryFileManager.readFile();
		
	}
	public void writeFile()
	{
		FileOutputStream output = null;
		try {
			output = new FileOutputStream(fileName);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        for(int i=1; i<11; i++) {
            String data = i+" 번째 줄입니다.\r\n";
            try {
				output.write(data.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        try {
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void readFile()
	{
        byte[] b = new byte[1024];
        FileInputStream input = null;
		try {
			input = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
			input.read(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(new String(b));
        try {
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
