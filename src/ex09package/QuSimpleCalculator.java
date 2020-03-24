package ex09package;
/*
 문제1) 파일명 : QuSimpleCalculator.java
기본 4칙연산을 할때마다 연산의 결과와 몇번 수행되었는지를 출력하는 계산기 클래스를 정의해보자.
아래 main함수에 부합하는 CalculatorEx 클래스를 정의하면되고 해당 수치는 임의로 바꿔도 된다.
init() 멤버메소드에서는 계산의 결과를 카운트하는 멤버변수를 0으로 초기화 한다.

문제2) 파일명 : QuTriangle.java
밑변과 높이 정보를 저장할 수 있는 Triangle클래스를 정의해보자. init메소드를 통해 밑변과 높이를 초기화한다.
그리고 밑변과 높이를 변경시킬수 있는 메소드와 삼각형의 넓이를 계산해서 반환하는 메소드도 함께 정의해보자.

메인메소드 샘플코드]
public static void main(String[] args)
{
	Triangle t = new Triangle();
	t.init(10, 17); //밑변10, 높이17로 초기화
	System.out.println("삼각형의 넓이 : " + t.getArea());
	t.setBottom(50);//밑변 50으로 변경
	t.setHeight(14);//높이 14로 변경
	System.out.println("삼각형의 넓이 : " + t.getArea());
}

실행결과]
삼각형의 넓이 : 85.0
삼각형의 넓이 : 350.0
 */

/*
 실행결과]
1 + 2 = 3.0
10.5 - 5.5 = 5.0
4.0 * 5.0 = 20.0
100 / 25 = 4.0
10.0 * 3.0 = 30.0
덧셈횟수 : 1
뺄셈횟수 : 1
곱셈횟수 : 2
나눗셈횟수 : 1
 */
class CalculatorEx 
{
//멤버변수: 연산의 횟수를 카운트할 용도로사용
	public void init() 
	{
		addVal = 0;
		minVal = 0;
		mulVal = 0;
		divVal = 0;
		
	}
		
		public double add(int n1, int n2) 
		{
			addval++; //덧셈연산횟수카운트
			return n1 + n2;
		}
		public double min(double n1, double n2) 
		{
			minVal++;
			return n1 + n2;
		}
		public double mul(double n1, double n2) 
		{
			mulVal++;
			return n1 + n2;
		}
		public double div(int n1, int n2) 
		{
			return n1 + n2;
		}
		// 연산횟수 메소드
		}

		public void showOpCount() {
			덧셈횟수 : 1
			뺄셈횟수 : 1
			곱셈횟수 : 2
			나눗셈횟수 : 1
			System.out.println("덧셈횟수: "+ addVal);
			System.out.println("뺄셈횟수: "+ minVal);
			System.out.println("곱셈횟수: "+ mulVal);
			System.out.println("나누셈횟수: "+ divVal);
		}
	}
		public class QuSimpleCalculator
		{

		public static void main(String[] args)
		{
			CalculatorEx cal = new CalculatorEx();
			cal.init();
			System.out.println("1 + 2 = " + cal.add(1 , 2));
			System.out.println("10.5 - 5.5 = " + cal.min(10.5 , 5.5));
			System.out.println("4.0 * 5.0 = " + cal.mul(4.0 , 5.0));
			System.out.println("100 / 25 = " + cal.div(100 , 25));
			System.out.println("10.0 * 3.0 = " + cal.mul(10.0 , 3.0));
			cal.showOpCount();

	}
}
