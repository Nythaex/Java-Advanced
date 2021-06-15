package TrafficLight;

public class TrafficLight {
    Lights state;

    public TrafficLight(Lights state) {
        this.state = state;
    }

    public Lights getState() {
        return state;
    }

    public void setState(Lights state) {
        this.state = state;
    }

    public void update(){
        switch (state.name()){
            case "RED":
              setState(Lights.GREEN);
                break;
            case "YELLOW":
                setState(Lights.RED);
                break;
            case "GREEN":
                setState(Lights.YELLOW);
                break;

        }
    }
}
