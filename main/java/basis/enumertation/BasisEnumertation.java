package basis.enumertation;

import java.util.Arrays;

/**
 *@author: Stiles Yu
 *@data: 2018年7月19日
 *@declaration:
 * 枚举的方法示例基础
 *
 */
public class BasisEnumertation {

	public static void main(String[] args) {

		Week week[]=new Week[] {Week.MONDAY,Week.TUESDAY,
				Week.WEDNESDAY,Week.THURSDAY,Week.FRIDAY,
				Week.SATURDAY,Week.SUNDAY};
//test ordinal method(oprdinal用于枚举变量在枚举类中声名的顺序)
		for(int i=0;i<week.length;i++) {
			System.out.println("Day["+i+"].ordinal():"
					+week[i].ordinal());
		}
		System.out.println("--------------------------------------");
//test compareTo method(compareTo是根据每个枚举的ordinal值大小进行比较的)
		System.out.println("week[0].compareTo(week[1]):"+week[5].compareTo(week[1]));
		System.out.println("--------------------------------------");
//test getDeclaringclass() 返回与此枚举常量的枚举类型相对应的Class对象,也可以
//通过getClass方法
		Class<?> clazz=week[0].getDeclaringClass();
		System.out.println("clazz:"+clazz);
		System.out.println("--------------------------------------");
//test name method 返回此枚举的名称
		System.out.println("Today is:"+week[0].name());
		System.out.println("Tomorrow is:"+week[1].name());

//测试枚举的values和valueOf方法
//values()方法的作用就是获取枚举类中的所有变量，并作为数组返回
//valueOf(String name)方法与Enum类中的valueOf类似，根据名称获取枚举变量
		System.out.println("--------------------------------------");
		Week day[]=Week.values();
		System.out.println("day:"+Arrays.toString(day));
		Week day1=Week.valueOf("MONDAY");
		System.out.println("day is:"+day1);


	}
}

enum Week{
	MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,
	SUNDAY
}