package basis.enumertation;


/**
 *@author: Stiles Yu
 *@data: 2018年7月19日
 *@declaration:
 *枚举的进阶
 *
 */
public enum AdvancedEnumertation {

	FIRST{
		public String getInfo() {
			return "FIRST TIME";

		}
	},
	SECOND{
		public String getInfo() {
			return "SECOND TIME";
		}
	};

	/**
	 * 定义了抽象方法
	 */
	public abstract String getInfo();


	public static void main(String[] args) {
		System.out.println("F:"+AdvancedEnumertation.FIRST);
		System.out.println("S:"+AdvancedEnumertation.SECOND);

	}

}
