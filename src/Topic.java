package test.src;
// name: Ran Gedamo
// ID : 205386626

import java.util.HashSet;
import java.util.Set;

public class Topic {
    public final String name;
    private final Set<Agent> subscribers = new HashSet<>();

    Topic(String name) {
        this.name = name;
    }

    public void subscribe(Agent a) {
        subscribers.add(a);
    }

    public void unsubscribe(Agent a) {
        subscribers.remove(a);
    }

    public void publish(Message m) {
        for (Agent subscriber : subscribers) {
            subscriber.callback(name, m);
        }
    }
}