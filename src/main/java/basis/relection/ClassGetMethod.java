package basis.relection;

import java.lang.reflect.Method;

public class ClassGetMethod {

	public static void main(String[] args) {
		try {
			Class<?> aClass=Class.forName("Relection.Person");
			Method[] dMethods=aClass.getMethods();
			for (Method method : dMethods) {
				System.out.println(method);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
