package designPattern.strategyPattern;

/**
 *@authorStiles Yu
 *@data:2018��7��31��
 *@declaration:
 *������Ͷ��ٴ��۷���
 *��300-rebate
 */
public class CrashRebate implements Strategy{

	private float crash;
	private float rebate;

	//���췽��,��crash������rebate
	public CrashRebate(float crash, float rebate) {
		super();
		this.crash = crash;
		this.rebate = rebate;
	}
	@Override
	public float acceptCrash(float acptcrash) {
		if (acptcrash>crash) {
			return acptcrash-rebate;
		}
		return crash;
	}
	
	


}
