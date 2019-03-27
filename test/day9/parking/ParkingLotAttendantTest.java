package day9.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotAttendantTest {
    @Test
    void shouldParkACarAndReturnToken() {
        ParkingLot parkingLot = new ParkingLot(1, 4);
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addParkingLot(parkingLot);
        Car car = new Car();
        assertEquals(Token.class, parkingLotAttendant.park(car).getClass());
    }


    @Test
    void shouldNotParkWhenParkingLotIsFull() {
        ParkingLot parkingLot = new ParkingLot(1, 2);
        CivicBody civicBody = new CivicBody();
        parkingLot.registerCivicBody(civicBody);
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addParkingLot(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        parkingLotAttendant.park(car1);
        parkingLotAttendant.park(car2);
        assertNull(parkingLotAttendant.park(car3));
    }

    @Test
    void shouldParkInAnyOneOfParkingLot() {
        TestParkingLot parkingLot1 = new TestParkingLot(1, 2);
        TestParkingLot parkingLot2 = new TestParkingLot(1, 2);
        CivicBody civicBody = new CivicBody();
        parkingLot1.registerCivicBody(civicBody);
        parkingLot2.registerCivicBody(civicBody);
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addParkingLot(parkingLot1);
        parkingLotAttendant.addParkingLot(parkingLot2);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        parkingLotAttendant.park(car1);
        parkingLotAttendant.park(car2);
        assertEquals(Token.class, parkingLotAttendant.park(car3).getClass());
    }

    @Test
    void shouldParkACarWhenAFullLotBecomesFree() {

        ParkingLot parkingLot = new ParkingLot(1, 1);
        CivicBody civicBody = new CivicBody();
        parkingLot.registerCivicBody(civicBody);
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addParkingLot(parkingLot);
        Car car = new Car();
        Token token = parkingLotAttendant.park(car);
        parkingLot.unPark(token);
        assertEquals(Token.class, parkingLotAttendant.park(new Car()).getClass());
    }

    @Test
    void shouldAddParkingLotDisplayToAttendantWhenNewDisplayIsAdded() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addParkingLot(parkingLot);
        TestDisplay testDisplay = new TestDisplay();
        parkingLotAttendant.addDisplay(testDisplay);
        assertTrue(testDisplay.called);
    }

    @Test
    void shouldAddParkingLotDisplayToAssistantWhenNewDisplayIsAdded() {
        ParkingLot parkingLot = new ParkingLot(1, 1);
        TestAssistant parkingLotAssistant = new TestAssistant();
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        parkingLotAttendant.addAssistant(parkingLotAssistant);
        parkingLotAttendant.addParkingLot(parkingLot);
        TestDisplay testDisplay = new TestDisplay();
        parkingLotAttendant.addDisplay(testDisplay);
        assertTrue(parkingLotAssistant.isDisplayAdded);
    }

    @Test
    void shouldCallIncrementCarCountOfDisplay() {
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        TestDisplay testDisplay = new TestDisplay();
        parkingLotAttendant.addDisplay(testDisplay);
        parkingLotAttendant.notifyCarParked(1);
        assertTrue(testDisplay.incrementCarCountCalled);
    }

    @Test
    void shouldCallDecrementCarCountOfDisplay() {
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        CivicBody civicBody = new CivicBody();
        TestDisplay testDisplay = new TestDisplay();
        ParkingLot parkingLot = new ParkingLot(1, 1);
        parkingLot.registerCivicBody(civicBody);
        parkingLot.park(new Car());
        parkingLotAttendant.addParkingLot(parkingLot);
        parkingLotAttendant.addDisplay(testDisplay);
        parkingLotAttendant.notifyCarUnParked(parkingLot.getId());
        assertTrue(testDisplay.decrementCarCountCalled);
    }

    @Test
    void shouldAddAssistantToAttendant() {
        ParkingLotAssistant parkingLotAssistant = new ParkingLotAssistant();
        ParkingLotAttendant parkingLotAttendant = new ParkingLotAttendant();
        CivicBody civicBody = new CivicBody();
        TestParkingLot parkingLot1 = new TestParkingLot(1, 1);
        TestParkingLot parkingLot2 = new TestParkingLot(2, 1);
        parkingLot1.registerCivicBody(civicBody);
        parkingLot2.registerCivicBody(civicBody);
        parkingLot1.park(new Car());
        parkingLotAttendant.addParkingLot(parkingLot1);
        parkingLotAttendant.addParkingLot(parkingLot2);
        parkingLotAttendant.addAssistant(parkingLotAssistant);

        assertEquals(parkingLot1.displayManager, parkingLotAssistant);
        assertEquals(parkingLot2.displayManager, parkingLotAssistant);
    }
}
    class TestDisplay extends Display {
        boolean called;
        boolean incrementCarCountCalled;
        boolean decrementCarCountCalled;

        TestDisplay() {
            super();
            this.called = false;
            this.incrementCarCountCalled = false;
            this.decrementCarCountCalled = false;
        }

        @Override
        void addParkingLot(Integer parkingLotId, Integer carCount) {
            called = true;
        }

        @Override
        void incrementCarCount(Integer parkingLotId) {
            this.incrementCarCountCalled = true;
        }

        @Override
        void decrementCarCount(Integer parkingLotId) {
            this.decrementCarCountCalled = true;
        }
    }