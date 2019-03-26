package day9.bag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Bag {

    private int bagSize;
    private Map<String, Integer> details;
    private ArrayList<Ball> balls;

    Bag(int bagSize) {
        this.bagSize = bagSize;
        this.balls = new ArrayList<>(bagSize);
        this.details = new HashMap<>();
    }

    boolean addBall(Ball ball) {
        this.balls.add(ball);
        updateDetails(ball);
        return true;
    }

    private void updateDetails(Ball ball) {
        Integer currentCount = details.getOrDefault(ball.getColor(), 0);
        details.put(ball.getColor(), currentCount + 1);
    }
}
