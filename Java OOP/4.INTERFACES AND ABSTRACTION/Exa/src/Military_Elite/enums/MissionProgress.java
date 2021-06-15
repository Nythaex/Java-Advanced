package Military_Elite.enums;

import java.util.HashMap;
import java.util.Map;

public enum MissionProgress {
    FINISHED("Finished"),
    IN_PROGRESS("inProgress");

    private String normalCase;
    private static Map<String,MissionProgress> missions=new HashMap<>();
    private static boolean registered=false;
    MissionProgress(String normalCase) {
        this.normalCase = normalCase;
    }

    public String getNormalCase() {
        return normalCase;
    }
    public static MissionProgress getMissionProgress(String normalCase) {
        if (!registered){
            register();
            registered=true;
        }
        return missions.get(normalCase);
    }

    private static void register() {
        missions.put(FINISHED.getNormalCase(), FINISHED);
        missions.put(IN_PROGRESS.getNormalCase(), IN_PROGRESS);
    }
}
