package designPattern.prototypePattern;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;



/**
 * @author Stiles yu
 * @since 1.0
 */
public abstract class Template {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        PurchaseTemplate template = new PurchaseTemplate(new User());
        PurchaseTemplate copy = (PurchaseTemplate) template.clone();
        //BigDecimal的hashcode（）是通过
        System.out.println(template.getUser());
        System.out.println(copy.getUser());
    }
}

