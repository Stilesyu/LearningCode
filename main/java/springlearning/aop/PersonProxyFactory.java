package springlearning.aop;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author: 虞晓晨
 * @version：
 * @createtime: 2018/11/8
 * @Modifytime: 2018/11/8
 * @Description:
 **/

public class PersonProxyFactory {

    public static Person getAuthInstance(){
        Enhancer enhancer = new Enhancer();
        /*设置要代理的目标类*/
        enhancer.setSuperclass(Person.class);
        /*设置要代理的拦截器*/
        enhancer.setCallback(new AroundAdvice());
        return (Person)enhancer.create();
    }

}
