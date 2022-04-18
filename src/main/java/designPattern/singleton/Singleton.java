package designPattern.singleton;

import java.io.Serializable;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class Singleton {

    public static void main(String[] args) throws NoSuchFieldException {

    }
}

class Container implements Serializable {

    private static final long serialVersionUID = 1L;


    private final static Container instance = new Container();
    private Container(){
        if (instance != null){
            throw new RuntimeException("已存在实例，不允许创建多个");
        }
    }
    public static Container getInstance(){
        return instance;
    }
}