package ex05method;

import java.util.Scanner;

public class E05MethodType04_2
{

	public static void main(String[] args)
	{
		int maxValue1 = returnMaxNumber(4);
		System.out.println("최댓값1 : " + maxValue1);

		int maxvalue2 = returnMaxNumber(6);
		System.out.println("최댓값2" + maxvalue2);
	}

	static int returnMaxNumber(int numberCnt)
	{
		Scanner scanner = new Scanner(System.in);

		int maxVal = 0;// 최댓값 저장할 변수
		for (int i = 1; i <= numberCnt; i++)
		{
			System.out.print("정수를 입력하시오:");
			int inputNum = scanner.nextInt();

			if (i == 1)
			{// 입력받은 숫자중 첫번째입력값을 기준값으로 설정한다
				maxVal = inputNum;

			} else
			{// 두번째 입력값부터 maxVal과 비교한다
				if (maxVal < inputNum)
				{
					/*
					 * 만약maxVal보다 입력값이 더 크면 입력값으로 교체한다
					 */ maxVal = inputNum;
				}
				// maxVal이 더 크다면 기존값을 유지하면 되므로 else는 필요없다 ㅇㄹㅇㄹㅇㄹㅇㄹㅇㄹㅇㄹ
			}
		}
		return maxVal;
	}

}
