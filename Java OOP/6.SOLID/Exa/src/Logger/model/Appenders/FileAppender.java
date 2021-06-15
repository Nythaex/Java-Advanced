package Logger.model.Appenders;

import Logger.api.File;
import Logger.api.Layout;
import files.LogFile;

public class FileAppender extends BaseAppender{
    private File file;
    public FileAppender(Layout layout) {
        super(layout);
        this.setFile(new LogFile());
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void appendMessage(String dateTime, String reportLevel, String message) {

    }

    @Override
    public void append(String message) {
        this.file.write(message);
    }
}
