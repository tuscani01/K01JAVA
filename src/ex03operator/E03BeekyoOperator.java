package ex03operator;

public class E03BeekyoOperator {

	/*
	 * 비교연산자
	 * : 좌우측항의 값이 크거나 , 같거나 한지 비교는 연산자
	 */
	public static void main(String[] args) {
		int num1 = 10, num2 = 20;

		/*
		 * num1클때 참을 반환하므로, 아레조건은 거짓이다.
		 * else구문이 실행된다.
		 */
		if (num1 > num2) {
			System.out.println("num1이 더 큽니다.");
		} 
		else {
			System.out.println("num2이 더 큽니다.");
		}
		/*
		 * num1과num2가 다를때 참을 반환하고 아레조건은 참이된다.
		 * if구문이 실헹된다.
		 */
		if (num1 != num2) {
			System.out.println(" 이둘은 다름");
		} 
		else {
			System.out.println(" 이둘은 같음");
		}
	}

}
