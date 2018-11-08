package designPattern.simpleFactoryPattern;

/**
 *@author:Stiles Yu
 *@data:2018��8��4��
 *@declaration:
 *������ӿ��ࣨ���ࣩ
 *
 */
public class Operation {
	private int numA;
	private int numB;
	
    public void setNum(int numA,int numB) {
    	this.numA=numA;
    	this.numB=numB;
    }
    
    public int getNumA() {
    	return numA;
    }
	
	public int getNumB() {
		return numB;
	}
	public int getResult() {
			
		return 0;
	}
}
