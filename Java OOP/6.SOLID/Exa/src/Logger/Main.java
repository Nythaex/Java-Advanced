package Logger;


import Logger.api.Appender;
import Logger.api.File;
import Logger.api.Layout;
import Logger.api.Logger;
import Logger.model.Appenders.ConsoleAppender;
import Logger.model.Appenders.FileAppender;
import Logger.model.Layouts.SimpleLayout;
import Logger.model.Layouts.XmlLayout;
import Logger.model.Loggers.MessageLogger;
import files.LogFile;


public class Main {
    public static void main(String[] args) {
        Layout simpleLayout = new SimpleLayout();
        Appender consoleAppender = new ConsoleAppender(simpleLayout);

        File file = new LogFile();
        Appender fileAppender = new FileAppender(simpleLayout);
        ((FileAppender) fileAppender).setFile(file);

        Logger logger = new MessageLogger(consoleAppender, fileAppender);

        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");


    }
}
