package ex05method;

import java.util.Scanner;

/*
 * [메소드 형식4]
 * 		매개변수도 있고, 반환값도 있는 메소드, 4가지 형식 중 가장 활용빈도가 높은 메소드 형식이다.
 */

public class E05MethodType04_1
{
	

	public static void main(String[] args)
	{
		int sumOfAge = getTotalAge(5);
		System.out.println("입력받은 나이의 합" + sumOfAge);
	}

	static int getTotalAge(int personCnt)
	{
		Scanner scanner = new Scanner(System.in);
		int sumAge = 0;

		for (int i = 1; i <= personCnt; i++)
		{
			System.out.println(i + "첫번째 사람나이");
			int age = scanner.nextInt();
			sumAge += age;
		}
		return sumAge;
	}

}
