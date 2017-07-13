package Game;

import java.awt.Graphics;

public class MenuState  extends State{
	
	public MenuState(Handler handler)
	{
		super(handler);
	}

	@Override
	public void tick() {
		System.out.println(handler.getMouseManager().getMouseX() +  "  " +handler.getMouseManager().getMouseY());
		
	}

	@Override
	public void render(Graphics g) {
	
		//g.fillOval(100, 150, 40, 40);
		//g.fillRect(handler.getMouseManager().getMouseX(), handler.getMouseManager().getMouseY(), 30, 30);
		
	}

}
