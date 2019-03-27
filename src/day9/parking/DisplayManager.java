package day9.parking;

abstract class DisplayManager {
    protected Display display;


    void notifyCarParked(Integer parkingLotId) {
        if (this.display != null)
            this.display.incrementCarCount(parkingLotId);
    }

    void notifyCarUnParked(Integer parkingLotId) {
        if (this.display != null)
            this.display.decrementCarCount(parkingLotId);
    }

    abstract void addDisplay(Display display);
}
