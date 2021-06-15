package Logger.model.Appenders;

import Logger.api.Appender;
import Logger.api.Layout;
import Logger.enums.ReportLevel;

public abstract class BaseAppender implements Appender{
        private Layout layout;
        private ReportLevel reportLevel;

    protected Layout getLayout() {
        return layout;
    }
    @Override
    public void appendMessage(String dateTime, String reportLevel, String message) {
        System.out.println(String.format(this.layout.getLayout(),dateTime,reportLevel,message));
    }
    public BaseAppender(Layout layout) {
        this.layout = layout;
    }
}
