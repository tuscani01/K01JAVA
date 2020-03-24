package ex11static;
/*
 정적변수(Static variable)
 -멤버변수앞에 static지정자가 붙으면 정적변수가된다
 -정적변수는 JVM(자바가상머신)에의해 프로그램이 로드되는 시점에 초기화
 -main메소드가 실행되기전 이미 초기화되므로 main메소드 실행시 별도 선언없이
 변수 사용할수있다
 
 접근방법
 -클래스내부
 변수명으로 접근가능(일반적 멤버변수와동일)
 -클래스외부
 참조변수.변수명 혹은 클래스명.변수명 형태로 접근
 
 */
class MyStatic {
	/*
	 멤버변수] 인스턴스형 멤버변수는 반드시 클래스객체 생성후 참조변수 통해 접근
	 */
	int instanceVar;
	/*
	 [정적멤버변수] 객체 생성필요없이 클래스명 바로 접근가능 프로그램시작시 이미 메소드영역 초기화
	 */
	static int staticVar;
	/*
	 [인스턴스형멤버메소드] 인스턴스형 메소드에서 모든멤버 사용가능 인스턴스형변수,정적변수 둘다가능
	 */
	void instanceMethod() {
		System.out.println("instanceVar="+ instanceVar); //접근가능
		System.out.println("staticVar="+ staticVar); //접근가능
		staticMethod();//접근가능
	}
	/*
	 [정적멤버메소드]: 정적메소드안에서 인스턴스 멤버를 사용할수 없다 정적멤버만 사용가능
	 (※main메소드에서 static으로 선언된 메소드만 호출할수있었음을 기억할것)
	 */
	static void staticMethod() {
		System.out.println("instanceVar="+ instanceVar); //[오류발생]
		System.out.println("staticVar="+ staticVar); //[오류발생]
		instanceMethod(); //오류발생
	}
	
}


public class E01StaticModifier
{

	public static void main(String[] args)
	{
		/*
		 MyStatic클래스 인스턴스형 멤버변수에 접근하는방법
		 ->인스턴스생성 후 참조변수 통해 접근
		 */
		MyStatic myStatic = new MyStatic();
		myStatic.instanceVar = 100;
		System.out.println("myStatic.instanceVar="+
		myStatic.instanceVar);
		/*
		 static(정적) 멤버변수접근방법
		 방법1: 클래스명통해 접근 객체 생성없이 바로접근 가능
		 */
		MyStatic.staticVar = 200;
		System.out.println("MyStatic.staticVar="+
				System.out.println(MyStatic.staticVar);
		/*
		 방법2: 인스턴스변수처럼 참조변수 통해 접근
		 단 이경우 정적변수 인스턴스변수로 착각할수있으며 권장하지않는다
		 */
		myStatic.staticVar = 300;
		System.out.println("myStatic.staticVar="+
		myStatic.staticVar);
		//////////////////////////////////////////////////////////////////////
		MyStatic ms1 = new MyStatic();
		MyStatic ms2 = new MyStatic();
		/*
		 인스턴스멤버변수는 객체별로 각각존재하며 아래 초기화된값은 객체별로 각각저장됨 
		 따라서 출력결과는 100,1000이된다
		 */
		ms1.instanceVar = 100;
		ms2.instanceVar = 1000;
		
		System.out.println("ms1.instanceVar="+ ms1.instanceVar);//100
		System.out.println("ms2.instanceVar="+ ms2.instanceVar);//1000
		/*
		 정적멤버는 인스턴스화된 객체마다 따로있는멤버가 아니라 메소드 영역에 하나만 생성되어
		 모든객체가 공유하는 공유변수가된다 아래 출력결과는 800, 900이된다
		 */
		ms1.staticVar = 800;
		ms2.staticVar = 900;
		/*
		 위 두개 문장은 동일한 변수에 접근하고 있으나 코드레벨에서 마치 다른 변수처럼 보인다
		 따라서 위 문장은 MyStatic.staticVar로 기술하는것이 좋다
		 */
		System.out.println("ms1.staticVar="+ ms1.staticVar);//900
		System.out.println("ms2.staticVar="+ ms2.staticVar);//900
		/*
		 정적 멤버메소드 접근방법도 정적변수와 동일한규칙
		 */
		myStatic.instanceMethod();
		myStatic.staticMethod();
		
		//myStatic.instanceMethod(); //에러발생 참조변수통해서만 호출가능
		myStatic.staticMethod();
		
	}

}
