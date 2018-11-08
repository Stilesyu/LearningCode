package designPattern.simpleFactoryPattern;

/**
 *@author:Stiles Yu
 *@data:2018��8��4��
 *@declaration:
 *ִ����
 *
 */
public class Execution {
			public static void main(String[] args) {
				Operation operation=new Operation();
				CreatOperator creatOperator=new CreatOperator();
				System.out.println(creatOperator.returnResult("*",10,20));
				
			}
			
}
