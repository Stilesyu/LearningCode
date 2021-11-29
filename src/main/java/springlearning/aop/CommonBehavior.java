package springlearning.aop;

import org.springframework.stereotype.Component;

/**
 * @author 虞晓晨
 * @version 1.0
 * @since 2018/11/8
 * 
 **/
@Component
public class CommonBehavior implements Behavior{

    @Override
    public void shit() {
        System.out.println("Everyone need to shit");
    }
}
