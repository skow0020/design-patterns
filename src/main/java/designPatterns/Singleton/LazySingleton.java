package designPatterns.Singleton;

public class LazySingleton {
    private static LazySingleton instance = null;
    private static String asdf;

    private LazySingleton()
    {
        System.out.println("Singleton being initialized");
        asdf = "lazy lazy";
    }

    public static LazySingleton getInstance()
    {
        if(instance == null)
            instance = new LazySingleton();
        return instance;
    }

    public static String runSomething() {
        return asdf;
    }
}
