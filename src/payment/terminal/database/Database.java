package payment.terminal.database;

import java.io.File;
import java.net.URI;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Simple Database handling class
 */
public class Database
{
	private static final String DRIVER = "org.sqlite.JDBC";
	public static final int TIMEOUT = 30; // seconds
	
	private static Connection mConnection;
	private File mFile;
	private static Statement mStatement;
	
	/**
	 * Constructor
	 */
	public Database(File f)
	{
		mFile = f;
	}
	
	/**
	 * Initialise the database
	 * 
	 * @throws	Exception
	 */
	public void init() throws
		Exception
	{
		Class.forName(DRIVER);

		// Fix the potential problem of an encoded url
		String path = URLDecoder.decode(mFile.getCanonicalPath(), "UTF-8");
		mConnection = DriverManager.getConnection("jdbc:sqlite:" + path);
		mStatement = mConnection.createStatement();
		mStatement.setQueryTimeout(TIMEOUT);
	}
	
	/**
	 * Execute an instruction query
	 * 
	 * @param	instruction
	 * @throws	SQLException
	 */
	public static ResultSet executeQuery(String sql) throws
		SQLException
	{
		return mStatement.executeQuery(sql);
	}
	
	/**
	 * Execute an instruction statement
	 * 
	 * @param	instruction
	 * @throws	SQLException
	 */
	public static int executeStatement(String sql) throws
		SQLException
	{
		return mStatement.executeUpdate(sql);
	}
	
	/**
	 * Close the connection to the database
	 */
	public void close()
	{
		try
		{
			mConnection.close();
		}
		catch(Exception e)
		{
			// Nobody cares
		}
	}
}
