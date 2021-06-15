package garage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class GarageTests {
    public  Garage garage;

    @Before
    public void setUp() throws Exception {
        garage=new Garage();
        Car car=new Car("volvo",200,12);
        garage.addCar(car);
    }
    @Test
    public void when_find2CarsAboveMaxSpeed(){
        Car car=new Car("pejo",2001,121);
        garage.addCar(car);
        List<Car> cars=garage.findAllCarsWithMaxSpeedAbove(200);
        assertEquals(1, cars.size());

    }
    @Test
    public void when_getAllCarsByBrand(){
        Car car=new Car("pejo",2001,12);
        garage.addCar(car);
        List<Car> cars=garage.findAllCarsByBrand("pejo");
        assertEquals(1, cars.size());

    }
    @Test
    public void when_getMostExpensiveCar(){
        Car car=new Car("pejo",2001,121);
        garage.addCar(car);
        Car care=garage.getTheMostExpensiveCar();
        assertEquals(121d, care.getPrice());

    }
}