package Logger.model.Layouts;

import Logger.api.Layout;

public class XmlLayout implements Layout {
    @Override
    public String getLayout() {
        StringBuilder builder = new StringBuilder();
        builder.append("<log>");
        builder.append(System.lineSeparator());
        builder.append("<date>%s</date>");
        builder.append(System.lineSeparator());
        builder.append("<level>%s</level>");
        builder.append(System.lineSeparator());
        builder.append("<message>%s</message>");
        builder.append(System.lineSeparator());
        builder.append("</log>");

        return builder.toString();
    }
}
