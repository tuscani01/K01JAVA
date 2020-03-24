package ex17collection;

class Apple{
	int weight;
	public Apple(int w) {
		weight = w;
	}
	public void showInfo() {
		System.out.println("사과무게"+ weight +"입니다");
	}
}
class Banner{
	int sugar;
	public Banner(int s) {
		sugar = s;
	}
	public void showInfo() {
		System.out.println("바나나당도 "+ sugar +" 입니다");
	}
}

/*
 class FruitBox{
	Object item;

	}
	public void store(Orange item) {
		this.item = item;
	}
	public Object pullOut() {
		return item;
	}
}
=> 기존Object기반의 FuritBox를 아래와같이 제네릭클래스로 정의한다 자료형 해당하는 부분을 대표문자T(Type)으로 교체하고
객체생성시 자료형 결정하기 위해 "클래스명<T>"형태로 변경
 */

class GenericFruitBox<T> {
	T item;
	public void store(T item) {
		this.item = item;
	}
	public T pullOut() {
		return item;
	}
}

public class Ex02GenericClass
{

	public static void main(String[] args)
	{
		/*
		 인스턴스 생성시 T부분 결정하며 구현 편의성 보장된다 각각 apple, banner객체 저장할수있는 인스턴스가 생성되었다
		 */
		GenericFruitBox<Apple> appleBox = new GenericFruitBox<Apple>();
		appleBox.store(new Apple(10));
		Apple apple = appleBox.pullOut()
				apple.showInfo();
		
		GenericFruitBox<Banner> bannerBox = new GenericFruitBox<Banner>();
		bannerBox.store(new Banner(10));
		Banner banner = bannerBox.pullOut()
		banner.showInfo();
		
		/*
		 orangebox는 인스턴스 생성시 orange를 저장할수있는 용도로 생성되었고 다른객체 저장할수없다
		 아래 코드에서 컴파일에러가 발생하며 자료형에도 안전한 코드가 된다
		 */
		
		GenericFruitBox<Orange> orangeBox = new GenericFruitBox<Orange>();
//		orangeBox.store("나오렌지"); <-컴파일에러발생>
//		orangeBox.store(apple);
//		orangeBox.store(banner);
	}
}
