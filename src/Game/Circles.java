package Game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Circles extends Entity{
	
	public static  double DEFAULT_SPEED=8.0f;
	public static int DEFAULT_CIRCLE_WIDTH=55,
			                DEFAULT_CIRCLE_HEIGHT=55;
	protected int health;
	protected double speed;
	protected double xMove;
	protected double yMove;

	public Circles(Handler handler,float x, float y,int width,int height) {
		super(handler,x, y,width,height);
		
		speed=DEFAULT_SPEED;
		xMove=0;
		yMove=0;
		
	}
	
	public void move()
	{
	
		
		
		if(!checkEntityCollisons(xMove,0f)){
		x+=xMove;
		
		if(x>=1840){
			x-=xMove;
			
		}
		if(x<=0)
			x-=xMove;
	
		}
		if(!checkEntityCollisons(0f,yMove)){
		y+=yMove;
		//System.out.println("YMOVE "+y);
		
		if(y>=1795)
			y-=yMove;
		if(y<=0)
			y-=yMove;
	
		}
	//	if(getBounds().intersects(Display.bounds))
		//			System.out.println("colliison");
		
		//moveX();
		//moveY();
		
		
		}

	
	
	
	public Rectangle getBounds()
	{
	    return new Rectangle((int)x,(int)y,width,height);
	}

	public double getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public double getyMove() {
		return yMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d=(Graphics2D) g;
		g2d.drawString(UserInfo.username_input.getText().toString(),(x-handler.getGameCamera().getxOffset()),(y-handler.getGameCamera().getyOffset()));
		
	}

}
