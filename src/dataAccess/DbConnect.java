package dataAccess;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.HashMap;
import java.util.Properties;

import org.apache.log4j.Logger;	

public class DbConnect {
	
	private Connection conn;
	/**
	 * method provides connection to DB via JDBC
	 * @return object with connection to database
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Connection connect() throws SQLException, ClassNotFoundException {
		try {
			Class.forName("org.postgresql.Driver");
						
			//setup connection to DB
			String databaseUrl = System.getenv("DATABASE_URL");
			String databaseUser = System.getenv("DATABASE_USER");
			String databasePass = System.getenv("DATABASE_PASS");
			conn = DriverManager.getConnection("jdbc:" + databaseUrl.toString(), databaseUser.toString(), databasePass.toString());
			}
	    catch (SQLException e) {
	        e.printStackTrace();
	    	}
		return conn;
	}
	
	/**
	 * method to SQL query
	 * @param sql - string of SQL query
	 * @return HashMap of queried data 
	 * @throws SQLException
	 */
	public HashMap<String, Integer> query(String sql) throws SQLException {
		PreparedStatement preparedStatement;
		HashMap<String, Integer> data = new HashMap<String, Integer>();
		try {
			preparedStatement = conn.prepareStatement(sql);
			ResultSet result = preparedStatement.executeQuery();
			
			while (result.next()) {
				data.put("workingdays", result.getInt("workingdays"));
				data.put("workingdayswithoutholidays", result.getInt("workingdays_without_holidays"));
				data.put("month", result.getInt("month"));
				data.put("year", result.getInt("year"));
			}
		} catch (SQLException e) {
			final Logger logger = Logger.getLogger(DbConnect.class);
			logger.error("SQL query in DbConnect.java failed:" + DbConnect.readProperties());
			e.printStackTrace();
		}
		return data;
	}
	
	/**
	 * method to close connection to DB
	 * @throws SQLException
	 */
	public void quitConnection() throws SQLException {
		conn.close();
	}
	
	/**
	 * method read config of DB connection
	 * @return 
	 */
	public static Properties readProperties() {
        Properties props = new Properties();
        Path myPath = Paths.get("resource/database.properties");
        try {
            BufferedReader bf = Files.newBufferedReader(myPath, StandardCharsets.UTF_8);
            props.load(bf);
        } catch (IOException ex) {
        	ex.getStackTrace();
        }
        return props;
    }
}