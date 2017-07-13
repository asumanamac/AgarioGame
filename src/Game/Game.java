package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JOptionPane;

public class Game implements Runnable{
	
	private Display display;
	private int width,height;
	static Thread thread;
	public String title;
	public static boolean running=false;
	private BufferStrategy bs;
	private Graphics g;
	public static State menuState;
	private KeyManager keyManager;
	private MouseManager mouseManager;
	private GameCamera gameCamera;
	private static Handler handler;
	public static State gameState;
	private GameClient socketClient;
	private GameServer socketServer;
	
	public Game(String title,int width,int height)
	{
		this.title=title;
		this.width=width;
		this.height=height;
		display=new Display(title,width,height);
		keyManager=new KeyManager();
		mouseManager=new MouseManager();
		}
	private void init()
	{
		
		display=new Display(title,width,height);
		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		Assets.init();
		handler=new Handler(this);
		gameCamera=new GameCamera(handler,0,0);
		gameState=new GameState(handler);
		menuState=new MenuState(handler); 
		State.setState(gameState);
		socketClient.sendData("ping".getBytes());
		
	}
	private void tick()//update everything
	{
		keyManager.tick();
		mouseManager.tick();
		if(State.getState()!=null)
			State.getState().tick();
		
	}
	
	public GameCamera getGameCamera()
	{
		return gameCamera;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	private void render()
	{
		bs=display.getCanvas().getBufferStrategy();
		if(bs==null)
		{
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g=bs.getDrawGraphics();
		
		//Clean Screen
		g.clearRect(0,0, width, height);
		
		//g.drawImage(Assets.squareTile, 10, 10, null);
		
		if(State.getState()!=null)
			State.getState().render(g);
		//Draw here
		//g.setColor(Color.red);
		//g.fillOval(0, 0, 30, 30);
		
		
		bs.show();
		g.dispose();
		//End Drawing
	}
	
	public void run()
	{
		init();
		
		int fps=60;
		double timePeerTick=1000000000/fps;
		double delta=0;
		long now;
		long lastTime=System.nanoTime();
		long timer=0;
		int ticks=0;
		
		
		while(running)
		{
			now=System.nanoTime();
			delta+=(now-lastTime)/timePeerTick;
			timer+=now-lastTime;
			lastTime=now;
			
			if(delta >=1){
			tick();
			render();
			ticks++;
			delta--;
			}
			
			if(timer>=1000000000)
			{
				
				ticks=0;
				timer=0;
			}
		}
		stop();
	}
	
	public KeyManager getKeyManager()
	{
		return keyManager;
	}
	
	public MouseManager getMouseManager()

	{
		return mouseManager;
	}
		
	public synchronized void start()
	{
		if(running)
			return;
		running=true;
		
		thread=new Thread(this);
		thread.start();
		
			socketServer=new GameServer(this);
			socketServer.start();
		
		socketClient=new GameClient(this,"localhost");
		socketClient.start();
	}
	
	public static synchronized void stop()
	{
		
		if(running!=false)
			return;
		running=false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	



	


}