package designPattern.decoratorPattern;

/**
 *@author:Stiles Yu
 *@data:2018��7��24��
 *@declaration:
 *������
 *װ������󣬼̳���Person
 *����������չPerson��������
 *Person��˵��������֪��Finery�Ĵ��ڵ�
 *
 */
public class Finery implements Person{
	
	protected Person person;

	//���
	public void Decorate(Person person) {
		this.person=person;
	}
	//չʾ
	@Override
	public void show() {
		if (person!=null) {
		person.show();	
		}
	}
	
	
}