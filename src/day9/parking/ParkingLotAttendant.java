package day9.parking;

import java.util.ArrayList;
import java.util.List;

class ParkingLotAttendant extends DisplayManager {

    private List<ParkingLot> freeParkingLots;
    private List<ParkingLot> filledParkingLots;
    private ParkingLotAssistant assistant;

    ParkingLotAttendant() {
        super();
        this.freeParkingLots = new ArrayList<>();
        this.filledParkingLots = new ArrayList<>();
    }

    void addParkingLot(ParkingLot parkingLot) {
        parkingLot.registerAttendant(this);
        List<ParkingLot> respectiveParkingLots = freeParkingLots;
        if (parkingLot.isFull()) respectiveParkingLots = filledParkingLots;
        respectiveParkingLots.add(parkingLot);
    }

    Token park(Car car) {
        if (freeParkingLots.isEmpty()) return null;
        ParkingLot parkingLot = freeParkingLots.iterator().next();
        Token token = parkingLot.park(car);
        return token;
    }

    void notifyLotFull(ParkingLot parkingLot) {
        freeParkingLots.remove(parkingLot);
        filledParkingLots.add(parkingLot);
    }

    void notifyLotFree(ParkingLot parkingLot) {
        filledParkingLots.remove(parkingLot);
        freeParkingLots.add(parkingLot);
    }

    void addAssistant(ParkingLotAssistant assistant) {
        this.assistant = assistant;
        for (ParkingLot parkingLot : freeParkingLots) {
            parkingLot.registerDisplayManager(assistant);
        }
        for (ParkingLot parkingLot : filledParkingLots) {
            parkingLot.registerDisplayManager(assistant);
        }
    }

    @Override
    void addDisplay(Display display) {
        if (assistant != null) {
            assistant.addDisplay(display);
        } else
            this.display = display;
        for (ParkingLot parkingLot : freeParkingLots) {
            display.addParkingLot(parkingLot.getId(), parkingLot.getParkedCarsCount());
        }
        for (ParkingLot parkingLot : filledParkingLots) {
            display.addParkingLot(parkingLot.getId(), parkingLot.getParkedCarsCount());
        }
    }

    void notifyEightyPercentLotFree(ParkingLot parkingLot) {
        System.out.println("Promotion");
    }
}