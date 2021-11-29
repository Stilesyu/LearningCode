package designPattern.simpleFactoryPattern;

/**
 *@authorStiles Yu
 *@data:2018��8��4��
 *@declaration:
 *�ӷ�
 *
 */
public class OperationAdd extends Operation{
	
	
	public int getResult() {
		int numA=super.getNumA();
		int numB=super.getNumB();	
		return numA+numB;
	}
	
		
}
