
public class MessageSender {
	public static void main(String args[])
	{
		Sender sender = new Sender(1234);
		sender.initSender();
		String response;
		String cmd = sender.recvMsg();
		if(cmd.trim().equals("start"))
		{
			System.out.println("[RECV] start");
			
			for(int i = 0; i< 5; i++)
			{
				sender.sendMsg("hello");
				response = sender.recvMsg();
				if( response.equals("ack"))
				{
					System.out.println("[RECV] ack");
				}
			}
		}
		sender.destroySender();
	}
}
