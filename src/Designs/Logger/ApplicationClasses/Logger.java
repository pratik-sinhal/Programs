package Designs.Logger.ApplicationClasses;

import Designs.Logger.Constants.LogLevel;
import Designs.Logger.Entities.LogMessage;

import java.util.HashMap;
import java.util.Map;

public class Logger{
    //private static Map<LogLevel, Boolean> logStatusMap;
    private Subject subject;

    private static final long SerialVersionUID = 1L;

    private Logger() {
        subject = new Subject();
        //logStatusMap = new HashMap<>();
        //logStatusMap.put(LogLevel.ERROR, Boolean.TRUE);
        //throw new IllegalStateException("Instance already created");
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
        //if(logStatusMap.get(level)){
            subject.notifyObservers(level, new LogMessage(level, msg));
        //}
    }

    /*public void enableLogLevel(LogLevel level) {
        logStatusMap.put(level, true);
    }*/

    /*public void disableLogLevel(LogLevel level) {
        logStatusMap.put(level, false);
    }*/


    public void attach(LogLevel level, Observer observer) {
        subject.attachObserver(level,observer);
    }

    public void detachObserver(LogLevel level, Observer observer) {
        subject.detachObserver(level, observer);
    }
}
