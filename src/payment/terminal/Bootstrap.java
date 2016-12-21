package payment.terminal;

import java.io.FileNotFoundException;
import java.io.IOException;

import payment.terminal.database.Database;

/**
 * Bootstrap
 * 
 * This bootstrap class sequences the application
 * start up process, organising respective code to handle
 * different processes of this 'start up' process uniformly.
 * 
 * 
 * @author	Alexander Jung
 */
public class Bootstrap
{
	private static Application app;
	private String mController;
	
	/**
	 * Constructor
	 */
	public Bootstrap() {}
	
	/**
	 * Initialise
	 * 
	 * @return	This instance
	 */
	public Bootstrap init()
	{
		app = new Application();

		// Set the resources
		//app.setResources(new Resources());
		
		Resources resources = new Resources();
		resources.setClass(getClass());
		
		// TODO:
		// What platform are we using?
		
		return this;
	}
	
	/**
	 * Configure
	 * 
	 * Load generic modules and classes
	 * 
	 * @return	This instance
	 */
	public Bootstrap configure()
	{
		return this;
	}
	
	/**
	 * Decide the mode of the application on start up
	 * 
	 * Can decide from:
	 * 
	 * - Set up
	 * - Login
	 * - Update
	 * - (More)
	 * 
	 * @return	This instance
	 */
	public Bootstrap decide()
	{
		mController = "Front";
		
		try
		{
			Database db = new Database(Resources.getFile("database.db"));
			db.init();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
			
			mController = "Error";
			
			// TODO:
			// Attempt to replace from backup?
		}
		catch (IOException e)
		{
			e.printStackTrace();
			
			mController = "Error";
			
			// TODO:
			// a). Attempt to repair file, or
			// b). Attempt to replace from backup?
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
			mController = "Error";
		}
		
		return this;
	}
	
	/**
	 * Execute the decided application mode
	 * 
	 * @return	void
	 */
	public void execute()
	{	
		Intent intent = new Intent(mController, Intent.ACTION_START);
		app.startIntent(intent);
		
		// ...Go!
		app.go();
	}
}
