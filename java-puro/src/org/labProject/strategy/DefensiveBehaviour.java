package org.labProject.strategy;

public class DefensiveBehaviour implements Behaviour{
    @Override
    public void move() {
        System.out.println("It is moving defensively");
    }
}
