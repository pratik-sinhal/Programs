package Designs.Logger.ApplicationClasses;

import Designs.Logger.Entities.LogMessage;

public interface Observer {
    void update(LogMessage msg);
}
