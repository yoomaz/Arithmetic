package q02;

import q03.Find;

public class SingletonClass {

    private SingletonClass() {}

    private static class SingletonClassHolder {
        private static final SingletonClass singletonClass = new SingletonClass();
    }

    public static SingletonClass getInstance() {
        return SingletonClassHolder.singletonClass;
    }
}
