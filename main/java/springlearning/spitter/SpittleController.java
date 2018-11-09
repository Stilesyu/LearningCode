package springlearning.spitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;

/**
 * @author: 虞晓晨
 * @version：
 * @createtime: 2018/11/9
 * @Modifytime: 2018/11/9
 * @Description:
 **/
@Controller
public class SpittleController {

        private SpittleRepository spittleRepository;

    /**
     * Inject Repository
     * @param spittleRepository
     */
    @Autowired
        public SpittleController(SpittleRepository spittleRepository){
            this.spittleRepository = spittleRepository;
        }


        @RequestMapping("/Spitter")
        public String spittles(Model model){
            model.addAllAttributes(spittleRepository.findSpittles(Long.MAX_VALUE,20));
            return "spittles";
        }




}
