package payment.terminal.util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.HashMap;

import payment.terminal.holder.NineSliceComponent;

public class NineSlice
{
	/**
	 * The individual components of the nine-slice
	 */
	public static final int TOP_LEFT		= 1;
	public static final int TOP_CENTER		= 2;
	public static final int TOP_RIGHT		= 3;
	public static final int MIDDLE_LEFT		= 4;
	public static final int MIDDLE_CENTER	= 5;
	public static final int MIDDLE_RIGHT	= 6;
	public static final int BOTTOM_LEFT		= 7;
	public static final int BOTTOM_CENTER	= 8;
	public static final int BOTTOM_RIGHT	= 9;
	
	private BufferedImage mImage;
	private HashMap<Integer, NineSliceComponent> mComponents;
	
	/**
	 * Constructor
	 */
	public NineSlice()
	{
		mComponents = new HashMap<Integer, NineSliceComponent>();
	}
	
	/**
	 * Set the image component of the button
	 * 
	 * @access	
	 * @param i
	 */
	public void setImage(BufferedImage i)
	{
		mImage = i;
	}
	
	/**
	 * Get the buffered image
	 */
	public BufferedImage getImage()
	{
		return mImage;
	}

	/**
	 * Set the parameters for the top left component
	 * 
	 * @param	x
	 * @param	y
	 * @param	w
	 * @param	h
	 */
	public void setTopLeft(int x, int y, int w, int h)
	{
		mComponents.put(TOP_LEFT, new NineSliceComponent(x, y, w, h, false));
	}

	/**
	 * Set the parameters for the top left component
	 * 
	 * @param	x
	 * @param	y
	 * @param	w
	 * @param	h
	 * @param	r
	 */
	public void setTopCenter(int x, int y, int w, int h, Boolean r)
	{
		mComponents.put(TOP_CENTER, new NineSliceComponent(x, y, w, h, r));
	}

	/**
	 * Set the parameters for the top left component
	 * 
	 * @param	x
	 * @param	y
	 * @param	w
	 * @param	h
	 */
	public void setTopRight(int x, int y, int w, int h)
	{
		mComponents.put(TOP_RIGHT, new NineSliceComponent(x, y, w, h, false));
	}

	/**
	 * Set the parameters for the top left component
	 * 
	 * @param	x
	 * @param	y
	 * @param	w
	 * @param	h
	 * @param	r
	 */
	public void setMiddleLeft(int x, int y, int w, int h, Boolean r)
	{
		mComponents.put(MIDDLE_LEFT, new NineSliceComponent(x, y, w, h, r));
	}

	/**
	 * Set the parameters for the top left component
	 * 
	 * @param	x
	 * @param	y
	 * @param	w
	 * @param	h
	 * @param	r
	 */
	public void setMiddleCenter(int x, int y, int w, int h, Boolean r)
	{
		mComponents.put(MIDDLE_CENTER, new NineSliceComponent(x, y, w, h, r));
	}

	/**
	 * Set the parameters for the top left component
	 * 
	 * @param	x
	 * @param	y
	 * @param	w
	 * @param	h
	 * @param	r
	 */
	public void setMiddleRight(int x, int y, int w, int h, Boolean r)
	{
		mComponents.put(MIDDLE_RIGHT, new NineSliceComponent(x, y, w, h, r));
	}

	/**
	 * Set the parameters for the top left component
	 * 
	 * @param	x
	 * @param	y
	 * @param	w
	 * @param	h
	 */
	public void setBottomLeft(int x, int y, int w, int h)
	{
		mComponents.put(BOTTOM_LEFT, new NineSliceComponent(x, y, w, h, false));
	}

	/**
	 * Set the parameters for the top left component
	 * 
	 * @param	x
	 * @param	y
	 * @param	w
	 * @param	h
	 * @param	r
	 */
	public void setBottomCenter(int x, int y, int w, int h, Boolean r)
	{
		mComponents.put(BOTTOM_CENTER, new NineSliceComponent(x, y, w, h, r));
	}

