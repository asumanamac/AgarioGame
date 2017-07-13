package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class World extends JFrame{
	
	private int width,height;

	
	private int[][] tiles;
	private int spawnX,spawnY;
	private Handler handler;
	Timer timer;
	Thread thread;
	boolean drawn=false;
	int count=0;

	static boolean isEnter=false;
	
	int x,y;
	RandomPermutation rp,rp1,rp2,rp3,rp4,rp5,rp6,rp7,rp15;
	
	public EntityManager getEntitiyManager() {
		return entitiyManager;
	}
	
	public EntityManager getEntitiyManagerPurple() {
		return entitiyManager_purple;
	}
	
	public EntityManager getEntitiyManagerEnemy() {
		return entitiyManager_enemy;
	}
	
	public EntityManager getEntitiyManagerCirle() {
		return entitiyManager_circle;
	}
	public EntityManager getEntitiyManagerYellow() {
		return entitiyManager_yellow;
	}
	
	public EntityManager getEntitiyManagerBlue() {
		return entitiyManager_blue;
	}
	
	public EntityManager getEntitiyManagerCyan() {
		return entitiyManager_cyan;
	}
	
	public EntityManager getEntitiyManagerMagenta() {
		return entitiyManager_magenta;
	}
	public EntityManager getEntitiyManagerBigEnemies() {
		return entitiyManager_big_enemies;
	}
	
	public EntityManager getEntitiyManagerLightBlue() {
		return entitiyManager_light_blue;
	}
	
	public EntityManager getEntitiyManagerLightGreen() {
		return entitiyManager_light_green;
	}
	

	public EntityManager getEntitiyManagerDarkPink() {
		return entitiyManager_dark_pink;
	}
	
	public EntityManager getEntitiyManagerDarkBlue() {
		return entitiyManager_dark_blue;
	}
	
	public EntityManager getEntitiyRandomFood() {
		return entitiyManager_random_food;
	}
	
	public EntityManager getEntitiyRandomFood2() {
		return entitiyManager_random_food2;
	}
	
	public EntityManager getEntitiyRandomFood3() {
		return entitiyManager_random_food3;
	}

	private EntityManager entitiyManager_purple;
	private EntityManager entitiyManager_enemy;
	private EntityManager entitiyManager_circle;
	private EntityManager entitiyManager_yellow;
	private EntityManager entitiyManager_blue;
	private EntityManager entitiyManager_cyan;
	private EntityManager entitiyManager_magenta;
	private EntityManager entitiyManager_big_enemies;
	private EntityManager entitiyManager_dark_blue;
	private EntityManager entitiyManager_dark_pink;
	private EntityManager entitiyManager;
	private EntityManager entitiyManager_light_green;
	private EntityManager entitiyManager_light_blue;
	private EntityManager entitiyManager_random_food,entitiyManager_random_food2,entitiyManager_random_food3;
	
	
	
	public World(Handler handler,String path)
	{
		
		this.handler=handler;
		Random r=new Random();	
		
		rp=new RandomPermutation(50,1800);
		rp15=new RandomPermutation(50,300);
		entitiyManager=new EntityManager(handler,new Player(handler,100,100));
		
		entitiyManager_enemy=new EntityManager(handler,new Enemy(handler,-450,-450));
		
		entitiyManager_circle=new EntityManager(handler,new CirclesEntity(handler,-200,-200));
		
		entitiyManager_yellow=new EntityManager(handler,new CirclesEntity(handler,-350,-350));
		
		entitiyManager_blue=new EntityManager(handler,new CirclesEntity(handler,-550,-550));
		
		entitiyManager_cyan=new EntityManager(handler,new CirclesEntity(handler,-550,-550));
		
		entitiyManager_magenta=new EntityManager(handler,new CirclesEntity(handler,-750,-650));
		
		entitiyManager_big_enemies=new EntityManager(handler,new Enemy(handler,-800,-800));
		
		entitiyManager_dark_blue=new EntityManager(handler,new CirclesEntity(handler,-800,-800));
		
		entitiyManager_dark_pink=new EntityManager(handler,new CirclesEntity(handler,-800,-800));
		
		entitiyManager_purple=new EntityManager(handler,new CirclesEntity(handler,-800,-800));
		
		entitiyManager_light_green=new EntityManager(handler,new CirclesEntity(handler,-800,-800));
		
		entitiyManager_light_blue=new EntityManager(handler,new CirclesEntity(handler,-800,-800));
		
		entitiyManager_random_food=new EntityManager(handler,new CirclesEntity(handler,-800,-800));
		
		entitiyManager_random_food2=new EntityManager(handler,new CirclesEntity(handler,-800,-800));
		
		entitiyManager_random_food3=new EntityManager(handler,new CirclesEntity(handler,-800,-800));
		
	
	
		Set<Integer> nums = new HashSet<Integer>();

		
		ArrayList<Integer> list=new ArrayList<Integer>();
	
		
		for(int i=0;i<100;i++){
		
			list.add(rp.GetRandom());
			if(list.contains(rp.GetRandom()))
				list.remove(rp.GetRandom());
			
			
		}	

		
	
		for(int i=0;i<10;i++)
		{
			rp=new RandomPermutation(80,1850);
			
		entitiyManager_enemy.addEnemy(new Enemy(handler,rp.GetRandom()-handler.getGameCamera().getxOffset(),
				rp.GetRandom()+1-handler.getGameCamera().getyOffset()));
		
	
		
	
		}
		
		for(int i=0;i<10;i++)
		{
		rp=new RandomPermutation(160,1080);
		entitiyManager_circle.addCircle(new CirclesEntity(handler,rp.GetRandom()-handler.getGameCamera().getxOffset(),
				rp.GetRandom()+1-handler.getGameCamera().getyOffset()));

	
		}
		
		for(int i=0;i<10;i++)
		{
		rp=new RandomPermutation(200,1850);
				
		entitiyManager_yellow.addYellowCircles(new CirclesEntity(handler,rp.GetRandom()-handler.getGameCamera().getxOffset(),
				rp.GetRandom()+1-handler.getGameCamera().getyOffset()));
	
		}
		
		for(int i=0;i<10;i++)
		{
				
			rp=new RandomPermutation(300,1850);
		entitiyManager_blue.addPinkCircles(new CirclesEntity(handler,rp.GetRandom()-handler.getGameCamera().getxOffset(),
				rp.GetRandom()+1-handler.getGameCamera().getyOffset()));
	
		
			
		}	
		
		for(int i=0;i<10;i++)
		{
			
			rp=new RandomPermutation(700,1850);	
		entitiyManager_cyan.addCyanCircles(new CirclesEntity(handler,rp.GetRandom()-handler.getGameCamera().getxOffset(),
				rp.GetRandom()+1-handler.getGameCamera().getyOffset()));
	
		}

		rp=new RandomPermutation(100,1850);
		for(int i=0;i<10;i++)
		{
			  
				
		
		entitiyManager_magenta.addOrangeCircles(new CirclesEntity(handler,rp.GetRandom()-handler.getGameCamera().getxOffset(),
				rp.GetRandom()+1-handler.getGameCamera().getyOffset()));
		
		
		}
		

		rp=new RandomPermutation(100,1850);
		for(int i=0;i<10;i++)
		{
			
			
		entitiyManager_big_enemies.addBigEnemy(new Enemy(handler,rp.GetRandom()-handler.getGameCamera().getxOffset(),
				rp.GetRandom()+1-handler.getGameCamera().getyOffset()));
		
		
		}
		
		rp=new RandomPermutation(100,1850);
		for(int i=0;i<5;i++)
		{
			
			
		entitiyManager_dark_blue.addDarkBlueCircles(new CirclesEntity(handler,rp.GetRandom()-handler.getGameCamera().getxOffset(),
				rp.GetRandom()+1-handler.getGameCamera().getyOffset()));
		
		
		}
		
		rp=new RandomPermutation(100,1850);
		for(int i=0;i<5;i++)
		{
			
			
		entitiyManager_dark_pink.addPurpleCircles(new CirclesEntity(handler,rp.GetRandom()-handler.getGameCamera().getxOffset(),
				rp.GetRandom()+1-handler.getGameCamera().getyOffset()));
		
		
		}
		
		rp=new RandomPermutation(100,1850);
		for(int i=0;i<10;i++)
		{
			
			
		entitiyManager_purple.addPinkCircles(new CirclesEntity(handler,rp.GetRandom()-handler.getGameCamera().getxOffset(),
				rp.GetRandom()+1-handler.getGameCamera().getyOffset()));
		
		
		}
		
		rp=new RandomPermutation(100,1850);
		for(int i=0;i<10;i++)
		{
			
			
		entitiyManager_light_green.addLightGreenCircles(new CirclesEntity(handler,rp.GetRandom()-handler.getGameCamera().getxOffset(),
				rp.GetRandom()+1-handler.getGameCamera().getyOffset()));
		
		
		}
		
		rp=new RandomPermutation(100,1850);
		for(int i=0;i<10;i++)
		{
			
			
		entitiyManager_light_blue.addLightBlueCircles(new CirclesEntity(handler,rp.GetRandom()-handler.getGameCamera().getxOffset(),
				rp.GetRandom()+1-handler.getGameCamera().getyOffset()));
		
		
		}
		
		rp=new RandomPermutation(250,900);
		for(int i=0;i<2;i++)
		{
			
			
		entitiyManager_random_food.addRandomFood(new CirclesEntity(handler,rp.GetRandom()-handler.getGameCamera().getxOffset(),
				rp.GetRandom()+1-handler.getGameCamera().getyOffset()));
			}
			
		
		rp=new RandomPermutation(800,900);
		for(int i=0;i<2;i++)
		{
			
		
		entitiyManager_random_food2.addRandomFood2(new CirclesEntity(handler,rp.GetRandom()-handler.getGameCamera().getxOffset(),
				rp.GetRandom()+1-handler.getGameCamera().getyOffset()));
		
			
		}
		rp=new RandomPermutation(900,1500);
		for(int i=0;i<2;i++)
		{
			
			
		entitiyManager_random_food3.addRandomFood3(new CirclesEntity(handler,rp.GetRandom()-handler.getGameCamera().getxOffset(),
				rp.GetRandom()+1-handler.getGameCamera().getyOffset()));
		
			}
			
		loadWorld(path);
		
		entitiyManager.getPlayer().setX(spawnX);
		entitiyManager.getPlayer().setY(spawnY);
		
		
	
		
	}
	
	public EntityManager getEntitiyManager9() {
		return entitiyManager_dark_blue;
	}

	public void setEntitiyManager9(EntityManager entitiyManager9) {
		this.entitiyManager_dark_blue = entitiyManager9;
	}

	public EntityManager getEntitiyManager10() {
		return entitiyManager_dark_pink;
	}

	public void setEntitiyManager10(EntityManager entitiyManager10) {
		this.entitiyManager_dark_pink = entitiyManager10;
	}

	public EntityManager getEntitiyManager11() {
		return entitiyManager_purple;
	}

	public void setEntitiyManager11(EntityManager entitiyManager11) {
		this.entitiyManager_purple = entitiyManager11;
	}

	public EntityManager getEntitiyManager12() {
		return entitiyManager_light_green;
	}

	public void setEntitiyManager12(EntityManager entitiyManager12) {
		this.entitiyManager_light_green = entitiyManager12;
	}

	private void loadWorld(String path)
	{
		
		
		
		String file = null;
		try {
			file = Utils.loadFileAsString(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tokens[]=file.split("\\s+");
		width=Utils.parseInt(tokens[0]);
		height=Utils.parseInt(tokens[0]);
		spawnX=Utils.parseInt(tokens[0]);
		spawnY=Utils.parseInt(tokens[0]);
		
		
		
		tiles=new int[width][height];
		
		for(int y=0;y<height;y++)
		{
			for(int  x=0;x<width;x++)
			{
				tiles[x][y]=Utils.parseInt(tokens[(x+y*width)+4]);
				
			}
			}
		/*width=5;
		height=5;
		for(int x=0;x<width;x++)
		{
			for(int y=0;y<height;y++)
			{
				tiles[x][y]=0;
			}
		}*/
		
	}
	
	public void tick()
	{
		entitiyManager.tick();
		
		
	}
	
	public void render(Graphics g)
	{
		
		int xStart=(int)Math.max(0, handler.getGameCamera().getxOffset()/Tile.TILEWIDTH);
		int yStart=(int)Math.max(0, handler.getGameCamera().getyOffset()/Tile.TILEHEIGT);;
		int xEnd=(int) Math.min(width, (handler.getGameCamera().getxOffset()+handler.getWidth())/Tile.TILEWIDTH+1);
		int yEnd=(int) Math.min(height, (handler.getGameCamera().getyOffset()+handler.getHeight())/Tile.TILEHEIGT+1);;
		
		for(int y=yStart;y< yEnd;y++)
		{
			for(int x=xStart;x< xEnd;x++)
			{
				
				getTile(x,y).render(g, (int)(x*Tile.TILEWIDTH-handler.getGameCamera().getxOffset()),
						(int)(y*Tile.TILEHEIGT-handler.getGameCamera().getyOffset()));
			}
		}
	
	entitiyManager_enemy.render_enemy(g);
	entitiyManager_circle.render_circle(g);
	entitiyManager_yellow.render_yellow(g);
	entitiyManager_blue.render_blue(g);
	entitiyManager_cyan.render_cyan(g);
	entitiyManager_magenta.render_magenta(g);
	entitiyManager_big_enemies.render_big_enemies(g);
	entitiyManager_dark_blue.render_dark_blue(g);
	entitiyManager_dark_pink.render_dark_pink(g);
	entitiyManager_purple.render_purple(g);
	entitiyManager_light_green.render_light_green(g);
	entitiyManager_light_blue.render_light_blue(g);
	
	entitiyManager.render(g);
	if(Entity.isCollsion==true)
	{

		startClock(g);
	
			
			
	}
	
	
		
	}
	
	 public synchronized void startClock( Graphics g )
	    {  
		
	           
	           thread = new Thread()
	            {
	                @Override
	                 public void run()
	                 {
	              
	                	try {
	       
	                		if(Entity.isCollsion==true){
	                		entitiyManager_random_food.render_random_food(g);
	                		
	                			/*if(Score.score==150)
	                			entitiyManager_random_food2.render_random_food2(g);
	                			else
	                				entitiyManager_random_food2.getRandomFood2().clear();
	                				
	                		
	                		if(Score.score==350)
	                			entitiyManager_random_food3.render_random_food3(g);*/
	                		
							thread.sleep(4000);
						
	                		}
	                		Entity.isCollsion=false;
	                		entitiyManager_random_food.getRandomFood().clear();
	                		
	                		
	                		
	                		thread.join();
	                	
	                	
					
	                	} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}      
						    }
	                
						
	                 
	            };

	            thread.start();           
	    }
	

	
	public Tile getTile(int x,int y)
	{
		
		if(x<0 || y<0 || x>=width || y>=height)
		{
			return Tile.squareTile;
		}
		Tile t=Tile.tiles[tiles[x][y]];
		
		if(t==null)
		{
			return Tile.squareTile;
		}
		
		return t;
		
	}
	
	public int getWidth()
	{
		return width;
		
	}
	
	public int getHeight()
	{
		return height;
		
	}
	
	
	
	
	
	
}
