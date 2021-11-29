package designPattern.simpleFactoryPattern;

/**
 *@authorStiles Yu
 *@data:2018��8��4��
 *@declaration:
 *������
 *
 */
public class CreatOperator {
	Operation operation;

	public int returnResult(String Algorithm,int numA,int numB) {
		
		switch (Algorithm) {
		case "+":
			operation=new OperationAdd();
			operation.setNum(numA, numB);
			return operation.getResult();
		case "-":
			operation=new OperationSub();
			operation.setNum(numA, numB);
			return	operation.getResult();
			
		case "*":
			operation=new OperationMul();
			operation.setNum(numA, numB);
			return operation.getResult();
			default:
			return 0;
		
		}
		
		
	
	}
	
}
  