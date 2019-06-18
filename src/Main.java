import org.apache.log4j.Logger;

import dataAccess.DbConnect;

public class Main {

	public static void main(String[] args) {
		final Logger logger = Logger.getLogger(Main.class);
		  logger.debug("Log4jExample: A Sample Debug Message");
	        logger.info("Log4jExample: A Sample Info  Message");
	}
}