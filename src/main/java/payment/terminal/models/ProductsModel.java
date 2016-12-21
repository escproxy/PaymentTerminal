package payment.terminal.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;

import payment.terminal.database.Database;
import payment.terminal.holder.Product;

public class ProductsModel extends DefaultListModel<Product>
{
	public ProductsModel()
	{
		ResultSet product;
		
		try
		{
			product = Database.executeQuery("SELECT * FROM `products`;");
			
			while(product.next())
			{
				addElement(new Product(product.getInt("product_id"), product.getInt("price"), product.getInt("category_id"), product.getString("name")));
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
