package ex14;

import java.util.ArrayList;
/*
 내부멤버클래스
 : 클래스안에 정의된 클래스로 static이 없는 클래스
 -외부클래스 모든멤버(정적혹은 인스턴스형) 사용할수있다
 -정적멤버를 가질수없다(단, 상수는 가능하다)
 -컴파일시 외부클래스명$내부클래스명.class파일이 생성된다
 -이벤트기반 프로그래밍(윈도우프로그래밍,안드로이드 등)에서 주로많이 사용
 */
class OuterMember {
	//멤버변수
	int outerInstanceVar; //인스턴스형 변수
	static int outerStaticVar; //정적멤버 변수
	
	int sameVar = 1000;
	
	//내부클래스 사용하기위한 멤버변수 및 객체생성
	InnerMember inner;
	public OuterMember() {
		inner = new InnerMember();
	}
	
	void outerInstanceMethod() {
		System.out.println("외부 sameVar:"+ sameVar);
		System.out.println("내부클래스 상수:"+ InnerMember.MAX_INT);
		System.out.println("내부의 sameVar:"+ inner.sameVar);
	}
	static void outerStaticMethod() {
		
		//외부클래스 정적메소드 내부클래스 정적상수에 접근가능함
		System.out.println(InnerMember.MAX_INT);
		
		//정적메소드에서 정적멤버만 접근가능
		System.out.println("내부의 sameVar:"+ inner.sameVar); //에러발생
	}
	//내부클래스(내부멤버클래스)
	class InnerMember {
		int innerInstanceVar;
		int sameVar = 100;
		/*
		 외부클래스 내부클래스보다 더한 지역에서 
		 */
		void innerInstanceMethod() {
			outerInstanceMethod();
			outerStaticMethod();
			this.sameVar = sameVar;
			OuterMember.this.sameVar = sameVar;
		}
		/*
		 내부클래스에서 static멤버를 선언할수없다 단 상수(final)인  경우에만 허용된다
		 */
	static final int MAX_INT = Integer.MAX_VALUE;
	}
}

public class E01InnerMemberClass
{

	public static void main(String[] args)
	{
		/*
		 외부클래스 아닌 다른클래스에서 내부멤버클래스가 보이지 않으며 직접 인스턴스를 생성할수없다
		 */
		//InnerMember innerClass = new InnerMember(); //에러발생
		
		/*
		 외부클래스 인스턴스를먼저 생성한후 내부클래스 인스턴스를 생성해야한다
		 */
		OuterMember outerClass = new OuterMember();
		
		/*
		 내부클래스 객체 아래 3가지 방법통해 생성할수있다
		 */
		outerClass.inner.innerInstanceMethod();
		OuterMember.InnerMember in = outerClass.new InnerMember();
		OuterMember.InnerMember in2 = new OuterMember().new 
				InnerMember();
	}
}
