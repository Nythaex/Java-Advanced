package Military_Elite.Soldiers.Creator;

import Military_Elite.Comperators.LieutenantComparator;
import Military_Elite.Data.SoldiersData;
import Military_Elite.Resources.Mission;
import Military_Elite.Resources.Repair;
import Military_Elite.Soldiers.*;
import Military_Elite.Vailidations.CorpValidation;
import Military_Elite.Vailidations.MissionProgressValidation;
import Military_Elite.enums.Corp;
import Military_Elite.enums.MissionProgress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SoldierCreator {
    private static SoldiersData data;

    public static SoldierImpl createSoldier(String[] info) {
        data = SoldiersData.getInstance();

        SoldierImpl createdSoldier=null;

        String soldierType = info[0];
        switch (soldierType) {
            case "Private":
                createdSoldier=new PrivateImpl(Integer.parseInt(info[1]), info[2],info[3],Double.parseDouble(info[4]));
                data.getPrivateSoldiers().put(String.valueOf(createdSoldier.getID()), (PrivateImpl) createdSoldier);
                break;
            case "LeutenantGeneral":
                List<PrivateImpl> privates=new ArrayList<>();
                for (int i = 5; i <= info.length - 1; i++) {
                 privates.add(data.getPrivateSoldiers().get(info[i]));
                }
                Collections.sort(privates,new LieutenantComparator());
                createdSoldier=new LieutenantGeneralImpl(Integer.parseInt(info[1]), info[2],info[3],Double.parseDouble(info[4]),privates);
                break;
            case "Engineer":
                if (CorpValidation.check(info[5])) {
                    List<Repair> repairs = new ArrayList<>();
                    for (int i = 6; i <= info.length - 1; i += 2) {
                        repairs.add(new Repair(info[i],Integer.parseInt(info[i+1])));
                    }

                    createdSoldier = new EngineerImpl(Integer.parseInt(info[1]), info[2], info[3], Double.parseDouble(info[4]),Corp.getCorp(info[5]), repairs);
                }else {
                    throw new IllegalArgumentException();
                }
                break;
            case "Commando":
                if (CorpValidation.check(info[5])) {
                    List<Mission> missions = new ArrayList<>();
                    for (int i = 6; i <= info.length - 1; i += 2) {
                        if (MissionProgressValidation.check(info[i+1])){
                        missions.add(new Mission(info[i], MissionProgress.getMissionProgress(info[i+1])));
                        }
                    }

                    createdSoldier = new CommandoImpl(Integer.parseInt(info[1]), info[2], info[3], Double.parseDouble(info[4]),Corp.getCorp(info[5]),missions);
                }else {
                    throw new IllegalArgumentException();
                }
                break;

            case "Spy":
                createdSoldier=new SpyImpl(Integer.parseInt(info[1]), info[2],info[3],info[4]);
                break;
        }


        return createdSoldier;
    }
}
