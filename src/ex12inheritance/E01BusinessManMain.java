package ex12inheritance;
/*
  상속(Inheritance)
  : 기존 정의된 클래스 메소드,변수 추가해 새로운 클래스정의 하는것
  부모클래스, 자식클래스가 상속할때 extends를 사용
 */

/*
 부모클래스(상위,기본,super): 사람의 일반적 형태를 추상화
 */

class Man{
	private String name;
	/*
	 만약 자식클래스에서 super()를 통해 매개변수 전달하지 않는다면 초기화가 되지않아 null이 출력될수있다
	 */
	public Man() {
		System.out.println("Man클래스 디폴트 생성자호출됨");
	}
	public Man(String name) {
		this.name = name;
		System.out.println("Man클래스인자 생성자 호출됨");
	}
	public void tellYourName() {
		System.out.println("내이름은"+ name +"입니다");
	}
}
//자식클래스(하위,유도,Sub): Man클래스 상속받은클래스
class BusinessMan extends Man {
	
	private String company;
	private String position;
	/*
	 상속받은 자식클래스에서 부모클래스의 생성자를 호출해 부모객체가 먼저 생성되도록 해야하는
	 책임을 갖고있다 super()는 부모클래스의 생성자를 호출하는 역할을 하게되면 만약 super()를
	 쓰지 않으면 디폴트 생성자가 호출된다
	 */
	public BusinessMan)String name, String company,
			String position) {
				
				super(name); /*
				부모클래스 매개변수가 1개인 생성자를 호출
				*/
				this.company = company;
				this.position = position;
				System.out.println("BusinessMan 생성자호출");
			}
			
			public void tellYourInfo() {
				System.out.println("회사명은 "+ company +" 입니다");
				System.out.println("직급은 "+ position +" 입니다");
				//부모클래스 정의된 멤버메소드호출 상속받으므로 호출가능함
				tellYourName();
			}
	}

class E01BusinessManMain
{
	
	public static void main(Stirng[] args) 
	{
		BusinessMan man1 =
				new BusinessMan("김천국","NAVER", "팀장");
		BusinessMan man2 =
				new BusinessMan("이낙원","DAUM", "부장");
		
		man1.tellYourInfo();
		//man1.tellYourName(); //자식객체로 부모의 메소드 호출가능
		
		man2.tellYourInfo();
		//man2.tellYourName(); 
		
	}
}
