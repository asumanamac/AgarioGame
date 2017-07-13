package Game;

import java.awt.*;

import javax.swing.*;


public class CircularButton extends JButton{
	

	public CircularButton() {
		super();
	
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusable(false);
		setPreferredSize(new Dimension(68, 65));
		setRolloverEnabled(true);
		setForeground(Color.BLACK);

	}

	public CircularButton(ImageIcon icon1) {
		super();
		
		setIcon(icon1);
		setContentAreaFilled(false);
		setBorderPainted(false);
		setFocusable(false);
		setPreferredSize(new Dimension(68, 65));
		setRolloverEnabled(true);
		
	}

	
	public void paintComponent(Graphics g) {
		int size = Math.min(getWidth(), getHeight()) - 4;
		int totalSize = size + 4;
		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		
		super.paintComponent(graphics);

	}

	
}


