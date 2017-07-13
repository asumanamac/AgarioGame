package Game;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScoreBoard extends JFrame{
	
	
	TextArea scoreArea;
	java.awt.Image backgroundImage;
	ImageIcon backgroundIcon;
	int highScore = 0;
	JPanel panel;
	CircularButton backbutton;
	ArrayList<String> highScores=new ArrayList<String>();
	
	public ScoreBoard()
	{
		
		
		backgroundIcon = new ImageIcon("images//main_page2.png");
		backgroundImage = backgroundIcon.getImage();
		
		scoreArea=new TextArea(35,65);
		scoreArea.setEditable(false);
		
		GridBagConstraints c = new GridBagConstraints();
		c.ipady = 0;
		c.weighty = 1.0;
		c.anchor = GridBagConstraints.SOUTH;
		c.insets = new Insets(120, -400, 100, 200);
		c.gridx = 200;
		c.gridwidth = 200;
		c.gridy = 200;
		
		c.insets = new Insets(0, 0, 0, 0);
		
		GridBagConstraints c1 = new GridBagConstraints();
		c1.weighty = 1.0;
		c1.anchor = GridBagConstraints.SOUTH;
	
		c1.gridx = 200;
		c1.gridwidth = 200;
		c1.gridy = 200;
		
		c1.insets = new Insets(50, 150, 0, 950);



		ImageIcon backbuttonImage=new ImageIcon("images//back2.png");
		backbutton=new CircularButton(backbuttonImage);

		
	
	
		panel = new JPanel(new GridBagLayout()) {

			protected void paintComponent(Graphics g) {
				g.drawImage(backgroundImage, 0, 0, null);
			}
		};
		panel.add(scoreArea,c);
		panel.add(backbutton,c1);
		
	    try {
	    	File file=new File("score.txt");
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line = reader.readLine();
	      
	        while (line != null)             
	        {
	        	   String[] array=line.split("\t");
	        	   
	        	   highScores.add(array[0]+"\t\t"+array[1]);
	            
	               line = reader.readLine();
	        
	     
	               
	        }
	        Collections.sort(highScores);
	        for( int s= highScores.size()-1; s >= 0; s--)
	        	scoreArea.append(highScores.get(s)+"\n");
	        
	        reader.close();

	    } catch (IOException ex) {
	        System.err.println("ERROR reading file");
	    }
		
		
		setSize(1080,600);
		add(panel);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		backbutton.addActionListener(new ButtonListener());
		
		
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==backbutton)
		{
			dispose();
			new Main();
		}
			
		}
		
	}
	

	}
	
	


