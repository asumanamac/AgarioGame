package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Comparator;



public abstract class Entity {
	
	protected  float x;
	protected  float y;
	protected int width,height;
	protected Handler handler;
	protected Rectangle bounds;
	static boolean isCollsion=false;
	static boolean isActive=false;
	Score score;
	
	public Entity(Handler handler,float x,float y,int width,int height)
	{
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.handler=handler;
		score=new Score();
		
		bounds=new Rectangle(0,0,width,height);
	}
	
	public float getX() {
		return x;
	}
	
	

public boolean compare(Player player1, CirclesEntity circle1) {
	
	 int player= player1.getWidth();
     int circle_entitiy = circle1.getWidth();
     
	
	if(player>=circle_entitiy)
		return true;
	else
		return false;
}

public boolean compareEnemy(Player player1, Enemy enemy) {
	
	 int player= player1.getWidth();
    int enemy_entitiy = enemy.getWidth();
    
	
	if(player>=enemy_entitiy)
		return true;
	else
		return false;
}

public boolean compareRandomFood(Player player1, CirclesEntity circle) {
	
	 int player= player1.getWidth();
   int circle_entitiy = circle.getWidth();
   
	
	if(player>=circle_entitiy)
		return true;
	else
		return false;
}


	
	public boolean checkEntityCollisons(double xOffset,double yOffset)
	{
		for(Entity e:handler.getWorld().getEntitiyManager().getEntities())
		{
			if(e.equals(this))
				continue;
			if(e.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
			{
				
				
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManager().getCircle())==true){
		
				handler.getWorld().getEntitiyManager().getEntities().remove(e);
				
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_WIDTH+=2;
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_HEIGHT+=2;
				handler.getWorld().getEntitiyManager().getPlayer().speed-=0.1d;
				Display.scoreField.setText(""+score.increaseScore());
				Display.speedField.setText(""+handler.getWorld().getEntitiyManager().getPlayer().speed);
				

				if(handler.getWorld().getEntitiyManager().getPlayer().speed<0.1d)
					GameOver.gameOver();
				}
				
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManager().getCircle())==false){
					
					GameOver.gameOver();
					
					
				}
				return true;
			}
			
			else
				isCollsion=false;
			
			
		}
		
		for(Enemy e:handler.getWorld().getEntitiyManagerEnemy().getEnemies())
		{
			if(e.equals(this))
				continue;
			if(e.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
			{
				if(compareEnemy(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerEnemy().getEnemy())==true){
				
		
				handler.getWorld().getEntitiyManagerEnemy().getEnemies().remove(e);
				handler.getWorld().getEntitiyManager().getPlayer().setRandomColor(Color.BLACK);
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_WIDTH-=2;
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_HEIGHT-=2;
				handler.getWorld().getEntitiyManager().getPlayer().speed+=0.1d;
				Display.scoreField.setText(""+score.decreaseScore());
				Display.speedField.setText(""+handler.getWorld().getEntitiyManager().getPlayer().speed);
				

				if(handler.getWorld().getEntitiyManager().getPlayer().speed<0.1d)
					GameOver.gameOver();
			}

				if(compareEnemy(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerEnemy().getEnemy())==false){
					
					GameOver.gameOver();
					
					
				}
			
				return true;
			
			}	
			}
			
			for(CirclesEntity c:handler.getWorld().getEntitiyManagerCirle().getCircles())
			{
				if(c.equals(this))
					continue;
				if(c.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
				{
					if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
							handler.getWorld().getEntitiyManagerCirle().getCircle())==true){
						
				
				
					handler.getWorld().getEntitiyManagerCirle().getCircles().remove(c);
					handler.getWorld().getEntitiyManager().getPlayer().setRandomColor(Color.green);
					handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_WIDTH+=2;
					handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_HEIGHT+=2;
					handler.getWorld().getEntitiyManager().getPlayer().speed-=0.1d;
					Display.scoreField.setText(""+score.increaseScore());
					Display.speedField.setText(""+handler.getWorld().getEntitiyManager().getPlayer().speed);
					

					if(handler.getWorld().getEntitiyManager().getPlayer().speed<0.1d)
						GameOver.gameOver();
				
					}

					if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
							handler.getWorld().getEntitiyManagerCirle().getCircle())==false){
						GameOver.gameOver();
						
					}
				
					return true;
				
					
				}
			}
		
		
		for(CirclesEntity c:handler.getWorld().getEntitiyManagerYellow().getCircles2())
		{
			if(c.equals(this))
				continue;
			if(c.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
			{
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerYellow().getCircle())==true){
				isCollsion=true;
				handler.getWorld().getEntitiyManagerYellow().getCircles2().remove(c);
				handler.getWorld().getEntitiyManager().getPlayer().setRandomColor(Color.yellow);
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_WIDTH+=2;
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_HEIGHT+=2;
				handler.getWorld().getEntitiyManager().getPlayer().speed-=0.4d;
				Display.scoreField.setText(""+score.increaseScore());
				Display.speedField.setText(""+handler.getWorld().getEntitiyManager().getPlayer().speed);
				

				if(handler.getWorld().getEntitiyManager().getPlayer().speed<0.1d)
					GameOver.gameOver();
				}
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerYellow().getCircle())==false){
					GameOver.gameOver();
					
				}
			
			
				
				return true;
			}
			
		}
	
		for(CirclesEntity c:handler.getWorld().getEntitiyManagerBlue().getCircles3())
		{
			if(c.equals(this))
				continue;
			if(c.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
			{
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerBlue().getCircle())==true){
				isCollsion=true;
				handler.getWorld().getEntitiyManagerBlue().getCircles3().remove(c);
				handler.getWorld().getEntitiyManager().getPlayer().setRandomColor(Color.blue);
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_WIDTH+=4;
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_HEIGHT+=4;
				handler.getWorld().getEntitiyManager().getPlayer().speed-=0.1d;
				Display.scoreField.setText(""+score.increaseScore());
				Display.speedField.setText(""+handler.getWorld().getEntitiyManager().getPlayer().speed);

				if(handler.getWorld().getEntitiyManager().getPlayer().speed<0.1d)
					GameOver.gameOver();
			}
				
				else
					isCollsion=false;
				

				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerBlue().getCircle())==false){
					
					GameOver.gameOver();
					
				}
				
				
				
				return true;
				
				
			}
				
				
				
			
		
		}
		
		for(CirclesEntity c:handler.getWorld().getEntitiyManagerCyan().getCircles4())
		{
			if(c.equals(this))
				continue;
			if(c.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
			{
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerCyan().getCircle())==true){
				isCollsion=true;
				handler.getWorld().getEntitiyManagerCyan().getCircles4().remove(c);
				handler.getWorld().getEntitiyManager().getPlayer().setRandomColor(Color.cyan);
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_WIDTH+=2;
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_HEIGHT+=2;
				handler.getWorld().getEntitiyManager().getPlayer().speed-=0.1d;
				Display.scoreField.setText(""+score.increaseScore());
				Display.speedField.setText(""+handler.getWorld().getEntitiyManager().getPlayer().speed);
				

				if(handler.getWorld().getEntitiyManager().getPlayer().speed<0.1d)
					GameOver.gameOver();

				}
				
				else
					isCollsion=false;
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerCyan().getCircle())==false){
					isCollsion=true;
					GameOver.gameOver();
					
				}
				
			
				
				return true;
				
			}
		}
		
		for(CirclesEntity c:handler.getWorld().getEntitiyManagerMagenta().getCircles5())
		{
			if(c.equals(this))
				continue;
			if(c.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
			{
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerMagenta().getCircle())==true){
				isCollsion=true;
				handler.getWorld().getEntitiyManagerMagenta().getCircles5().remove(c);
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_WIDTH+=2;
				handler.getWorld().getEntitiyManager().getPlayer().setRandomColor(Color.MAGENTA);
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_HEIGHT+=2;
				handler.getWorld().getEntitiyManager().getPlayer().speed-=0.1d;
				Display.scoreField.setText(""+score.increaseScore());
				Display.speedField.setText(""+handler.getWorld().getEntitiyManager().getPlayer().speed);
				

				if(handler.getWorld().getEntitiyManager().getPlayer().speed<0.1d)
					GameOver.gameOver();
				
				
			}
				
				else
					isCollsion=false;
				
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerMagenta().getCircle())==false){
					
					GameOver.gameOver();
					
				}
				
			
				return true;
			}
		}
		
		for(CirclesEntity c:handler.getWorld().getEntitiyManagerDarkBlue().getCircles6())
		{
			if(c.equals(this))
				continue;
			if(c.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
			{
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerDarkBlue().getCircle())==true){
				isCollsion=true;
				handler.getWorld().getEntitiyManagerDarkBlue().getCircles6().remove(c);
				handler.getWorld().getEntitiyManager().getPlayer().setRandomColor(new Color(77,46,250));
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_WIDTH+=2;
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_HEIGHT+=2;
				handler.getWorld().getEntitiyManager().getPlayer().speed-=0.1d;
				Display.scoreField.setText(""+score.increaseScore());
				Display.speedField.setText(""+handler.getWorld().getEntitiyManager().getPlayer().speed);

				if(handler.getWorld().getEntitiyManager().getPlayer().speed<0.1d)
					GameOver.gameOver();
					
				
			}
				
				else
					isCollsion=false;
				
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerDarkBlue().getCircle())==false){
					
					GameOver.gameOver();
					
				}
				
				
				return true;
			}
		}
		
		for(CirclesEntity c:handler.getWorld().getEntitiyManagerDarkPink().getCircles7())
		{
			if(c.equals(this))
				continue;
			if(c.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
			{
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerDarkPink().getCircle())==true){
				isCollsion=true;
				handler.getWorld().getEntitiyManagerDarkPink().getCircles7().remove(c);
				handler.getWorld().getEntitiyManager().getPlayer().setRandomColor(new Color(250,46,250));
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_WIDTH+=2;
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_HEIGHT+=2;
				handler.getWorld().getEntitiyManager().getPlayer().speed-=0.1d;
				Display.scoreField.setText(""+score.increaseScore());
				Display.speedField.setText(""+handler.getWorld().getEntitiyManager().getPlayer().speed);
				

				if(handler.getWorld().getEntitiyManager().getPlayer().speed<0.1d)
					GameOver.gameOver();
				
					
				
			}
				
				else
					isCollsion=false;
				
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerDarkPink().getCircle())==false){
					isCollsion=true;
					GameOver.gameOver();
					
				}
				
			
				
				return true;
			}
		}
		
		for(CirclesEntity c:handler.getWorld().getEntitiyManagerPurple().getCircles8())
		{
			if(c.equals(this))
				continue;
			if(c.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
			{
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerLightGreen().getCircle())==true){
				isCollsion=true;
				handler.getWorld().getEntitiyManagerLightGreen().getCircles8().remove(c);
				handler.getWorld().getEntitiyManager().getPlayer().setRandomColor(new Color(16,203,245));
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_WIDTH+=2;
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_HEIGHT+=2;
				handler.getWorld().getEntitiyManager().getPlayer().speed-=0.1d;
				Display.scoreField.setText(""+score.increaseScore());
				Display.speedField.setText(""+handler.getWorld().getEntitiyManager().getPlayer().speed);
				

				if(handler.getWorld().getEntitiyManager().getPlayer().speed<0.1d)
					GameOver.gameOver();
					
				
			}
				
				else
					isCollsion=false;
				
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerLightGreen().getCircle())==false){
					isCollsion=true;
					GameOver.gameOver();
					
				}
			
				
				return true;
			}
		}
		
		for(CirclesEntity c:handler.getWorld().getEntitiyManagerLightGreen().getCircles9())
		{
			if(c.equals(this))
				continue;
			if(c.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
			{
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerLightGreen().getCircle())==true){
				isCollsion=true;
				handler.getWorld().getEntitiyManagerLightGreen().getCircles9().remove(c);
				handler.getWorld().getEntitiyManager().getPlayer().setRandomColor(new Color(134,245,16));
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_WIDTH+=2;
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_HEIGHT+=2;
				handler.getWorld().getEntitiyManager().getPlayer().speed-=0.1d;
				Display.scoreField.setText(""+score.increaseScore());
				Display.speedField.setText(""+handler.getWorld().getEntitiyManager().getPlayer().speed);
				

				if(handler.getWorld().getEntitiyManager().getPlayer().speed<0.1d)
					GameOver.gameOver();
				
			}
				else
					isCollsion=false;
				
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerLightGreen().getCircle())==false){
					GameOver.gameOver();
					
				}
				
				
				
				return true;
			}
		}
		
		for(CirclesEntity c:handler.getWorld().getEntitiyManagerLightBlue().getCircles10())
		{
			if(c.equals(this))
				continue;
			if(c.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
			{
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerLightBlue().getCircle())==true){
				isCollsion=true;
				handler.getWorld().getEntitiyManagerLightBlue().getCircles10().remove(c);
				handler.getWorld().getEntitiyManager().getPlayer().setRandomColor(new Color(16,203,245));
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_WIDTH+=2;
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_HEIGHT+=2;
				handler.getWorld().getEntitiyManager().getPlayer().speed-=0.1d;
				Display.scoreField.setText(""+score.increaseScore());
				Display.speedField.setText(""+handler.getWorld().getEntitiyManager().getPlayer().speed);
				

				if(handler.getWorld().getEntitiyManager().getPlayer().speed<0.1d)
					GameOver.gameOver();
					
				
			}
				else
					isCollsion=false;
				
				if(compare(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerLightBlue().getCircle())==false){
					GameOver.gameOver();
					
				}
				
				
				
				return true;
			}
			
		}
		
		

		for(CirclesEntity c:handler.getWorld().getEntitiyRandomFood().getRandomFood())
		{
			if(c.equals(this))
				continue;
			if(c.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
			{
				if(compareRandomFood(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyRandomFood().getCircle())==true){
				
			
				isCollsion=true;
				handler.getWorld().getEntitiyRandomFood().getRandomFood().remove(c);
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_WIDTH+=10;
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_HEIGHT+=10;
				handler.getWorld().getEntitiyManager().getPlayer().speed-=0.0d;
				Display.scoreField.setText(""+score.increasedoubleScore());
				Display.speedField.setText(""+handler.getWorld().getEntitiyManager().getPlayer().speed);
				

				if(handler.getWorld().getEntitiyManager().getPlayer().speed<0.1d)
					GameOver.gameOver();
				
				
				}
				
				else{
					isCollsion=false;
					
				}
				if(compareRandomFood(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyRandomFood().getCircle())==false){
					GameOver.gameOver();
					
				}
				
				
				
				
				return true;
			}
			
		}
		

		for(CirclesEntity c:handler.getWorld().getEntitiyRandomFood2().getRandomFood2())
		{
			if(c.equals(this))
				continue;
			if(c.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
			{
				if(compareRandomFood(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyRandomFood2().getCircle())==true){
				
			
				isCollsion=true;
				handler.getWorld().getEntitiyRandomFood2().getRandomFood2().remove(c);
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_WIDTH+=10;
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_HEIGHT+=10;
				handler.getWorld().getEntitiyManager().getPlayer().speed-=0.0d;
				Display.scoreField.setText(""+score.increasedoubleScore());
				Display.speedField.setText(""+handler.getWorld().getEntitiyManager().getPlayer().speed);
				

				if(handler.getWorld().getEntitiyManager().getPlayer().speed<0.1d)
					GameOver.gameOver();
					
				
				}
				
				else
					isCollsion=false;
				
				if(compareRandomFood(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyRandomFood2().getCircle())==false){
					GameOver.gameOver();
					
				}
				
				
				
				
				return true;
			}
			
		}
		

		for(CirclesEntity c:handler.getWorld().getEntitiyRandomFood3().getRandomFood3())
		{
			if(c.equals(this))
				continue;
			if(c.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
			{
				if(compareRandomFood(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyRandomFood3().getCircle())==true){
		
			
				isCollsion=true;
				handler.getWorld().getEntitiyRandomFood3().getRandomFood3().remove(c);
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_WIDTH+=10;
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_HEIGHT+=10;
				handler.getWorld().getEntitiyManager().getPlayer().speed-=0.0d;
				Display.scoreField.setText(""+score.increasedoubleScore());
				Display.speedField.setText(""+handler.getWorld().getEntitiyManager().getPlayer().speed);
				

				if(handler.getWorld().getEntitiyManager().getPlayer().speed<0.1d)
					GameOver.gameOver();
				
				}
				
				else{
					isCollsion=false;
					
				}
				
				if(compareRandomFood(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyRandomFood3().getCircle())==false){
					GameOver.gameOver();
					
				}
				
				
				return true;
			}
			
		}
			
		
		for(Enemy c:handler.getWorld().getEntitiyManagerBigEnemies().getBigEnemies())
		{
			if(c.equals(this))
				continue;
			if(c.getCollisionBound(0f,0f).intersects(getCollisionBound(xOffset,yOffset)))
			{
				if(compareEnemy(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerBigEnemies().getEnemy())==true){
				isCollsion=true;
				handler.getWorld().getEntitiyManagerBigEnemies().getBigEnemies().remove(c);
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_WIDTH-=4;
				handler.getWorld().getEntitiyManager().getPlayer().DEFAULT_CIRCLE_HEIGHT-=4;
				handler.getWorld().getEntitiyManager().getPlayer().speed+=0.2d;
				Display.scoreField.setText(""+score.decreaseScore());
				Display.speedField.setText(""+handler.getWorld().getEntitiyManager().getPlayer().speed);
				
				if(handler.getWorld().getEntitiyManager().getPlayer().speed<0.1d)
					GameOver.gameOver();
			
				}
					
				if(compareEnemy(handler.getWorld().getEntitiyManager().getPlayer(),
						handler.getWorld().getEntitiyManagerBigEnemies().getEnemy())==false){
				
					GameOver.gameOver();	
					
					
				}
				
			
				
				
				return true;
		
		}
			
			
			}
		
		
		

	
	
	
		
		return false;
		
	}
	
	public Rectangle getCollisionBound(double d,double e)
	{
		return new Rectangle((int)(x+bounds.x+d),(int)(y+bounds.y+e),bounds.width,bounds.height);
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

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

	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void render2(Graphics g);
	public abstract void render3(Graphics g);
	public abstract void render4(Graphics g);
	public abstract void render5(Graphics g);
	public abstract void render6(Graphics g);
	public abstract void render7(Graphics g);
	public abstract void render8(Graphics g);
	public abstract void render9(Graphics g);
	public abstract void render10(Graphics g);
	

}
