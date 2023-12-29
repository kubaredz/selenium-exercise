package utils.testng.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int counter = 0;
    private static final int ITERATION_LIMIT = 2;
    private Logger logger = Logger.getLogger(String.valueOf(RetryAnalyzer.class));

    @Override
    public boolean retry(ITestResult iTestResult) {

        if (!iTestResult.isSuccess()) {
            if (counter < ITERATION_LIMIT) {
                counter++;
                logger.log(Level.INFO, "Retrying test method {}!", iTestResult.getName());
                return true;
            }
        }
        logger.log(Level.INFO, "Test method {} will be not retried!", iTestResult.getName());
        return false;
    }
}