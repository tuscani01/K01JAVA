package ex18Lambda;

/*
람다식(Lambda expression)
: 객체지향에서 메소드 사용하기 위해서 반드시 클래스 정의한후 메소드를 선언해야한다
이런 불편함은 최근 함수형프로그래밍(Functional Programming)의 장점이 보였고
단점을 고치기위해 JDK1.8부터 지원했다
 */

interface IKosmo3
{
	
	void studyLambda(String str);

public class E01Nomalclass
{

	public static void main(String[] args)
	{
	/*
	 2번예제 익명클래스를 람다식으로 표현하면 아래와같다
	 */
	IKosmo3 kosmo1 = (String str) -> {
		System.out.println(str +"을드디어 썼다");
	};
	kosmo1.studyLambda("람다식");
	
	/*
	 위 람다식을 아래같이 한번더 줄이는게 가능하다
	 -매개변수 타입 예상할수 있다면 생략가능
	 -매개변수가 하나라면 소괄호 생략가능
	 -실행할 문장이 하나이고 동시에 return문이 아니라면 중괄호생략가능
	 */
	IKosmo3 kosmo2 = str -> System.out.println(str+" 완전간단");
	kosmo2.studyLambda("람다식");
	
	
	
	
	}
}
