package org.labProject;

import org.labProject.facade.Facade;
import org.labProject.singleton.SingletonEager;
import org.labProject.singleton.SingletonLazy;
import org.labProject.singleton.SingletonLazyHolder;
import org.labProject.strategy.*;


public class Test {

    public static void main(String[] args) {
        //Singleton

        SingletonLazy lazy = SingletonLazy.getInstance();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstance();
        System.out.println(lazy);

        SingletonEager eager = SingletonEager.getInstance();
        System.out.println(eager);
        eager = SingletonEager.getInstance();
        System.out.println(eager);

        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstance();
        System.out.println(lazyHolder);
        lazyHolder = SingletonLazyHolder.getInstance();
        System.out.println(lazyHolder);

        //Strategy

        Behaviour normal = new NormalBehaviour();
        Behaviour defensive = new DefensiveBehaviour();
        Behaviour aggressive = new AggressvieBehaviour();

        Robot robot = new Robot();
        robot.setStrategy(normal);
        robot.move();
        robot.move();

        robot.setStrategy(defensive);
        robot.move();

        robot.setStrategy(aggressive);
        robot.move();
        robot.move();
        robot.move();

        //Facade
        Facade facade = Facade.getInstance();
        facade.migrateClient("Italo", "12345");
    }

}
