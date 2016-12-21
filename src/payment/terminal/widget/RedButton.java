package payment.terminal.widget;

import java.awt.Color;

public class RedButton extends PlainButton
{
	public static final String IMAGE_IDLE = "button_red.png";
	public static final String IMAGE_PRESSED = "button_red_pressed.png";
	
	public RedButton()
	{
		super();
		
		setIdleBackground(IMAGE_IDLE);
		setPressedBackground(IMAGE_PRESSED);
		
		setForeground(Color.WHITE);
		
		updateNineSlice();
	}
}
