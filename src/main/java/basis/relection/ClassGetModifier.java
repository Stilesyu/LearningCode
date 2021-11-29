package basis.relection;

import java.lang.reflect.Modifier;

/**
 *@authorStiles Yu
 *@data:2018��7��20��
 *@declaration:
 *Class��ȡ���η�
 *
 */
public class ClassGetModifier {
	public static void main(String[] args) {
		System.out.println("modifiers value:"+ClassGetModifier.class.getModifiers());
		System.out.println("modifiers:"+Modifier.toString(ClassGetModifier.class.getModifiers()));
	}
}
