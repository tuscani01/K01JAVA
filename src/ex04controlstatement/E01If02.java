package ex04controlstatement;

public class E01If02
{

	public static void main(String[] args)
	{
		int num = 101;
		if (num % 3 == 0)
		{
			System.out.println("짝수");
		} else
		{
			System.out.println("홀수");
		}
		/*
		 * 삼항 연산자(조건연산자) if~else문과 동일하지만 짧은 코드로 표현가능하도록
		 * 
		 * 실무에서 자주 사용되는 문장임 [형식] 변수 = (조건식) ? 참 : 거짓
		 */
		String numberResult = (num % 2 == 0) ? "짝수" : "홀수";
		System.out.println("숫자" + num + "은" + numberResult);

		/*
		 * [시나리오] 숫자를 홀/짝수인지 먼저 판단힌 후 100 이상인지를 판단하는 프로그램 if~else를 이용해 작성해라
		 */
		int num2 = 120;
		if (num2 % 2 == 0)
		{// 짝수일때...
			if (num2 > 100)
			{// 짝수면서 100보다 클때

				System.out.println("짝수이면소 100이상");
			} else
			{// 100보다 작을때
				System.out.println("짝수이면소 100미만");
			}
		}

		else
		{// 홀수일때...
			if (num2 >= 100)
			{
				System.out.println("홀수이면소 100이상");
			} else
			{
				System.out.println("홀수이면소 100이상");
			}
		}

	}

}
