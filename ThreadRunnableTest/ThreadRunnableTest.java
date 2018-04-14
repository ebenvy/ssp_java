import java.util.ArrayList;

public class ThreadRunnableTest {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("Start main method.");

		Runnable r = new ConcreteRunnable(); // ���� ������ Runnable �������̽�
		ArrayList<Thread> threadList = new ArrayList<Thread>(); // ��������� ���� ��ü

		for(int i = 0 ; i < 10 ; i++ ){
			// Runnable �������̽��� ����� ���ο� �����带 ����ϴ�.
			Thread test = new Thread(r);

			test.start(); // �� �޼ҵ带 �����ϸ� Thread ���� run()�� �����Ѵ�.
			threadList.add(test); // ������ �����带 ����Ʈ�� ����
		}

		for(Thread t : threadList){
			t.join(); // �������� ó���� ���������� ��ٸ��ϴ�.
		}

		System.out.println("End main method.");
	}

}
