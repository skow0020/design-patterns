package designPatterns;

import designPatterns.Adapter.BirdAdapter;
import designPatterns.Adapter.PlasticToyDuck;
import designPatterns.Adapter.Sparrow;
import designPatterns.Adapter.ToyDuck;
import designPatterns.Builder.Student;
import designPatterns.Decorator.BasicCar;
import designPatterns.Decorator.Car;
import designPatterns.Decorator.LuxuryCar;
import designPatterns.Decorator.SportsCar;
import designPatterns.Factory.Computer;
import designPatterns.Factory.ComputerFactory;
import designPatterns.Observer.*;
import designPatterns.Singleton.EagerSingleton;
import designPatterns.Singleton.LazySingleton;
import designPatterns.Strategy.CreditCardStrategy;
import designPatterns.Strategy.Item;
import designPatterns.Strategy.PaypalStrategy;
import designPatterns.Strategy.ShoppingCart;
import designPatterns.State.Package;

public class DesignPatterns{
    public static void main(String[] args){
        // Eager Singleton
        System.out.println("HELLO WORLD");
        EagerSingleton eager = EagerSingleton.getInstance();
        System.out.println(eager.runSomething());
        System.out.println(EagerSingleton.runSomething());
        EagerSingleton eager2 = EagerSingleton.getInstance();
        System.out.println(eager2.runSomething());

        // Lazy singleton
        LazySingleton lazy = LazySingleton.getInstance();
        System.out.println(lazy.runSomething());

        // Factory
        Computer pc = ComputerFactory.getComputer("pc","2 GB","500 GB","2.4 GHz");
        Computer server = ComputerFactory.getComputer("server","16 GB","1 TB","2.9 GHz");
        Computer pc2 = ComputerFactory.getComputer("pc","6 GB","1000 GB","3.6 GHz");
        System.out.println("Factory PC Config::"+pc);
        System.out.println("Factory Server Config::"+server);
        System.out.println("Factory PC2222 Config::"+pc2);

        pc2.smash();
        server.smash();

        // Strategy
        ShoppingCart cart = new ShoppingCart();

        Item item1 = new Item("1234",10);
        Item item2 = new Item("5678",40);

        cart.addItem(item1);
        cart.addItem(item2);

        cart.pay(new PaypalStrategy("myemail@example.com", "mypwd"));

        cart.pay(new CreditCardStrategy("Pankaj Kumar", "1234567890123456", "786", "12/15"));

        // Observer
        MessageSubscriberOne s1 = new MessageSubscriberOne();
        MessageSubscriberTwo s2 = new MessageSubscriberTwo();
        MessageSubscriberThree s3 = new MessageSubscriberThree();

        MessagePublisher p = new MessagePublisher();

        p.attach(s1);
        p.attach(s2);

        p.notifyUpdate(new Message("Hello I am awesome"));   //s1 and s2 will receive the update

        p.detach(s1);
        p.attach(s3);

        p.notifyUpdate(new Message("THe bloody tea is amazing")); //s2 and s3 will receive the update

        // Builder
        Student student1 = Student.Builder.newInstance()
                .setId(1)
                .setName("Ram")
                .setAddress("Noida")
                .build();

        Student student2 = Student.Builder.newInstance()
                .setId(2)
                .setName("Ramis")
                .setAddress("Noidalto")
                .build();

        System.out.println(student1);
        System.out.println(student2);

        // Adapter

        Sparrow sparrow = new Sparrow();
        ToyDuck toyDuck = new PlasticToyDuck();

        // Wrap a bird in a birdAdapter so that it
        // behaves like toy duck
        ToyDuck birdAdapter = new BirdAdapter(sparrow);

        System.out.println("Sparrow...");
        sparrow.fly();
        sparrow.makeSound();

        System.out.println("ToyDuck...");
        toyDuck.squeak();

        // toy duck behaving like a bird
        System.out.println("BirdAdapter...");
        birdAdapter.squeak();

        // State
        Package pkg = new Package();

        pkg.getState().printStatus();
        pkg.nextState();
        pkg.getState().printStatus();
        pkg.nextState();
        pkg.getState().printStatus();

        // Decorator
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");

        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }
}
