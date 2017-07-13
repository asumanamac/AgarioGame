package Game;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HelpScreen extends JFrame{
	
	java.awt.Image backgroundImage,boardImage;
	ImageIcon backgroundIcon;
	JPanel panel;
	ImageIcon board;
	JLabel boardLabel;
	JTextArea text;
	CircularButton backbutton;
	
	
	public HelpScreen()
	{
		

		backgroundIcon = new ImageIcon("images//first3.png");
		backgroundImage = backgroundIcon.getImage();
		
		board=new ImageIcon("images/help.png");
		boardImage=board.getImage();
	
		
		ImageIcon backbuttonImage=new ImageIcon("images//back2.png");
		backbutton=new CircularButton(backbuttonImage);
		

		
		boardLabel=new JLabel(board);
		text=new JTextArea(5,5);
		text.setText("Oyunun amacý sabit toplarý yiyerek büyümek."+"\n"+"Siyah toplarý yediðinizde oyuncu küçülürken\n"
				+ " ve hýzý artarken,diðer renkteki toplarý yediðinizde ise büyür"+"\n" +"ve büyümesi baðlý olarak hýzý azalýr.\n"
				+ "Oyun klavye yön tuþlarý ile oynanýr");
		
		text.setBackground(new Color(171,195,247));
		text.setEditable(false);
		text.setFont(new Font("Comic", Font.BOLD, 20));
		
		panel=new JPanel(new BorderLayout());
		panel.setBackground(new Color(171,195,247));
		panel.add(boardLabel, BorderLayout.NORTH);
		panel.add(text,BorderLayout.CENTER);
		

		
	
		add(panel);	pack();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

}
