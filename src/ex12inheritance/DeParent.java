package ex12inheritance;

public class DeParent {
	
	private String name;
	private int age;
	
	public DeParent() {}
	public DeParent(String name, int age)
	{
		
		this.name = name;
		this.age = age;
	}
	
	//getter()메소드
	public String getName() {
	{
		return name;
	}
		/*
		 멤버메소드정의
		 -4가지 메소드 정의
		 */
	private void eat() {
		System.out.println("부모님드신다");
	}
	String sleep() {
		System.out.println("부모님주무신다");
		return null;
	}
		protected void walk() {
			System.out.println("부모님 산책신다");
		}
		protected void excecise() {
		System.out.println("부모님 운동하다");
		}
		//정보출력 메소드
		public void printParent() {
			System.out.printf("성함:%s, 연세:%d", name, age);
		}
		//정적메소드 정의
		public static void staticMethod() {
			System.out.println("부모님의 정적메소드");
	}
}