package Designs.Logger.Entities;

import Designs.Logger.EnumsAndConstants.LogLevel;

public class LogMessage {
    LogLevel level;
    String msg;

    public LogMessage(LogLevel level, String msg) {
        this.level = level;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
