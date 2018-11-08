package designPattern.proxyPattern;

/**
 *@author:Stiles Yu
 *@data:2018年8月1日
 *@declaration:
 *执行类
 *
 */
public class Execute {
	public static void main(String[] args) {
		SchoolGril mm=new SchoolGril("刘亦菲");
		Proxy proxy=new Proxy(mm);
		proxy.GiveDolls();
		proxy.GiveFlowers();
		proxy.GiveChocolate();
		
		
		
	}	
	
}
