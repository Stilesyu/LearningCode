package designPattern.strategyPattern;


/**
 *@author:Stiles Yu
 *@data:2018��7��31��
 *@declaration:
 *ִ��
 *
 */
public class Execute {
	public static void main(String[] args) {
		CrashContext context=new CrashContext(1);
		//�����
		System.out.println(context.ContextResult(300));
		//��300-100
		context=new CrashContext(2);
		System.out.println(context.ContextResult(500));
		//������
		context=new CrashContext(3);
		System.out.println(context.ContextResult(500));
	}
}
