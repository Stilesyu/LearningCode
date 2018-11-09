package springlearning.spitter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: 虞晓晨
 * @version：
 * @createtime: 2018/11/9
 * @Modifytime: 2018/11/9
 * @Description:
 **/

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }



}
