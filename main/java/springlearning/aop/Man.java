package springlearning.aop;

import org.springframework.stereotype.Component;

/**
 * @author: 虞晓晨
 * @version：
 * @createtime: 2018/11/8
 * @Modifytime: 2018/11/8
 * @Description: 男人
 **/

@Component
public class Man implements Person{

    @Override
    public void say(String hero) {
        System.out.println("My name is "+hero+" and I like girl");
    }
}
