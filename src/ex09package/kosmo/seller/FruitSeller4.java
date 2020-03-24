package ex09package.kosmo.seller;

public class FruitSeller4 {

	int numOfApple;//판매자의 사과 보유갯수
	int myMoney;//판매수익
	int APPLE_PRICE; //다시상수로 선언함
	/*
	 상수는 값의 변경 불가능하고 단 한번만 초기화되기 때문에 일반적 멤버메소드 초기화X
	단 생성자 메소드에서는 초기화 가능 마음대로 호출X 객체생성시 
	단 한번만 호출되는 특성이 동일하기 때문 한번이상 초기화 되지 않음이 보장되기 때문
	 */
	
	public FruitSeller4(int money, int appleNum, int price) {
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
