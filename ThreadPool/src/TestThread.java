
public class TestThread implements Runnable{

	private int myName;
	public TestThread(int i)
	{
		myName = i;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i< 20 ;i++)
		{
			System.out.println(Thread.currentThread().getName()+" : "+myName+" : "+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
