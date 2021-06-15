package Logger.model.Appenders;

import Logger.api.Appender;
import Logger.api.Layout;

public class ConsoleAppender extends BaseAppender {
    public ConsoleAppender(Layout layout) {
        super(layout);

    }
    @Override
    public void appendMessage(String dateTime, String reportLevel, String message) {
        System.out.println(String.format(super.getLayout().getLayout(),dateTime,reportLevel,message));
    }

    @Override
    public void append(String message) {
        System.out.println(message);
    }
}
