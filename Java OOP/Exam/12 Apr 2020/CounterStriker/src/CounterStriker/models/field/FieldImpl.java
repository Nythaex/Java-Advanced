package CounterStriker.models.field;

import CounterStriker.common.OutputMessages;
import CounterStriker.models.players.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FieldImpl implements Field{
    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorists=new ArrayList<>();
        List<Player> CTerrorists=new ArrayList<>();

        for (Player player : players) {
            if (player.getType().equals("Terrorist")){
                terrorists.add(player);
            }else {
                CTerrorists.add(player);
            }
        }

        while(true){
            for (Player t:terrorists
            ) {
                if (t.isAlive()){
                    int shots=0;
                    for (Player ct:CTerrorists
                    ) {
                        if (ct.isAlive()) {
                            ct.takeDamage(t.getGun().fire());
                            shots++;
                        }

                    }
                    if (shots==0){
                        return OutputMessages.TERRORIST_WINS;
                    }
                }
            }
            for (Player ct:CTerrorists
            ) {
                if (ct.isAlive()){
                    int shots=0;
                    for (Player t:terrorists
                    ) {
                        if (t.isAlive()){
                            t.takeDamage(ct.getGun().fire());
                            shots++;
                        }
                    }
                    if (shots==0){
                        return OutputMessages.COUNTER_TERRORIST_WINS;
                    }
                }

            }
        }
    }
}
