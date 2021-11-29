package designPattern.facadePattern;

/**
 *@authorStiles Yu
 *@data:2018��7��24��
 *@declaration:
 *�����
 *
 */
public class Facade {
	private SubsystemA obj1=new SubsystemA();
	private SubsystemB obj2=new SubsystemB();
	
	public void Method() {
		obj1.Method();
		obj2.Method();
	}
}
