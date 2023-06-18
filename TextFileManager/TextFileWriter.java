package TextFileManager;

import java.io.FileWriter;
import java.io.IOException;


public class TextFileWriter {
	
	public void writeFile(String fileName, String contents)
	{
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fw.write(contents);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
}
