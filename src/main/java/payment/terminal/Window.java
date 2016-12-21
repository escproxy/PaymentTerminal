package payment.terminal;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Window
{
	private static final String TITLE = "SCC 110 Shop";
	private static final Dimension MINIMUM_DIMENSION = new Dimension(1126, 650);
	
	private JFrame mFrame;
	private JPanel mPanel;
	
	private ArrayList<Controller> mControllers;
	private ArrayList<Controller> mHistory;
	
	/**
	 * Organises the window so as to allow for
	 * different controllers
	 */
	public Window()
	{
		mFrame = new JFrame();
		mFrame.setMinimumSize(MINIMUM_DIMENSION);
		
		mFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mPanel = new JPanel();
		mPanel.setLayout(new CardLayout());

		mControllers = new ArrayList<Controller>();
		mHistory = new ArrayList<Controller>();
		
		finalise();
	}
	
	/**
	 * Switches to a specific controller
	 * 
	 * @param panel
	 */
	public void switchToController(Controller controller)
	{
		CardLayout layout = (CardLayout)mPanel.getLayout();
		
		if(!containsController(controller))
		{
			registerController(controller);
		}
		
		if(!mHistory.contains(controller))
		{
			controller.onStart();
		}
		
		controller.onResume();
		layout.show(mPanel, controller.getName());
		
		try
		{
			controller.onLayout();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		controller.onVisualise();
		mHistory.add(controller);
		
		for(Controller c : mControllers)
		{
			if(!c.getName().equals(c.getName()))
			{
				c.onPause();
			}
		}
	}
	
	/**
	 * Registers a controller
	 * 
	 * @param	c
	 */
	public void registerController(Controller controller)
	{
		controller.setParentPanel(mPanel);
		controller.onCreate();
		mControllers.add(controller);
		controller.onAttach();
	}
	
	/**
	 * Unregisters a controller
	 * 
	 * TODO:
	 * 	- Remove from container
	 * 
	 * @param	panel
	 */
	public void unRegisterController(Controller controller)
	{
		mControllers.remove(controller);
		controller.onStop();
		controller.onDestroy();
		controller.onDetach();
	}
	
	/**
	 * Checks whether the panel already exists in the window container
	 * 
	 * @param	panel
	 * @return	Boolean result of query
	 */
	private Boolean containsController(Controller controller)
	{
		for(Controller c : mControllers)
		{
			if(c.getName().equals(controller.getName()))
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 */
	public void finalise()
	{
        mFrame.setContentPane(mPanel);
        mFrame.pack();   
		mFrame.setVisible(true);
		mFrame.setResizable(true);
		mFrame.setTitle(TITLE);
	}
}