package payment.terminal.widget;

import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.border.EmptyBorder;

import payment.terminal.Resources;
import payment.terminal.util.NineSlice;

public class SearchField extends NineSliceTextField
{
	public static final String BACKGROUND = "search_background.png";
	
	public SearchField()
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
		
		setBorder(new EmptyBorder(10, 10, 10, 10) );
		
		setNineSlice(ns);
		
		//setSize(new Dimension(100, 100));
		
		Dimension d = getPreferredSize();
		d.height = 20;
		setPreferredSize(d); 
		
		//System.out.println("Height: " + getHeight());
	}
}
