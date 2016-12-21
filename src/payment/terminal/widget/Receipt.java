package payment.terminal.widget;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JPanel;

import payment.terminal.Resources;

public class Receipt extends JPanel
{
	public static final String BACKGROUND_IMAGE = "receipt_background.png";
	
	public Receipt()
	{
	}
	
	/**
	 * paint component
	 */
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g.create();
		
		try
		{
			g2d.drawImage(Resources.getBufferedImage(BACKGROUND_IMAGE), 0, 0, this);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		g2d.dispose();
	}
}