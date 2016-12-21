package payment.terminal.widget;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import payment.terminal.Resources;
import payment.terminal.util.NineSlice;

public class PlainButton extends NineSliceButton implements MouseListener
{
	public static String IMAGE_IDLE = "button_plain.png";
	public static String IMAGE_PRESSED = "button_plain_pressed.png";
	
	private NineSlice mNineSlice;
	
	/**
	 * Constructor
	 */
	public PlainButton()
	{
		setPadding(0, 10, 20, 10);
		setPressDisplacement(2);

		mNineSlice = new NineSlice();
		
		updateNineSlice();
	}
	
	/**
	 * Update the nine slice object
	 */
	protected void updateNineSlice()
	{
		try
		{
			mNineSlice.setImage(Resources.getBufferedImage(getIdleBackground() == null ? IMAGE_IDLE : getIdleBackground()));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		mNineSlice.setTopLeft(0, 0, 7, 11);
		mNineSlice.setTopCenter(7, 0, 31, 11, false);
		mNineSlice.setTopRight(38, 0, 7, 11);

		mNineSlice.setMiddleLeft(0, 11, 7, 25, false);
		mNineSlice.setMiddleCenter(7, 11, 31, 25, false);
		mNineSlice.setMiddleRight(38, 11, 7, 25, false);

		mNineSlice.setBottomLeft(0, 37, 7, 9);
		mNineSlice.setBottomCenter(7, 37, 31, 9, false);
		mNineSlice.setBottomRight(38, 37, 7, 9);
		
		setNineSlice(mNineSlice);

		init(getText(), null);
		
		addMouseListener(this);
	}
	
	/**
	 * On press
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{
		super.mousePressed(e);
		
		try
		{
			mNineSlice.setImage(Resources.getBufferedImage(getPressedBackground() == null ? IMAGE_PRESSED : getPressedBackground()));
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
		super.mouseReleased(e);
	
		try
		{
			mNineSlice.setImage(Resources.getBufferedImage(getIdleBackground() == null ? IMAGE_IDLE : getIdleBackground()));
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
}