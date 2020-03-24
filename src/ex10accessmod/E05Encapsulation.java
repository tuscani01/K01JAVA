package ex10accessmod;
/*
 캡슐화[encapsulation]
 :여러가지 비즈니스 로직을 하나로 묶는 의미와 업무순서까지 
 고려한형태의 로직구성한다는 의미를 가지고있다 관련있는 메소드 하나의클래스로 묶는것을 말함
 */
public class E05Encapsulation
{
//아래 4가지업무는 번호순서대로 진행되어야한다고 가정한다
	class MemberRegist {
		void doMemberRegist() {
			System.out.println("1.회원가입진행");
		}
	}
	class CongratulationPoint {
		void doMemberRegist() {
			System.out.println("3.가입축하10포인트지급");
		}
	}
	class AutoLogin {
		void doAutoLogin() {
			System.out.println("2.자동로그인");
		}
	}
	class FirstLoginEvent {
		void doFirstLoginEvent() {
			System.out.println("4.첫로그인 이벤트페이지 이동");
		}
	}
	/*
	 업무 순서를 고려해 관련된 메소드를 하나의 클래스로 정의 차후 별도 분석작업없이 해당 클래스
	 메소드만 호출하면 업무는 오류없이 진행된다
	 */
	class EncapsulLogic {
		
		MemberRegist memberRegist = new MemberRegist();
		FirstLoginEvent firstLoginEvent = new FirstLoginEvent();
		AutoLogin autoLogin = new AutoLogin();
		CongratulationPoint congratulationPoint = new
				CongratulationPoint();
		void doProcess() {
			memberRegist.doMemberRegist();
			autoLogin.doAutoLogin();
			congratulationPoint.doCongratulationPoint();
			firstLoginEvent.doFirstLoginEvent();
		}
	}
	public class E05Encapsulation {
		
		public static void main(String[] args) {
			/*
			 업무진행순서가 중요할때 캡슐화 이전코드에서 
			 개발자가 순서 지키지 않은 상태에서 실행이 가능한코드가 된다
			 */
			System.out.println("캡슐화전코드");
			
			MemberRegist memberRegist = new MemberRegist();
			FirstLoginEvent firstLoginEvent = new FirstLoginEvent();
			AutoLogin autoLogin = new AutoLogin();
			CongratulationPoint congratulationPoint = new
			CongratulationPoint();
			
			memberRegist.doMemberRegist();
			firstLoginEvent.doFirstLoginEvent();
			congratulationPoint.doCongratulationPoint();
			autoLogin.doAutoLogin();
			
			System.out.println("===========================");
			
			System.out.println("캡슐화이후코드");
			new EncapsulLogic().doProcess();
			
		}
	}
}