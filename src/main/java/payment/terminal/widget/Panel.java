package payment.terminal.widget;

import javax.swing.JPanel;

import org.swixml.SwingEngine;

import payment.terminal.Resources;

public class Panel extends JPanel
{
	private SwingEngine mEngine = new SwingEngine(this);
	
	public void setLayoutView(String res)
	{
		try
		{
			mEngine.insert(Resources.getXMLStream(res), this);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Register a specific tag
	 */
	public void registerTag(String arg0, Class arg1)
	{
		mEngine.getTaglib().registerTag(arg0, arg1);
	}
}
