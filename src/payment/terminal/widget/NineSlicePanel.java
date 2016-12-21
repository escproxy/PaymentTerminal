package payment.terminal.widget;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import payment.terminal.util.NineSlice;

public class NineSlicePanel extends JPanel
{
	private NineSlice mNineSlice;

	/**
	 * Constructor
	 */
	public NineSlicePanel()
	{
		setBorder(null);
		setOpaque(false);
		setBackground(null);
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
		    g2d.dispose();
		}
	}
}
