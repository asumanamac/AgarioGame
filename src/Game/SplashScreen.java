package Game;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SplashScreen extends JFrame{
	
	public SplashScreen()
	{
		setContentPane(new JLabel(new ImageIcon("images//background.png")));
		pack();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		try {
			Thread.sleep(1000);
			
			
			setVisible(false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dispose();
		
		new Launcher();
	}

}
