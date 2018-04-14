import java.util.ArrayList;
import java.util.Random;

public class ThreadExtendsTest extends Thread{

	private static int index = 0;

	private int id = -1;
	public ThreadExtendsTest(int id){
		this.id = id;
	}

	public void run(){
		System.out.println( id + "번 쓰레드 동작 중..." );
		Random r = new Random(System.currentTimeMillis());
		try {
			long s = r.nextInt(3000); // 3초내로 끝내자.
			Thread.sleep(s); // 쓰레드를 잠시 멈춤
			setIndex();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println( id + "번 쓰레드 동작 종료..." );
	}

	public synchronized static void setIndex(){
		index++; // index 변수를 증가시킵니다.
	}

	public static void main(String[] args) {

		System.out.println("Start main method.");

		ArrayList<Thread> threadList = new ArrayList<Thread>();

		for(int i = 0 ; i < 10 ; i++ ){
			ThreadExtendsTest test = new ThreadExtendsTest(i);

			test.start(); // 이 메소드를 실행하면 Thread 내의 run()을 수행한다.
			threadList.add(test); // 생성한 쓰레드를 리스트에 삽입
		}

		for(int i = 0 ; i < threadList.size(); i++){
			try {
				threadList.get(i).join(); // 쓰레드의 처리가 끝날때까지 기다립니다.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("current Index: "+ index); // index의 값을 반환합니다.
		System.out.println("End main method.");
	}


}
