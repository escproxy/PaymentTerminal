package payment.terminal;

public class Intent
{
	public static final int ACTION_NOTHING = 0;
	public static final int ACTION_START = 1;
	public static final int ACTION_STOP = 2;
	public static final int ACTION_COMPLETE = 3;
	public static final int ACTION_ERROR = 4;
	
	private int mAction;
	private String mControllerClass;
	private Controller mController;
	
	public Intent()
	{
		mAction = ACTION_NOTHING;
	}
	
	/**
	 * Constructor
	 * 
	 * @param controller
	 */
	public Intent(String controller, int a)
	{
		this();
		setAction(a);
		
		mControllerClass = controller;
	}
	
	public Intent(Controller controller)
	{
		this();
	}

	/**
	 * Set the action of the intent
	 * 
	 * @param	a
	 */
	public void setAction(int a)
	{
		mAction = a;
	}
	
	public Integer getAction()
	{
		return mAction;
	}
	
	/**
	 * Get the controller
	 * 
	 * @throws NullPointerException
	 * @throws Exception
	 */
	public Controller getController() throws
		NullPointerException
	,	Exception
	{
		if(mController != null)
		{
			return mController;
		}
		else if(mControllerClass != null)
		{
			try
			{
				return (Controller)getClass()
					.getClassLoader()
					.loadClass(mControllerClass)
					.newInstance();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
		}
		
		throw new NullPointerException();
	}
}
