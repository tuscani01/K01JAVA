package ex10accessmod;
/*
 DTO클래스(DataTransferObject)
 : 데이터 교환을위한객체 스프링에서는 Bean(빈)이라고 함 주로 DTO객체는로직을 전혀가지고 있지않은 순수 데이터객체
 멤버변수 접근하기 위한 getter/setter메소드를 가지고있다 VO(Value Object)라고 부르기도한다 
 */
public class AccountDTO
{
	//1.속성(멤버변수)
	private String name;
	private String accountNumber;
	private int balance;
	//기본생성자,인자생성자 (필요한경우에만 정의한다)
	public AccountDTO() {}
	public AccountDTO(String name, String accountNumber, int balance)
	{
		
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	//2.getter/setter메소드
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getAccountNumber()
	{
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}
	public int getBalance()
	{
		return balance;
	}
	public void setBalance(int balance)
	{
		this.balance = balance;
	}
	

}
