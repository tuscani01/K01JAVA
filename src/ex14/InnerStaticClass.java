package ex14;
/*
 내부정적클래스
 :클래스 정의하는 클래스로 static을 붙여준다
 -이와같이 내부클래스를 static으로 선언하면 nested클래스라고 한다
 -정적멤버변수 & 멤버메소드를 가질수있다
 -외부클래스 인스턴스형 멤버는 사용할수없다
 -외부클래스명$내부클래스명.class 파일이생성된다
 
 ※원래 클래스앞에는 static을 붙일수없지만 내부클래스는 허용된다
 */


class OuterClass {
	//인스턴스형멤버변수
	InnerStaticClass innerStaticClass = new InnerStaticClass();
	int outerMemberVar;
	//인스턴스형멤버메소드
	void outerMemberMethod() {
		/*
		 외부클래스 멤버메소드에서 내부정적클래스 멤버 접근가능 (heap영역에서 Method영역 참조)
		 */
		System.out.println("외부클래스 멤버메소드 호출");
		innerStaticClass.innerMemberVar = 100; //내부클래스 멤버변수
		innerStaticClass.innerStaticVar = 101; //내부클래스 정적변수
	}
	//외부클래스 정적멤버 변수&메소드
	static int outerStaticVar;
	static void outerStaticMethod() {
		/*
		 외부클래스 정적멤버메소드 내부클래스 정적멤버만 접근할수있다 (Method영역에서 Heap영역 참조할수없다)
		 */
		System.out.println("외부클래스 정적메소드호출됨");
		
		innerStaticClass.innerMemberVar = 102; //에러
		innerStaticClass.innerMemberMethod(); //에러
		
		innerStaticClass.innerStaticVar = 103; //에러
		innerStaticClass.innerStaticMethod(); //에러
		
		innerStaticClass.innerMemberVar = 104; //에러
		innerStaticClass.innerMemberMethod(); //에러
	}
	//내부정적 클래스
	static class InnerStaticClass {
		//인스턴스형 멤버
		int innerMemberVar;
		void innerMemberMethod() {
			System.out.println("내부클래스 멤버메소드호출");
		}
		//정적멤버
		static int innerStaticVar;
		static void innerStaticMethod() {
			System.out.println("내부클래스 정적메소드호출");
		}
 	
	}
}

public class InnerStaticClass
{

	public static void main(String[] args)
	{
		/*
		 외부클래스가 아닌 다른클래스 접근할때 방법은 아래와 같다
		 */
		
		/*
		 내부정적 클래스 정적멤버 접근할때 외부클래스 객체 생성없이 클래스명으로 바로 접근가능
		 */
		
		
		OuterClass.InnerStaticClass.innerStaticVar = 1;
		OuterClass.InnerStaticClass.innerStaticMethod();
		/*
		 내부정적 클래스 인스턴스멤버에 접근할때 객체 생성후 참조변수 통해 접근해야한다
		 */
		OuterClass.InnerStaticClass innerStaticClass =
				new OuterClass.InnerStaticClass();
		innerStaticClass.innerMemberVar = 2;
		innerStaticClass.innerMemberMethod();
		/*
		 그외는 클래스 접근의 일반적 방법을 따른다
		 
		 외부클래스 멤버변수(메소드)는 객체 생성후 참조변수 통해 접근한다
		 */
		OuterClass outerClass = new OuterClass();
		OuterClass.outerMemberVar = 3;
		OuterClass.outerMemberMethod();
		/*
		 외부클래스 정적멤버는 클래스명으로 바로접근
		 */
		OuterClass.outerStaticVar = 4;
		OuterClass.outerStaticMethod();
		
	}
}
