package ex08class;

public class E06FruitSalesMain2___
{
	
	int numOfApple;
	int myMoney;
	int apple_price;

	public void initMembers(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		apple_price = price;
	}
	public static void main(String[] args)
	{
	
		public int saleApple(int money) 
		{
			int num = money / apple_price;
			numOfApple -= num;
			myMoney += money;
			return num;
		}
		
		public void showSaleResult() {
			System.out.println("[판매자]남은사과개수:"+ numOfApple);
			System.out.println("[판매자]판매수익:"+ myMoney);
		}
	}

	class FuritBuyer2{
		int myMoney;
		int numOfApple;
		
		public void initMembers(int _myMoney, int _numOfApple) {
			myMoney = myMoney;
			numOfApple = _numOfApple;
		}
	}
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+ myMoney);
		System.out.println("[구매자]사과개수:"+ numOfApple);
	}
}
public class E06FuritSalesMain2 {
	
	public static void main(String[] args) {
		
		//판매자1
		FruitSeller2 seller1 = new FruitSeller2();
		seller1.initMembers(0, 100, 1000);
		//판매자1
		FruitSeller2 seller1 = new FruitSeller2();
		seller1.initMembers(0, 100, 1000);
	}
}
