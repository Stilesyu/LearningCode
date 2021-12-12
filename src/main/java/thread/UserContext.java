package thread;

public class UserContext implements AutoCloseable {

    static final ThreadLocal<String> ctx = new InheritableThreadLocal<>();

    public UserContext(String user) {
        ctx.set(user);
    }

    public static String currentUser() {
        return ctx.get();
    }

    @Override
    public void close() throws Exception {
        ctx.remove();
    }
}
