package ex10accessmod;
/* class를 정의할때 반드시 public과 default(생략형)만 가능
 * 아래는 에러발생됨
 */
private class  PrivateClass1 {
	void myFunc() {
		System.out.println("나는정의할수없는Class");
	}
/*
 접근지정자 생략하며 default클래스로 지정된다 해당클래스는 동일 패키지내에서 접근가능
 */
class  DefaultClass1 {

	void myFunc() {
		System.out.println("DefaultClass클래스의 myFunc()메소드호출");
	}
	
}
public class E01AccessModifier1 {
	//멤버변수를 각각 접근지정자 통해 선언
}
	private int privateVar;
	int defaultVar;
	public int publicVar;
	/*
	 동일클래스내에서 private멤버라해도 접근이 가능 즉 동일클래스라면 접근지정자 영향 받지않는다
	 */
	private void privateMethod() {
		privateVar = 100;
		System.out.println("privateMethod() 메소드 호출");
	}
	 void defaultMethod() {
		 privateVar = 200;
		 System.out.println("defaultMEthod() 메소드 호출");
		 /*
		  private로 선언된멤버(변수,메소드)를 외부클래스에서 접근하고싶을때 public으로 선언된 멤버메소드 이용해
		  간접적 접근 허용
		  */
	 }
	 public void publicMethod() {
		 privateVar = 300;
		 System.out.println("publicMethod() 메소드 호출");
		 privateMethod();
	 }
}