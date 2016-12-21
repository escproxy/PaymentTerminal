package payment.terminal.widget;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import payment.terminal.Resources;
import payment.terminal.util.NineSlice;

public class SimpleButton extends NineSliceButton
{
	public static final String IMAGE_IDLE = "button_simple.png";
	public static final String IMAGE_PRESSED = "button_simple_pressed.png";
	
	/**
	 * Constructor
	 */
	public SimpleButton()
	{
		setPadding(7, 10, 9, 10);
		setPressDisplacement(1);
		
		final NineSlice ns = new NineSlice();
		
		try
		{
			ns.setImage(Resources.getBufferedImage(IMAGE_IDLE));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		ns.setTopLeft(0, 0, 5, 5);
		ns.setTopCenter(5, 0, 2, 5, false);
		ns.setTopRight(7, 0, 5, 5);

		ns.setMiddleLeft(0, 5, 5, 2, false);
		ns.setMiddleCenter(5, 5, 2, 2, false);
		ns.setMiddleRight(7, 5, 5, 2, false);

		ns.setBottomLeft(0, 7, 5, 5);
		ns.setBottomCenter(5, 7, 2, 5, false);
		ns.setBottomRight(7, 7, 5, 5);
		
		setNineSlice(ns);
		
		addMouseListener(new MouseListener()
		{
			/**
			 * On press
			 */
			@Override
			public void mousePressed(MouseEvent e)
			{
				try
				{
					ns.setImage(Resources.getBufferedImage(IMAGE_PRESSED));
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				
				repaint();
			}
			
			/**
			 * On release
			 */
			@Override
			public void mouseReleased(MouseEvent e)
			{
				try
				{
					ns.setImage(Resources.getBufferedImage(IMAGE_IDLE));
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
				
				repaint();
			}
			

			/**
			 * Unimplemented methods
			 */
			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
	}
}