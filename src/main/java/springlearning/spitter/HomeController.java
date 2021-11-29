package springlearning.spitter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 虞晓晨
 * @version 1.0
 * @since 2018/11/9
 * @Modifytime: 2018/11/9
 * 
 **/

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String home(){
        return "home";
    }



}
