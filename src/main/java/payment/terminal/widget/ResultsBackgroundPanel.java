package payment.terminal.widget;

import java.io.FileNotFoundException;
import java.io.IOException;

import payment.terminal.Resources;
import payment.terminal.util.NineSlice;

public class ResultsBackgroundPanel extends NineSlicePanel
{
	public static final String BACKGROUND = "results_background.png";
	
	public ResultsBackgroundPanel()
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
	}
}