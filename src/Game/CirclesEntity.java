package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

public class CirclesEntity extends StaticEntity {
	Random r=new Random();
	int width=0;
	private int height=0;
	
	@Override
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}



	public CirclesEntity(Handler handler, float x, float y) {
		super(handler, x, y,Tile.TILEWIDTH, Tile.TILEHEIGT*2);
		
	
	}

	@Override
	public void tick() {
		
		
		
	}
	@Override
	public void render(Graphics g) {
		
		Graphics2D g2d=(Graphics2D) g;
		
		width=45;
		height=45;

		g2d.setColor(Color.green);
		g2d.fillOval((int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),
				    width, height);
	
		//g.setColor(Color.yellow);
	}
	


	@Override
	public void render3(Graphics g) {
		Graphics2D g2d=(Graphics2D) g;
		
		width=30;
		height=30;
		g2d.setColor(Color.yellow);
		g2d.fillOval((int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),
				    width, height);
		
	}

	@Override
	public void render2(Graphics g) {
       Graphics2D g2d=(Graphics2D) g;
		
   	width=35;
	height=35;
	
		g2d.setColor(Color.blue);
		g2d.fillOval((int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),
				   width, height);
		
	}

	@Override
	public void render4(Graphics g) {
		 Graphics2D g2d=(Graphics2D) g;
		 
			width=40;
			height=40;
			
			g2d.setColor(Color.MAGENTA);
			g2d.fillOval((int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),
					    width, height);
		
	}

	@Override
	public void render5(Graphics g) {
		Graphics2D g2d=(Graphics2D) g;
		
		width=45;
		height=45;
		
		g2d.setColor(Color.cyan);
		g2d.fillOval((int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),
			width, height);
		
	}

	@Override
	public void render6(Graphics g) {
       Graphics2D g2d=(Graphics2D) g;
		
		width=75;
		height=75;
		
		g2d.setColor(new Color(77,46,250));//dark blue
		g2d.fillOval((int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),
			width, height);
			
	}

	@Override
	public void render7(Graphics g) {
		 Graphics2D g2d=(Graphics2D) g;
			
			width=75;
			height=75;
			
			g2d.setColor(new Color(250,46,250));//dark pink
			g2d.fillOval((int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),
				width, height);
		
	}

	@Override
	public void render8(Graphics g) {
		 Graphics2D g2d=(Graphics2D) g;
			
			width=75;
			height=75;
			
			g2d.setColor(new Color(16,203,245));//light blue
			g2d.fillOval((int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),
				width, height);
		
	}

	@Override
	public void render9(Graphics g) {
		 Graphics2D g2d=(Graphics2D) g;
			
			width=75;
			height=75;
			
			g2d.setColor(new Color(134,245,16));//light green
			g2d.fillOval((int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),
				width, height);
		
	}

	@Override
	public void render10(Graphics g) {
		 Graphics2D g2d=(Graphics2D) g;
			
			width=75;
			height=75;
			
			g2d.setColor(new Color(157,68,168));//purple
			g2d.fillOval((int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),
				width, height);
		
		
	}
	

	public void render_random_food(Graphics g) {
		 Graphics2D g2d=(Graphics2D) g;
		 Random rand = new Random();
		 int r = (int) (Math.random()*256);
		 int gr = (int) (Math.random()*256);
		 int b = (int) (Math.random()*256);
			
			width=50;
			height=50;
			
			g2d.setColor(new Color(r,gr,b));//purple
			g2d.fillOval((int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),
				width, height);
	
		
		
	}
	

	public void render_random_food2(Graphics g) {
		 Graphics2D g2d=(Graphics2D) g;
		 Random rand = new Random();
		 int r = (int) (Math.random()*256);
		 int gr = (int) (Math.random()*256);
		 int b = (int) (Math.random()*256);
			
			width=50;
			height=50;
			
			g2d.setColor(new Color(r,gr,b));
			g2d.fillOval((int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),
				width, height);
	
		
	}
	

	public void render_random_food3(Graphics g) {
		 Graphics2D g2d=(Graphics2D) g;
		 Random rand = new Random();
		 int r = (int) (Math.random()*256);
		 int gr = (int) (Math.random()*256);
		 int b = (int) (Math.random()*256);
			width=50;
			height=50;
			
			g2d.setColor(new Color(r,gr,b));//purple
			g2d.fillOval((int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),
				width, height);
	
		
		
	}
	
		
	}
	
	


