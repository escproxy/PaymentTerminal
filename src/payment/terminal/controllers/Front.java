package payment.terminal.controllers;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import payment.terminal.Controller;
import payment.terminal.helpers.Basket;
import payment.terminal.helpers.Stock;
import payment.terminal.widget.Controls;
import payment.terminal.widget.Header;
import payment.terminal.widget.Printer;
import payment.terminal.widget.ProductSearch;
import payment.terminal.widget.Terminal;

public class Front extends Controller
{
	public static final String LAYOUT = "layouts/front.xml";

	private Stock mStock;
	private Basket mBasket;

	private Header mHeader;
	private Controls mControls;
	private ProductSearch mProductSearch;
	private Printer mPrinter;
	private Terminal mTerminal;
	private JPanel mWrapper;
	
	
	/**
	 * Constructor
	 */
	public Front()
	{
		super();
		
		setLayoutView(LAYOUT);
		
		mStock = new Stock();
		mBasket = new Basket();
	}

	/**
	 * On Attach method
	 * 
	 * Called when the panel is registered
	 */
	@Override
	public void onAttach()
	{
		registerTag("header", Header.class);
		registerTag("controls", Controls.class);
		registerTag("terminal", Terminal.class);
		registerTag("productsearch", ProductSearch.class);
		registerTag("printer", Printer.class);
	}
	
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
		mWrapper.setBorder(new EmptyBorder(30, 30, 30, 30));
		
		// I am so lazy
		mControls.setHandles(mTerminal, mProductSearch, mBasket);
		mProductSearch.setTerminalHandle(mTerminal);
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
