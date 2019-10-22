package designPatterns.State;

public class Package {

    private PackageState state = new OrderedState();

    // getter, setter
    public void setState(PackageState state){
        this.state = state;
    }

    public PackageState getState(){
        return this.state;
    }

    public void previousState() {
        state.prev(this);
    }

    public void nextState() {
        state.next(this);
    }

    public void printStatus() {
        state.printStatus();
    }
}