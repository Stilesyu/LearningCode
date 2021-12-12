package thread;

import java.util.ArrayList;
import java.util.List;

public class WaitThread {

    public static void main(String[] args) throws InterruptedException {
        DeliveryPlatform task = new DeliveryPlatform();
        Thread t1 = new ChiefThread(task);
        Thread t2 = new DeliveryDriverThread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("今天任务完成");
    }
}

class ChiefThread extends Thread {
    DeliveryPlatform task;

    public ChiefThread(DeliveryPlatform task) {
        this.task = task;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            String food = "pizza" + i;
            task.addTask(food);
            System.out.println("收到食物：" + food);
        }
    }
}


class DeliveryDriverThread extends Thread {
    DeliveryPlatform task;

    public DeliveryDriverThread(DeliveryPlatform task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            while (true) {
                task.delivery();
            }
        } catch (InterruptedException e) {
            System.out.println("中断异常");
        }
    }
}


class DeliveryPlatform {
    public volatile List<String> taskList = new ArrayList<>();

    public synchronized void addTask(String task) {
        taskList.add(task);
        this.notify();
    }


    public synchronized void delivery() throws InterruptedException {
        while (taskList.isEmpty()) {
            this.wait();
        }
        System.out.println("宇宙外卖正在配送食物:" + taskList.get(0));
        taskList.remove(0);
    }
}
