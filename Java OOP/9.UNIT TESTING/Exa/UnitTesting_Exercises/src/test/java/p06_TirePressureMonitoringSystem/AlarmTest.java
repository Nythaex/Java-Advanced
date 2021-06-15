package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class AlarmTest  {
    @Mock
    private Sensor SENSOR;

    @Before
    public void setUp() throws Exception {
        SENSOR= Mockito.mock(Sensor.class);
    }

    @Test
    public void when_theGivenSensorIsInRangeAndThereIsNoAlarm(){
        when(SENSOR.popNextPressurePsiValue()).thenReturn(19.0);
        Alarm alarm = new Alarm(SENSOR);
        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }
    @Test
    public void when_theGivenSensorIsOn(){
        when(SENSOR.popNextPressurePsiValue()).thenReturn(-23.0);
        Alarm alarm = new Alarm(SENSOR);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }
}