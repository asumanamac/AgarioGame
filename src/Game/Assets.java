package Game;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage squareTile,squareTile_second,squareTile_third,squareTile_fourth,squareTile_fifth;
	public static final int width=32,height=32;
	
	public static void init()
	
	{
		
		SpriteSheet sheet=new SpriteSheet(ImageLoader.loadImage("/textures/tile_map.png"));
		squareTile=sheet.crop(0,0, width, height);
		squareTile_second=sheet.crop(width,0, width, height);
		squareTile_third=sheet.crop(width*2,0, width, height);
		squareTile_fourth=sheet.crop(width*3,0, width, height);
		squareTile_fifth=sheet.crop(0,height, width, height);
		
		
		
	}

}
