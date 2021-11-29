package algorithm.basis;

/**
 *@authorStiles Yu
 *@data:2018年7月19日
 *@declaration:
 *判断一个数是不是素数(不能被1和它本身整除）
 *false不是素数，true是素数
 */
public class IsPrime {
	/**常规方法：一个数从2一直除到它本身-1*/
	private static boolean conventional(int num) {
		if (num<2)
			return true;

		for(int i=2;i<num;i++) {
			if (num%i==0)  return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(conventional(21));
	}


}
