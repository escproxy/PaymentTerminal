package payment.terminal.widget;


public class Printer extends Panel
{
	public static final String LAYOUT = "components/printer.xml";
	
	private PlainButton mPrint;
	private Receipt mReceipt;
	
	public Printer()
	{
		// 1. Register tags
		registerTag("plainbutton", PlainButton.class);
		registerTag("receipt", Receipt.class);
		
		// 2. Set the layout
		setLayoutView(LAYOUT);
		
		// 3. The rest
	}
}
