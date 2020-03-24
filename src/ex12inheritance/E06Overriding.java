package ex12inheritance;
/*
 오버라이딩
 :클래스가상속관계 있을때 하위클래스 상위클래스 멤버메소드와 완전 동일한 모양 재정의하는것
 
 오버로딩과 다른점 매개변수개수, 타입, 반환형이 완전 똑같은 형태로 정의
 하위클래스 오버라이딩 한 메소드 상위클래스 메소드 가리게 됨 항상 최하위클래스 오버라이딩한 메소드 호출되게됨
 */

//일반적 클래스를 추상화한클래스
class Speaker {
	private int volumnRate;
	//setter메소드
	public void setVolumn(int vol) {
		volumnRate = vol;
	}
	//상속관계에서 오버라이딩 목적으로
	public void showState() {
		System.out.println("스피커볼륨크기:"+ volumnRate);
	}
}
//일반적 스피커에 중저음 보강된 스피커 추상화
class BaseSpeaker extends Speaker {
	private int baseRate;
	public void setBase(int bas) {
		baseRate = bas;
	}
	/*
	@Override: 어노테이션이라 부르고 오버라이딩된 메소드에붙어 컴파일러에게 알려준 역할을한다
	 */
	@Override
	public void showState() {
		//super를통해 부모클래스 정의된 멤버메소드 호출
		super.showState();
		System.out.println("베이스볼륨크기:"+baseRate);
	}
}
public class E06Overriding {
	public static void main(String[] args) {
		BaseSpeaker baseSpeaker = new BaseSpeaker();
		baseSpeaker.setVolumn(10);
		baseSpeaker.setBase(20);
		baseSpeaker.showState();
		/*
		 하위클래스 오버라이딩된 showState()메소드가 호출
		 */
		System.out.println();
		/*
		 부모클래스 참조변수가 자식클래스 객체를 참조할수있다
		 이경우 접근범위는 부모클래스로 제한된다 즉 아래호출부분에서 speaker참조변수를 통해서는 setBase() 메소드는 호출할수없다
		 setBase()는 자식클래스에 정의된 멤버메소드이기때문이다
		 단 오버라이딩 처리된 메소드가 있는경우 하위클래스 메소드가 호출되게 된다
		 */
	
		Speaker speaker = new BaseSpeaker();
		speaker.setVolumn(30);
		//speaker.setBase(40); //에러발생
		speaker.showState();
	}
}