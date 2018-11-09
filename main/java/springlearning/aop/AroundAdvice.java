package springlearning.aop;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: 虞晓晨
 * @version：
 * @createtime: 2018/11/8
 * @Modifytime: 2018/11/8
 * @Description: 使用CGLIB实现一个拦截器
 **/

public class AroundAdvice implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Simulate start transaction before execute target method");
        Object rvt = methodProxy.invokeSuper(o,objects);
        System.out.println("Simulate end transaction after execute target method");
        return rvt+"this is new content";
    }
}
