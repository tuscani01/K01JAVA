package ex11static;
/*
 싱글콘 디자인패턴
 : 클래스 설계하는 디자인패턴의 하나로 하나의 인스턴스 즉 하나의 메모리를 생성해 이를
 공유해서 사용하고자 할때 사용하는 패턴
 
 작성방법]
 1.생성자 접근지정자를 private로 정의
 2. 외부클래스에서 생성자 접근할수 없으며 new연산자 통해 객체생성은 불가능
 3. 클래스 내부 정적메소드 해당 클래스 객체 반환하도록 정의
 4. 위 방법 통해 객체 생성하면 메모리에 하나만 만들어지게 된다
 */

	class NoSigleTone {
		int instVar;
		public NoSingleTone() {
		
	}
}
	//싱글톤패턴이 적용된클래스
	class SingleTone {
		int shareVar;
		/*
		 JVM(자바 가상머신)에 의해 프로그램이 시작될때 정적변수는 메소드영역에 미리 생성되며 사용할준비를 마치게된다
		 */
		
		private static SingleTone single = new SingleTone();
		/*
		 생성자 private로 선언하면 클래스외부에서 접근할수 없으며 new 연산자 통해 객체생성 불가능
		 */
		private SingleTone( ) {
			//기본생성자
		}
		/*
		 정적메소드로 해당클래스의 객체를 외부로 반환하도록 정의한다
		 */
		public static SingleTone getInstance() {
			return single;
		}
		void print() {
			System.out.println(String.format("shareVar=%d",
					shareVar));
		}
	}

public class E03SingleToneDesignPattern
{

	public static void main(String[] args)
	{
		/*
		 일반적 방식의 객체생성이며 객체 생성할때마다 새로운 주소를 할당받은 인스턴스가 생성된다
		 */
	NoSingleTone nst1 = new NoSingleTone();	
	nst1.instVar = 100;
	System.out.println("nst1="+ nst1);
	
	NoSingleTone nst2 = new NoSingleTone();	
	nst2.instVar = 200;
	System.out.println("nst2="+ nst2);
	
	//생성자가 private로 선언되었으며 외부에서 접근불가능
	//SingleTone st1 = new SingleTone();//[오류발생]
	
	/*
	 생성자 접근할수없는 대신getInstance() 메소드 통해 객체 참조변수를 반환 받을수있다
	 */
	SingleTone st2 = new SingleTone.getInstance();
	st2.shareVar = 100;
	st3.print();
	//두객체 주소값은 동일하다
	System.out.println(String.format("st2의주소:%s", st2));
	System.out.println(String.format("st3의주소:%s", st3));
	
	System.out.println(String.format("st2의 shareVar:%d",
			st2.shareVar));
	System.out.println(String.format("st3의 shareVar:%d",
			st3.shareVar));
	
	}

}
