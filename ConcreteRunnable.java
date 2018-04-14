import java.util.Random;

class ConcreteRunnable implements Runnable{

	private int index = 0;

	@Override
	public void run() {

		Random r = new Random(System.currentTimeMillis());

		long s = r.nextInt(3000); // 3�ʳ��� ������.
		try {
			Thread.sleep(s); // �����带 ��� ����
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		addIndex();

	}

	// ���� ������ ����ȭ�ؼ� ���!
	// ����ȭ ������ �ñ��ϴٸ� synchronized Ű���带 ���� �ؼ� ������ ����������!
	synchronized void addIndex(){
		index++;
		System.out.println("current index value: " + index);
	}

}
