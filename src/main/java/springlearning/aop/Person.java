package springlearning.aop;

import org.springframework.stereotype.Component;

/**
 * @author 虞晓晨
 * @version 1.0
 * @since 2018/11/8
 *  人的行为,执行在测试类中
 **/
@Component
public interface Person {
    /**
     * behavior
     */
    void say(String name);

}
