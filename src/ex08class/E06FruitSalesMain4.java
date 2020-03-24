package ex08class;

//과일판매자를 추상화한 클래스
class FruitSeller
{
	int numOfApple = ;//판매자의 사과 보유갯수
	int myMoney = ;//판매수익
	int apple_price = ;//사과의 단가(상수로 표현)
	
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
class FruitBuyer
{
	int myMoney = ;//보유한 금액
	int numOfApple = ;//구매한 사과의 갯수

	public void buyApple(FruitSeller seller, int money)
	{
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}

	public void showBuyResult()
	{
		System.out.println("[구매자]현재잔액 = " + myMoney);
		System.out.println("[구매자]사과갯수 = " + nunOfApple);
	}
}

public class E06FruitSalesMain4
{

	public static void main(String[] args)
	{
		FruitSeller seller = new FruitSeller();//판매자 객체
		FruitBuyer buyer = new FruitBuyer();//구매자 객체

		System.out.println("구매행위가 일어나기전의 상태");
		seller.showSaleResult();
		buyer.showBuyResult();
		buyer.buyApple(seller, 5000);

		System.out.println("구매행위가 일어난 후의 상태");
		seller.showSaleResult();
		buyer.showBuyResult();
	}

}
