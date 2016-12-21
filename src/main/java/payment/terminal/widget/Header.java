package payment.terminal.widget;

import java.awt.Container;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import payment.terminal.database.Database;

public class Header extends Panel
{
	public static final String LAYOUT = "components/header.xml";
	
	// Handles
	public JLabel mUser;
	public JLabel mDate;
	public JLabel mTitle;
	public JPanel mButtons;
	public SimpleButton mOverview;
	public SimpleButton mLogout;
	
	/**
	 * Constructor
	 */
	public Header()
	{
		// 1. Register tags
		registerTag("simplebutton", SimpleButton.class);
		
		// 2. Set the layout
		setLayoutView(LAYOUT);

		// 3. Animate
		mTitle.setHorizontalAlignment(SwingConstants.CENTER);
		mUser.setBorder(new EmptyBorder(0, 30, 2, 0));
		mUser.setVerticalAlignment(SwingConstants.BOTTOM);
		
		Date now = new Date();
		SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEEE d MMMMM, yyyy");
		
		mDate.setBorder(new EmptyBorder(2, 30, 0, 0));
		mDate.setVerticalAlignment(SwingConstants.TOP);
		mDate.setText(dateFormatter.format(now));

		mButtons.setBorder(new EmptyBorder(20, 0, 20, 30));

		mOverview.setMargin(new Insets(0, 0, 0, 5));
		//mLogout.setMargin(new Insets(0, 5, 0, 0));
		
		
		final Container parent = getParent();
		
		mOverview.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				ResultSet result;
				int total = 0;

				Date now = new Date();
				SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
				
				try
				{
					result = Database.executeQuery
					(
						"SELECT SUM(`total`) AS `total` "
					+	"FROM `purchases` "
					+	"WHERE `timestamp` LIKE '" + dateFormatter.format(now) + "%';"
					);
					
					result.next();
					total = result.getInt("total");
				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
				
				NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.UK);
				
				JOptionPane.showMessageDialog(parent,
					"Today's sales: " + currencyFormatter.format(total / 100.0)
				,   "Today's overview"
				,   JOptionPane.PLAIN_MESSAGE
				);
			}
		});
	}
}
