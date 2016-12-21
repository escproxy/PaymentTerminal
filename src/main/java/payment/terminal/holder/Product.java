package payment.terminal.holder;

import java.text.NumberFormat;
import java.util.Locale;

public class Product
{
	private int mProductId;
	private Integer mPrice;
	private int mCategoryId;
	private String mName;
	private int mQuantity;
	
	/**
	 * Constructor
	 * 
	 * @param	name
	 */
	public Product(String name)
	{
		this(-1, 0, -1, name);
	}
	
	/**
	 * Constructor
	 * 
	 * @param id
	 * @param price
	 * @param categoryId
	 * @param name
	 */
	public Product(int id, Integer price, int categoryId, String name)
	{
		mProductId = id;
		mPrice = price;
		mCategoryId = categoryId;
		mName = name;
		mQuantity = 1;
	}
	
	/**
	 * Get the product id
	 */
	public int getProductId()
	{
		return mProductId;
	}
	
	/**
	 * Get the product name
	 */
	public String getName()
	{
		return mName;
	}
	
	/**
	 * Get the price
	 */
	public int getPrice()
	{
		return mPrice;
	}
	
	/**
	 * Get the price
	 */
	public void setPrice(Integer p)
	{
		mPrice = p;
	}
	
	/**
	 * Get the price, nicely formatted
	 */
	public String getPriceFormatted()
	{
		// TODO:
		// Locali[sz]ation
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.UK);
		return formatter.format(mPrice / 100.0);
	}
	
	/**
	 * Set the quantity
	 */
	public void setQuantity(int q)
	{
		mQuantity = q;
	}
	
	/**
	 * get the quantity
	 */
	public int getQuantity()
	{
		return mQuantity;
	}
	
	/**
	 * Increment quantity by 1
	 */
	public void increaseQuantity()
	{
		mQuantity++;
	}
	
	/**
	 * Decrement quantity by 1
	 */
	public void decreaseQuantity()
	{
		mQuantity--;
	}
}