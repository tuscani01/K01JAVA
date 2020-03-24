package ex20io;

import java.util.Scanner;

/*
 연습문제] 해당프로그램은 친구정보를 저장하게된다 프로그램종료시 Friend타입의 객체배열에 저장된 친구정보를 파일 형태로
 저장할수있도록 직렬화하시오
 -저장될파일명: friend_info.obj
 */
class Friend {
	String name;//이름
	String phone; //전화번호
	String addr; //주소

	public Friend(String name, String Phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}
	//멤버메소드
	/*
	 멤버변수전체정보 출력메소드
	 */
	public void showAllData() {
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phone);
		System.out.println("주소:"+ addr);
	}
	/*
	 간략한 정보만을 출력하는 메소드로, 현재실행부가 없는상태로 정의되었다 
	 여기서는 오버라이딩을 할 목적으로 정의되었다
	 */
	public void showBasicInfo() { }
}
//고등친구
class HighFriend extends Friend {
	String nickname; //자식에서 확장한 멤버변수
	public HighFriend(String name, String phone, String addr,
			String nickname) {
		super(name, phone, addr);
		this.nickname = nickname;
	}
		/*
		고등친구의 전체정보출력 위해 부모에서 정의된 메소드 
		super를 통해 호출하고 자식에서 확장한 변수 별도의 print문 통해 출력
		 */
	public void showAllData() {
		System.out.println("==고딩친구(전체정보)==");
		super.showAllData();
		System.out.println("별명:"+ nickname);
	}
	/*
	자식에서 오버라이딩하여 재정의한 메소드로 고딩친구의 간략정보를 출력한다
	 */
	@Override
	public void showBasicInfo() {
		System.out.println("==고딩친구(전체정보)==");
		System.out.println("별명:"+ nickname);
		System.out.println("전번:"+ phone);
	}
}
class UnivFriend extends Friend {
	String major;
	public UnivFriend(String name, String phone, String addr,
			String major) 
	{
		super(name, phone, addr);
		this.major = major;
	}
	@Override
	public void showAllData() {
		System.out.println("==대딩친구(전체정보)==");
		super.showAllData();
		System.out.println("전공:"+ phone);
	}
	@Override
	public void showBasicInfo() {
		System.out.println("==대딩친구==");
		System.out.println("이름:"+ name);
		System.out.println("전화번호:"+ phone);
		
public class E10MyFriendInfoBook {
	//프로그램에서 입력메뉴 출력
	public static void menuShow() {
		System.out.println("***메뉴선택 ***");
		System.out.println("1.고딩친구");
		System.out.println("2.대딩친구");
		System.out.println("3.전체정보출력");
		System.out.println("4.간략정보출력");
		System.out.println("5.검색");
		System.out.println("6.삭제");
		System.out.println("7.프로그램종료");
		System.out.println("메뉴선택>>");
	}
	public static void main(String[] args) {
		//프로그램전반에대한 비즈니스로직을 가진 핸들러 객체 생성
		FriendInfoHandler handler =
				new FriendInfoHandler(100);
		while(true) {
			//메뉴출력 위한 메소드호출
			menuShow();
			
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			
			switch(choice) {
			case 1:case 2:
				handler.addFriend(choice);
				break;
			case 3:
				handler.showAllDate();
				break;
			case 4:
				handler.showSimpleData();
				break;
			case 5:
				//친구정보검색
				handler.searchInfo();
				break;
			case 6:
				//친구정보삭제
				handler.deleteInfo(choice);
				break;
			case 7:
				handler.saveFriendInfo();
				System.out.println("프로그램종료한다");
				return; //main함수의 종료는 프로그램종료로 이어진다
			}
		}///end of while
	}///end of while
}///end of while

class FriendInfoHandler {
	//멤버변수
	/*
	 Friend타입의 객체배열은 하위클래스인 High,Univ객체를 모두저장 하나 배열내에 2개 객체
	  동시 저장하여 관리할수 있다
	 */
	private Friend[] myFriends;
	private int numOfFriends; //친구정보 추가할때 +1증가
	
	//생성자: 인자로 전달된 num크기로 객체배열을 생성한다
	public FriendInfoHandler(int num) {
		myFriends = new Friend[num];
		numOfFriends = 0;
	}
	//새로운친구입력
	public void addFriend(int choice) {
		
		//사용자로부터 친구정보 입력받기위한준비
		Scanner scan = new Scanner(System.in);
		
		String iName,iPhone,iAddr,iNickname,iMajor;
		//공통사항 입력받기
		System.out.print("이름:");iName = scan.nextLine();
		System.out.print("전화번호:");iPhone = scan.nextLine();
		System.out.print("주소:");iAddr = scan.nextLine();
		/*
		 1.친구정보 입력받은후..
		 2.객체배열0번방에 객체를 저장하고
		 3.numOfFriends 변수를1증가시킨다 (후위증가)
		 */
		if(choice==1) {
			//고딩친구입력
		
			System.out.println("별명");iNickname = scan.nextLine();
			HighFriend high =
					new HighFriend(iName, iPhone, iAddr, iNickname);
			myFriends[numofFriends++] = high;
		}
		else if(choice==2) {
			//대딩친구읿력
		
			System.out.print("전공:"); iMajor = scan.nextLine();
			myFriends[numofFriends++] =
					new UnivFriend(iName, iPhone, iAddr, iNickname);
		}
		System.out.println("친구정보 입력완료");		
		
	}////end of addFriend
}

//친구정보 전체보기
public void showAllData() {
	for(int i=0 ; i<numOfFriends ; i++) {
		myFriends[i].showAllData();
	}
	System.out.println("==전체정보가 출력되었다==");
	
}///end of showAllData
//친구정보 간략보기
/*
 1. 고딩친구 정보를 Friend 추가
 2. High객체가 Friend타입으로 자동형변환되어 저장
 3. 객체배열에 저장된 객체들을 for문을 통해 순차적으로 출력 이때 오버라이딩된 메소드 통해
 항상 해당 객체 정보를 출력할수있다 (참조변수의 타입에 영향을 받지않음)
 */
public void showSimpleData() {
	for(int i=0 ; i<numOfFriends ; i++) {
		myFriends[i].showAllData();
	}
	System.out.println("==간략정보가 출력되었다==");
	}
}///end of simpleAllData
	
