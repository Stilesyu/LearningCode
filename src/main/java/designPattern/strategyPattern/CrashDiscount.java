package designPattern.strategyPattern;

/**
 *@authorStiles Yu
 *@data:2018��7��31��
 *@declaration:
 *����
 *
 */
public class CrashDiscount implements Strategy{

	//�ۿ�
	private float discount;
	//����
	private float crash;
	
	//���췽��
	public CrashDiscount(float discount) {
			this.discount=discount;
	}

	@Override
	public float acceptCrash(float crash) {
		return discount*crash;
	}
	
	
	

		
	
	
}
