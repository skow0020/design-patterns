package designPatterns.Singleton;

public class EagerSingleton {

    private static final EagerSingleton instance = new EagerSingleton();
    private static String asdf;
    //private constructor to avoid client applications to use constructor
    private EagerSingleton(){
        asdf = "asdf";
    }

    public static EagerSingleton getInstance(){
        return instance;
    }

    public static String runSomething(){
        return asdf;
    }
}