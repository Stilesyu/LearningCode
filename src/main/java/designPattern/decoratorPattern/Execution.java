package designPattern.decoratorPattern;

/**
 *@authorStiles Yu
 *@data:2018��7��24��
 *@declaration:
 *��Ŀ��ִ����
 *
 */
public class Execution {  
	public static void main(String[] args) {
		
		ConcretePerson person=new ConcretePerson("����");
		System.out.println("��һ��װ��");
		BigTrouser bigTrouser=new BigTrouser();
		Brokenshoes brokenshoes=new Brokenshoes();
		Tshirts tshirts=new Tshirts();
		
		bigTrouser.Decorate(person);
		tshirts.Decorate(bigTrouser);
		brokenshoes.Decorate(tshirts);
		brokenshoes.show();
		
		
		
		
		
		
	}
}
