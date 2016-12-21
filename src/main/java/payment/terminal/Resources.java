package payment.terminal;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

import javax.imageio.ImageIO;

public class Resources
{
	public static final String ASSETS_DIR = "res/";
	public static final String XML_DIR = "xml/";
	public static final String IMAGES_DIR = "images/";
	
	private static Class<?> mClass;
	
	public Resources() {}
	
	/**
	 * Assign class loader
	 * 
	 * Assigning the class loader in a public method
	 * for static execution of accessing file
	 * 
	 * @access	public
	 * @return	void
	 */
	public void setClass(Class<?> c)
	{
		mClass = c;
	}
	
	/**
	 * Set a default class
	 */
	public void setClass()
	{
		mClass = getClass();
	}
	
	/**
	 * Access resource
	 * 
	 * @param	file
	 * @throws	FileNotFoundException
	 * @throws	IOException
	 */
	public static URL getResource(String file) throws
		FileNotFoundException
	,	IOException
	{
		return mClass
			.getClassLoader()
			.getResource(ASSETS_DIR + file);
	}
	
	/**
	 * Access resource as a stream
	 * 
	 * @param	file
	 * @throws	FileNotFoundException
	 * @throws	IOException
	 */
	public static InputStream getResourceAsStream(String file) throws
		FileNotFoundException
	,	IOException
	{
		return mClass
			.getClassLoader()
			.getResourceAsStream(ASSETS_DIR + file);
	}
	
	/**
	 * Access a file
	 * 
	 * @param	file
	 * @throws	FileNotFoundException
	 * @throws	IOException
	 */
	public static File getFile(String file) throws
		FileNotFoundException
	,	IOException
	{
		return new File(getResource(file).getFile());
	}
	
	/**
	 * Access an XML stream
	 * 
	 * @param	file
	 * @throws	FileNotFoundException
	 * @throws	IOException
	 */
	public static InputStream getXMLStream(String file) throws
		FileNotFoundException
	,	IOException
	{
		return getResourceAsStream(XML_DIR + file);
	}
	
	/**
	 * Access an image as a buffer
	 * 
	 * @param	file
	 * @throws	FileNotFoundException
	 * @throws	IOException
	 */
	public static BufferedImage getBufferedImage(String file) throws
		FileNotFoundException
	,	IOException
	{
		return ImageIO.read(getResource(IMAGES_DIR + file));
	}
	
	/**
	 * Clean a path
	 * 
	 * @param	path
	 */
	public static String cleanPath(String path)
	{
		try
		{
			return URLDecoder.decode(path, "UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
}