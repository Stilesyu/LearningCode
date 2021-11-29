package springlearning.spitter;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author 虞晓晨
 * @version 1.0
 * @since 2018/11/9
 * @Modifytime: 2018/11/9
 * 
 **/
@Setter
@Getter
public class Spittle {
    private final Long id;
    private final String msg;
    private final Date  time;
    private Double latitude;
    private Double longitude;


    public Spittle(String msg, Date time) {
        this(msg,time,null,null);
    }

    public Spittle(String msg, Date time, Double latitude, Double longitude) {
        this.msg = msg;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
        this.id = null;
    }

   
}
