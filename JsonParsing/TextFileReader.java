package JsonParsing;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {

	public List<String> readFileToList(String fileName){
		BufferedReader br = null;
		List<String> strArray = new ArrayList<String>();
		try {
			br = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true) {
			String line =null;
			try {
				line = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (line == null){
				break;
			}
			strArray.add(line);
		}
		return strArray;
	}
	public String readFile(String fileName) {
		String fileContent = String.join("\n", this.readFileToList(fileName));
		return fileContent;
				
	}
}
