import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

public class FileMerge {

	PrintWriter s_writer = null; 
	PrintWriter t_writer = null;
	HashMap<String,Integer> source_list = null;
	HashMap<String,Integer> target_list = null;
	public FileMerge()
	{
		
		source_list = new HashMap<String,Integer>();
		target_list = new HashMap<String,Integer>();
				
	}
	public void MakeList()
	{
		File source = new File("source");
		File target = new File("target");

		File [] source_files = source.listFiles();
		for(File file: source_files)
		{
			if(file.getName().equals("file_list.txt"))
				continue;
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file.getAbsolutePath()));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String str = null;
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			source_list.put(file.getName(), Integer.parseInt(str)) ;
		}
		File [] target_files = target.listFiles();
		for(File file: target_files)
		{
			if(file.getName().equals("file_list.txt"))
				continue;
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(file.getAbsolutePath()));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String str = null;
			try {
				str = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			target_list.put(file.getName(), Integer.parseInt(str)) ;
		}
		
		
	}
	public void writeList()
	{
		try {
			
			s_writer = new PrintWriter(new FileWriter("source\\file_list.txt"),true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t_writer = new PrintWriter(new FileWriter("target\\file_list.txt"),true);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Set<String> keys =source_list.keySet();
		for(String key: keys)
		{
			s_writer.println(key+"_"+source_list.get(key));
		}
		
	    keys =target_list.keySet();
		for(String key: keys)
		{
			t_writer.println(key+"_"+target_list.get(key));
		}
		s_writer.close();
		t_writer.close();
		
	}
	public void diffVersion()
	{
		Set<String> keys =source_list.keySet();
		PrintWriter r_writer = null;
		 String cmd = null;
		try {
			r_writer = new PrintWriter(new FileWriter("result.txt"),true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String key: keys)
		{
			if(target_list.containsKey(key))
			{
				if(source_list.get(key) >target_list.get(key))
				{
					//C
					try {
						cmd = "cmd /c cp source\\"+key+" target\\";
						Runtime.getRuntime().exec(cmd);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					r_writer.println(key+"_C");
					
				}
				else
				{
					//U
					r_writer.println(key+"_U");
				}
			}
			else
			{
				//C
				try {
					cmd = "cmd /c cp source\\"+key+" target\\";
					Runtime.getRuntime().exec(cmd);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				r_writer.println(key+"_C");
			}
			
		}
		
	    keys =target_list.keySet();
		for(String key: keys)
		{
			if(!source_list.containsKey(key))
			{
				
				//D
				try {
					cmd = "cmd /c rm target\\"+key;
					Runtime.getRuntime().exec(cmd);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				r_writer.println(key+"_D");
				
				
			}
			
		}
		r_writer.close();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileMerge fileMerge = new FileMerge();
		fileMerge.MakeList();
		fileMerge.writeList();
		fileMerge.diffVersion();
	}
	

}
