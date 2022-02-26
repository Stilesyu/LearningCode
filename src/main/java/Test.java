/**
 * @author Stiles yu
 * @since 1.0
 */
public class Test {

    /**
     * 根据对象o的起始地址+偏移量offset获取需要需要需要字段的值
     * 如果该值=对象expected的地址，则执行更新操作，返回true
     * 如果该值!=对象expected的地址，直接返回false
     *
     * @param o        要修改字段的对象
     * @param offset   要修改值的字段的偏移量
     * @param expected 期望值
     * @param update   更新值
     */
    public final native boolean compareAndSwapObject(Object o, long offset, Object expected, Object update);

    /**
     * 同上一个方法类似，唯一不同的是期望值和修改值是基本类型int
     *
     * @param o        要修改字段的对象
     * @param offset   要修改值的字段的偏移量
     * @param expected 期望值
     * @param update   更新值
     */
    public final native boolean compareAndSwapInt(Object o, long offset, int expected, int update);

    /**
     * 同上一个方法类似，唯一不同的是期望值和修改值是基本类型long
     *
     * @param o        要修改字段的对象
     * @param offset   要修改值的字段的偏移量
     * @param expected 期望值
     * @param update   更新值
     */
    public final native boolean compareAndSwapLong(Object o, long offset, long expected, long update);

    public static int a = 1;

    public static void main(String[] args) {
        Thread A = new Thread(() -> a = a + 1);
        Thread B = new Thread(() -> System.out.println(a));
        A.start();
        B.start();
    }




}
