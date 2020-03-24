package ex13interface;
/*
 추상클래스
 -상속목적 제작되며 객체생성 허용하지않는다
 -추상클래스는 대부분 추상메소드 포함하며 이를 상속받는 클래스는 반드시 추상메소드를 오버라이딩해야한다
 -클래스 상속관계에서 설계도 역할을 한다
 -객체생성은 할수없으나 그외 참조변수, 상속등 모든기능을 가지고있다
 
 추상메소드
 -오버라이딩 목적으로 만들어짐
 -함수실행부 없기때문에 {}를 쓰지않고 함수의원형에 ;을 붙인다
 */

//프로젝트 전체에서 기준될수있는 추상클래스정의
abstract class PersonalNumberStorageAbs {
	public abstract void addPersonalInfo(String juminNum,
			String name);
	public abstract String searchPersonalInfo(String juminNum);
}
/*
 사람정보 저장할 DTO클래스 혹은 VO클래스라고 한다
 */
class PersonalInfoVO {
	//멤버변수
	private String name;
	private String JuminNum;
	//생성자
	public PersonalInfoVO(String name, String juminNum) {
		this.name = name;
		this.JuminNum = juminNum;
	}
	//getter메소드
	String getName() { return name; }
	String getJuminNum() { return juminNum; }
}
/*
 제공된 추상클래스 상속해 사람정보 저장하는 기능 검색 기능 구현한 클래스
 */
class PersonalNumberStorageExt extends PersonalNumberStorageAbs {
	
	PersonalInfoVO[] personalArr; //정보저장용객체배열
	int numOfPerInfo; //입력정보 카운트용변수
	
	public PersonalNumberStorageExt(int arrSize) {
		personalArr = new PersonalInfoVO[arrSize];
		numOfPerInfo = 0;
		/*
		 전달받은 인자통해 PersonalInfo 객체생성후 객체배열에 저장
		 */
		
	}
	@Override
	public void addPersonalInfo(String juminNum, String name) {
		personalArr[numOfPerInfo] =
				new PersonalInfoVO(name, juminNum);
		numOfPerInfo++;
	}
	/*
	 주민번호 인자 전달받아 객체배열에저장된 정보를 검색한후 일치하는 경우에만 이름을 반환한다
	 */
	@Override
	public String searchPersonalInfo(String juminNum) {
		for(int i=0 ; i<numOfPerInfo ; i++) {
			if(juminNum.compareTo(personalArr[i].getJuminNum())==0)
			{
				//getter통해 이름 반환
				return personalArr[i].getName();
			}
		}
		return null; //검색결과 없는 경우 null반환
	}
}

public class E02AbstractToInterface1
{

	public static void main(String[] args)
	{
		PersonalNumberStorageExt storage =
				new PersonalNumberStorageExt(10);
		
		//정보저장
		storage.addPersonalInfo("201134-2222222", "김태희");
		storage.addPersonalInfo("201134-1222222", "비");

		//검색
		System.out.println(storage.searchPersonalInfo("201134-2222222"));
		System.out.println(storage.searchPersonalInfo("201134-1222222"));
		System.out.println(storage.searchPersonalInfo("001134-2222222"));
		
	}

}
