package basis.relection;

/**
 *@author:Stiles Yu
 *@data:2018��7��20��
 *@declaration:
 *Class��ȡ������
 *
 */
public class ClassGetName {
		
		public static void main(String[] args) {
	//��ͬ�����µ�getName����
			//������������
			String aClass=Person.class.getName();
			System.out.println(aClass);
			System.out.println("-------------------------------");
			//������������
			String aClass2=int.class.getName();
			System.out.println(aClass2);
			//�����������͵�����
			System.out.println("--------------------------------");
			String aClass3=int[][][].class.getName();
			System.out.println(aClass3);
			System.out.println("--------------------------------");
			outter outter=new outter();
			outter.main(args);
		}

}
		class outter{
		static class Inner{}
		
		public void main(String[] args) {
			Class clz= Inner.class;
			System.out.println("Inner class name:"+clz.getName());
			System.out.println("Inner class simple name:"+clz.getSimpleName());
			System.out.println("Inner class CanonicalName:"+clz.getCanonicalName());
			
		}
		
		
		
	}	
