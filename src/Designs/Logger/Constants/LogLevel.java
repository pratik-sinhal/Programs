package Designs.Logger.Constants;

public enum LogLevel {
    INFO(1),
    WARNING(2),
    DEBUG(3),
    ERROR(4),
    FATAL(5),
    ALL(6);

    private final int level;

    LogLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
