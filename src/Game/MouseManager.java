package Game;

import java.awt.AWTException;
import java.awt.Cursor;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener,MouseMotionListener{
	
	private boolean leftPressed,rightPressed;
	private int mouseX,mouseY;
	public boolean up,down,right,left;

	
	private boolean[] keys;

	
	
	public MouseManager()
	{
		keys=new boolean[256];
	}
	
	public void tick()
	{
		up=keys[MouseEvent.BUTTON1];
		down=keys[MouseEvent.BUTTON2];
		right=keys[MouseEvent.BUTTON3];
		//left=keys[MouseEvent.BUTTON2];
	}
	
	
	public boolean isleftPressed()
	{
		return leftPressed;
	}
	
	public boolean isRightPressed()
	{
		return rightPressed;
	}
	
	public int getMouseX()
	{
		return mouseX;
	}
	
	public int getMouseY()
	{
		return mouseY;
	}
	
	
	@Override
	public void mousePressed(MouseEvent e) {
		
		System.out.println("Mouse pressed");
		
		keys[e.getButton()]=true;
		/*System.out.println("Pressed");
		
		if(e.getButton()==MouseEvent.BUTTON1)
		{
			leftPressed=true;
		}
		
		
		if(e.getButton()==MouseEvent.BUTTON3)
		{
			rightPressed=true;
		}*/
		//keys[e.getModifiers()]=true;
		

		
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		/*System.out.println("NOt pressed");
		
		if(e.getButton()==MouseEvent.BUTTON1)
		{
			leftPressed=false;
		}
		
		if(e.getButton()==MouseEvent.BUTTON3)
		{
			rightPressed=false;
		}
		*/
		//keys[e.getModifiers()]=false;
		
		keys[e.getButton()]=false;
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
	
		/*
		point=new Point(e.getX(),e.getY());
		
		//ystem.out.println(point.getX());
		mouseX= (int) (point.getX()-Player.x);
		e.getPoint().setLocation(Player.x, Player.y);
		//Player.speed++;
		Player.x++;
		mouseY=(int) (point.getY()-Player.y);
		//Player.y++;
	
		
		*/
	//System.out.println(Player.speed);
		//System.out.println(Player.xMove+ "   " + Player.yMove);
		
		//point=new Point(e.getX(),e.getY()-25);
		
		//mouseX=e.getX()-50;
		//mouseY=e.getY()-50;
		//keys[e.getModifiers()]=true;
		//Player.xMove=point.x;
		//Player.yMove=point.y;
		
		
		
		//System.out.println(point.x +  "   " + point.y);
		
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
	System.out.println("Clicked");
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
