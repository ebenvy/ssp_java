package TextFileManager;

import java.util.ArrayList;
import java.util.List;

public class TextFileManagerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextFileWriter writer = new TextFileWriter();
		TextFileReader reader = new TextFileReader();
		List<String> contents = new ArrayList<String>();
		contents.add("line-1:11");
		contents.add("line-2:22");
		contents.add("line-3:33");
		writer.writeFile("text.txt", String.join("\n", contents));
		System.out.println(reader.readFile("text.txt"));
		

	}

}

