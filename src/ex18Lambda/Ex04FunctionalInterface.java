package ex18Lambda;
/*
 함수형 인터페이스
 : 람다식 구현하기 위해서 먼저 인터페이스 만들고 람다식으로 구현할 추상메소드 선언한다
 이를 람다식 만들기위한 함수형인터페이스라고한다
 
 ※함수형 인터페이스에는 오직하나의 추상메소드만 선언할수있다
 
 @FunctionalInterface
 ; 함수형 인터페이스의 조건을 갖췄는지 대한 검사를 컴파일러에게 요청하는 역할을 하는 어노테이션이다
 
 */

@FunctionalInterface
interface IKosmo4 {
	void studyLambda(String str);
	void studyLambda2(String str);
}

public class Ex04FunctionalInterface {

	/*
	 매개변수 타입이 IKosmo4를 구현한 람다식 자체를전달하여 해당함수에서 studyLambda()를
	 호출해 실행
	 */
	static void execute(IKosmo4 ko, String s) {
		ko.studyLambda(s);
	}

	public static void main(String[] args)
	{
	Ikosmo4 kosmo = (str) ->
		System.out.println("IKosmo4를 구현받아 정의한람다"+str);
	execute(kosmo, "\n람다를 매개변수로 전달");

	}
}
