package ex05method;

import java.util.Scanner;

public class E03MethodType02_2
{
	static String getHakjum() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("국어점수");
		int kor = scanner.nextInt();
		System.out.print("영어점수");
		int eng = scanner.nextInt();
		System.out.print("수학점수");
		int math = scanner.nextInt();
		
		double avg = (kor+eng+math)/3.0;
		
		String hakjum = "";
		
		int result =(int)avg /10;
		
		switch(result){
		case 10: case 9:
		hakjum = "A"; break;
		case 8:
			hakjum ="B"; break;
		case 7:
			hakjum ="C"; break;
		case 6:
			hakjum ="D"; break;
		default:
			hakjum ="F"; break;
		
		}
		return hakjum;
	}
	//평균값의 소수점을 구하기 위헤 double 형으로 연산
	public static void main(String[] args)
	{
		System.out.println("너의 학점은 "+ getHakjum()+ "이야");

	}

}
