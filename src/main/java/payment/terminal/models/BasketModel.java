package payment.terminal.models;

import javax.swing.DefaultListModel;

import payment.terminal.holder.Product;

public class BasketModel extends DefaultListModel<Product>
{
	public BasketModel() {}
	
	/**
	 * Calculate the basket total
	 * 
	 * @return	total
	 */
	public int calculateTotal()
	{
		int total = 0;
		
		for(int i = 0; i < getSize(); i++)
		{
			Product p = getElementAt(i);
			total += p.getPrice() * p.getQuantity();
		}
		
		return total;
	}
}