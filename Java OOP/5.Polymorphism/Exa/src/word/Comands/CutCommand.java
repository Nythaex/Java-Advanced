package word.Comands;

import word.TextTransform;

public class CutCommand implements TextTransform {
    private String lastCut;

    public String getLastCut() {
        return this.lastCut;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        String cut=text.substring(startIndex,endIndex);
        this.lastCut =cut;
                text.delete(startIndex,endIndex);
    }
}
