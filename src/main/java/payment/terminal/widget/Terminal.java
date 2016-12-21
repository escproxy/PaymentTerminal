package payment.terminal.widget;

import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import payment.terminal.holder.Product;
import payment.terminal.models.BasketModel;
import payment.terminal.renderer.TerminalCellRenderer;
import payment.terminal.util.NineSlice;

public class Terminal extends Panel
{
	public static final String LAYOUT = "components/terminal.xml";
	public static final Color HIGHLIGHT_COLOR = Color.decode("#D3D739");
	public static final Color BACKGROUND_COLOR = Color.decode("#555D65");
	public static final Font FONT = new Font("Courier New", Font.BOLD, 12);
	
	private NineSlice mNineSlice;
	private TerminalBackgroundPanel mBackground;
	private JScrollPane mScroll;
	private JList mBasket;
	
	private JPanel mTotalContainer;
	private JLabel mTotalLabel;
	private JLabel mTotalSum;
	
	private int mItemContext;
	
	public Terminal()
	{
		// 1. Register tags
		registerTag("background", TerminalBackgroundPanel.class);
		
		// 2. Set the layout
		setLayoutView(LAYOUT);

		mScroll.setOpaque(false);
		mScroll.setBorder(null);
		mScroll.setBackground(null);
		mBasket.setOpaque(false);
		mBasket.setBorder(null);
		mBasket.setBackground(null);
		
		mScroll.getViewport().setOpaque(false);
		
		mBasket.setModel(new BasketModel());
		mBasket.setCellRenderer(new TerminalCellRenderer());
		
		// Hide them scrollbars for terminal effects
		mScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		mScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		mScroll.setBorder(new MatteBorder(0, 0, 2, 0, Terminal.HIGHLIGHT_COLOR));
		
		mTotalContainer.setBorder(new EmptyBorder(4, 10, 4, 10));
		
		mTotalLabel.setFont(Terminal.FONT);
		mTotalLabel.setForeground(Terminal.HIGHLIGHT_COLOR);
		
		mTotalSum.setFont(Terminal.FONT);
		mTotalSum.setForeground(Terminal.HIGHLIGHT_COLOR);
		
		updateSum();
	}
	
	/**
	 * Add a product
	 * 
	 * @param	p
	 */
	public void addProduct(Product p)
	{
		if(p.getProductId() == -1)
		{
			((BasketModel)mBasket.getModel()).addElement(p);
			setContext(mBasket.getModel().getSize() - 1);
		}
		else
		{
			Boolean found = false;
			for(int i = 0; i < ((BasketModel)mBasket.getModel()).getSize(); i++)
			{
				if(((BasketModel)mBasket.getModel()).getElementAt(i).getProductId() == p.getProductId())
				{
					found = true;
					
					p = ((BasketModel)mBasket.getModel()).getElementAt(i);
					p.increaseQuantity();
					
					((BasketModel)mBasket.getModel()).remove(i);
					((BasketModel)mBasket.getModel()).add(i, p);
					
					setContext(i);
					updateSum();
					
					break;
				}
			}
			
			if(!found)
			{
				((BasketModel)mBasket.getModel()).addElement(p);
				setContext(mBasket.getModel().getSize() - 1);
			}
		}
		
		
		updateSum();
	}
	
	/**
	 * Get the basket 
	 * 
	 * @return
	 */
	public JList getBasket()
	{
		return mBasket;
	}
	
	/**
	 * Update the total basket
	 */
	public void updateSum()
	{
		NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.UK);
		mTotalSum.setText(formatter.format(((BasketModel)mBasket.getModel()).calculateTotal() / 100.0));
	}

	/**
	 * Set the context, i.e. the item in question
	 * 
	 * @param	c
	 */
	public void setContext(int c)
	{
		mItemContext = c;

		mBasket.setSelectedIndex(c);
		mBasket.ensureIndexIsVisible(c);
	}
	
	/**
	 * Clear the selection/context
	 */
	public void clearContext()
	{
		setContext(-1);
		mBasket.clearSelection();
	}
	
	/**
	 * Get the context, i.e. the item in question
	 */
	public int getContext()
	{
		return mItemContext;
	}
	
	/**
	 * Get the current selected item
	 */
	public Product getSelectedItem()
	{
		return ((BasketModel)mBasket.getModel()).getElementAt(mItemContext);
	}
	
	/**
	 * Clear all items
	 */
	public void clear()
	{
		((BasketModel)mBasket.getModel()).clear();
		updateSum();
	}
}