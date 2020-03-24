package ex16exception;

import java.util.Scanner;

public class Ex04MultiCatch
{

	public static void main(String[] args)
	{
		/*
		 예외처리 할때 필요에 따라 여러개 catch블럭 사용할수 있다
		 -이경우 반드시 자식예외 클래스부터 catch블럭에 사용된다
		 -Exception클래스는 모든 예외를 catch하기 때문에 마지막 블럭에 사용해야한다
		 -중간에 사용하면 에러가 발생한다
		 */
	Scanner scanner = new Scanner(System.in);
	int array[] = new int[3];
	
	try {
		for(int i=0 ; i<array.length ; i++) {
			System.out.print("array["+ i +"]에 저장할 숫자입력:");
			array[i] = Integer.parseInt(scanner.nextLine());
			//테스트시 '11a' 형태로 입력할것
		}
		System.out.println("배열에저장된 두 숫자 나누기:"+
		array[0]/array[1]); //테스트시 0입력
		
		System.out.print("나이를 입력:");
		int age = scanner.nextInt();
		//나이 입력시 숫자이외 문자 입력할것
		System.out.println("당신의 나이는:"+ age);
		
		array[3] = age;
	}
	catch(InputMismatchException e) {
	System.out.println("숫자로만 입력해야 한다");
}
	catch(ArithmeticException e) {
		System.out.println("산술연산 불가능");
	}
		catch(NumberFormatException e) {
			System.out.println("숫자형태 문자만 입력가능");
		}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("배열인덱스 초과");
			}
	catch(Exception e) {
		System.out.println("예외가 발생");
		System.out.println(e.getMessage());
		e.printStackTrace();
	}
			System.out.println("===프로그램끝===");
	}
}
