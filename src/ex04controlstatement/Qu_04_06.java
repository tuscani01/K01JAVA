package ex04controlstatement;

public class Qu_04_06
{/*
	 * 문제1] 다음과 같은 모양을 출력하는 프로그램을 while문으로 작성하시오. 파일명 : Qu_04_06.java 출력]
	 *
	 * * * * * * * * * * *
	 */

	public static void main(String[] args)
	{
		int i = 1;
		while (i <= 5)
		{
			int j = 1;
			while (j <= i)//5로 해도됨
			{
				//j는 i의 갯수만큼 출력한다
				//if(i>=j) {
					System.out.print("* ");
			//}
				j++;
			}
			System.out.println();

			i++;
		}

	}

}
