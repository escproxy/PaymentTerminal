package payment.terminal;

import java.awt.Container;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JPanel;

import org.swixml.SwingEngine;

import payment.terminal.exceptions.CouldNotRenderLayoutException;
import payment.terminal.exceptions.LayoutNotFoundException;
import payment.terminal.util.Lifecycle;

public class Controller extends JPanel implements Lifecycle
{
	private JPanel mParent;
	private SwingEngine mEngine;
	private Controller mController;
	private InputStream mLayout;
	private Container mContainer;
	
	/**
	 * Constructor
	 */
	public Controller()
	{
		mEngine = new SwingEngine(this);
		setName(getClass().getSimpleName());
		setLayout(null);
	}

	/**
	 * Attach the layout
	 */
	public void onLayout() throws
            LayoutNotFoundException
	, CouldNotRenderLayoutException
	,	IOException
	{
		try
		{
			if(mLayout.available() == 0)
			{
				throw new LayoutNotFoundException();
			}
		}
		catch (IOException e)
		{
			throw e;
		}

		try
		{
			mContainer = mEngine.render(mLayout);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new CouldNotRenderLayoutException();
		}
		
		mParent.add(mContainer);
	}
	
	/**
	 * Set the parent panel
	 * 
	 * @param panel
	 */
	protected void setParentPanel(JPanel p)
	{
		mParent = p;
	}
	
	/**
	 * Set the layout file
	 * 
	 * @param	l	File path
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	protected void setLayoutView(String l)
	{
		try
		{
			mLayout = Resources.getXMLStream(l);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Access the engine
	 * 
	 * @return
	 */
	protected SwingEngine getEngine()
	{
		return mEngine;
	}
	
	/**
	 * Access the layout container
	 * 
	 * @return
	 */
	protected Container getContainer()
	{
		return mContainer;
	}
	
	/**
	 * Set the parent of this panel
	 * 
	 * @param	parent
	 */
	public void setParent(JPanel parent)
	{
		mParent = parent;
	}
	
	/**
	 * Get the panel parent
	 */
	public JPanel getParent()
	{
		return mParent;
	}
	
	/**
	 * Register a specific tag
	 */
	public void registerTag(String arg0, Class arg1)
	{
		mEngine.getTaglib().registerTag(arg0, arg1);
	}

	/**
	 * On Attach method
	 * 
	 * Called when the panel is registered
	 */
	@Override
	public void onAttach() {}
	
	/**
	 * On Create method
	 * 
	 * Called when the panel is initialised
	 */
	@Override
	public void onCreate() {}
	
	/**
	 * On Start method
	 * 
	 * Called when the panel is shown for the first time
	 */
	@Override
	public void onStart() {}
	
	/**
	 * On Resume method
	 * 
	 * Called when the panel continues visible display
	 */
	@Override
	public void onResume() {}
	
	/**
	 * On Visualise method
	 * 
	 * Called when the panel just has become visible
	 */
	@Override
	public void onVisualise()
	{
		mContainer.setVisible(true);
	}
	
	/**
	 * On Pause method
	 * 
	 * Called when the panel is no longer visible or away
	 */
	@Override
	public void onPause() {}
	
	/**
	 * On Stop method
	 * 
	 * Called when the panel is removed from the window or cancelled
	 */
	@Override
	public void onStop() {}
	
	/**
	 * On Destroy method
	 * 
	 * Called when the panel is removed all together
	 */
	@Override
	public void onDestroy() {}
	
	/**
	 * On Detach method
	 * 
	 * Called when the panel is unregistered
	 */
	@Override
	public void onDetach() {}
}