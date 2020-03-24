package ex15usefulClass;

/*
 equals() 메소드
 -자바에서 인스턴스 내용비교위해 비교연산자(==)를 사용한것은 단순히 참조값에 대한 비교이며 실제 내용에
 대한 비교는 이뤄지지 않았따
 -인스턴스간 내용비교 위해서 equals()메소드 각 클래스에 맞게 적절히 오버라이딩하여 사용해야한다
 -String과 같은 기본클래스는 별도의 오버라이딩없이 내용비교가 가능하다
 */
class IntNumber {
	int num;
	public IntNumber(int num) {
		this.num = num;
	}
	/*
	  equals()메소드가 어떻게 인스턴스간 내용 비교하는지 설명하기 위한 코드로 구성됨
	 */
	public boolean myEquals(IntNumber numObj) {
		if(this.num==numObj.num) {
			return true; //값이 같을때 true반환
		}
		else {
			return false; //다를때 false반환
		}
		
	}
}

public class E04Object2MyEquals
{

	public static void main(String[] args)
	{
		//기본클래스 String클래스 인스턴스 비교
		String str1 = new String("우린kosmo");
		String str2 = "우린kosmo"
				
				if(str1.equals(str2)) {
					System.out.println("같은 문자열이다");
				}
				else {
					System.out.println("다른 문자열이다");
				}
		//개발자가 정의한클래스에대한 비교
		IntNumber num1 = new IntNumber(10);
		IntNumber num2 = new IntNumber(20);
		IntNumber num3 = new IntNumber(10);
		
		if(num1.myEquals(num2)) {
			System.out.println("num1과 num2는 동일정수");
		}
		else {
			System.out.println("num1과 num2는 다른정수");
		}
		if(num1.myEquals(num3)) {
			System.out.println("num1과 num3은 동일정수");
		}
		else {
			System.out.println("num1과 num3은 다른정수");
		}
	}
}
