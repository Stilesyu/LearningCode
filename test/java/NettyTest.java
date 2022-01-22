import com.github.hermes.ClientApplication;
import com.github.hermes.config.ClientNettyConfig;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class NettyTest {
    @Test
    public void client() throws InterruptedException {
        ClientApplication application = new ClientApplication(new ClientNettyConfig().setServerAddress("127.0.0.1").setServerPort(9607));
        application.start();
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(()->{
            System.out.println("start record");
        },0,10, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        ClientApplication application = new ClientApplication(new ClientNettyConfig().setServerAddress("127.0.0.1").setServerPort(9607));
        application.start();
    }

}