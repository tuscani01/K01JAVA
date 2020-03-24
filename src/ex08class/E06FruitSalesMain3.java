package ex08class;

//과일판매자를 추상화한 클래스
class FruitSeller3
{
	int numOfApple;//판매자의 사과 보유갯수
	int myMoney;//판매수익
	int APPLE_PRICE; //다시상수로 선언함
	/*
	 상수는 값의 변경 불가능하고 단 한번만 초기화되기 때문에 일반적 멤버메소드 초기화X
	단 생성자 메소드에서는 초기화 가능 마음대로 호출X 객체생성시 
	단 한번만 호출되는 특성이 동일하기 때문 한번이상 초기화 되지 않음이 보장되기 때문
	 */
	
	public FruitSeller3(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		APPLE_PRICE = price; // <=생성자 내에서는 상수 초기화할수있음
	}
	
	public int saleApple(int money)
	{
		int num = money / APPLE_PRICE;
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
class FruitBuyer3
{
	int myMoney;//보유한 금액
	int numOfApple;//구매한 사과의 갯수
	/*
	 초기화메소드: 멤버변수 초기화할때 사용 2차버전 생성자대신 사용되고 있으며 객체 초기화시 여러줄 걸쳐 코딩해야
	 하는 번거로움 해결
	 */
	public FruitBuyer3(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	public void buyApple(FruitSeller3 seller, int money)
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

public class E06FruitSalesMain3
{

	public static void main(String[] args)
	/*
	 초기화 메소드의해 서로 다른 초기값 가진 객체 생성할수 있음
	 아래에서는 판매단가와 재고가 서로 다른 2개 판매자 객체 생성
	 */
	{
		/*
		 생성자 통해서 객체 생성과 동시에 초기화 되므로 init(초기화메소드) 메소드를 호출할필요 X
		 따라서 객체생성코드 한줄로 줄일수있다
		 */
		//판매자1
		FruitSeller3 seller1 = new FruitSeller3(0, 100, 1000);
		//판매자2
		FruitSeller3 seller2 = new FruitSeller3(0, 80, 500);
		
		FruitBuyer3 buyer = new FruitBuyer3(10000, 0);
		
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
