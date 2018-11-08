package basis.relection;

import java.lang.reflect.Field;

public class FieldContentRead {
	public static void main(String[] args) {
		Son son=new Son();
		son.toy=10;
		System.out.println("son.toy:"+son.toy);
		Class aClass=Son.class;
		try {
		Field field=aClass.getDeclaredField("car");
		field.setAccessible(true);
		System.out.println(field);
		String ra=(String)field.get(son);
		System.out.println(ra);
		field.set(son, "BMW");
		System.out.println((String)field.get(son  ));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
