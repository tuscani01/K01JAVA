package ex11static;
/*
 static블럭
 : 동일클래스 안의 main메소드보다 먼저 실행되는 블럭으로 main메소드의 실행코드가 없어도 먼저 실행된다
 단,다른클래스에 main이 있는경우 main이 순차적으로 실행되다가 static블럭이 있는 클래스가 객체화될때
 실행되게된다 이때 생성자보다 static블럭이 먼저 실행된다
 */
public class StaticBlock
{
	//인스턴스형 멤버
	int instanceVar;
	void instanceMethod() {}
	//정적멤버
	static int staticVar;
	static void staticMethod() {
		int localVar;
		System.out.println("정적메소드");
	}
	//static블럭
	static {
		//static블럭안에서 정적멤버인 staticVar 접근가능
		staticVar = 1000;
		/*
		 static블럭안에시머나 사용할수있는 지역변수선언
		 블럭내 제한적 사용이 가능하다
		 */
		int localVar;
		System.out.println("localVar="+ localVar);//[허용됨]
		/*
		 static블럭내에서 인스턴스형 멤버를 사용할수없다
		 */
//		System.out.println("instanceVar="+ instanceVar); //에러발생
//		instanceMethod(); //에러발생
		
		/*
		 정적멤버만 접근이가능하다
		 */
		System.out.println("staticVar="+ staticVar);
		staticMethod();
		//main메소드보다 먼저실행되는지 확인할 출력문
		System.out.println("===static block===");
	}
	//생성자 메소드
	/*
	 외부파일 main메소드 실행되는경우 해당 클래스 객체가 생성자 통해 생성되기전 static블럭이 먼저 실행된다
	 */
	public StaticBlock() {
		staticVar = -1;
		System.out.println("===StaticBlock의생성자==");
	}
	
	public static void main(String[] args)
	{
		/*
		 E02StaticBlockMain.java에서 실행할때 추석처리후 실행하세요 main메소드가
		 외부파일 있을때 실행 테스트하기 위함
		 */
		//System.out.println("==메인메소드==");
		
		//static블럭에서만 실행가능
		//System.out.println("localVar="+ localVar);
	}
}
