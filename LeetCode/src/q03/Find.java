package q03;

public class Find {

    private Find() {}

    private static class SingletonClassHolder {
        private static final Find singletonClass = new Find();
    }

    public static Find getInstance() {
        return SingletonClassHolder.singletonClass;
    }
}
