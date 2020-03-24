package ex02variable;

public class E04StringType {

	public static void main(String[] args) {
		int number;
		number = 99;
		
		/*
		 * string형: 참조형 변수로써 기본자료형이 아님.
		 *  문자열을 저장할수 있는 데이터타입으로 실재로는 class이다.
		 *   자바에서는 문자열을 표현할때 "으로 감싸면되고, 연결할떄 +기호를 사용한다.
		 */
		 
		//int stringNumber1 = (int)"100";
		//String stringNumber =(string) "100";
		
		/*
		 * 참조형변수와 기본자료형변수 사이에는 형변횐이 불가능하다
		 * 서로 사용하는 메모리공간이 다르기 때문이다.
		 *  기본자료형-> 스택영역
		 *  참조형 -> 힙영역
		 */
		
		/*
		 * 문자열 + 정수 => 문자열
		 * 즉 문자열에 정수가 연결된 형태로 출력된다.
		 */
		
		String strNumber = "100";
		System.out.println(strNumber + number);
		
		/*
		 * String은 클래스이므로 new키워드를 이용해서 인스턴스(객체)를 생성한후 문자열을 참조한다.
		 */
		
		String newString = new String("new 키워드 사용");
		System.out.println(newString);
		
		String stringBasic = "클래스지만";
		String plusString = "기본 자료형초롬 사용";
		System.out.println(stringBasic + plusString);
		
		/*
		 * 문자열 +숫자=> 우선순위가 없다면 일반적으로 문자욜로 출력한다.
		 * 단, 산술연산의 결과를 출력하고 싶다면 아래와 같이 소괄호를 이용해서
		 * 우선순위에 대한 변화를 주면 된다.
		 */
		
		int kor = 100, eng=99, math=98;
		System.out.println("총점:" +kor+eng+math);
		System.out.println("총점:"+(kor+eng+math));

	}

}
