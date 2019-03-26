package day9.parking;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {
    private List<Car> cars;

    ParkingLot() {
        this.cars = new ArrayList<>();
    }

    boolean park(Car car) {
        return this.cars.add(car);
    }
}
