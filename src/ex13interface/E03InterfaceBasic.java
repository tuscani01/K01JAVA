package ex13interface;

/*
 인터페이스(Interface)
 
 -클래스 객체 설계도라면 인터페이스는 클래스 설계도라 할수있다
 -자바는 단일상속원칙이나 인터페이스 통해 다중상속 구현할수있다
 -추상 클래스 동일하게 상속 목적으로 제작되며 구현받은 하위 클래스에서 반드시 오버라이딩 해야한다
 -멤버로는 추상메소드와 상수로만 구성된다
 
 메소드-> public abstract
 변수-> public static final
 -인터페이스는 생성자가 없다
 */
interface MyInterface1 {
	//생성자 사용불가
	//public MyInterface1() {} //->에러발생
	
	//멤버상수
	public MyInterface1 {
		
		public MyInterface1() {} // ->에러발생
		
		//멤버상수
		public static final int MAX_INT = 2100000000;
		double MAX_DBL = Double.MAX_VALUE;
		
		//멤버추상메소드
		public abstract void absFunc1();
		void absFunc2();
	}
	interface MyInterface2 {
		void absFunc2();
	}
	class simpleClass {
		int simple=1;
		void mySimple() {
			System.out.println("simple="+ simple);
		}
	}
	/*
	 컴마 이용해 여러개 인터페이스 '구현'하는것도 가능
	 그리고 '상속'과 '구현'을 동시에 할수도있다
	 */
class MyClass extends simpleClass implements MyInterface1, MyInterface2 {
	
		@Override
		public void absFunc1() {
			System.out.println("absFunc1() 호출됨");
		}
/*
 인터페이스 동일이름의 추상메소드가 존재하는경우 하나만 오버라이딩 하면 된다
 */
		@Override
		public void absFunc2() {
			System.out.println("absFunc2() 호출됨");
	}
}
public class E03InterfaceBasic {
	public static void main(String[] args) {
		
		MyInterface1 my1 = new MyClass();
		my1.absFunc1();
		my1.absFunc2();
	}
}

