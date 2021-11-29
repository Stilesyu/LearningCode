package designPattern.decoratorPattern;


/**
 *@authorStiles Yu
 *@data:2018��7��24��
 *@declaration:
 *������˶���
 *������һ������Ķ���Ҳ���Ը��������
 *���һЩְ��
 *
 */
public class ConcretePerson implements Person{

	private String name;
	
	//�޲ι���
	public ConcretePerson() {
		// TODO Auto-generated constructor stub
	}
	
	//�вι���
	public ConcretePerson(String name) {
		this.name=name;
	}
	//�ӿڵķ���
	@Override
	public void show() {
		System.out.println("װ���"+name);
		
	}

		
			
}
