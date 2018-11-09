package springlearning.spitter;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 虞晓晨
 * @version：
 * @createtime: 2018/11/9
 * @Modifytime: 2018/11/9
 * @Description:
 **/
@Component
public interface SpittleRepository {
    /**
     *
     * @param max Spittle最大值
     * @param count 返回多少个Spittle对象
     * @return
     */
    List<Spittle> findSpittles(Long max,int count);


}