	//주소록검색
	public void searchInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요:");
		String searchName = scan.nextLine();
		
		for(int i=0 ; i<numOfFriends ; i++) {
			if(searchName.compareTo(myFriends[i].name)==0) {
				myFriends[i].showAllData();
				
				System.out.println("**귀하가 요청하는정보 찾았다**")
			}
		}
	}
	//주소록항목삭제
	public void deleteInfo() {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할이름 입력:");
		String deleteName = scan.nextLine();
		/*
		 배열요소중 삭제된 요소 인덱스값 저장할 용도의변수 요소 삭제한후 빈자리를 채울때 사용할 예정임
		 */
		
		int deleteIndex = -1;
		
		for(int i=0 ; i<numOfFriends ; i++) {
			
			System.out.println("검색중인이름:"+ myFriends[i].name);
			//검색할이름과 객체이름 일치하는경우 모든정보 출력함
			if(deleteName.compareTo(myFriends[i].name)==0) {
				//요소 삭제위해 참조값 null로 변경
				myFriends[i] = null;
				//삭제된 요소 인덱스값 저장
				deleteIndex = i;
				//전체 카운트 변수 -1차감
				numOfFriends--;
			}
		}
		if(deleteIndex==-1) {
			System.out.println("==삭제된데이터 없음==");
		}
		else {
			/*
			 객체배열에서 검색된 요소 삭제후 입력된 위치 바로뒤 요소를 앞으로 하나씩 교환한다
			 */
			for(int i=deleteIndex ; i<numOfFriends ; i++) {
				myFriends[i] = myFriends[i+1];
			}
			System.out.println("==데이터("+ deleteIndex
					+"번)가 삭제되었다==");
			}
		} ////end of deleteInfo
	} ////end of FriendInfoHandler
	
	
