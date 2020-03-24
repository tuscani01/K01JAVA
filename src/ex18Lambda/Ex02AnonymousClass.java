package ex18Lambda;
/*
익명클래스로 오버라이딩
 */
interface IKosmo2
{
	/*
	 인터페이스 정의된 메소드는 public abstract로 선언된다
	 */
	void studyLambda(String str);

public class E01Nomalclass
{

	public static void main(String[] args)
	{
		//IKosmo2 인터페이스를 구현한 익명클래스정의
	IKosmo2 kosmo = new IKosmo2() {
		@Override
		public void studyLambda(String str) {
			System.out.println(str+"을 공부하기위해 익명클래스 만들었다")
		}
	};
	kosmo.studyLambda("람다식");
	
	}
}
