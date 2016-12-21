package payment.terminal.controllers;

import payment.terminal.Controller;

public class Overview extends Controller
{
	public static final String LAYOUT = "layouts/overview.xml";
	
	/**
	 * Constructor
	 */
	public Overview()
	{
		super();
		
		setLayoutView(LAYOUT);
	}
}
