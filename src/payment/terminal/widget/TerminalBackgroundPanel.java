package payment.terminal.widget;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.border.EmptyBorder;

import payment.terminal.Resources;
import payment.terminal.util.NineSlice;

public class TerminalBackgroundPanel extends NineSlicePanel
{
	public static final String BACKGROUND = "terminal_background.png";
	
	public TerminalBackgroundPanel()
	{
		final NineSlice ns = new NineSlice();
		
		try
		{
			ns.setImage(Resources.getBufferedImage(BACKGROUND));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		// x, y, w, h
		
		ns.setTopLeft(0, 0, 5, 6);
		ns.setTopCenter(5, 0, 5, 5, false);
		ns.setTopRight(10, 0, 5, 6);

		ns.setMiddleLeft(0, 6, 5, 2, true);
		ns.setMiddleCenter(5, 6, 5, 2, true);
		ns.setMiddleRight(10, 6, 5, 2, true);

		ns.setBottomLeft(0, 10, 5, 5);
		ns.setBottomCenter(5, 10, 5, 5, false);
		ns.setBottomRight(10, 10, 5, 5);
		
		setBorder(new EmptyBorder(10, 10, 10, 10) );
		
		setNineSlice(ns);
	}
}
