package day9.parking;

import java.util.HashMap;
import java.util.Map;

class ParkingLot {
    private Map<Token, Car> parkedCars;
    private int size;
    private ParkingLotAttendant attendant;
    private DisplayManager displayManager;
    private Integer id;
    private CivicBody civicBody;

    ParkingLot(int id, int size) {
        this.id = id;
        this.size = size;
        this.parkedCars = new HashMap<>();
    }

    Token park(Car car) {
        if (isFull()) return null;
        Token token = new Token(parkedCars.size());
        parkedCars.put(token, car);
        if (isFull() && attendant != null) {
            this.attendant.notifyLotFull(this);
        }
        if (this.displayManager != null) this.displayManager.notifyCarParked(this.id);
        if (isLessThanTwentyPercent()) this.attendant.notifyEightyPercentLotFree(this);
        if (isEightyPercentFull()) this.civicBody.notifyEightyPercentLotFull();
        return token;
    }

    private boolean isEightyPercentFull() {
        int filled = this.parkedCars.size();
        int total = this.size;
        return (float) filled / total >= 0.8;
    }

    private boolean isLessThanTwentyPercent() {
        int filled = this.parkedCars.size();
        int total = this.size;
        return (float) filled / total <= 0.2;
    }

    void registerAttendant(ParkingLotAttendant attendant) {
        this.attendant = attendant;
    }

    void registerDisplayManager(DisplayManager displayManager) {
        this.displayManager = displayManager;
    }

    void registerCivicBody(CivicBody civicBody) {
        this.civicBody = civicBody;
    }

    boolean isFull() {
        return size == parkedCars.size();
    }

    boolean unPark(Token token) {
        if (!parkedCars.containsKey(token)) return false;
        if (isFull() && this.attendant != null) attendant.notifyLotFree(this);
        parkedCars.remove(token);
        if (this.displayManager != null) this.displayManager.notifyCarUnParked(this.id);
        return true;
    }

    int getParkedCarsCount() {
        return this.parkedCars.size();
    }

    Integer getId() {
        return this.id;
    }
}
