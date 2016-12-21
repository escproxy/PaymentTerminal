package payment.terminal.widget;

import java.awt.Color;

public class GreenButton extends PlainButton
{
	public static final String IMAGE_IDLE = "button_green.png";
	public static final String IMAGE_PRESSED = "button_green_pressed.png";
	
	public GreenButton()
	{
		super();
		
		setIdleBackground(IMAGE_IDLE);
		setPressedBackground(IMAGE_PRESSED);
		
		setForeground(Color.WHITE);
		
		updateNineSlice();
	}
}
