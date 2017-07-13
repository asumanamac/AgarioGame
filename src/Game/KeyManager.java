package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public boolean up,down,right,left;
	
	public KeyManager()
	{
		keys=new boolean[256];
	}
	
	public void tick()
	{
		up=keys[KeyEvent.VK_UP];
		down=keys[KeyEvent.VK_DOWN];
		right=keys[KeyEvent.VK_RIGHT];
		left=keys[KeyEvent.VK_LEFT];
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
		keys[arg0.getKeyCode()]=true;
		//System.out.println("Key pressed");
		
	
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		keys[arg0.getKeyCode()]=false;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

}
