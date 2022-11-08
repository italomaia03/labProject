package org.labProject.singleton;

//possibly the safest way of implementing singleton.

public class SingletonLazyHolder {
    private static class Holder{
        public static SingletonLazyHolder instance = new SingletonLazyHolder();
    }

    private SingletonLazyHolder(){
        super();
    }

    public static SingletonLazyHolder getInstance(){
        return Holder.instance;
    }
}
