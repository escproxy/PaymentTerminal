package payment.terminal.holder;

public class NineSliceComponent
{
	/**
	 * Component fields
	 */
	private int mX;
	private int mY;
	private int mWidth;
	private int mHeight;
	private Boolean mRepeatable;
	
	/**
	 * Constructor
	 * 
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param r
	 */
	public NineSliceComponent(int x, int y, int w, int h, Boolean r)
	{
		setX(x);
		setY(y);
		setWidth(w);
		setHeight(h);
		setRepeatable(r);
	}
	
	/**
	 * Set the x coordinate
	 * 
	 * @param	x
	 */
	public void setX(int x)
	{
		mX = x;
	}
	
	/**
	 * Set the y coordinate
	 * 
	 * @param	y
	 */
	public void setY(int y)
	{
		mY = y;
	}
	
	/**
	 * Set the width
	 * 
	 * @param	w
	 */
	public void setWidth(int w)
	{
		mWidth = w;
	}
	
	/**
	 * Set the height
	 * 
	 * @param	x
	 */
	public void setHeight(int h)
	{
		mHeight = h;
	}
	
	/**
	 * Set the whether or not the component background should be repeated
	 * instead of being stretched
	 * 
	 * @param	r
	 */
	public void setRepeatable(Boolean r)
	{
		mRepeatable = r;
	}
	
	/**
	 * Get the x coordinate
	 */
	public int getX()
	{
		return mX;
	}
	
	/**
	 * Get the y coordinate
	 */
	public int getY()
	{
		return mY;
	}
	
	/**
	 * Get the width
	 */
	public int getWidth()
	{
		return mWidth;
	}
	
	/**
	 * Get the height
	 */
	public int getHeight()
	{
		return mHeight;
	}
	
	/**
	 * Get whether or not its repeatable
	 */
	public Boolean repeatable()
	{
		return mRepeatable;
	}
	
	/**
	 * 
	 */
	public String toString()
	{
		return "x: " + getX() + ", y: " + getY() + ", width: " + getWidth() + ", height: " + getHeight();
	}
}
