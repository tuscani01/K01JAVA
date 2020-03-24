package ex09package.kosmo.buyer;

import ex09package.kosmo.seller.FruitSeller4;

public class FruitBuyer4
{
	int myMoney;//보유한 금액
	int numOfApple;//구매한 사과의 갯수
	/*
	 초기화메소드: 멤버변수 초기화할때 사용 2차버전 생성자대신 사용되고 있으며 객체 초기화시 여러줄 걸쳐 코딩해야
	 하는 번거로움 해결
	 */
	public FruitBuyer4(int _myMoney, int _numOfApple) {
		myMoney = _myMoney;
		numOfApple = _numOfApple;
	}
	public void buyApple(FruitSeller4 seller, int money)
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
