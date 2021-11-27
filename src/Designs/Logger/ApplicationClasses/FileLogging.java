package Designs.Logger.ApplicationClasses;

import Designs.Logger.ApplicationClasses.Observer;
import Designs.Logger.Entities.LogMessage;

public class FileLogging implements Observer {
    @Override
    public void update(LogMessage msg) {
        System.out.println(getClass().getName() + ":" + msg);
    }
}
