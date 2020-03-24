package ex02variable;

public class E07TypeCasting {

	public static void main(String[] args) {
		
		/*
		 *자동형변환 : 작은 상자의 데이터를 큰상자에 대입할때 자동 형변환이 된다,
		 */
		byte b1 = 65;
		short s1;
		s1 = b1;
		System.out.printf("b1은 %d, s1은 %d%n", b1,s1);
		
		/*
		  * 아래코드는 자동형변환이 아님. Cpu는 int 보다 작은 자료형을
		  * int로 간주하고 연산을 진행하며, 결과도 int로 반환한다,
		  */
		int num1 = b1 + s1;
		int num2 = num1;
		System.out.println("num1은" + num2);
		
		/*
		 * char형(문자타입)애 byte형(숫자타입)을 바로 대입할수 없다,
		 * 성질이 다르므로 명시적 형변환후 대입
		 */
		//char ch1 = b1;
		char ch2 = (char)b1;
		System.out.println("b1="+ b1 +",ch2="+ ch2);
		
		/*
		 * 명시적 형변환 : 큰상자의 자료를 작은 상자의 자료형에 할당해야항떄 
		 * 사용한다, 단, 이때는 데이터 손실이 있을수 있음 
		 */
		short s2 =100;
		byte b2 = (byte)s2;
		System.out.printf("데이터손실: b2=%d, s2=%d\n",b2,s2);
		
		/*
		 * 소수점 아레부분이 버려지므로 데이터 손실됨, 그래서 특수한 경우 아니면 자제하는게 좋음
		 */
		int num3;
		double dl = 3.14;
		num3 = (int)dl;
		System.out.printf("데이터손실: num3=%d, dl=%.2f %n", num3, dl);
		
		/*
		 * char와 int를 연산하면 결과는 int를 반환하므로 char형 변수에 대ㅇ입하려면 명시적 형변횐후 해야함
		 */
		char ch3 = 'A', ch4;
		int num4 = 2;
		
		//ch4 = ch3 + num4;
		ch4 =(char)(ch3 + num4);
		System.out.println("ch4=" + ch4);

	}

}
