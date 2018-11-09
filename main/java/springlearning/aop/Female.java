package springlearning.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
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
public class Female {

    @Around("execution(* springlearning.aop.Person.say(..))")
    public void perfume(ProceedingJoinPoint pj){
        try {
            System.out.println("Look!There is a superman");
            pj.proceed();
            System.out.println("Wow!We will have a wonderful night!");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
