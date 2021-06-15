package p06_TirePressureMonitoringSystem;

import org.junit.Test;

public class SensorTest  {
    @Test
    public void when_theGivenSensorIsInRangeAndThereIsNoAlarm(){
        Sensor sensor=new Sensor();
        double p=sensor.popNextPressurePsiValue();

    }

}