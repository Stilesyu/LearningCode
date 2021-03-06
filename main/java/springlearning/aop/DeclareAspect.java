package springlearning.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * @author: 虞晓晨
 * @version：
 * @createtime: 2018/11/8
 * @Modifytime: 2018/11/8
 * @Description:
 **/

@Aspect
@Component
public class DeclareAspect {
    /**
     * value:目标的类
     * defaultImpl:要引入接口的实现类
     */
    @DeclareParents(value = "springlearning.aop.Person+",
            defaultImpl = CommonBehavior.class)
        public static Behavior behavior;


}
