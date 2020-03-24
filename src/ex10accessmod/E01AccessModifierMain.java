package ex10accessmod;

import ex10accessModifier.sub.E01AccessModifier2;
/*
 접근지정자(접근제어지시자)
 : 클래스와클래스 사이 멤버간 접근 제어하는 키워드
 
 접근범위비교
 private < default(생략형) < protected< public
 접근지정자 붙일곳
 클래스,멤버변수,멤버메소드 모두 가능 class명 앞에는 public과 default만 붙일수있다
 */
public class E01AcessModifierMain {
	
	public static void main(String[] args) {
		
		System.out.println("E01AccessModifier1 객체생성 및 접근");
		/*
		 private으로 선언된멤버는 동일한 패키지라 할지라도 접근 불가능
		 해당멤버는 동일클래스내에서 접근허용
		 
		 ※private로 선언된 멤버를 외부클래스 접근할때 주로 public로 선언된 멤버메소드 통해 간접적 접근
		 */
		E01AccessModifier1 one = new E01AccessModifier1();
		
		//System.out.println("one.privateVar="+ one.privateVar);
		//에러발생
		System.out.println("one.defaultVar="+ one.defaultVar);
		System.out.println("one.publicVar="+ one.publicVar);
		
		//one.privateMethod(); //에러발생
		one.defaultMethod();
		one.publicMethod();
		/*
		 동일패키지에 선언된 클래스이므로 import없이 객체생성및 접근이 가능하다
		 */
		System.out.println("DefaultClass 객체생성및접근");
		new DefaultClass1().myFunc(); //객체생성과동시에 멤버메소드호출
		///////////////////////////////////////////////////////////////////
		System.out.println("E01AccessModifier2 객체생성및접근");
		/*
		 다른패키지 선언된 클래스이며 객체생성위해서 import가 필요하다
		 
		 패키지가 다른경우private, default멤버 접근을 허용하지 않는다
		 */
		E01AccessModifier2 two = new E01AccessModifier2();
		//System.out.println("two.privateVar="+ two.privateVar); //에러발생
		//System.out.println("two.defaultVar="+ two.defaultVar); //에러발생
		System.out.println("two.publicVar="+ two.publicVar);
		two.privateMethod();
		two.defaultMethod();
		two.publicMethod();
		/*
		 다른패키지에 정의된 디폴트클래스라서 객체생성 불가능
		 import도 불가능하며 아예 사용할수없는클래스
		 */
		System.out.println("DefaultClass객체 생성및 접근");
		//new DefaultClass2().myFunc();
	}
	
}
