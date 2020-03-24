package ex10accessmod;

//과일판매자를 추상화한 클래스
class FruitSeller
{
	//외부클래스 접근할수없도록 private로 선언
	private int numOfApple;//판매자의 사과 보유갯수
	private int myMoney;//판매수익
	private int APPLE_PRICE; //다시상수로 선언함

	public FruitSeller(int money, int appleNum, int price) {
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
class FruitBuyer
{
	private int myMoney;//보유한 금액
	private int numOfApple;//구매한 사과의 갯수
	/*
	 초기화메소드: 멤버변수 초기화할때 사용 2차버전 생성자대신 사용되고 있으며 객체 초기화시 여러줄 걸쳐 코딩해야
	 하는 번거로움 해결
	 */
	public FruitBuyer(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	public void buyApple(FruitSeller seller, int money)
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

public class E03InformationHiding
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
		FruitSeller seller1 = new FruitSeller(0, 100, 1000);
		//판매자2
		FruitSeller seller2 = new FruitSeller(0, 80, 500);
		
		FruitBuyer buyer = new FruitBuyer(10000, 0);
		
		System.out.println("구매행위가 일어나기전상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		/*
 	멤버변수 private 선언하면 외부클래스 접근 불가능 아래코드 에러발생
		 */
//		seller1.myMoney += 1000; //판매자1에게 1000원결제
//		seller1.numOfApple -= 50; //사과50개 구매
//		buyer.numOfApple += 50;
//		
//		seller2.myMoney += 1000; //판매자2 1000원결제
//		seller2.numOfApple -= 70; //사과70개 구매
//		buyer.numOfApple += 70; //하지만 구매자보유금액 차감X
		/*
		 판매자1,2에게 각각금액지불하고 금액해당하는 사과를 정상적으로구매 정보은닉통해 판매규칙 지켜지게 됨
		 */
		buyer.buyApple(seller1, 1000);
		buyer.buyApple(seller2, 1000);
		
		System.out.println("구매행위가 일어난후 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
	}

}
