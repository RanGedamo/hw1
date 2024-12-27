package test.src;
// name: Ran Gedamo
// ID : 205386626

import java.util.HashMap;
import java.util.Map;

public class TopicManagerSingleton {

    private static final TopicManager instance = new TopicManager();

    private TopicManagerSingleton() {}

    public static TopicManager get() {
        return instance;
    }

    public static Topic getTopic(String name) {
        return instance.getTopic(name);
    }

    public static class TopicManager {
        private final Map<String, Topic> topics = new HashMap<>();

        public synchronized Topic getTopic(String name) {
            return topics.computeIfAbsent(name, Topic::new);
        }
    }
}