import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ExecutorService exec = Executors.newFixedThreadPool(10);
		  
		  for(int i = 0 ; i<20 ; i++) {
		   
		   exec.execute(new TestThread(i));
		  }
		  
		  exec.shutdown();
		  
		  while(!exec.isTerminated());
		  
		
	}

}
