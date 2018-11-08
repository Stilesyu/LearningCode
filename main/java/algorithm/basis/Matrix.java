package algorithm.basis;
/**
 *  @author stilesyu
 *  @CreateTime 2018年7月17日
 *  @decription 矩阵相乘算法	a[][]*b[][]=c[][]
 */
public class Matrix {
	public static void main(String[] args) {
		int a[][]= {{1,1},{2,2}};
		int b[][]= {{2,2},{3,3}};
		//获取二维数组c的行长度
		int row=a.length;
		//获取二维数组c的列长度
		int col=b[0].length;
		//获取二维数组a的列，同时也是b的行
		int col1=a[0].length;
		//c的行数和a的行数相同，c的列数和b的列数相同
		int [][] c=new int[row][col];

		//遍历C的行，同时也是a的行
		for(int i=0;i<row;i++) {
			//遍历C的列，同时也是b列
			for(int j=0;j<col;j++) {
				//遍历a的列，同时也是b的行
				for(int k=0;k<col1;k++) {
					c[i][j]+=a[i][k]*b[k][j];
				}
			}
		}
		for(int i=0;i<c.length;i++) {
			for(int j=0;j<c[0].length;j++) {
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
	}








}
