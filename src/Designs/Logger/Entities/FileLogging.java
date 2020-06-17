package Designs.Logger.Entities;

import Designs.Logger.UseCaseClasses.Observer;

public class FileLogging implements Observer {
    @Override
    public void update(LogMessage msg) {
        System.out.println(msg);
    }
}
