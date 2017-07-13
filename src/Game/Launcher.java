package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Launcher extends JFrame{
	
	java.awt.Image backgroundImage;
	ImageIcon backgroundIcon;
	JButton playbutton,exitbutton,scorebutton,helpbutton;
	JPanel panel;
	
	public Launcher()
	{
		
		
		backgroundIcon = new ImageIcon("images//main_page2.png");
		backgroundImage = backgroundIcon.getImage();
		
		playbutton=new JButton("PLAY");
		playbutton.setFont(new Font("Comic", Font.BOLD, 20));
		playbutton.setBackground(new Color(174, 214, 241));
		
		exitbutton=new JButton("EXIT");
		exitbutton.setBackground(new Color(174, 214, 241));
		exitbutton.setFont(new Font("Comic", Font.BOLD, 20));
		
		scorebutton=new JButton("SCORE");
		scorebutton.setBackground(new Color(174, 214, 241));
		scorebutton.setFont(new Font("Comic", Font.BOLD, 20));
		
		helpbutton=new JButton("HELP");
		helpbutton.setBackground(new Color(174, 214, 241));
		helpbutton.setFont(new Font("Comic", Font.BOLD, 20));
		
	
		
		panel=new JPanel(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.ipady = 0;
		c.weighty = 1.0;
		c.anchor = GridBagConstraints.SOUTH;
		c.insets = new Insets(120, -600, 100, 200);
		c.gridx = 200;
		c.gridwidth = 200;
		c.gridy = 200;
		
		panel = new JPanel(new GridBagLayout()) {

			protected void paintComponent(Graphics g) {
				g.drawImage(backgroundImage, 0, 0, null);
			}
		};

		
		panel.add(playbutton,c);
		
		c.anchor = GridBagConstraints.SOUTH;
		c.insets = new Insets(120, -50, 100, 200);
		
		panel.add(scorebutton,c);
		

		
		c.anchor = GridBagConstraints.SOUTH;
		c.insets = new Insets(120, 450, 100, 200);
		
		panel.add(helpbutton,c);
		
		c.anchor = GridBagConstraints.SOUTH;
		c.insets = new Insets(120, 950, 100, 200);
		
		panel.add(exitbutton,c);
		
	
		setSize(1080,600);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		playbutton.addActionListener(new ButtonListener());
	    scorebutton.addActionListener(new ButtonListener());
	    helpbutton.addActionListener(new ButtonListener());
	    exitbutton.addActionListener(new ButtonListener());
				
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==playbutton)
		{
			dispose();
		
			
			
			/*SwingUtilities.invokeLater(new Runnable() {
		         @Override
		         public void run() {
		        	 Game game=new Game("Title",1000,600);
		     		game.start();
		         }
		      });*/
			
			new UserInfo();
			 
			
			 
		
			
		}
		
		if(arg0.getSource()==scorebutton)
		{
			dispose();
			new ScoreBoard();
		
			
		}
		
		if(arg0.getSource()==helpbutton)
		{
			dispose();
			new HelpScreen();
		
			
		}
		
		if(arg0.getSource()==exitbutton)
		{
			dispose();
			System.exit(0);
		}
			
		}
		
	}


}

