package Designs.Logger.UseCaseClasses;

import Designs.Logger.Entities.LogMessage;

public interface Observer {
    void update(LogMessage msg);
}
