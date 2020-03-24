package ex12inheritance;

class Account {
	/*
	 멤버변수가 상속관계 있다 하더라도 private으로 선언되면
	 클래스내부에서 접근가능 즉 상속받은 하위클래스 직접접근 불가능
	 */
	private int money; //잔고
	public Account(int init) {
		money = init;
	}
	/*
	 입금처리: protected로 선언되었으며 상속관계에서 접근가능
	 */
	protected void depositMoney(int_money) {
		if(_money<0) {
			System.out.println("마이너스금액 입금처리불가함");
			return;
		}
		money += _money;
	}
	//private 멤버변수를 외부클래스로 반환할때 사용
	protected int getAccMoney() {
		return money;
	}
}
class SavingAccount extends Account {
	/*
	 인자생성자에서 부모의 생성자 메소드를 호출하기 위해
	  super()를 사용하고있다 이때 인자가 하나인 생성자를 호출하게된다
	 */
	public SavingAccount (int initVal) {
		super(initVal);
	
	/*
	 부모클래스에 protectd로 선언된 멤버메소드를 각각호출
	 private멤버변수인 money는 직접 접근할수 없으며 접근 가능한 메소드 통해 간접적으로 접근한다
	 */
	}
	public void saveMoney(int money) {
		depositMoney(money);
	}
	public void showAccountMoney() {
		System.out.println("지금까지 누적금액:"+ getAccMoney());
		//System.out.println("지금까지 누적금액:"+ money) //[접근불가]
	}
}
public class E02PrivateInheritanceMain
{

	public static void main(String[] args)
	{
		/*
		 private 멤버이므로 상속받은 하위클래스 참조변수 통해 접근이 불가능하다 부모 멤버메소드 통해 접근한다
		 */
		SavingAccount sa = new SavingAccount(10000);
		
		//sa.money = 100000; //[접근불가]
		
		sa.saveMoney(5000);
		sa.showAccountMoney();
		
		sa.saveMoney(5000);
		sa.showAccountMoney();
		sa.saveMoney(-1000);
		sa.showAccountMoney();
		/*
		 부모객체 참조변수 통해서도 private멤버는 접근이 불가능 현재위치가 다른 클래스이기때문
		 */
		
		Account account = new Account(1000);
		//account.money = 1000; //접근불가
		
	}

}