	/**
	 * Set the parameters for the top left component
	 * 
	 * @param	x
	 * @param	y
	 * @param	w
	 * @param	h
	 */
	public void setBottomRight(int x, int y, int w, int h)
	{
		mComponents.put(BOTTOM_RIGHT, new NineSliceComponent(x, y, w, h, false));
	}
	
	/**
	 * Get the top let component
	 */
	public NineSliceComponent getTopLeft()
	{
		return mComponents.get(TOP_LEFT);
	}
	
	/**
	 * Get the top let component
	 */
	public NineSliceComponent getTopCenter()
	{
		return mComponents.get(TOP_CENTER);
	}
	
	/**
	 * Get the top let component
	 */
	public NineSliceComponent getTopRight()
	{
		return mComponents.get(TOP_RIGHT);
	}
	
	/**
	 * Get the top let component
	 */
	public NineSliceComponent getMiddleLeft()
	{
		return mComponents.get(MIDDLE_LEFT);
	}
	
	/**
	 * Get the top let component
	 */
	public NineSliceComponent getMiddleCenter()
	{
		return mComponents.get(MIDDLE_CENTER);
	}
	
	/**
	 * Get the top let component
	 */
	public NineSliceComponent getMiddleRight()
	{
		return mComponents.get(MIDDLE_RIGHT);
	}
	
	/**
	 * Get the top let component
	 */
	public NineSliceComponent getBottomLeft()
	{
		return mComponents.get(BOTTOM_LEFT);
	}
	
	/**
	 * Get the top let component
	 */
	public NineSliceComponent getBottomCenter()
	{
		return mComponents.get(BOTTOM_CENTER);
	}
	
	/**
	 * Get the top let component
	 */
	public NineSliceComponent getBottomRight()
	{
		return mComponents.get(BOTTOM_RIGHT);
	}
	
