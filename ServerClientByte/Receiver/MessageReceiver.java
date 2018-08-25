
public class MessageReceiver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Receiver receiver = new Receiver(1234);
		receiver.initReceiver();
 		receiver.sendMsg("start");
		String response;
		for(int i = 0; i< 5; i++)
		{
			
			response = receiver.recvMsg();
			System.out.println("[RECV] "+response);
			receiver.sendMsg("ack");
			
		}
		receiver.destroyReceiver();
	}

}
