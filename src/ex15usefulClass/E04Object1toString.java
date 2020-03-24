package ex15usefulClass;

/*
 Object클래스
 -자바에서 최상위클래스
 -별도 선언없이 Object클래스에 정의된 모든 메소드 사용할수있다
 -개발자가 정의한 모든 클래스를 Object인스턴스로 참조 할수있다
 */
class myFriends extends Object {
	String myName;
	public myFriends(String name) {
		myName = name;
	}
	
	//오버라이딩처리하여 재정의함
	@Override
	public String toString() {
		return "이름:"+ myName; 
		
	}
}

/*
 toString()메소드
 -Object클래스에 정의된 메소드로 println()이 문자열을 출력하기전에 자동으로 호출하는 메소드
 -인스턴스 변수를 문자열 형태로 변환하여 반환해준다
 -필요한경우 클래스 정의할때 적절히 오버라이딩하여 재정의하는것이 좋다 단 필수사항은 아님
 */

class yourFriends extends Object {
	String myName;
	public yourFriends(String name) {
		myName = name;
	}
}
public class E04Object1toString
{

	public static void main(String[] args)
	{
	myFriends fnd1 = new myFriends("성유겸");
	yourFriends fnd2 = new yourFriends("헬로비너스");
	
	System.out.println(fnd1); //이름출력
	System.out.println(fnd2); //인스턴스 주소값출력
	}
}
