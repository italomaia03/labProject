package org.labProject.strategy;

public class Robot {
    private Behaviour strategy;

    public void setStrategy(Behaviour strategy) {
        this.strategy = strategy;
    }

    public void move() {
        strategy.move();
    }
}
