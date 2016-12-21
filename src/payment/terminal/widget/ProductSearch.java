package payment.terminal.widget;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.JScrollPane;

import payment.terminal.holder.Product;
import payment.terminal.models.ProductsModel;
import payment.terminal.renderer.ProductRenderer;

public class ProductSearch extends Panel
{
	public static final String LAYOUT = "components/productsearch.xml";
	
	private JScrollPane mScroll;
	private JList<Product> mProducts;
	private Terminal mTerminal;
	
	public ProductSearch()
	{
		// 1. Register tags
		registerTag("background", ResultsBackgroundPanel.class);
		
		// 2. Set the layout
		setLayoutView(LAYOUT);
		
		mProducts.setModel(new ProductsModel());
		mProducts.setCellRenderer(new ProductRenderer());
	}
	
	public void setTerminalHandle(Terminal terminal)
	{
		mTerminal = terminal;
		
		mProducts.addMouseListener(new MouseListener()
		{
			@Override
			public void mousePressed(MouseEvent e)
			{
			//	mTerminal.clearContext();
				mTerminal.addProduct(((ProductsModel)mProducts.getModel()).elementAt(mProducts.getSelectedIndex()));
			}
			
			/**
			 * Unimplemented methods 
			 */
			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
	}
	
	/**
	 * Clear the selection/context
	 */
	public void clearContext()
	{
		mProducts.clearSelection();
	}
}
