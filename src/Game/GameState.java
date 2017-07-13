package Game;

import java.awt.Graphics;

public class GameState extends State{
	
	private World world;

	
	public GameState(Handler handler)
	{
		super(handler);

	    //handler.getGameCamera().move(0,0);
		
	    world=new World(handler,"res/worlds/world1.txt");
	    handler.setWorld(world);;
		//player=new Player(handler,100,100);
		//handler.getGameCamera().move(0,0);
		//circle=new CirclesEntity(handler,100,200);
		
		
	}

	@Override
	public void tick() {
		
		world.tick();
		//handler.getGameCamera().move(1,1);
		//player.tick();
		//circle.tick();
		
	}

	@Override
	public void render(Graphics g) {
		//Tile.tiles[0].render(g, 0, 0);
		world.render(g);
		
		//g.fillOval(150, 150, 30, 30);
		
		//player.render(g);
		//circle.render(g);
		
		
	}
	

}
