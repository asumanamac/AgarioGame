package Game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class UserInfo {
	public static String username;
	JFrame frame;
	JPanel panel;
	JPanel panel2;
	public static JTextField username_input;
	JLabel username_label;
	JButton button;
	
	public UserInfo()
	{
		
		frame=new JFrame();
		frame.setLayout(new BorderLayout());
		username_input=new JTextField(10);
		username_label=new JLabel("Enter a username");
		button=new JButton("OK");
		
		
		
		JPanel panel=new JPanel(new GridLayout(1,2));
		JPanel panel2=new JPanel();
		
		panel.add(username_label);
		panel.add(username_input);
		panel2.add(button);
		
		frame.add(panel,BorderLayout.NORTH);
		frame.add(panel2,BorderLayout.CENTER);
		frame.setSize(250,120);
		frame.setTitle("Username");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		button.addActionListener(new ButtonListener());
			
		
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==button)
		{
			frame.dispose();
			
			SwingUtilities.invokeLater(new Runnable() {
		         @Override
		         public void run() {
		        	 Game game=new Game("Title",1000,600);
		     		game.start();
		         }
		      });
		}
			
		}
		
	}

}
