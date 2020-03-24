package ex12inheritance;
/*
 Is-A관계
 : X Is A Y => X는Y의 일종이다로 표현가능
 -노트북은 컴퓨터 일종
 -휴대폰 전화기 일종
 이와같이 Is-A관계가 성립하는 개체 상속으로 표현하기 적합
 */

/*
 컴퓨터 표현
 :기본적 컴퓨터 계산
 */
class Computer{
	String owner; //컴퓨터 소유자
	
	public Computer(String name) {
		owner = name;
		/*
		 private접근지정자 선언된 멤버메소드 외부클래스 혹은 상속받은 클래스에서
		 접근이 불가능하며 public으로 선언된 메소드 통해 간접호출 해야한다
		 상속 관계라면 protected로 선언된 메소드로호출할수있다
		 */
	}
	private void keyboardTouch() {
		System.out.println("키보드 통해서 입력");
	}
	private void calculate() {
		System.out.println("요청한 내용 계산");
	}
	public void calculateFunc() {
		keyboardTouch();
		calculate();
	}
	/*
	 해당 메소드 내부에서만 접근되며 호출순서 지켜 실행할수있도록 캡슐화하여 정의
	 */
}
/*
 컴퓨터 상속한 노트북컴퓨터
 : 컴퓨터가 가지고있는 기본기능 휴대성 부분 확장해 정의 휴대성 위해 배터리 멤버변수 추가
 */
class NotebookComputer extends Computer {
	
	int battary; //배터리충전량
	/*
	 부모생성자 호출위해 사용한 super()는 생략 가능
	 앞에 다른 문장 먼저오게되면 오류 발생 주의해야한다
	 */
	public NotebookComputer(String name, int initCharge) {
		super(name);
		battary = initCharge;
	}//배터리 충전 표현
	public void charging() {
		battary += 5;
	}//휴대하며 컴퓨팅 할수있는거 표현
	public void movigCal() {
		//배터리양 체크 사용여부판단
		if(battary < 1) {
			System.out.println("배터리 방전되어 사용불가");
			return;
		}
		System.out.print("이동하며 ");
		/*
		 아래 메소드 private로 선언 상속받은 자식클래스에서도 접근은 불가능하다
		 */
		//keyboardTouch(); //에러발생
		//calculate(); //에러발생
		
		calculateFunc();
		battary -= 1; //배터리차감
	}
}
/*
 태블릿노트북컴퓨터
 : 컴퓨터 기본기능, 휴대이용에 펜으로 드로잉하는 기능까지 추가된 클래스
 */
class TabletNotebook extends NotebookComputer{
	
	String registPencil; //타블렛 사용하는 펜슬
	
	public TabletNotebook(String name, int initCharge
			, String pen) {
		super(name, initCharge);
		registPencil = pen;
	}
	/*
	 타블렛아용 위해 배터리양체크 및 등록된 펜인지 체크
	 */
	public void write(String penInfo) {
		if(battary<1) {
			System.out.println("배터리 방전 사용불가");
			return;
		}
		/*
		 A.compateTo(B)
		 : 문자열A와 B를 비교하여 0이 반환되면 같은 문자열로 판단하고 -1혹은 1이
		 반환되면 서로 다른 문자열로 판단하는 string클래스에 정의된메소드
		 */
		if(registPencil.compareTo(penInfo)!=0) {
			System.out.println("등록된펜 아님");
			return;
		}
		movigCal();
		System.out.println("스크린 펜으로 그림그린다");
		battary -= 1;
	}
}
public class E04ISAInheritance {
	public static void main(String[] args) {
		
		NotebookComputer noteBook =
				new NotebookComputer("공유", 5);
		TabletNotebook tablet =
				new TabletNotebook("이동건", 5, "ISE-1234");
		
		System.out.println("==노트북컴퓨터사용자==");
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		noteBook.movigCal();
		
		System.out.println("==ISE-1234 펜으로 타블렛사용==");
		tablet.write("ISE-1234"); //정상사용
		System.out.println("==XYZ-9876 펜으로 타블렛사용==");
		tablet.write("XYZ-9876"); //사용불가
		
	}
}




