package Football_Team_Generator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;
    public boolean incorrect=false;
    ///-name: String
    //-	endurance:  int
    //-	sprint:  int
    //-	dribble: int
    //-	passing: int
    //-	shooting: int

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }
    //+ 	Player (String, int, int, int, int, int)

    private void setName(String name) {
        this.name = name;
    }

    private void setEndurance(int endurance) {
        if (!checkStats(endurance)){
            System.out.println("Endurance should be between 0 and 100.");
            this.incorrect=true;
        }else {
            this.endurance = endurance;
        }
    }

   private void setSprint(int sprint) {
       if (!checkStats(sprint)){
           System.out.println("Sprint should be between 0 and 100.");
           this.incorrect=true;
       }else {
           this.sprint = sprint;
       }

    }

    private void setDribble(int dribble) {
        if (!checkStats(dribble)){
            System.out.println("Dribble should be between 0 and 100.");
            this.incorrect=true;
        }else {
            this.dribble = dribble;
        }
    }

    private void setPassing(int passing) {
        if (!checkStats(passing)){
            System.out.println("Passing should be between 0 and 100.");
            this.incorrect=true;
        }else {
            this.passing = passing;
        }

    }

    private void setShooting(int shooting) {
        if (!checkStats(shooting)){
            System.out.println("Shooting should be between 0 and 100.");
            this.incorrect=true;
        }else{
            this.shooting = shooting;
        }

    }

    public String getName() {
        return name;
    }
    //-	setName(String) : void
    //+	getName(): String
    //-	setEndurance (int) : void
    //-	setSprint (int) : void
    //-	setDribble (int) : void
    //-	setPassing (int) : void
    //-	setShooting (int) : void

    public double overallSkillLevel(){
        return (this.dribble+this.passing+this.shooting+this.sprint+this.endurance)/5.0;
    }

    //+	overallSkillLevel() : double
    private boolean checkStats(int skillLevel) {
        return skillLevel>=0&&skillLevel<=100;
    }
}
