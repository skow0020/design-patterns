package designPatterns.Observer;

import designPatterns.Observer.Message;
import designPatterns.Observer.Observer;

public interface Subject
{
    public void attach(Observer o);
    public void detach(Observer o);
    public void notifyUpdate(Message m);
}
