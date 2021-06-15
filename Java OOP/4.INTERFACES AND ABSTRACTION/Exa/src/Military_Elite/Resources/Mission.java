package Military_Elite.Resources;

import Military_Elite.enums.MissionProgress;

import java.util.Locale;

public class Mission {
    private String codeName;
    private MissionProgress state;

    public Mission(String codeName,MissionProgress state) {
        this.codeName = codeName;
        this.state=state;
    }
    public void completeMission(){
        this.state=MissionProgress.FINISHED;
    }

    public String getCodeName() {
        return codeName;
    }

    public MissionProgress getState() {
        return state;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",this.codeName,this.state.getNormalCase());
    }
}
