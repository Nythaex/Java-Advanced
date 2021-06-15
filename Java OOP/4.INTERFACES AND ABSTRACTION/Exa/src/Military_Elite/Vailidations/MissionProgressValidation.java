package Military_Elite.Vailidations;

import Military_Elite.enums.MissionProgress;

public class MissionProgressValidation {

    public static boolean check(String provided) {
        return provided.equals(MissionProgress.FINISHED.getNormalCase())||provided.equals(MissionProgress.IN_PROGRESS.getNormalCase());
    }
}
