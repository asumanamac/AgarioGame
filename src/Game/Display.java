package Game;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.TextField;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;





public class Display {
	
	private static JFrame frame;
	private String title;
	public  int width,height;
	static  Canvas canvas;
	static JPanel panel,gameover_panel;
	static JLabel timerField,scoreField,speedField;
	static JLabel timerLabel,scoreLabel,speedLabel;
	CountTimer countTimer;
	Timer timer;
	Score score;
	static  Rectangle bounds;
	
	public Display(String title,int width,int height)
	{
		this.title=title;
		this.width=width;
		this.height=height;
		score=new Score();
		
		createDisplay();
	}
	public Display()
	{
		
	}
	
	private void createDisplay()
	{
		frame=new JFrame(title);
		frame.setSize(width, height);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		
		

		panel=new JPanel(new GridLayout(1,4,10,10));
		timerLabel=new JLabel("Timer");
		timerField=new JLabel();
		Font f1=new Font("Sanserif",Font.BOLD,20);
        timerField.setFont(f1);
        timerLabel.setFont(f1);


		Runnable gui=new Runnable(){

			@Override
			public void run() {
				countTimer=new CountTimer();
			}
			
		};
		
		SwingUtilities.invokeLater(gui);
			


		scoreLabel=new JLabel("Score",10);
		scoreLabel.setFont(f1);
		scoreField=new JLabel();
		scoreLabel.setFont(f1);
		scoreField.setFont(f1);
	
		speedLabel=new JLabel("Speed",10);
		speedField =new JLabel();
		speedLabel.setFont(f1);
		speedField.setFont(f1);
		
		panel.add(timerLabel);
		panel.add(timerField);
		panel.add(scoreLabel);
		panel.add(scoreField);
		panel.add(speedLabel);
		panel.add(speedField);

	     bounds = new Rectangle(width, height);
	     
	     
		
		
		frame.add(panel,BorderLayout.NORTH);
		
		canvas=new Canvas();
		canvas.setPreferredSize(new Dimension(width,height));
		canvas.setMaximumSize(new Dimension(width,height));
		canvas.setMinimumSize(new Dimension(width,height));
		canvas.setFocusable(false);
		 frame.setMaximizedBounds(bounds);
	
		frame.add(canvas);
		
		//frame.pack();
	}
	
	public Canvas getCanvas()
	{
		return canvas;
	}
	
	public static JFrame getFrame()
	{
		return frame;
	}
	
	
	
	


}