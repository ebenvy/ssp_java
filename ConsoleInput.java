import java.util.Scanner;

public class ConsoleInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String line;
		
		while(true)
		{
			line = sc.nextLine();
			String [] strArr = line.split("#|,");
			for(String str : strArr)
				System.out.print(str+" ");
			
		}
		
	}

}
