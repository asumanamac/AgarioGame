package Game;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class GameServer extends Thread{
	
	private InetAddress ipAdress;
	private DatagramSocket socket;
	private Game game;
	
	public GameServer(Game game)
	{
		this.ipAdress=ipAdress;
		this.game=game;
		
		try{
			
			this.socket=new DatagramSocket(1331);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public void run()
	{
		while(true){
			
			byte[] data=new byte[1024];
			DatagramPacket packet=new DatagramPacket(data,data.length);
			
			
				try {
					socket.receive(packet);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String message=new String(packet.getData());
				
				if(message.equalsIgnoreCase("ping"))
				System.out.println("CLIENT > "+ message);
				sendData("pong".getBytes(),packet.getAddress(),packet.getPort());
				
			
		}
	}
	
	public void sendData(byte[] data,InetAddress ipAdress,int port)
	
	{
		DatagramPacket  packet=new DatagramPacket(data,data.length,ipAdress,1331);
		try {
			socket.send(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
