package ex12inheritance;
/*
 구성관계 표현하기 적합한 Has-A관계
 : X Has a Y -> X가Y를 소유하고있다
 -경찰이 권총을소유
 -경찰이 수갑을 소유
 Has-A와 같이 소유 관계를 상속으로 표현하면 클래스간 강한 연결고리가 형성되어 권총없는 경찰 표현하기 힘들어짐
 따라서 이경우 구성관계로 표현하는것이 적합 구성관계는 클래스 멤버 또 다른 객체 정의하는것을말한다
 */

class Gun {
	int bullet; //총알개수
	public Gun(int bNum) {
		bullet = bNum;
	}
	//총쏘는 행위표현
	public void shutGun() {
		System.out.println("빵야");
		//탄환 감소
		bullet--;
	}
}
class Police {
	int handCuffs; //수갑개수
	Gun gun; //보유 권총
	
	public Police(int bNum, int hCuff) {
		handCuffs = hCuff;
		/*
		 권총보유여부 초기화
		 : 만약 총알없는상태라면 보유한 권총 없는것으로 표현하기 위해 참조변수 null로 초기화
		 참조변수가 null값을 가진다는건 아무것도 참조할객체가 없다는 의미
		 */
		
		if(bNum<=0) {
			gun = null;
		}
		else {
			gun = new Gun(bNum);
		}
	}
	//수갑 채우는행위
	public void putHandcuff() {
		System.out.println("수갑채움 넌감옥");
		handCuffs--;
	}
	//경찰이 권총발사하는 행위
	public void shut() {
		if(gun==null) {
			System.out.println("보유권총없음 헛발");
		}
		else {
			gun.shutGun();
		}
	}
}

public class E05HasAComposite {

	public static void main(String[] args) {
	//권총보유경찰
	System.out.println("==경찰1==");
	Police police1 = new Police(5, 3);
	police1.shut();
	police1.putHandcuff();
	//권총보유x 경찰
	System.out.println("==경찰2==");
	Police police2 = new Police(0, 3);
	police2.shut();
	police2.putHandcuff();
	}
}