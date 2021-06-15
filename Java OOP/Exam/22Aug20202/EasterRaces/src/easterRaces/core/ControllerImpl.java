package easterRaces.core;

import easterRaces.common.ExceptionMessages;
import easterRaces.common.OutputMessages;
import easterRaces.core.interfaces.Controller;
import easterRaces.entities.cars.Car;
import easterRaces.entities.cars.MuscleCar;
import easterRaces.entities.cars.SportsCar;
import easterRaces.entities.drivers.Driver;
import easterRaces.entities.drivers.DriverImpl;
import easterRaces.entities.racers.Race;
import easterRaces.entities.racers.RaceImpl;
import easterRaces.repositories.interfaces.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    Repository<Driver> driverRepository;
    Repository<Car> carRepository;
    Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> riderRepository, Repository<Car> motorcycleRepository, Repository<Race> raceRepository) {
        this.driverRepository = riderRepository;
        this.carRepository = motorcycleRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        if (driverRepository.getByName(driver) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_EXISTS, driver));
        }
        driverRepository.add(new DriverImpl(driver));
       return String.format(OutputMessages.DRIVER_CREATED, driver);
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        if (carRepository.getByName(model) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_EXISTS, type));
        }
        Car car = null;
        switch (type) {
            case "Muscle":
                car = new MuscleCar(model, horsePower);
                break;
            case "Sports":
                car = new SportsCar(model, horsePower);
                break;
        }
        carRepository.add(car);
        return String.format(OutputMessages.CAR_CREATED,car.getClass().getSimpleName(),car.getModel());
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        if (carRepository.getByName(carModel) == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAR_NOT_FOUND, carModel));
        }
        if (driverRepository.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        driverRepository.getByName(driverName).addCar(carRepository.getByName(carModel));

        return String.format(OutputMessages.CAR_ADDED,driverName,carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        if (raceRepository.getByName(raceName) == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND, raceName));
        }
        if (driverRepository.getByName(driverName) == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DRIVER_NOT_FOUND, driverName));
        }
        raceRepository.getByName(raceName).addDriver(driverRepository.getByName(driverName));
        return String.format(OutputMessages.DRIVER_ADDED,driverName,raceName);
    }

    @Override
    public String startRace(String raceName) {
        if (raceRepository.getByName(raceName)==null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_NOT_FOUND,raceName));
        }if (raceRepository.getByName(raceName).getDrivers().size()<3){
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_INVALID,raceName,3));
        }
        int laps=raceRepository.getByName(raceName).getLaps();
        List<Driver> drivers=raceRepository.getByName(raceName).getDrivers().stream().sorted((s1,s2)->
                Double.compare(s2.getCar().calculateRacePoints(laps),s1.getCar().calculateRacePoints(laps))).limit(3).collect(Collectors.toList());
        StringBuilder builder=new StringBuilder();
        builder.append(String.format(OutputMessages.DRIVER_FIRST_POSITION,drivers.get(0).getName(),raceName)).append(System.lineSeparator());
        builder.append(String.format(OutputMessages.DRIVER_SECOND_POSITION,drivers.get(1).getName(),raceName)).append(System.lineSeparator());
        builder.append(String.format(OutputMessages.DRIVER_THIRD_POSITION,drivers.get(2).getName(),raceName));
        raceRepository.remove(raceRepository.getByName(raceName));
        return builder.toString().trim();
    }

    @Override
    public String createRace(String name, int laps) {
        if (raceRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.RACE_EXISTS, name));
        }
        raceRepository.add(new RaceImpl(name,laps));
        return String.format(OutputMessages.RACE_CREATED,name);
    }
}
