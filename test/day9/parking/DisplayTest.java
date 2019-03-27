package day9.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTest {
    @Test
    void shouldShowCurrentDisplayOfParkingLots() {
        Display display = new Display();
        ParkingLot parkingLot = new ParkingLot(1, 3);
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        display.addParkingLot(parkingLot.getId(), parkingLot.getParkedCarsCount());
        String expectedDisplay = "Parking Lots\tNo Of Cars\n";
        expectedDisplay = expectedDisplay.concat("PL1\t2\n");
        assertEquals(expectedDisplay, display.toString());
    }

    @Test
    void shouldIncrementParkingLotCarsCount() {
        Display display = new Display();
        ParkingLot parkingLot = new ParkingLot(1, 3);
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        display.addParkingLot(parkingLot.getId(), parkingLot.getParkedCarsCount());
        String expectedDisplay1 = "Parking Lots\tNo Of Cars\n";
        expectedDisplay1 = expectedDisplay1.concat("PL1\t2\n");
        assertEquals(expectedDisplay1, display.toString());
        display.incrementCarCount(parkingLot.getId());
        String expectedDisplay2 = "Parking Lots\tNo Of Cars\n";
        expectedDisplay2 = expectedDisplay2.concat("PL1\t3\n");
        assertEquals(expectedDisplay2, display.toString());
    }

    @Test
    void shouldDecrementParkingLotCarsCount() {
        Display display = new Display();
        ParkingLot parkingLot = new ParkingLot(1, 3);
        parkingLot.park(new Car());
        parkingLot.park(new Car());
        display.addParkingLot(parkingLot.getId(), parkingLot.getParkedCarsCount());
        String expectedDisplay1 = "Parking Lots\tNo Of Cars\n";
        expectedDisplay1 = expectedDisplay1.concat("PL1\t2\n");
        assertEquals(expectedDisplay1, display.toString());
        display.decrementCarCount(parkingLot.getId());
        String expectedDisplay2 = "Parking Lots\tNo Of Cars\n";
        expectedDisplay2 = expectedDisplay2.concat("PL1\t1\n");
        assertEquals(expectedDisplay2, display.toString());
    }
}