package payment.terminal.util;

public interface Lifecycle
{
	/**
	 * On Attach method
	 * 
	 * Called when something is initially added
	 */
	public void onAttach();
	
	/**
	 * On Layout method
	 * 
	 * Called when a layout is formed
	 */
	public void onLayout() throws
		Exception;
	
	/**
	 * On Create method
	 * 
	 * Called when something is created
	 */
	public void onCreate();
	
	/**
	 * On Start method
	 * 
	 * Called when something starts
	 */
	public void onStart();
	
	/**
	 * On Resume method
	 * 
	 * Called when something resumes
	 */
	public void onResume();
	
	/**
	 * On Visualise method
	 * 
	 * Called when something has become visible
	 */
	public void onVisualise();
	
	/**
	 * On Pause method
	 * 
	 * Called when something is paused or hidden
	 */
	public void onPause();
	
	/**
	 * On Stop method
	 * 
	 * Called when something is stopped
	 */
	public void onStop();
	
	/**
	 * On Destroy method
	 * 
	 * Called when something is removed all together
	 */
	public void onDestroy();
	
	/**
	 * On Detatch method
	 * 
	 * Called when something is removed from context all together
	 */
	public void onDetach();
}