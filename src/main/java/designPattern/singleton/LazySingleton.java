package designPattern.singleton;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class LazySingleton {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println(Container.getInstance());
        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        thread.start();
        thread1.start();
    }
}

class Container {

    private Container() {
    }

    private final static class ContainerHolder {
        private static volatile Container instance = new Container();
    }

    public static Container getInstance() {
        return ContainerHolder.instance;
    }
}
