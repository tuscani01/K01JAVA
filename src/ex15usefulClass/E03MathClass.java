package ex15usefulClass;

import java.lang.*;
/*
 Math클래스
 -java.lang패키지 포함된 클래스
 -수학과 관련된 일련의 작업들 처리함
 -메소드 static으로 선언되어 객체생성없이 사용가능
 */
public class E03MathClass extends Object {
{

	public static void main(String[] args)
	{
	System.out.println("원주율:"+ Math.PI);
	float f = -3.14f;
	double d = -100.9;
	int num = -10;
	
	//절대값1
	System.out.println("###절대값###");
	System.out.println("Math.abs:"+ Math.abs(f));
	System.out.println("Math.abs:"+ Math.abs(d));
	System.out.println("Math.abs:"+ Math.abs(num));
	
	System.out.println("###올림###");
	System.out.println("Math.ceil:"+ Math.ceil(3.4)); //3
	System.out.println("Math.ceil:"+ Math.ceil(-3.4)); //-4
	System.out.println("Math.ceil:"+ Math.ceil(3.9)); //3
	
	System.out.println("###내림###");
	System.out.println("Math.ceil:"+ Math.ceil(3.4)); //3
	System.out.println("Math.ceil:"+ Math.ceil(-3.4)); //-4
	System.out.println("Math.ceil:"+ Math.ceil(3.9)); //3
	
	/*
	 반올림: 무조건 소수점 첫번째 자리에서 반올림처리
	 */
	System.out.println("###반올림###");
	System.out.println("Math.round:"+ Math.round(3.49999)); //버림처리
	System.out.println("Math.round:"+ Math.round(3.54444)); //버림처리
	System.out.println("Math.round:"+ Math.round(-1.4)); //버림처리
	System.out.println("Math.round:"+ Math.round(-1.5)); //버림처리
	System.out.println("Math.round:"+ Math.round(-3.51)); //버림처리
	
	System.out.println("###최대/최소###");
	System.out.println("Math.max:"+ Math.max(100, 99));
	System.out.println("Math.min:"+ Math.min(100, 99));
	
	System.out.println("###난수###");
	System.out.println((int)(Math.random()*45)+1);
	
	System.out.println("###거듭제곱###");
	System.out.println("2의10승은?"+ Math.pow(2, 10));
	
	}

}
