package Designs.Logger.UseCaseClasses;

import Designs.Logger.Entities.LogMessage;
import Designs.Logger.EnumsAndConstants.LogLevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject {
    Map<LogLevel, List<Observer>> registryMap;

    public Subject() {
        registryMap = new HashMap<>();
    }

    public void attachObserver(LogLevel level, Observer observer) {
        if(registryMap.get(level) == null)
            registryMap.put(level, new ArrayList<>());
        registryMap.get(level).add(observer);
    }

    public void detachObserver(LogLevel level, Observer observer) {
        if(registryMap.get(level) != null) {
            List<Observer> observers = registryMap.get(level);
            observers.remove(observer);
        }
    }

    public void notifyObservers(LogLevel level, LogMessage msg) {
        if(registryMap.get(level) != null) {
            List<Observer> observers = registryMap.get(level);
            if(!observers.isEmpty()) {
                observers.forEach(o -> o.update(msg));
            }
        }
    }
}
