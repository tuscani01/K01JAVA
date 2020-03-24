package ex09package;
/*
 /*
연습문제] 해당 프로그램을 아래의 지시에 따라 패키지로 
구분하여 정상 실행되도록 변경하시오.

FruitSeller4 클래스 -> kosmo.seller 패키지에 묶는다.
FruitBuyer4 클래스 -> kosmo.buyer 패키지에 묶는다.

두 클래스를 적당히 import하여 정상동작할수 있도록 
FruitSalesMain4 클래스를 구성한다.
 */
/*
 FruitSeller4 클래스는 외부패키지에 정의되어있으므로 반드시 import해야한다 buyApple() 메소드에서 매개변수로 사용
 */

import ex09package.kosmo.buyer.FruitBuyer4;
import ex09package.kosmo.seller.FruitSeller4;

//과일판매자를 추상화한 클래스


//구매자룰 표현한 클래스

public class FruitSalesMain4
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
		FruitSeller4 seller1 = new FruitSeller4(0, 100, 1000);
		//판매자2
		FruitSeller4 seller2 = new FruitSeller4(0, 80, 500);
		
		FruitBuyer4 buyer = new FruitBuyer4(10000, 0);
		
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
