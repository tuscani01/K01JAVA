package ex15usefulClass;
/*
 Wrapper클래스
 :기본자료형의 데이터 인스턴스화할때 사용하는 클래스 
 -오토박싱: 기본자료형이 자동으로 참조형으로 변경되는것
 예] int => Integer
 -오토언박싱: 참조형이 기본자료형으로 자동변경되는것
 
※ 오토박싱 언박싱은 jdk1.5이상에서 적용
 */
public class E01WrapperClass1
{

	public static void main(String[] args)
	{
		//일반적 정수의연산
		int num1 = 10;
		int num1 = 20;
		int result = num1 + num2;
		System.out.println("result="+ result);
		
		//JDK1.4이전 버전에서 코딩형태
		/*
		 기본자료형 박싱처리한 객체에 대한 산술연산 언박싱하기 위해 intValue()같은 메소드 통해 값 꺼내온다
		 */
		Integer n100bj = new Integer(10);
		Integer n200bj = new Integer(num2);
		int result2 = n100bj.intValue() + n200bj.intValue();
		System.out.println("result2="+ result2);
		
		Integer result0bj = new Integer(result2);
		System.out.println("결과값 byte형 값으로 변경:"+
		result0bj.byteValue());
		System.out.println("결과값 2진수로 변경:"+
		Integer.toBinaryString(result2));

		//JDK1.5이후 버전 코딩형태
		Interger numObj1 = 100; //오토박싱처리
		Interger numObj2 = 200;
		int num3 = numObj1 - numObj2;; //오토언박싱처리
		System.out.println("오토언박싱이후연산결과:"+ result3);
		
		/*
		 Wrapper클래스를 사용하는 이점
		 : Wrapper클래스에 정의된 많은 메소드를 사용할수있다 int형의 최대, 최소값 혹은 진법 변환등의 기능을 가지고있다
		 */
		System.out.println("int형 최대값:"+ Integer.MAX_VALUE);
		System.out.println("int형 최소값:"+ Integer.MIN_VALUE);
		System.out.println("10을2진수로:"+
		Integer.toBinaryString(10));
		System.out.println("10을8진수로:"+
				Integer.toOctalString(10));
		System.out.println("10을16진수로:"+
				Integer.toHexString(10));
		
		
		/*
		 자바의 모든클래스는 Object클래스 상속받는다 그래서 아래 메소드 사용가능
		 
		 toString() : 인스턴스변수 출력시 참조값 아니라 실제 저장된 값을 문자열 형태로 반환해주는 메소드
		 hashCode() : 객체 구별하기 위해 참조값 고유한 정수값으로 반환해주는 메소드
		 */
		
		Integer numObj = new Integer(99);
		System.out.println("numObj="+ numObj);
		System.out.println("numObj.toString()="+ numObj.toString());
		System.out.println("numObj.hashCode()="+ numObj.hashCode());
		System.out.println(numObj + 1); //99+1=100
		System.out.println(numObj.toString() + 1); //"99"+1=991
		
	}

}
