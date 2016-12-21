package payment.terminal.helpers;

import java.sql.SQLException;

import javax.swing.JList;

import payment.terminal.database.Database;
import payment.terminal.models.BasketModel;

public class Basket
{
	public Basket() {}
	
	/**
	 * Save the basket
	 * 3
	 * @param basket
	 */
	public void saveBasket(JList basket)
	{
		String insert = "INSERT INTO `purchases` (`cashier_id`, `total`) VALUES (1, " + ((BasketModel)basket.getModel()).calculateTotal() + ")";
		
		try
		{
			Database.executeStatement(insert);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}
