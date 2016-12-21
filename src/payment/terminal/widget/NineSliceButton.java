package payment.terminal.widget;

import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import payment.terminal.util.NineSlice;

public class NineSliceButton extends JButton implements MouseListener
{
	private NineSlice mNineSlice;
	private int mPaddingTop = 0;
	private int mPaddingLeft = 0;
	private int mPaddingBottom = 0;
	private int mPaddingRight = 0;
	private int mPressDisplacement = 0;
	private Boolean mPressed = false;
	private Image mIcon;
	private String mIdleBackground;
	private String mPressedBackground;

	/**
	 * Constructor
	 */
	public NineSliceButton()
	{
		setBorder(null);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		addMouseListener(this);
	}
	
	/**
	 * Set the icon
	 * 
	 * @param icon
	 */
	public void setIcon(ImageIcon icon)
	{
		mIcon = icon.getImage();
		super.setIcon(icon);
	}
	
	/**
	 * Set the background image
	 */
	protected void setIdleBackground(String image)
	{
		mIdleBackground = image;
	}
	
	/**
	 * Get the idle background
	 * 
	 * @return
	 */
	protected String getIdleBackground()
	{
		return mIdleBackground;
	}
	
	/**
	 * Set the pressed background
	 */
	protected void setPressedBackground(String image)
	{
		mPressedBackground = image;
	}
	
	/**
	 * Get the pressed background
	 */
	protected String getPressedBackground()
	{
		return mPressedBackground;
	}
	
	/**
	 * Set the nine slice parameter
	 * 
	 * @param	ns
	 */
	protected void setNineSlice(NineSlice ns)
	{
		mNineSlice = ns;
	}
	
	/**
	 * Set the push displacement
	 */
	protected void setPressDisplacement(int d)
	{
		mPressDisplacement = d;
	}
	
	/**
	 * Set the button padding
	 */
	protected void setPadding(int top, int left, int bottom, int right)
	{
		mPaddingTop = top;
		mPaddingLeft = left;
		mPaddingBottom = bottom;
		mPaddingRight = right;
		setText(getText());
	}
	
	/**
	 * Set the button bottom padding
	 */
	protected void setPaddingBottom(int bottom)
	{
		mPaddingBottom = bottom;
	}

	/**
	 * The magic behind 9 slice
	 */
	@Override
	protected void paintComponent(Graphics g)
	{
        super.paintComponent(g);
        
		if(mNineSlice != null)
		{
			Graphics2D g2d = mNineSlice.paint(g, getWidth(), getHeight(), this);

			// TODO:
			// Instead of automatically center, align
			
	        // Position the text accordingly
		    if(getText().length() > 0)
		    {
			    TextLayout text = new TextLayout(getText(), getFont(), g2d.getFontRenderContext());
			    g2d.drawString(getText(), (int)((getWidth() - text.getBounds().getWidth()) / 2), (int)(((getHeight() + text.getBounds().getHeight()) / 2) + (mPressed ? mPressDisplacement : 0)));   
		    }
		    
		    if(mIcon != null)
		    {
		    	g2d.drawImage
		    	(
		    		mIcon
		    	,	(getWidth() - getIcon().getIconWidth()) / 2
		    	,	((getHeight() - getIcon().getIconHeight()) / 2) + (mPressed ? mPressDisplacement : 0)
		    	,	getIcon().getIconWidth()
		    	,	getIcon().getIconHeight()
		    	,	this);
		    }
	        
		    g2d.dispose();
		}
	}
	
	/**
	 * Set the text
	 */
	@Override
	public void setText(String t)
	{
	    super.setText(t);
	    FontMetrics m = getFontMetrics(getFont()); 
	    setPreferredSize(new Dimension(m.stringWidth(getText()) + mPaddingLeft + mPaddingRight, m.getHeight() + mPaddingTop + mPaddingBottom));
	    setBounds(new Rectangle(getLocation(), getPreferredSize()));
	}
	
	/**
	 * On press
	 */
	@Override
	public void mousePressed(MouseEvent e)
	{
		mPressed = true;
		repaint();
	}
	
	/**
	 * On release
	 */
	@Override
	public void mouseReleased(MouseEvent e)
	{
		mPressed = false;
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
