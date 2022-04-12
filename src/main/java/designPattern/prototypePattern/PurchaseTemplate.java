package designPattern.prototypePattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class PurchaseTemplate extends Template {
    private User user;

    public PurchaseTemplate(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
