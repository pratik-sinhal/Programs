package Designs.Logger;

import Designs.Logger.ApplicationClasses.ConsoleLogging;
import Designs.Logger.ApplicationClasses.FileLogging;
import Designs.Logger.ApplicationClasses.Logger;
import Designs.Logger.ApplicationClasses.Observer;
import Designs.Logger.Constants.LogLevel;

public class TestLogger {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Observer consoleLogging = new ConsoleLogging();
        Observer fileLogging = new FileLogging();

        logger.attach(LogLevel.ERROR, consoleLogging);
        logger.attach(LogLevel.INFO, fileLogging);
        logger.writeLog(LogLevel.INFO, "This is error msg 1");
    }
}
