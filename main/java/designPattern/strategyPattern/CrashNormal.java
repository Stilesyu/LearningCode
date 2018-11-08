package designPattern.strategyPattern;

/**
 *@author:Stiles Yu
 *@data:2018��7��31��
 *@declaration:
 *������ȡ
 *
 */
public class CrashNormal implements Strategy{
			
	private float normal;
	
	

	@Override
	public float acceptCrash(float crash) {
		return crash;
	}

	
	
	
	
	
}
