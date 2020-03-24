package ex05method;

import  java.util.Scanner;

/*
 * 메소드 형식3]
 * 매개변수는 있으나 반환값은 없는경우
 * 메소드 실헹을 위한 값을 전달받은후 연산의 결과를
 * 반환하지 않고 콘솔에 즉시 출력하는 형태의
 */
public class E04MethodType03_1
{
	/*
	 * [메소드형식3]
	 * 		매개변수는 있으나 반환값은 없는 경우
	 * 		메소드 실행을 위한 값을 전달받은 후 연산의 결과를 
	 * 		반환하지 않고 콘솔에 즉시 출력하는 형태의 프로그램에
	 * 		주로 사용됨.
	 */


	public static void main(String[] args)
	{
	 Scanner scanner = new Scanner(System.in);
	 
	 System.out.print("시작값:");
	 int s = scanner.nextInt();
	 System.out.print("종료값:");
	 int e = scanner.nextInt();
	 yesParamNoReturn(s,e);
			 
	}
	static void yesParamNoReturn(int startNum, int endNum)
	{
		/*
		 * 1에서 10까지의 합을 구하는 프로그램의 시작과 종료값만 변수로 변경하여,
		 * 해당 구간의 합을 구하는 프로그램으로 업데이트 
		 */
		int sum = 0;
		for(int i = startNum ; i<=endNum; i++) {
			sum += i;
		}
		System.out.printf("%d~%d까지의 합%d",startNum,endNum,sum);
	}
}
