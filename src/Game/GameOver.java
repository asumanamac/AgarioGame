package Game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;



public class GameOver {
	
static TimerTask task;
static boolean isGameOver=false;
public static String username;
static JFrame frame;
static JPanel panel;
static JPanel panel2;
static JTextField username_input;
static JLabel username_label;
static JButton button;
                   

    public GameOver()
    {
    
		

			
    }

	public static void gameOver()
	{
		
			FileWriter fw = null;
			try {
				fw = new FileWriter("score.txt", true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			PrintWriter pw = null;//any resource with IO should be in a finally block to close
		    try {
		        pw = new PrintWriter(fw);
		        pw.println(UserInfo.username_input.getText().toString()+"\t"+Score.score);
		        pw.close();
		    } catch (Exception ex) {
		        System.out.println("save err " + ex);
		        ex.printStackTrace();
		       
		    }finally{
		        if (pw != null) {
		            try {
		                pw.close();
		            } catch (Throwable e) {
		               
		            }
		 }                  
		   } 
		    
		    JOptionPane.showMessageDialog(null, "Your Score = " + Score.score);
		    System.exit(0);
		    
			/*frame=new JFrame();
			frame.setLayout(new BorderLayout());
			username_label=new JLabel("Your Score = " +Score.score);
			button=new JButton("OK");
			

			JPanel panel=new JPanel(new GridLayout(1,2));
			JPanel panel2=new JPanel();
			
			panel.add(username_label);
			panel2.add(button);
			
			frame.add(panel,BorderLayout.NORTH);
			frame.add(panel2,BorderLayout.CENTER);
			frame.setSize(250,120);
			frame.setTitle("Username");
			frame.setResizable(false);
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			button.addActionListener(new ButtonListener());*/
		
		 }	
	
	static class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==button)
		{	
			frame.dispose();
	   
			System.exit(0);
			
		}	
	
			
				
		}
		
	
			
		}
}
	

	

		
		
	
	



