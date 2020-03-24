package ex13interface;
/*
 추상클래스 interface로 변경하기
 abstract class => interface
 
 메소드 경우 public abstract를 제거
 
 멤버상수인경우 public static final을 제거
 
 추상메소드
 -오버라이딩 목적으로 만들어짐
 -함수실행부 없기때문에 {}를 쓰지않고 함수의원형에 ;을 붙인다
 */

//프로젝트 전체에서 기준될수있는 추상클래스정의
interface PersonalNumberStorageInters {
	void addPersonalInfo(String juminNum, String name);
	String searchPersonalInfo(String juminNum);
}
/*
 사람정보 저장할 DTO클래스 혹은 VO클래스라고 한다
 */
class  {
	//멤버변수
	private String name;
	private String JuminNum;
	//생성자
	public (String name, String juminNum) {
		this.name = name;
		this.JuminNum = juminNum;
	}
	//getter메소드
	String getName() { return name; }
	String getJuminNum() { return juminNum; }
}
/*
 클래스가 클래스를 상속받을때 => extends사용 
 클래스가 인터페이스 상속받을때 =>implemnets 사용
 인터페이스가 인터페이스 상속받을때=> extends 사용
 
 extends는 상속이라 표현하고 implements는 구현 이라 표현한다
  */
class PersonalNumberStorageImp implemnets PersonalNumberStorageInter {
	
	PersonalInfoDT0[] personalArr; //정보저장용객체배열
	int numOfPerInfo; //입력정보 카운트용변수
	//생성자
	public PersonalNumberStorageExt(int arrSize) {
		personalArr = new PersonalInfoDT0[arrSize];
		numOfPerInfo = 0;
		/*
		 전달받은 인자통해 PersonalInfo 객체생성후 객체배열에 저장
		 */
		
	}
	@Override
	public void addPersonalInfo(String juminNum, String name) {
		personalArr[numOfPerInfo] =
				new PersonalInfoDT0(name, juminNum);
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

public class E02AbstractToInterface2
{

	public static void main(String[] args)
	{
		PersonalNumberStorageInter storage =
				new PersonalNumberStorageImpl(10);
		
		//정보저장
		storage.addPersonalInfo("201134-2222222", "김태희");
		storage.addPersonalInfo("201134-1222222", "비");

		//검색
		System.out.println(storage.searchPersonalInfo("201134-2222222"));
		System.out.println(storage.searchPersonalInfo("201134-1222222"));
		System.out.println(storage.searchPersonalInfo("001134-2222222"));
		
	}

}
