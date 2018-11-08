package designPattern.proxyPattern;

/**
 *@author:Stiles Yu
 *@data:2018年8月1日
 *@declaration:
 *代理类
 *
 */
public class Proxy implements Givegift{
	private Pursuit gg;
	public Proxy(SchoolGril mm) {
			gg=new Pursuit(mm);		
	}
	@Override
	public void GiveDolls() {
			gg.GiveDolls();
		
	}
	@Override
	public void GiveFlowers() {
			gg.GiveFlowers();
	}
	@Override
	public void GiveChocolate() {
			gg.GiveChocolate();
		
	}

	
}
