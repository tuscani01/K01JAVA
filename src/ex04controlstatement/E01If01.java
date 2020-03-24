package ex04controlstatement;

import java.io.IOException;

/*
 * if문(조건문,반복문)
 * 형식1
 * 	if(조건문){
 * 		실헹문1;
 * 		실헹문2;
 * 	}
   -if문의 조건은 반드시 비교식 혹은 논리식이어야한다.
   -즉 결과값이 boolean타입(true,false)이어야함
 */

public class E01If01 {

	public static void main(String[] args) throws IOException {
		// int a = System.in.read();
		int num = 10;

		/*
		 * 아래문장은 조건식이 아닌 산술식이므로 에러발생됨
		 * 
		 */
//		if(num%2) {
//			System.out.println("잘못된 조건식 입니다.");
//		}
//		if(num) {

//			System.out.println("이것도 잘못된 조건식 입니다.");
//		}

		/*
		 * if문의 조건은 아레와같이 boolean값을 반환하는 조건식이다.
		 */
		if (num % 2 == 0) {
			System.out.printf("%d는 짝수입니다.%n", num);
		}
		if (num % 2 == 0 && num >= 10) {
			System.out.printf("%d는 짝수이고 10보다 크거나 같다%n", num);
		}

		// 경우에 따라 무조건 실헹되는 if문도 필요
		if (true) {
			System.out.println("무조건 실행되는 문장");
		}

		// if(조건식);=> 조건식에 상관없이 다음 문장에 실행되는 형태로
		// 세미콜론은 문장의 끝을 나타내므로 사용에 주의해야한다.
		if (num % 2 != 0)
			;
		{
			// 위 조건과 상관없이 무조건 출력되는 문장임.
			System.out.printf("%d는 홀수입니다.%n", num);
		}
		/*
		 * 조건검사후 싱헹할 문장이 하나인 경우에는 {} 중괄호를 생략할 수 있다, 단 실행문이 2개이상인 경우에는 한문장만 실헹되므로 주의
		 */

		if (num % 2 == 0)
			System.out.printf("%d는 짝수입니다.%n", num);

		if (num % 2 != 0) {
			System.out.println("num은 " + num + "이다 ");
			System.out.println(num + "은 홀수");
		}
		/*
		 * system.in.read() 사용자에게 하나의 문자를 입력받을떄 사용하는 메소드로 입력힌 문자의 아스키토드갑ㄱ을 반환한다, 헤당 함수는
		 * IOEcption을 기본적으로 가지고 있어 이를 무시하기위해
		 */

//		System.out.printf("하나의 문자를 입력하시오 : ");
//		int asciiCode = System.in.read();
//		System.out.println("입력문자"+ asciiCode);
//		System.out.println("입력문자"+ (char)asciiCode);

		/*
		 * [시나리오] 사용자가 입력한 문자기 숫자인지 판단하는 프로그램을 if문을 이용해 구현
		 */

		System.out.printf("하나의 문자를 입력하시오: ");
		int asciiCode = System.in.read();
		/*
		 * 아스키토드값을 알고 있을때 구현방법 '0' => 48 '0' => 57이므로 헤당 구간안에 있다면 숫자로 판단할수 있다.
		 * 
		 * ※숫자의 구간을 정할때는 반드시 논리AND를 사용해야 한다.
		 */
		if (asciiCode >= 48 && asciiCode <= 57) {
			System.out.println("입력한 문자는 숫자다.");
		} else {
			System.out.println("입력한 문자가 숫자아님");
		}

		/*
		 * 아스키코드값을 모를때 구현방법 char형 문자는 메모리에 저장시 아스키코드값으로 저장되므로 아래처럼 비교연산이 가능 또한 산술연산도 가능
		 */
		boolean inNumber = (asciiCode >= '0' && asciiCode <= '9');
		if (inNumber == true) {
			System.out.println("입력문자는 숫자");
		} else {
			System.out.println("입력문자는 숫자아님");
		}
	}

}
