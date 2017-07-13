package Game;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TextField;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tile extends JFrame{
	
	public static final int TILEWIDTH=64,TILEHEIGT=64;
	
	protected BufferedImage texture;
	protected final int id;
	public static Tile[] tiles=new Tile[256];
	public static Tile squareTile=new SquareTile(0);
	public static Tile squareTile2=new SquareTile(1);
	public static Tile squareTile3=new SquareTile(2);
	JPanel panel;
	TextField timerField,scoreField,speedField;
	JLabel timerLabel,scoreLabel,speedLabel;
	
	
	public Tile(BufferedImage texture,int id)
	{
		this.texture=texture;
		this.id=id;
		tiles[id]=this;
		
	
		
		
	}
	
	public void tick()
	{
		
	}
	
	public boolean isSolid()
	{
		return false;
	}
	public void render(Graphics g,int x,int y)
	{
		g.drawImage(texture, x, y, TILEWIDTH,TILEHEIGT,null);


	}
	
	public int getId()
	{
		return id;
	}

}
