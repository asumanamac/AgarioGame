package Game;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends Circles{
	private Handler handler;
	
	Random r=new Random();
	Graphics2D g2d;
	Color color;
	

	public Player(Handler handler,float x, float y) {
		super(handler,x, y,Circles.DEFAULT_CIRCLE_WIDTH,Circles.DEFAULT_CIRCLE_HEIGHT);
		
		this.handler=handler;
		bounds.x=15;
		bounds.y=15;
		bounds.width=15;
		bounds.height=15;

	
		
		
	}
	
	public int getWidth()
	{
		return DEFAULT_CIRCLE_WIDTH;
	}
	
	@Override
	public void tick() {
		
		getInput();
	
		handler.getGameCamera().centerEntity(this);
		
		move();	
	getMouseInput();			
	}
	
	private void getInput()
	{
		xMove=0;
		yMove=0;
		
		if(handler.getKeyManager().up)
			yMove=-speed;
		
		if(handler.getKeyManager().down)
			yMove=speed;
		
		if(handler.getKeyManager().left)
			xMove=-speed;
		
		if(handler.getKeyManager().right)
			xMove=speed;
		
	}
	
	
	private void getMouseInput()
	{
	xMove=0;
		yMove=0;
		
		if(handler.getMouseManager().up)
			yMove=-speed;
		
		if(handler.getMouseManager().down)
			yMove=speed;
		
		if(handler.getMouseManager().left)
			xMove=-speed;
		
		if(handler.getMouseManager().right)
			xMove=speed;
		
		
		
		
	}
	
	
	
	public void setRandomColor(Color color)
	{
	this.color=color;
	}


	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g2d=(Graphics2D)g;
		g2d.fillOval((int)(x-handler.getGameCamera().getxOffset()), (int)(y-handler.getGameCamera().getyOffset()),
				              DEFAULT_CIRCLE_WIDTH,DEFAULT_CIRCLE_HEIGHT);
		
		g2d.drawString(UserInfo.username_input.getText().toString(), (x-handler.getGameCamera().getxOffset()), (y-handler.getGameCamera().getyOffset()));
		
		//g.fillOval((int)(x+bounds.x-handler.getGameCamera().getxOffset()), (int)(y+bounds.y-handler.getGameCamera().getyOffset()),
			//	bounds.width, bounds.height);
		
	}

	@Override
	public void render2(Graphics g) {
         
		//g2d.drawString(UserInfo.username, (x-handler.getGameCamera().getxOffset()), (y-handler.getGameCamera().getyOffset()));
		// TODO Auto-generated method stub
		
		Graphics2D g2d=(Graphics2D) g;
		g2d.drawString(UserInfo.username_input.getText().toString(),(x-handler.getGameCamera().getxOffset()),(y-handler.getGameCamera().getyOffset()));
		
	}

	@Override
	public void render3(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render4(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render5(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render6(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render7(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render8(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render9(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render10(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
	
}
