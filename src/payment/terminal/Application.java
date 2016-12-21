package payment.terminal;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

/**
 * This class is used to load and organise the MVC data flow
 * loading necessary classes for application runtime, and varied
 * application input. 
 *
 * This also handles paths
*/
public class Application
{
	private static Window mWindow;
	private static ArrayList<Intent> mIntents;
	private Intent mCurrentIntent;
	
	/**
	 * Register controllers in the application
	 */
	public Application()
	{
		mWindow = new Window();
		mIntents = new ArrayList<>();
	}
	
	/**
	 * GO!
	 */
	public void go()
	{
		SwingUtilities.invokeLater
		(
			new Runnable()
	        {
				@Override
	            public void run()
	            {
	            	update();
	            }
	        }
		);
	}
	
	/**
	 * The all important method to act according to the application intent
	 */
	public static void update()
	{
		for(Intent intent : mIntents)
		{
			// Is the intent to start?
			if(intent.getAction().equals(Intent.ACTION_START))
			{
				try
				{
					mWindow.switchToController(intent.getController());
				}
				catch (Exception e)
				{
					e.printStackTrace();
					intent.setAction(Intent.ACTION_ERROR);
					
					continue;
				}
				
				intent.setAction(Intent.ACTION_COMPLETE);
			}

			mWindow.finalise();
		}
	}
	
	/**
	 * Start an intent
	 * 
	 * @param intent
	 */
	public static void startIntent(Intent intent)
	{
		mIntents.add(intent);
		update();
	}
}