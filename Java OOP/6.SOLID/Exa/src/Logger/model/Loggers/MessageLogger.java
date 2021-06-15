package Logger.model.Loggers;

import Logger.api.Appender;
import Logger.api.Logger;
import Logger.enums.ReportLevel;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = new Appender[appenders.length];
        System.arraycopy(appenders, 0, this.appenders, 0, appenders.length);
    }


    @Override
    public void logInfo(String dateTime, String message) {
        this.logMessage(dateTime,ReportLevel.INFO,message);
    }

    @Override
    public void logWarning(String dateTime, String message) {
        this.logMessage(dateTime,ReportLevel.WARNING,message);
    }

    @Override
    public void logError(String dateTime, String message) {
        this.logMessage(dateTime,ReportLevel.ERROR,message);
    }

    @Override
    public void logCritical(String dateTime, String message) {
        this.logMessage(dateTime,ReportLevel.CRITICAL,message);
    }

    @Override
    public void logFatal(String dateTime, String message) {
        this.logMessage(dateTime,ReportLevel.FATAL,message);
    }

    private void logMessage(String dateTime, ReportLevel reportLevel, String message) {
        for (Appender appender : this.appenders) {
            appender.appendMessage(dateTime, reportLevel.name(), message);
        }
    }
}
