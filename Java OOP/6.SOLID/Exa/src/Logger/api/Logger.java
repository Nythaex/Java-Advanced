package Logger.api;

public interface Logger {
    //Info > Warning > Error > Critical > Fatal.
    void logInfo(String dateTime,String message);
    void logWarning(String dateTime,String message);
    void logError(String dateTime,String message);
    void logCritical(String dateTime,String message);
    void logFatal(String dateTime,String message);

}
