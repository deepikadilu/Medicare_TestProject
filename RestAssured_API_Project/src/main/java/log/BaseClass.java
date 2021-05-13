package log;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;


public class BaseClass {
	public Logger  logger =Logger.getLogger(BaseClass.class);
	
	public BaseClass() {
		PropertyConfigurator.configure("log4j.properties");
		
//		logger.debug("This is the debug message");
//		logger.error("This is the error message");
//		logger.info("This is the info message");
//
//	
//	try {
//		int a=1/0;
//	} catch(Exception e)
//	{
//		logger.error(e);
//		logger.error(e.getStackTrace());
//		logger.error(e.toString());
//	}
//	}
	
}
}
