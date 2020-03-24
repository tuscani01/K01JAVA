package ex04controlstatement;

import java.util.Scanner;

/*
 * switch문
 * if믄처럼 조건에 따라 분기하는 제어문으로 정수식의 값과 덩일한 부분을 찾아 실헹하는 형태를 가지고 있다
 * 
 * 형식]
 * swich(){
 * 	case 값1:
 * 		실헹문 1; break;
 * 	case 값2:
 * 		실헹문2; break;
 * 	default:
 *  
 */
public class E02Swich
{

	public static void main(String[] args)
	{
		/*
		 * Scanner 클래스 : JDK5.0부터 클래스로 키보드를 텅해 사용자로부터 값을 입렷받을때 사용한다. nextLine(): 문자열
		 * 입력받음 nextInt() : 정수를 입력받음
		 */

		Scanner scanner = new Scanner(System.in);
		System.out.println("숫자를 입력:");
		int iNum = scanner.nextInt();
		System.out.println("입력숫자는 :" + iNum);

		int remain = iNum % 3;

		switch (remain)
		{
		case 0:
			System.out.println("니머지 0");
			break;

		case 1:
			System.out.println("니머지 1");
			break;

		default:
			System.out.println("나머지 2");
		}
		/*
		 * Swich문 사용시 주의 사항 -long 타입의 변수는 사용이 불가능 \byte/short/int/char/string만 사용 가능
		 * -논리식도 사용이 불가능
		 */
//		long in = 100;
//		switch (in){
//		
//		case 100:
//		System.out.println("long타입?");
//		
//		default:
//			System.out.println("안됨");
//
//	}
//	switch(iNum%3 == 0) {
//	System.out.println("논리식 안됨");
//	}

		/* 
		 * 문자열이나 문자는 SWitch문에서 사용가능
		 */
		String title = "자바";
		switch (title)
		{
		case "자바":
			System.out.println("자바좋아");
			break;
		case "JAVA":
			System.out.println("JAVA좋아");
			break;
		}
		/*
		 * 여러 case를 동시에 초리할때 break문없이 case를 나열한다
		 * if문에서 ||로 여연결한것과 동일
		 */
		int season = 4;
		switch (season)
		{
		case 3:
		case 4:
		case 5:
			System.out.println("봄");
			break;
		case 10:
			System.out.println("가을");
		case 6:
		case 7:
		case 8:
		case 9:
			System.out.println("여름");
		case 11:
		case 12:
		case 1:
		case 2:
			System.out.println("겨울");
		}

	}
}
