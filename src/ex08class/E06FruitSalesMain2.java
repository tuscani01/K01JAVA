package ex08class;

//과일판매자를 추상화한 클래스
class FruitSeller2
{
	int numOfApple;//판매자의 사과 보유갯수
	int myMoney;//판매수익
	int apple_price; /*사과의 단가 ->일반변수로 변경
		클래스 멤버상수로 정의하는경우 선언과 동시에 초기화 해야하며 상수는 초기값이 없는 형태로는 사용이 불가능
	*/
	
	/*
	 apple_price를 상수에서 변수로 변경한이유 상수는 단한번만 초기화되는 특성 일반적 멤버메소드내 초기화 할수X
	 멤버메소드는 개발자 원할때 언제든지 호출가능 상수 특성과 맞지 않음
	 */
	public void initMembers(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		apple_price = price;
	}
	
	public int saleApple(int money)
	{
		int num = money / apple_price;
		numOfApple -= num;
		myMoney += money;
		return num;
	}

	public void showSaleResult()
	{
		System.out.println("[판매자]남은사과갯수 = " + numOfApple);
		System.out.println("[판매자]판매수익 = " + myMoney);
	}
}
//구매자룰 표현한 클래스
class FruitBuyer2
{
	int myMoney;//보유한 금액
	int numOfApple;//구매한 사과의 갯수
	/*
	 초기화메소드: 멤버변수 초기화할때 사용 2차버전 생성자대신 사용되고 있으며 객체 초기화시 여러줄 걸쳐 코딩해야
	 하는 번거로움 해결
	 */
	public void initMembers(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	public void buyApple(FruitSeller2 seller, int money)
	{
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}

	public void showBuyResult()
	{
		System.out.println("[구매자]현재잔액 = "+ myMoney);
		System.out.println("[구매자]사과갯수 = "+ numOfApple);
	}
}

public class E06FruitSalesMain2
{

	public static void main(String[] args)
	/*
	 초기화 메소드의해 서로 다른 초기값 가진 객체 생성할수 있음
	 아래에서는 판매단가와 재고가 서로 다른 2개 판매자 객체 생성
	 */
	{
		//판매자1
		FruitSeller2 seller1 = new FruitSeller2();
		seller1.initMembers(0, 100, 1000);
		//판매자2
		FruitSeller2 seller2 = new FruitSeller2();
		seller1.initMembers(0, 80, 500);
		
		FruitBuyer2 buyer = new FruitBuyer2();
		buyer.initMembers(10000, 0);
		
		System.out.println("구매행위가 일어나기전상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		//판매자1,판매자2에게 각각 5000원지불하고 구매
		buyer.buyApple(seller1,  5000);
		buyer.buyApple(seller2,  5000);
		
		System.out.println("구매행위가 일어난후 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
	}

}
