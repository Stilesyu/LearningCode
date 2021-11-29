package designPattern.proxyPattern;

/**
 *@authorStiles Yu
 *@data:2018年8月1日
 *@declaration:
 *追求者
 *被代理对象
 */
public class Pursuit implements Givegift{
	
	
	private SchoolGril mm;
	
	public Pursuit(SchoolGril mm) {
		this.mm = mm;
	}

	@Override
	public void GiveDolls() {
		System.out.println(mm.getName()+"送你娃娃");
	}

	@Override
	public void GiveFlowers() {
		System.out.println(mm.getName()+"送你鲜花");
	}

	@Override
	public void GiveChocolate() {
		System.out.println(mm.getName()+"送你巧克力");
	}
	
}
