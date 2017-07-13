package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class EntityManager {
	
	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	private ArrayList<Enemy> enemy_entities,big_enemies;
	private ArrayList<CirclesEntity> circle_entities,yellow_circle,blue_circle,cyan_circle,magenta_circle;
	private ArrayList<CirclesEntity> dark_blue,dark_pink,light_blue,light_green,purple,random_food,random_food2
	,random_food3;
	private Enemy enemy;
	private CirclesEntity circle;
	
	
	public EntityManager(Handler handler,Player player)
	{
		this.handler=handler;
		this.player=player;
		entities=new ArrayList<Entity>();
		addEntity(player);
		//addEnemy(enemy);
	}
	
	public EntityManager(Handler handler,Enemy enemy)
	{
		this.handler=handler;
		this.setEnemy(enemy);
		enemy_entities=new ArrayList<Enemy>();
		big_enemies=new ArrayList<Enemy>();
		
		
	}
	
	public EntityManager(Handler handler,CirclesEntity circle)
	{
		this.handler=handler;
		this.circle=circle;
		circle_entities=new ArrayList<CirclesEntity>();
		yellow_circle=new ArrayList<CirclesEntity>();
		blue_circle=new ArrayList<CirclesEntity>();
		cyan_circle=new ArrayList<CirclesEntity>();
		magenta_circle=new ArrayList<CirclesEntity>();
		dark_blue=new ArrayList<CirclesEntity>();
		dark_pink=new ArrayList<CirclesEntity>();
		light_green=new ArrayList<CirclesEntity>();
		purple=new ArrayList<CirclesEntity>();
		light_blue=new ArrayList<CirclesEntity>();
		random_food=new ArrayList<CirclesEntity>();
		random_food2=new ArrayList<CirclesEntity>();
		random_food3=new ArrayList<CirclesEntity>();
		
		
	}
	
	public void tick()
	{
		for(int i=0;i<entities.size();i++)
		{
			Entity e=entities.get(i);
			e.tick();
			
			
		}
		
		player.tick();
	}
	
	public void tick2()
	{
		for(int i=0;i<enemy_entities.size();i++)
		{
			Entity e=enemy_entities.get(i);
			e.tick();
			
			
		}
		
		enemy.tick();
	}
	

	
	public void render(Graphics g)
	{
		for(Entity e:entities)
		{
			e.render(g);
		}
		g.setColor(Color.red);	
		player.render(g);
		//enemy.render(g);
		
	
	
	}
	

	public void render_enemy(Graphics g)
	{
		for(Enemy e:enemy_entities)
		{
			e.render(g);
		}
		//g.setColor(Color.red);	
		enemy.render(g);
		//enemy.render(g);
		
	
	
	}
	

	public void render_circle(Graphics g)
	{
		
		Graphics2D g2 = (Graphics2D) g;

		for(CirclesEntity e:circle_entities)
		{
			
			e.render(g);
			
	
		}
		//g.setColor(Color.red);	
		circle.render(g);

		//enemy.render(g);
		
	
	
	}
	
	public void render_yellow(Graphics g)
	{
		
		Graphics2D g2 = (Graphics2D) g;

		for(CirclesEntity e:yellow_circle)
		{
			
			e.render3(g);
		
	
		}
		//g.setColor(Color.red);	
		circle.render3(g);
	
		//enemy.render(g);
	
	}
	
	public void render_blue(Graphics g)
	{
		

		for(CirclesEntity e:blue_circle)
		{
		
			e.render2(g);
	
		}
		//g.setColor(Color.red);	
	
		circle.render2(g);
		//enemy.render(g);
	
	}
	
	public void render_cyan(Graphics g)
	{
		

		for(CirclesEntity e:cyan_circle)
		{
		
			e.render5(g);
	
		}
		//g.setColor(Color.red);	
	
		circle.render5(g);
		//enemy.render(g);
	
	}
	
	public void render_magenta(Graphics g)
	{
		

		for(CirclesEntity e:magenta_circle)
		{
		
			e.render4(g);
	
		}
		//g.setColor(Color.red);	
	
		circle.render4(g);
		//enemy.render(g);
	
	}
	
	public void render_big_enemies(Graphics g)
	{
		

		for(Enemy e:big_enemies)
		{
		
			e.render2(g);
	
		}
		//g.setColor(Color.red);	
	
		enemy.render2(g);
		//enemy.render(g);
	
	}
	
	public void render_dark_blue(Graphics g)
	{
		

		for(CirclesEntity c:dark_blue)
		{
		
			c.render6(g);
	
		}
		//g.setColor(Color.red);	
	
		circle.render6(g);
		//enemy.render(g);
	
	
	
	}
	
	public void render_dark_pink(Graphics g)
	{
		

		for(CirclesEntity c:dark_pink)
		{
		
			c.render7(g);
	
		}
		//g.setColor(Color.red);	
	
		circle.render7(g);
		//enemy.render(g);
	
	}
	
	public void render_purple(Graphics g)
	{
		

		for(CirclesEntity c:purple)
		{
		
			c.render10(g);
	
		}
		//g.setColor(Color.red);	
	
		circle.render10(g);
		//enemy.render(g);
	
	}
	
	public void render_light_green(Graphics g)
	{
		

		for(CirclesEntity c:light_green)
		{
		
			c.render9(g);
	
		}
		//g.setColor(Color.red);	
	
		circle.render9(g);
		//enemy.render(g);
	
	}
	
	public void render_light_blue(Graphics g)
	{
		

		for(CirclesEntity c:light_blue)
		{
		
			c.render8(g);
	
		}
		//g.setColor(Color.red);	
	
		circle.render8(g);
		//enemy.render(g);
	
	}
	

	public void render_random_food(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
		
   if(Entity.isCollsion==true){
	 
		for(CirclesEntity c:random_food)
		{
			 
		
			c.render_random_food(g2);
	
		}
		//g.setColor(Color.red);	
	
		circle.render_random_food(g2);
		//enemy.render(g);
	
	}

	}
	
	public void render_random_food2(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
       if(Entity.isCollsion==true){
		for(CirclesEntity c:random_food2)
		{
		
			c.render_random_food2(g2);
	
		}
		//g.setColor(Color.red);	
	
		circle.render_random_food2(g2);
		//enemy.render(g);
	
	}

	}
	
	public void render_random_food3(Graphics g)
	{
		Graphics2D g2=(Graphics2D) g;
       if(Entity.isCollsion==true){
		for(CirclesEntity c:random_food3)
		{
		
			c.render_random_food3(g2);
	
		}
		//g.setColor(Color.red);	
	
		circle.render_random_food3(g2);
		//enemy.render(g);
	
	}

	}
	
	
	
	
	public void addEntity(Entity e)
	{
		entities.add(e);
		

	}
	
	public void addEnemy(Enemy e)
	{
		enemy_entities.add(e);
	}
	
	public void addBigEnemy(Enemy e)
	{
		big_enemies.add(e);
	}
	
	public void addCircle(CirclesEntity c)
	{
		circle_entities.add(c);
	}
	
	public void addYellowCircles(CirclesEntity c)
	{
		yellow_circle.add(c);
	}
	
	public void addPinkCircles(CirclesEntity c)
	{
		blue_circle.add(c);
	}
	public void addOrangeCircles(CirclesEntity c)
	{
		magenta_circle.add(c);
	}
	
	public void addCyanCircles(CirclesEntity c)
	{
		cyan_circle.add(c);
	}
	
	public void addDarkBlueCircles(CirclesEntity c)
	{
		dark_blue.add(c);
	}
	
	public void addDarkPinkCircles(CirclesEntity c)
	{
		dark_pink.add(c);
	}
	
	public void addPurpleCircles(CirclesEntity c)
	{
		purple.add(c);
	}
	
	public void addLightBlueCircles(CirclesEntity c)
	{
		light_blue.add(c);
	}
	
	public void addLightGreenCircles(CirclesEntity c)
	{
		light_green.add(c);
	}
	
	public void addRandomFood(CirclesEntity c)
	{
			random_food.add(c);
				
		
	}
	
	public void addRandomFood2(CirclesEntity c)
	{
			random_food2.add(c);
				
		
	}
	
	public void addRandomFood3(CirclesEntity c)
	{
			random_food3.add(c);
				
	
	}
	
	
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}



	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
	public ArrayList<Enemy> getEnemies()
	{
		return enemy_entities;
	}
	
	public ArrayList<Enemy> getBigEnemies()
	{
		return big_enemies;
	}
	
	
	public ArrayList<CirclesEntity> getCircles()
	{
		return circle_entities;
	}
	
	public ArrayList<CirclesEntity> getCircles2()
	{
		return yellow_circle;
	}
	
	public ArrayList<CirclesEntity> getCircles3()
	{
		return blue_circle;
	}
	
	public ArrayList<CirclesEntity> getCircles4()
	{
		return cyan_circle;
	}
	
	public ArrayList<CirclesEntity> getCircles5()
	{
		return magenta_circle;
	}
	
	public ArrayList<CirclesEntity> getCircles6()
	{
		return dark_blue;
	}
	
	public ArrayList<CirclesEntity> getCircles7()
	{
		return dark_pink;
	}
	
	public ArrayList<CirclesEntity> getCircles8(){
		return purple;
	}
	
	public ArrayList<CirclesEntity> getCircles9()
	{
		return light_green;
	}
	
	public ArrayList<CirclesEntity> getCircles10()
	{
		return light_blue;
	}
	
	public ArrayList<CirclesEntity> getRandomFood()
	{
	
		return random_food;
	}
	
	public ArrayList<CirclesEntity> getRandomFood2()
	{
	
		return random_food2;
	}
	
	public ArrayList<CirclesEntity> getRandomFood3()
	{
	
		return random_food3;
	}
	
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

	public Enemy getEnemy() {
		return enemy;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}

	public CirclesEntity getCircle() {
		return circle;
	}

	public void setCircle(CirclesEntity circle) {
		this.circle = circle;
	}

}
