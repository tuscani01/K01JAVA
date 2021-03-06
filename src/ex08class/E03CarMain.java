package ex08class;

class Car
{
	// 멤버상수
	public static final String AUTO = "자동";
	public static final String MANUAL = "수동";

	// 멤버변수
	String carGear = AUTO;
	String carModel;// 모델명
	int carYear;// 연식
	Human owner;/*
				 * 쇼유주: Human클래스를 기반으로 하는 멤버변수로 초기화를 위해 이름,나이,에너지 세가지의 값이 필요하다 클레스를 구성할때 또다른 객체를
				 * 멤버변수로 선언할수 있다
				 */

	// 멤버메소드
	void drive()
	{
		System.out.println(owner.name + "이" + carModel + "을 운전한다");
	}

	/*
	 * 객채의 초기화를 담당하는 메소드로 아래는 항상 값으로만 초기화 된다는 한계를 가지고 있다
	 */
	void initialize()
	{
		carModel = "람보르기니";
		carYear = 2017;
		owner = new Human();
		owner.name = "캡틴";
		owner.age = 30;
		owner.energy = 10;
	}

	/*
	 * 위와 동일한 이름의 함수로 오버로딩에 의해 정의되었다 초기화를 진행하는 역할은 동일하나, 매개변수를 통해 다양한 형태의 객체를 초기화할수
	 * 있다
	 */
	void initialize(String model, int year, String name, int age, int energy)
	{
		carModel = model;
		carYear = year;
		owner = new Human();
		owner.name = name;
		owner.age = age;
		owner.energy = energy;
	}

	// 해당 객체의 정보를 디스플레이한다
	void showCarInfo()
	{
		System.out.println("차량정보");
		System.out.printf("모델명:%s\n", carModel);
		System.out.printf("연식: %d\n", carYear);
		System.out.printf("기어: %s\n", carGear);
		owner.showState();
	}
}//// end of Car Class

public class E03CarMain
{

	public static void main(String[] args)
	{
		Car car1 = new Car();
		System.out.println("초기화 메소드 호출전");
		System.out.println("car1.owner=" + car1.owner);
		/*
		 * car1.drive(); => 에러발생(자동차소유주를 표현하는 Human객체가 초기화 되지 않은 상태에서 출력을 시도하여 에러가 발생한다
		 */

		System.out.println("초기화 메소드 호출후");
		car1.initialize();// 고정된 내용으로 초기화된다
		car1.drive();
		car1.showCarInfo();

		// 자동차2 객체생성: 객체생성후 멤버변수를 직접 접근하여 초기화한다
		Car car2 = new Car();
		car2.carGear = Car.MANUAL;
		car2.carModel = "벤틀리";
		car2.carYear = 2018;

		car2.owner = new Human();
		car2.owner.name = "토니스티크";
		car2.owner.energy = 8;

		System.out.println("자동차 정보와  소유자 정보 같이 보기");
		car2.showCarInfo();

		// 세번째 자동차 객채생성: 매개변수가 있는 초기화 메소드를 이용하여 초기화
		Car car3 = new Car();// 객체생성
		car3.initialize("테슬라", 2020, "이준승", 26, 10);// 초기화
		car3.showCarInfo();// 정보출력
	}
}
