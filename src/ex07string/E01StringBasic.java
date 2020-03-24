package ex07string;

public class E01StringBasic extends Object{


	public static void main(String[] args)
	{

		int num1 = 10, num2 = 20;
		String numResult = (num1 == num2) ? "데이터가 같다" : "데이터가 다르다";
		System.out.println("비교결과:" + numResult);

		/*
		 * String클래스의 객체생성 방법1: new를 사용한다
		 * new를 사용하여 객책를 생성하면 동일한 문자열이라도
		 * 항상 새로운 메모리를 할당한다
		 */
		String str1 = new String("Hello java");
		String str2 = new String("Hello java");
		/*
		 * str1,str2는String객체의 참조값을 가지고 있으므로
		 * 아래는 참조값에 대한 비교를 진행한다
		 */
		if (str1 == str2)
		{
			System.out.println("str1과str2는 참조주소 같음");
		} else
		{
			System.out.println("str1과str2는 참조주소 다름");
		}
		/*
		 * equals()메소드
		 * :object클래스로부터 상속받은 메소드로 실제 저장된
		 * 문자열을 비교하도록 만들어진 메소드다
		 * 즉 아래는 객체에 실제 저장된 문자열에 대한 비교가 이루어진다
		 */
		if (str1.equals(str2))
		{
			System.out.println("동일");
		} else
		{
			System.out.println("다름");
		}
		
		/*
		 * String틀레스릐 객체생성 방법2 : "(더블쿼테이션)"을 사용한다
		 */
		String str3 = "kosmo";
		String str4 = "kosmo";
		//내용에 대한 비교는 동일하다
		System.out.println("equals()메소드로 문자열 비교:"+ str3.equals(str4));
		
		/*
		 * 자바에서 문자ㅏ열객채를 생성할떄 new를 사용하지 않고 "을 사용하면
		 * 동일한 문자열인 경우 한군데만 메모리를 생성하여 공유하게된다
		 */
		if(str3==str4) {
			System.out.println("주소가 같다");
		}
		else {
			System.out.println("주소가 다르다");
		}
		System.out.println("the end..!!");
	}

}
