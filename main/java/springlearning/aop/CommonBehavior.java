package springlearning.aop;

import org.springframework.stereotype.Component;

/**
 * @author: 虞晓晨
 * @version：
 * @createtime: 2018/11/8
 * @Modifytime: 2018/11/8
 * @Description:
 **/
@Component
public class CommonBehavior implements Behavior{

    @Override
    public void shit() {
        System.out.println("Everyone need to shit");
    }
}
