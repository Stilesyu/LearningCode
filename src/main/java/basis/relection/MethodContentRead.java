package basis.relection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 *@authorStiles Yu
 *@data:2018��7��20��
 *@declaration:
 *
 *
 */
public class MethodContentRead {
		public static void main(String[] args) {
			Person person=new Person();
			Class<?> aClass=person.getClass();
			Method method[]=aClass.getDeclaredMethods();
			for (Method method2 : method) {
				System.out.println("Method Name:"+method2.getName());
				Parameter[] parameters=method2.getParameters();
				//��ȡ�����Ĳ������ͣ�Method����ķ�����
				System.out.println("----------------------------");
				Class<?>[] paratype=method2.getParameterTypes();
				for (Class<?> method3 :paratype) {
					System.out.println(method3);
				}
				//��ȡ����ֵ����
				Class<?> typetrun=method2.getReturnType();
			
					System.out.println(typetrun);
				
				//��ȡ�����Ĳ�������
				for (Parameter method3 : parameters) {
					System.out.println(method3.getType());
				}
		
		}
		
		
		}
}
