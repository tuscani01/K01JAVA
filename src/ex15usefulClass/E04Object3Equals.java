package ex15usefulClass;

class MyClass {
	int data;
	public MyClass(int data) {
		this.data = data;
	}
	/*
	 toString(): 실제 저장된 데이터 반환되도록 Object클래스로부터 상속받아 오버라이딩한 메소드
	
	 */
	@Override
	public String toString() {
		return String.valueOf(data);
	}
	/*
	 MyClass형 객체 비교위해 오버라이딩한 메소드 객체가 가지고있는 멤버변수 비교 통해 동일여부 판단
	 
	 */
	@Override
	public boolean equals(Object obj) {
		/*
		 매개변수 전달된 객체 Object로 받은후 MyClass의 인스턴스인지 먼저 판단한다
		 */
		if(obj instanceof MyClass) {
			//MyClass형으로 다운캐스팅 진행
			MyClass mc = (MyClass)obj;
			//두객체 멤버변수 값 실제로 비교함
			if(mc.data == this.data) {
				return true; //값 동일할때 true
			}
			else {
				return false; //다를때 false
			}
		}
		else {
			/*
			 매개변수 전달된 객체가 MyClass의 인스턴스가 아니라면 비교대상 될수없으며 false 반환함
			 */
			return false;
		}
	}
}
class Point {
	int x,y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/*
	 객체1,2의 x,y값을 동시 비교해서 둘다 동일할때 같은 객체로 판단하도록 오버라이딩처리
	 
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Point) {
			Point pos = (Point)obj;
	if(this.x==pos.x && this.y==pos.y) {
		return true;
	}
	else {
		return false;
	}
		}
		else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "x="+ String.valueOf(x) +", y="+ String.valueOf(y);
	
	}
}

public class E04Object3Equals
{

	public static void main(String[] args)
	{
		MyClass mc1 = new MyClass(10);
		MyClass mc2 = new MyClass(10);
		
		System.out.println("[두 객체 equals()메소드 비교]");
		//두객체 주소값 다름
		if(mc1==mc2) {
			System.out.println("인스턴스 참조값(주소값)이같다");
		}
		else {
			System.out.println("인스턴스 참조값(주소값)이 다르다"); //[0]
		}
		//두객체 멤버변수값 비교
		System.out.println(mc1.equals(mc2) ? "같다" : "다르다"); //[같다]
		
		/*
		 아래 toString() 메소드는 굳이 호출하지 않아도 print()문 실행될때 자동으로 호출하며 아래 출력결과는 동일하다
		 */
		//toString()메소드 오버라이딩한 내용 출력
		System.out.println("[두객체 toString()메소드 호출]");
		System.out.println("mc1.toString()=>"+ mc1.toString());
		System.out.println("mc2.toString()=>"+ mc2.toString());
		
		Point pos1 = new Point(10,20);
		Point pos2 = new Point(10,30);
		System.out.print("두점 비교결과");
		System.out.println(pos1.equals(pos2) ? "같다" : "다르다");
		
		System.out.println(pos1.toString()=>"+ pos1.toString());
		System.out.println(pos2.toString()=>"+ pos2.toString());
		System.out.println(pos1);
		System.out.println(pos2);
	}
}
