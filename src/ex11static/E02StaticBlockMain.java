package ex11static;

public class E02StaticBlockMain
{

	public static void main(String[] args)
	{
		System.out.println("static블럭 - 다른클래스메인메소드");
		StaticBlock sb = new StaticBlock();
		System.out.println("StaticBlock.staticVar="
				+ StaticBlock.staticVar);
		

	}

}
