package payment.terminal.renderer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

import payment.terminal.holder.Product;

public class ProductRenderer implements ListCellRenderer
{
	@Override
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus)
	{
		Product product = (Product)value;
		JPanel panel = new JPanel(new BorderLayout());

		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
	 	panel.setBackground(isSelected ? Color.decode("#00BFFF") : Color.WHITE);

		JLabel name = new JLabel(product.getName());
		name.setForeground(isSelected ? Color.WHITE : Color.BLACK);
		panel.add(name, BorderLayout.WEST);
		
		JLabel price = new JLabel(product.getPriceFormatted());
		price.setForeground(isSelected ? Color.WHITE : Color.BLACK);
		panel.add(price, BorderLayout.EAST);
	 	
		return panel;
	}
}