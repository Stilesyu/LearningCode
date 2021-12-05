//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import springlearning.aop.*;
//
//import javax.annotation.Resource;
//
///**
// * @author 虞晓晨
// * @version 1.0
// * @since 2018/11/8
// * @Modifytime: 2018/11/8
// *
// **/
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
//public class AopTest {
//    @Autowired
//    private Person person;
//
//    @Test
//    public void test(){
//    person.say("JJ");
//    }
//
//    @Test
//    public void test1(){
//        Person person = PersonProxyFactory.getAuthInstance();
//        person.say("JJ");
//        System.out.println(person.getClass());
//    }
//
//    @Test
//    public void test2(){
//          Behavior behavior = (Behavior)person;
//          behavior.shit();
//
//    }
//
//
//}
