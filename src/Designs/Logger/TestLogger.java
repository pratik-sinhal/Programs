package Designs.Logger;

import Designs.Logger.Entities.ConsoleLogging;
import Designs.Logger.Entities.FileLogging;
import Designs.Logger.Entities.Logger;
import Designs.Logger.EnumsAndConstants.LogLevel;

public class TestLogger {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        ConsoleLogging consoleLogging = new ConsoleLogging();
        FileLogging fileLogging = new FileLogging();

        logger.attach(LogLevel.ERROR, consoleLogging);
        //logger.attach(LogLevel.INFO, fileLogging)
        logger.writeLog(LogLevel.ERROR, "This is error msg 1");

    }
}
