package ex18Lambda;
/*
 일반적 인터페이스와 클래스 활용한 오버라이딩
 */
interface IKosmo1
{
	/*
	 인터페이스 정의된 메소드는 public abstract로 선언된다
	 */
	void studyLambda(String str);
	
}
class KosmoStudent1 implements IKosmo1
{
	//인터페이스구현받아 반드시 추상메소드를 오버라이딩 해야한다
}
class KosmoStudent1 implements IKosmo1
	{
		@Override
		public void studyLambda(String str) {
			System.out.println(str +"를 공부한다");
		}
	}

public class E01Nomalclass
{

	public static void main(String[] args)
	{
		/*
		 메소드 한개 정의해서 사용할때 인터페이스,상속,오버라이딩,객체생성까지 과정을
		 거쳐야한다 너무나도 복잡한 과정
		 */
	IKosmo1 kosmo = new KosmoStudent1();
	kosmo.studyLambda("람다식");
	}
}
