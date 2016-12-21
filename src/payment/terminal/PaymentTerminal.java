package payment.terminal;

class PaymentTerminal
{
	/**
	 * The almighty main
	 * 
	 * @param	args
	 */
	public static void main(String[] args)
	{
		// Bootstrap is application initialiser
		new Bootstrap()
			.init()
			.configure()
			.decide()
			.execute();
	}
}