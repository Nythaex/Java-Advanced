package Military_Elite.Vailidations;

import Military_Elite.enums.Corp;

public class CorpValidation {

    public static boolean check(String provided) {
        return provided.equals(Corp.MARINES.getNormalCase())||provided.equals(Corp.AIRFORCES.getNormalCase());
    }
}
