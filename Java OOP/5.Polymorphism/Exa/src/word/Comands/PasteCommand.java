package word.Comands;

import word.TextTransform;

public class PasteCommand implements TextTransform {
    CutCommand cut;

    public PasteCommand(CutCommand cut) {
        this.cut=cut;
    }

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        String paste= cut.getLastCut();
        text.replace(startIndex,endIndex,paste.toString());

    }
}
