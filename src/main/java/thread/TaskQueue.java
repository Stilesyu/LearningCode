package thread;

import java.util.ArrayList;
import java.util.List;

public class TaskQueue {


    List<String> queue = new ArrayList<>();

    public synchronized void addTask(String task) {
        queue.add(task);
    }

    public synchronized String getTask() {
        while (queue.isEmpty()) {
        }
        return queue.remove(0);
    }




}
