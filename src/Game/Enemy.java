package Game;

import java.awt.Color;
import java.awt.Graphics;

import javafx.scene.shape.Circle;

public class Enemy extends StaticEntity{
	
	private int width,height;
	

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

	public Enemy(Handler handler, float x, float y) {
		super(handler, x, y,Tile.TILEWIDTH, Tile.TILEHEIGT*2);
		
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void render(Graphics g) {
		
		width=40;
		height=40;
		
		g.setColor(Color.black);
		g.fillOval((int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),
				    width, height);
		
	}

	@Override
	public void render2(Graphics g) {
		
		width=70;
		height=70;
		g.setColor(Color.black);
		g.fillOval((int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),
				   width, height);
		
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
