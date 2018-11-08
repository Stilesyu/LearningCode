package basis.relection;

import java.lang.reflect.Field;

/**
 *@author:Stiles Yu
 *@data:2018年7月20日
 *@declaration:
 *反射获取Field
 *
 */
public class ClassGetField {
	public static void main(String[] args) {
		try {
			Class<?> aClass=Class.forName("Relection.Person");
			Field[] fields=aClass.getFields();
			for (Field field : fields) {
				System.out.println(field);
			}
			System.out.println(aClass.getField("city"));
			System.out.println("------------------------------");
			Field[] fields2=aClass.getDeclaredFields();
			for (Field field : fields2) {
				System.out.println(field);
				System.out.println(field.getGenericType());
			}



		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
