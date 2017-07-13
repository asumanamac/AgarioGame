package Game;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class CountTimer{

	static int interval;
	static Timer timer;
	static JDialog dialog;
	static TimerTask task;
	public  static boolean isGameOver=false;


		
		public CountTimer(){
	 
	    int delay = 1000;
	    int period = 1000;
	    dialog=new JDialog();
	    dialog.setTitle("GAME OVER");
	    dialog.setSize(300, 300);
	    dialog.setLocationRelativeTo(null);
	    
	    interval=50;
	    
	    
	   timer = new Timer();
	    ((Timer) timer).scheduleAtFixedRate(new TimerTask() {
	      public void run() {
	     Display.timerField.setText(""+setInterval());
	     
	     
	     

	        }
	    }, delay, period);
	    

		
	
	    
	   
	   
	}

	public static int setInterval() {
		
		
	
		     if(interval==0)
		     {
		    	 
		    	GameOver.gameOver();
	
			    
		    		}
		    		
		    
	    if(interval<0)
	    	interval=0;
	   if(interval>0)
	    	interval--;
	    
	    	return interval;
	   
	    
	}
	
	}
	
	