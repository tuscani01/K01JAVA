package ex18Lambda;

public class Ex06Define3Consumer
{

	public static void main(String[] args)
	{/*
	interface Consumer<T> {
	void accept(T t);
	}
	*/		
	Consumer<String> c1 = (String s) -> {	
		System.out.println(s +" 는 가수입니다");
	};
	c1.accept("zpdldnlf");
	Consumer<String> c2 = t -> {
		System.out.println(t + "는 과일이다");
		};
		c2.accept("Strawberry");
	}
}
