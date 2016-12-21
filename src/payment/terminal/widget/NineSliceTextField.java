package payment.terminal.widget;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.font.TextLayout;

import javax.swing.JTextField;

import payment.terminal.util.NineSlice;

public class NineSliceTextField extends JTextField
{
	private NineSlice mNineSlice;

	/**
	 * Constructor
	 */
	public NineSliceTextField()
	{
		setBorder(null);
		setOpaque(false);
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
	 * Paint the component
	 */
	@Override
	protected void paintComponent(Graphics g)
	{
        super.paintComponent(g);
        
		if(mNineSlice != null)
		{
	        Graphics2D g2d = mNineSlice.paint(g, getWidth(), getHeight(), this);
	        
	        // Position the text accordingly
		    if(getText().length() > 0)
		    {
			    TextLayout text = new TextLayout(getText(), getFont(), g2d.getFontRenderContext());
			    g2d.drawString(getText(), 0, (int)((getHeight() + text.getBounds().getHeight()) / 2));   
		    }
	        
		    g2d.dispose();
		}
	}
}
