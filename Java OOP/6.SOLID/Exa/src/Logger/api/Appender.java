package Logger.api;

public interface Appender {
    void appendMessage(String dateTime,String reportLevel,String message);
    void append(String message);
}
