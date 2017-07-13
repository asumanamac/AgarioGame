package Game;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GameClient extends Thread{
	
	private InetAddress ipAdress;
	private DatagramSocket socket;
	private Game game;
	
	public GameClient(Game game,String ipAdress)
	{
		try {
			this.ipAdress=InetAddress.getByName(ipAdress);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.game=game;
		
		try{
			
			this.socket=new DatagramSocket();
			
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
				
				System.out.println("SERVER > "+ new String(packet.getData()));
			
		}
	}
	
	public void sendData(byte[] data)
	
	{
		DatagramPacket  packet=new DatagramPacket(data,data.length,ipAdress,8080);
		try {
			socket.send(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
