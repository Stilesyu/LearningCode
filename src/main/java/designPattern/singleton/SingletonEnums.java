package designPattern.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Stiles yu
 * @since 1.0
 */
public enum SingletonEnums {
    START,
    END
}

class Test{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<SingletonEnums> singletonEnumsClass = SingletonEnums.class;
        Constructor<SingletonEnums> constructor = singletonEnumsClass.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        constructor.newInstance("START",0);

    }
}