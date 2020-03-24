package ex03operator;

public class E04LogicOperator {
	/*
	 * 논리연산자: 
	 * &&: 논리AND,양쪽모두가 true일떼만 TRUE를 반환하고
	 * 나머지는 false를 반환한다.
	 * ||: 논리OR,한쪽만 TRUE이면 TRUE를 반환하고 양쪽모두 false일떄 False를 반환한다.
	 * ! : 논리 not, 반대의 논리를 반환
	 */

	public static void main(String[] args) {
		int num1 = 10, num2 = 20;

		boolean result1 = (num1 == 100 && num2 == 20);//f AND t = FALSE 
		boolean result2 = (num1 < 12 || num2 >= 30);//T OR F = TRUE

		System.out.println("result1의 결과:" + result1);
		System.out.println("result2의 결과:" + result2);
		//NUM1과 NUM2가 다를때 TRUE를 반환한다. 따라서 IF구문 실행됨
		if (!(num1 == num2)) {
			System.out.println("num2과 num1은 다르다.");
		} else {
			System.out.println("둘은 같다.");
		}
	}

}
