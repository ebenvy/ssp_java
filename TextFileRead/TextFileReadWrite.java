package TextFileRead;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class TextFileReadWrite {
	private String fileName = null;
	TextFileReadWrite(String name)
	{
		fileName = name;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextFileReadWrite textFileManager= new TextFileReadWrite("out.txt");
		textFileManager.writeFile();
		textFileManager.readFile();
		
	}
	public void writeFile()
	{
		  FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        for(int i=1; i<11; i++) {
	            String data = i+" 번째 줄입니다.\r\n";
	            try {
					fw.write(data);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	public void readFile()
	{
		   BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	        while(true) {
	            String line = null;
				try {
					line = br.readLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            if (line==null) break;
	            System.out.println(line);
	        }
	        try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