	/**
	 * Create a graphic based on the 9-slice, this is the true magic
	 * 
	 * @param	g
	 * @param	w
	 * @param	h
	 * @param	o
	 */
	public Graphics2D paint(Graphics g, int width, int height, ImageObserver observer)
	{
        Graphics2D g2d = (Graphics2D) g.create();
        
        g2d.setRenderingHint(
        	RenderingHints.KEY_ANTIALIASING
        ,	RenderingHints.VALUE_ANTIALIAS_ON
        );
        
        // Draw top left
        g2d.drawImage
        (
        	getImage().getSubimage
        	(
        		getTopLeft().getX()
        	,	getTopLeft().getY()
        	,	getTopLeft().getWidth()
        	,	getTopLeft().getHeight()
        	)
        ,	0
        ,	0
        ,	getTopLeft().getWidth()
        ,	getTopLeft().getHeight()
        ,	observer
        );

        // Draw top center
        if(getTopCenter().repeatable())
        {
        	for(int i = 0; i < width - getTopLeft().getWidth() - getTopRight().getWidth(); i += getTopCenter().getWidth())
        	{
        		 // Draw top right
    	        g2d.drawImage
    	        (
    	        	getImage().getSubimage
    	        	(
    	        		getTopCenter().getWidth()
    	        	,	getTopCenter().getWidth()
    	        	,	getTopCenter().getWidth()
    	        	,	getTopCenter().getHeight()
    	        	)
    	        ,	i
    	        ,	0
    	        ,	getTopCenter().getWidth()
    	        ,	getTopCenter().getHeight()
    	        ,	observer
    	        );
        	}
        }
        else
        {
        	g2d.drawImage
	        (
	        	getImage().getSubimage
	        	(
	        		getTopCenter().getX()
	        	,	getTopCenter().getY()
	        	,	getTopCenter().getWidth()
	        	,	getTopCenter().getHeight()
	        	)
	        ,	getTopLeft().getWidth()
	        ,	0
	        ,	width - getTopLeft().getWidth() - getTopRight().getWidth()
	        ,	getTopCenter().getHeight()
	        ,	observer
	        );
        }
        
        // Draw top right
        g2d.drawImage
        (
        	getImage().getSubimage
        	(
        		getTopRight().getX()
        	,	getTopRight().getY()
        	,	getTopRight().getWidth()
        	,	getTopRight().getHeight()
        	)
        ,	width - getTopRight().getWidth()
        ,	0
        ,	getTopRight().getWidth()
        ,	getTopRight().getHeight()
        ,	observer
        );
        
    	// Draw middle left
        if(getMiddleLeft().repeatable())
        {
        	for(int i = getTopLeft().getHeight(); i < height - getBottomLeft().getHeight(); i += getMiddleLeft().getHeight())
        	{
        		 // Draw top right
    	        g2d.drawImage
    	        (
    	        	getImage().getSubimage
    	        	(
    	        		getMiddleLeft().getX()
    	        	,	getMiddleLeft().getY()
    	        	,	getMiddleLeft().getWidth()
    	        	,	getMiddleLeft().getHeight()
    	        	)
    	        ,	0
    	        ,	i
    	        ,	getMiddleLeft().getWidth()
    	        ,	getMiddleLeft().getHeight()
    	        ,	observer
    	        );
        	}
        }
        else
        {
	        g2d.drawImage
	        (
	        	getImage().getSubimage
	        	(
	        		getMiddleLeft().getX()
	        	,	getMiddleLeft().getY()
	        	,	getMiddleLeft().getWidth()
	        	,	getMiddleLeft().getHeight()
	        	)
	        ,	0
	        ,	getTopLeft().getHeight()
	        ,	getMiddleLeft().getWidth()
	        ,	height - getTopLeft().getHeight() - getBottomLeft().getHeight()
	        ,	observer
	        );
        }
        
        // Draw middle center
        if(getMiddleCenter().repeatable())
        {
        	/*
        	for(int i = getTopLeft().getWidth(); i < width - getMiddleRight().getWidth(); i += getMiddleCenter().getWidth())
        	{
        		for(int j = getTopLeft().getHeight(); j < height - getBottomCenter().getHeight(); j += getMiddleCenter().getHeight())
        		{
        			g2d.drawImage
    		        (
    		        	getImage().getSubimage
    		        	(
    		        		getMiddleCenter().getX()
    		        	,	getMiddleCenter().getY()
    		        	,	getTopRight().getWidth()
    		        	,	getTopRight().getHeight()
    		        	)
    		        ,	getTopLeft().getWidth()
    		        ,	getTopLeft().getHeight()
    		        ,	i
    		        ,	j
    		        ,	observer
    		        );
        		}
        	}
        	*/
        	
        	// -1 because something important didn't align once and it's technically incorrect...
        	for(int i = getTopCenter().getHeight() - 1; i < height - getBottomCenter().getHeight(); i += getMiddleCenter().getHeight())
        	{
        		 // Draw top right
    	        g2d.drawImage
    	        (
    	        	getImage().getSubimage
    	        	(
    	        		getMiddleCenter().getX()
    			    ,	getMiddleCenter().getY()
    			    ,	getMiddleCenter().getWidth()
    			    ,	getMiddleCenter().getHeight()
    	        	)
    	        ,	getTopLeft().getWidth()
    	        ,	i
    	        ,	width - getTopLeft().getWidth() - getTopRight().getWidth()
    	        ,	getMiddleLeft().getHeight()
    	        ,	observer
    	        );
        	}
        }
        else
        {
        	g2d.drawImage
	        (
	        	getImage().getSubimage
	        	(
	        		getMiddleCenter().getX()
	        	,	getMiddleCenter().getY()
	        	,	getMiddleCenter().getWidth()
	        	,	getMiddleCenter().getHeight()
	        	)
	        ,	getTopLeft().getWidth()
	        ,	getTopLeft().getHeight()
	        ,	width - getMiddleLeft().getWidth() - getMiddleRight().getWidth()
	        ,	height - getTopCenter().getHeight() - getBottomCenter().getHeight()
	        ,	observer
	        );
        }
        
        // Draw middle right
        if(getMiddleRight().repeatable())
        {
        	for(int i = getTopRight().getHeight(); i < height - getBottomRight().getHeight(); i += getMiddleRight().getHeight())
        	{
        		g2d.drawImage
		        (
		        	getImage().getSubimage
		        	(
		        		getMiddleRight().getX()
		        	,	getMiddleRight().getY()
		        	,	getMiddleRight().getWidth()
		        	,	getMiddleRight().getHeight()
		        	)
		        ,	width - getMiddleRight().getWidth()
		        ,	i
		        ,	getMiddleRight().getWidth()
		        ,	getMiddleRight().getHeight()
		        ,	observer
		        );
        	}
        }
        else
        {
        	g2d.drawImage
	        (
	        	getImage().getSubimage
	        	(
	        		getMiddleRight().getX()
	        	,	getMiddleRight().getY()
	        	,	getMiddleRight().getWidth()
	        	,	getMiddleRight().getHeight()
	        	)
	        ,	width - getMiddleRight().getWidth()
	        ,	getTopRight().getHeight()
	        ,	getMiddleRight().getWidth()
	        ,	height - getTopRight().getHeight() - getBottomRight().getHeight()
	        ,	observer
	        );
        }
        
        // Draw bottom left
        g2d.drawImage
        (
        	getImage().getSubimage
        	(
        		getBottomLeft().getX()
        	,	getBottomLeft().getY()
        	,	getBottomLeft().getWidth()
        	,	getBottomLeft().getHeight()
        	)
        ,	0
        ,	height - getBottomLeft().getHeight()
        ,	getBottomLeft().getWidth()
        ,	getBottomLeft().getHeight()
        ,	observer
        );
        
        // Draw bottom center
        if(getBottomCenter().repeatable())
        {
        	for(int i = getBottomLeft().getWidth(); i < width - getBottomRight().getWidth(); i += getBottomCenter().getWidth())
        	{
        		g2d.drawImage
     	        (
     	        	getImage().getSubimage
     	        	(
     	        		getBottomCenter().getX()
     	        	,	getBottomCenter().getY()
     	        	,	getBottomCenter().getWidth()
     	        	,	getBottomCenter().getHeight()
     	        	)
     	        ,	i
     	        ,	height - getBottomCenter().getHeight()
     	        ,	getBottomCenter().getWidth()
     	        ,	getBottomCenter().getHeight()
     	        ,	observer
     	        );
        	}
        }
        else
        {
        	g2d.drawImage
 	        (
 	        	getImage().getSubimage
 	        	(
 	        		getBottomCenter().getX()
 	        	,	getBottomCenter().getY()
 	        	,	getBottomCenter().getWidth()
 	        	,	getBottomCenter().getHeight()
 	        	)
 	        ,	getBottomLeft().getWidth()
 	        ,	height - getBottomCenter().getHeight()
 	        ,	width - getBottomLeft().getWidth() - getBottomRight().getWidth()
 	        ,	getBottomCenter().getHeight()
 	        ,	observer
 	        );
        }
        
        // Draw bottom right
        g2d.drawImage
        (
        	getImage().getSubimage
        	(
        		getBottomRight().getX()
        	,	getBottomRight().getY()
        	,	getBottomRight().getWidth()
        	,	getBottomRight().getHeight()
        	)
        ,	width - getBottomRight().getWidth()
        ,	height - getBottomRight().getHeight()
        ,	getBottomRight().getWidth()
        ,	getBottomRight().getHeight()
        ,	observer
        );
		
		return g2d;
	}
}