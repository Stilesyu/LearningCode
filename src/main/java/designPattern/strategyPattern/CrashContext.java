package designPattern.strategyPattern;

/**
 *@authorStiles Yu
 *@data:2018��7��31��
 *@declaration:
 *������
 *
 */
public class CrashContext {
			
	private Strategy strategy;

//	public CrashContext(Strategy strategy) {
//		this.strategy = strategy;
//	}
	
	public CrashContext (int i) {
		switch (i) {
		case 1:
			strategy=new CrashDiscount(0.8f);
			break;
		case 2:
			strategy=new CrashRebate(300f, 100f);
			break;
		default:
			strategy=new CrashNormal();
			break;
		}
	}
	public float ContextResult(float f) {
		return strategy.acceptCrash(f);
	}
	
	
	
	
}
