package Designs.Logger.Entities;

import Designs.Logger.EnumsAndConstants.LogLevel;
import Designs.Logger.UseCaseClasses.Observer;
import Designs.Logger.UseCaseClasses.Subject;

import java.util.HashMap;
import java.util.Map;

public class Logger{
    private static Map<LogLevel, Boolean> logStatusMap;
    private static Subject subject;

    static {
        subject = new Subject();
        logStatusMap = new HashMap<>();
        logStatusMap.put(LogLevel.ERROR, Boolean.TRUE);
    }

    private static final long SerialVersionUID = 1L;

    private Logger() {
        throw new IllegalStateException("Instance already created");
    }

    @Override
    protected Logger clone() throws CloneNotSupportedException {
        return getInstance();
    }

    protected Logger readResolve() {
        return getInstance();
    }

    public static Logger getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final Logger INSTANCE = new Logger();
    }

    public void writeLog(LogLevel level, String msg) {
        if(logStatusMap.get(level)){
            subject.notifyObservers(level, new LogMessage(level, msg));
        }
    }

    public void enableLogLevel(LogLevel level) {
        logStatusMap.put(level, true);
    }

    public void disableLogLevel(LogLevel level) {
        logStatusMap.put(level, false);
    }


    public void attach(LogLevel level, Observer observer) {
        subject.attachObserver(level,observer);
    }

    public void detachObserver(LogLevel level, Observer observer) {
        subject.detachObserver(level, observer);
    }
}
