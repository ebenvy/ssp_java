package systemCall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemCommandCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cmd = "cmd /c ls";
		Process process;
		BufferedReader reader;
		String line;
		String result="";
		try {
			process = Runtime.getRuntime().exec(cmd);
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			while((line=reader.readLine())!=null)
			{
				result+=line+"\n";
			}
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
