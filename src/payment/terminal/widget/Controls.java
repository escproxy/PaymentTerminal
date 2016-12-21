package payment.terminal.widget;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import payment.terminal.Resources;
import payment.terminal.helpers.Basket;
import payment.terminal.holder.Product;
import payment.terminal.models.BasketModel;

public class Controls extends Panel
{
	public static final String LAYOUT = "components/controls.xml";
	public static final String ICON_CROSS = "icon_cross.png";
	public static final String ICON_UP = "icon_up.png";
	public static final String ICON_DOWN = "icon_down.png";
	public static final String ICON_MINUS = "icon_minus.png";
	public static final String ICON_PLUS = "icon_plus.png";
	
	private JScrollPane mScroll;
	private JList mList;
	private Terminal mTerminalHandle;
	private Basket mBasketHandle;
	private ProductSearch mProductSearchHandle;
	
	private PlainButton mTerminalDownButton;
	private PlainButton mTerminalUpButton;
	private PlainButton mTerminalIncreaseButton;
	private PlainButton mTerminalDecreaseButton;
	private PlainButton mNewItemButton;
	private PlainButton mAddDiscountButton;
	private PlainButton mCancelButton;
	private GreenButton mPayButton;
	
	private PlainButton mKeypadDigit0;
	private PlainButton mKeypadDigit1;
	private PlainButton mKeypadDigit2;
	private PlainButton mKeypadDigit3;
	private PlainButton mKeypadDigit4;
	private PlainButton mKeypadDigit5;
	private PlainButton mKeypadDigit6;
	private PlainButton mKeypadDigit7;
	private PlainButton mKeypadDigit8;
	private PlainButton mKeypadDigit9;
	private PlainButton mKeypadDel;
	
	public Controls()
	{
		// 1. Register tags
		registerTag("plainbutton", PlainButton.class);
		registerTag("greenbutton", GreenButton.class);
		registerTag("redbutton", RedButton.class);
		
		// 2. Set the layout
		setLayoutView(LAYOUT);
		
		setBackground(Color.GREEN);
		
		try
		{
			mTerminalDownButton.setIcon(new ImageIcon(Resources.getBufferedImage(ICON_DOWN)));
			mTerminalUpButton.setIcon(new ImageIcon(Resources.getBufferedImage(ICON_UP)));
			mTerminalIncreaseButton.setIcon(new ImageIcon(Resources.getBufferedImage(ICON_PLUS)));
			mTerminalDecreaseButton.setIcon(new ImageIcon(Resources.getBufferedImage(ICON_MINUS)));
			
			// Lazy I know
			mTerminalDownButton.setPreferredSize(new Dimension(34, 36));
			mTerminalUpButton.setPreferredSize(new Dimension(34, 36));
			mTerminalIncreaseButton.setPreferredSize(new Dimension(34, 36));
			mTerminalDecreaseButton.setPreferredSize(new Dimension(34, 36));
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * When this is called, all is animated!
	 * 
	 * @param	terminal
	 */
	public void setHandles(Terminal terminal, ProductSearch productSearch, Basket basket)
	{
		mBasketHandle = basket;
		mTerminalHandle = terminal;
		mProductSearchHandle = productSearch;
		
		mTerminalDownButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				mProductSearchHandle.clearContext();
				
				int i = mTerminalHandle.getBasket().getSelectedIndex() + 1;
				mTerminalHandle.setContext(i);
			}
		});
		
		mTerminalUpButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				mProductSearchHandle.clearContext();
				
				int i = mTerminalHandle.getBasket().getSelectedIndex() < 0 ? 0 : mTerminalHandle.getBasket().getSelectedIndex() - 1;
				mTerminalHandle.setContext(i);
			}
		});
		
		mTerminalIncreaseButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				mProductSearchHandle.clearContext();
				
				Product product = mTerminalHandle.getSelectedItem();
				int c = mTerminalHandle.getContext();
				
				product.increaseQuantity();
				
				((BasketModel)mTerminalHandle.getBasket().getModel()).remove(c);
				((BasketModel)mTerminalHandle.getBasket().getModel()).add(c, product);
				mTerminalHandle.setContext(c);
				
				mTerminalHandle.updateSum();
			}
		});
		
		mTerminalDecreaseButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				mProductSearchHandle.clearContext();
				
				Product product = mTerminalHandle.getSelectedItem();
				int c = mTerminalHandle.getContext();
				
				product.decreaseQuantity();

				((BasketModel)mTerminalHandle.getBasket().getModel()).remove(c);
				
				if(product.getQuantity() > 0)
				{
					((BasketModel)mTerminalHandle.getBasket().getModel()).add(c, product);
					mTerminalHandle.setContext(c);
				}
				else
				{
					product.setQuantity(1);
					mTerminalHandle.setContext(c - 1 < 0 ? 0 : c - 1);
				}
				
				mTerminalHandle.updateSum();
			}
		});
		
		mNewItemButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				mProductSearchHandle.clearContext();
				
				String name = JOptionPane.showInputDialog("New item");
				
				mTerminalHandle.addProduct(new Product(name));
			}
		});
		
		//mAddDiscountButton.addActionListener(l);
		
		mCancelButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				mProductSearchHandle.clearContext();
				mTerminalHandle.clear();
			}
		});
		
		mPayButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				mBasketHandle.saveBasket(mTerminalHandle.getBasket());
				mTerminalHandle.clear();
			}
		});

		mKeypadDigit0.addActionListener(keypadDigitListener);
		mKeypadDigit1.addActionListener(keypadDigitListener);
		mKeypadDigit2.addActionListener(keypadDigitListener);
		mKeypadDigit3.addActionListener(keypadDigitListener);
		mKeypadDigit4.addActionListener(keypadDigitListener);
		mKeypadDigit5.addActionListener(keypadDigitListener);
		mKeypadDigit6.addActionListener(keypadDigitListener);
		mKeypadDigit7.addActionListener(keypadDigitListener);
		mKeypadDigit8.addActionListener(keypadDigitListener);
		mKeypadDigit9.addActionListener(keypadDigitListener);
		
		mKeypadDel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				mProductSearchHandle.clearContext();
				
				Product product = mTerminalHandle.getSelectedItem();
				
				if(product.getProductId() == -1)
				{			
					int c = mTerminalHandle.getContext();
					String price = Integer.toString(product.getPrice());
					
					product.setPrice(price.length() == 1 ? 0 : new Integer(price.substring(0, price.length() - 1)));
					
					((BasketModel)mTerminalHandle.getBasket().getModel()).remove(c);
					((BasketModel)mTerminalHandle.getBasket().getModel()).add(c, product);
					mTerminalHandle.setContext(c);
					
					mTerminalHandle.updateSum();
				}
			}
		});
	}
	
	/**
	 * Keypad listener
	 */
	private ActionListener keypadDigitListener = new ActionListener()
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			mProductSearchHandle.clearContext();
			
			Product product = mTerminalHandle.getSelectedItem();
			
			if(product.getProductId() == -1)
			{			
				int c = mTerminalHandle.getContext();
				String digit = ((PlainButton)e.getSource()).getText();
				product.setPrice(new Integer(new String(product.getPrice() + "" +  digit)));
				
				((BasketModel)mTerminalHandle.getBasket().getModel()).remove(c);
				((BasketModel)mTerminalHandle.getBasket().getModel()).add(c, product);
				mTerminalHandle.setContext(c);
				
				mTerminalHandle.updateSum();
			}
		}
	};
}