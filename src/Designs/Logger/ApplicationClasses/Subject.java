package Designs.Logger.ApplicationClasses;

import Designs.Logger.Entities.LogMessage;
import Designs.Logger.Constants.LogLevel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Subject {
    Map<LogLevel, List<Observer>> registryMap;

    public Subject() {
        registryMap = new HashMap<>();
    }

    public void attachObserver(LogLevel level, Observer observer) {
        registryMap.put(level, registryMap.getOrDefault(level, new ArrayList<>()));
        registryMap.get(level).add(observer);
    }

    public void detachObserver(LogLevel level, Observer observer) {
        if(registryMap.get(level) != null) {
            List<Observer> observers = registryMap.get(level);
            observers.remove(observer);
        }
    }

    public void notifyObservers(LogLevel level, LogMessage msg) {
        registryMap.entrySet().forEach(e -> {
            if(e.getKey().getLevel() <= level.getLevel()) {
                e.getValue().forEach(v -> v.update(msg));
            }
        });
    }
}
