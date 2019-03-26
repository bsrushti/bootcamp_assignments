package day9.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    @Test
    void shouldParkCar() {
        Car car = new Car(123);
        ParkingLot parkingLot = new ParkingLot();

        assertTrue(parkingLot.park(car));
    }
}