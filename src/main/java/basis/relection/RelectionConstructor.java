package basis.relection;

import java.lang.reflect.Constructor;

/**
 *@authorStiles Yu
 *@data:2018��7��20��
 *@declaration:
 *̽���������ķ���
 *
 */
public class RelectionConstructor {
	

		public static void main(String[] args) {
			try {
				Class<?> aClass=Class.forName("Relection.Person");
				
				Constructor<?>[] constructor=aClass.getConstructors();
				//�������������@********
				for (Constructor<?> constructor3 : constructor) {
					System.out.println(constructor3);
				}
				Constructor<?>[] constructor2=aClass.getDeclaredConstructors();
				System.out.println("-----------------------------");
				for (Constructor<?> constructor3 : constructor2) {
					System.out.println(constructor3);
				}
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		
	
	
	
	
	
	
	
	

	

}
