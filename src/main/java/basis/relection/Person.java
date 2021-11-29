package basis.relection;

import java.util.HashMap;


/**
 *@authorStiles Yu
 *@data:2018��7��20��
 *@declaration:
 *̽���������
 *��������Ϊ����
 */
public class Person {
		
		public String country;
		public String city;
		private String name;
		private String privince;
		private Integer height;
		private Integer age;
		
		//�޲�
		public Person() {
			System.out.println("����Person���޲ι���");
		}
		
		//Country��City��Name
		@SuppressWarnings("unused")
		private Person(String country,String city,String name) {
			this.country=country;
			this.city=city;
			this.name=name;
		}
		
		//Country,age
		public Person(String country,Integer age) {
			this.country=country;
			this.age=age;
		}
		
		public void getGennericHelper(HashMap<String, Integer> hashMap) {
			
		}
		
		
		public static void main(String[] args) {
			Person person=new Person();
			System.out.println(person.getClass());
		}
	
	
}
		
