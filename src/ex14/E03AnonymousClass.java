package ex14;
/*
 익명클래스(Anonymous Class)
 -이름없는 클래스
 -내부클래스처럼 GUI프로그램 많이 사용
 -부모클래스 메소드 오버라이딩 하는것이 목적
 -클래스 마치 메소드 정의하는것과 비슷
 -마지막에 세미클론 반드시써줘야한다
 
 형식]
 부모클래스명 참조변수= new 부모클래스명(){
 익명클래스의 실행부;
 부모클래스의메소드 오버라이딩;
 
 };
※ 부모클래스 상속받아 이름없는 자식클래스 생성하는 개념으로 이해하면 된다 상속되기때문에 오버라이딩 가능
 
 };
 */
class Person {
	Sting name;
	public Person(String n) {
		name = n;
	}
	void printInfo() {
		System.out.println(String.format("이름:%s",name));
	}
}
class Student extends Person {
	String stNumber;
	public Student(String n, String stNum) {
		super(n);
		stNumber = stNum;
	}
	String getInfo() {
		return String.format("학번:%s", stNumber);
	}
	//부모클래스의 메소드를 오버라이딩
	@Override
	void printInfo() {
		super.printInfo();
		System.out.println(getInfo());
	}
}
public class AnonymousClass {
	
	public static void main(String[] args) {
		/*
		 Student라는 이름가진 자식클래스 통해 객체생성하고 부모클래스 참조변수로 참조함 참조변수가 부모타입이므로 자식객체 직접 접근하는것은 불가능
		 반드시 다운캐스팅후 접근해야한다
		 */
		Person person = new Student("문사람", "2016");
		person.printInfo();
		person.stNumber = "2015"; //에러
		((Student)person).stNumber = "2015"; //다운캐스팅
		System.out.println((Student)person).getInfo());
		
		/*
		 Person클래스 상속받은 익명클래스 정의 및 생성
		 : Person타입의 인스턴스변수에 Person을 상속받은 익명클래스를 생성해서 그 주소를 할당한다
		 
		 -개념적으로 newPerson(){}; ==> 익명extends Person{}; 형태라 생각하면된다
		 
		- 이름 없는 객체이며 부모클래스 이름 빌려서 생성했다고 하자
		 */
		Person anonyPerson = new Person("이말년"){
			//익명클래스(자식객체)에서 새롭게 확장한 멤버
			
			/*
			 익명클래스 내에서만 접근가능
			 */
		
			
			
			
			int newVar;
			void newMethod() {
				System.out.println("익명클래스 새롭게확장한 메소드");
			}
			/*
			 오버라이딩하여 재정의한 메소드
			 */
			@Override
			void printInfo() {
				System.out.println("newVar="+ newVar);
				newMethod();
				System.out.println("익명클래스 오버라이딩");
			}
		};
		 anonyPerson.printInfo(); //호출가능
		//anonyPerson.newMethod(); //접근불가 에러발생
		 
		 /*
		  부모타입 참조변수 하위객체 확장한 멤버에 접근할수 없으며 위 부분 에러발생
		  */
		 //추상클래스
		 abstract class AbstractClass {
			 abstract void AbstractMethod();
		 }
		 //인터페이스
		 interface InterFace {
			 void abstractMethod();
		 }
		 //main메소드 추가부분
		 //Student클래스 상속받아 정의한 익명클래스(즉  student의 하위 익명객체)
			 Student anonyStudent = new Student("김사랑", "2017") {
				 //익명클래스 확장한 멤버변수
				 int age=1;
				 
				 @Override
				 String getInfo() {
					 return super.getInfo() + ", 나이:"+ age;
				 }
				 @Override
				 void printInfo() {
					 System.out.println("이름:"+ name +","+ getInfo());
				 }
			 };
			 System.out.println("[Student클래스 상속받은 익명클래스]");
			 anonyStudent.printInfo();
			 /*
			  하위익명클래스에서 확장한 변수이며 익명객체 통해 접근불가
			  */
			 //anonyStudent.age = 100; //접근불가-에러발생
			// ((Student)anonyStudent).age = 100; //다운캐스팅 불가-에러발생
			 
			 /*
			  다운캐스팅은 "(자식클래스명)부모타입 참조변수" 형태로 형변환하여 하위클래스 멤버 접근하기위한 수단
			  그러나 익명클래스는 클래스명 없기때문에 위와같이 다운캐스팅 불가능하다
			  
			  즉 익명클래스 새롭게 정의한 멤버변수 접근할수없다 따라서 익명클랫느느 오버라이딩 목적으로만 사용해야한다
			  
			 Person anonyTest = new Student("다운캐스팅", "안되여") {
				 String jumin = "001024";
			 };
			 ((Student)anonyTest).jumin = "181105";
			 */
			 //추상클래스 상속받은 익명클래스
			 AbstractClass ac = new AbstractClass() {
				 String abStr = "확장변수";
			
				 @Override
				 void abstractMethod() {
					 System.out.println("추상메소드 오버라이딩");
					 System.out.println("abStr="+ abStr);
				 }
			 };
			 ac.AbstractMethod();
			 //인터페이스 구현한 익명클래스
			 InterFace in = new InterFace() {
				 int interVar = 100;
				 @Override
				 public void abstractMethod() {
					 System.out.println("인터페이스 추상메소드 오버라이딩");
					 System.out.println("interVar="+ interVar);
			}
		};
		in.abstractMethod();
	}
}

