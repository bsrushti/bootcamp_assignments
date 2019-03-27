package day9.parking;

import java.util.HashMap;
import java.util.Map;

class Display {
    private Map<Integer, Integer> parkingLots;

    Display() {
        this.parkingLots = new HashMap<>();
    }

    void addParkingLot(Integer id, Integer carsCount) {
        this.parkingLots.put(id, carsCount);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int parkingLotCount = 1;
        stringBuilder.append("Parking Lots").append("\t").append("No Of Cars").append("\n");
        for (Integer count : parkingLots.values()) {
            String name = "PL" + parkingLotCount;
            stringBuilder.append(name).append("\t").append(count).append("\n");
            parkingLotCount++;
        }
        return stringBuilder.toString();
    }


    void incrementCarCount(Integer parkingLotId) {
        int previousCount = this.parkingLots.get(parkingLotId);
        this.parkingLots.put(parkingLotId, previousCount + 1);
    }

    void decrementCarCount(Integer parkingLotId) {
        int previousCount = this.parkingLots.get(parkingLotId);
        this.parkingLots.put(parkingLotId, previousCount - 1);
    }
}
