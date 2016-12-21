package payment.terminal.renderer;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

import payment.terminal.holder.Product;
import payment.terminal.widget.Terminal;

public class TerminalCellRenderer implements ListCellRenderer
{
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		Product product = (Product)value;
		JPanel panel = new JPanel(new BorderLayout());

		panel.setBorder(new EmptyBorder(4, 10, 4, 10));
		
		if(isSelected)
		{
			panel.setBackground(Terminal.HIGHLIGHT_COLOR);
		}
		else
		{
			panel.setOpaque(false);
			panel.setBackground(null);
		}
		
		JLabel name = new JLabel(Integer.toString(product.getQuantity()) + " x " + product.getName());
		name.setForeground(isSelected ? Terminal.BACKGROUND_COLOR : Terminal.HIGHLIGHT_COLOR);
		name.setFont(Terminal.FONT);
		panel.add(name, BorderLayout.WEST);
		
		JLabel price = new JLabel(product.getPriceFormatted());
		price.setForeground(isSelected ? Terminal.BACKGROUND_COLOR : Terminal.HIGHLIGHT_COLOR);
		price.setFont(Terminal.FONT);
		panel.add(price, BorderLayout.EAST);
	 	
		return panel;
	}
}