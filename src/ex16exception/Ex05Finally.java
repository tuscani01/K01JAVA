package ex16exception;

import java.util.InputMismatchException;

/*
 finally절
 : 예외발생 여부 상관없이 try문으로 진입했을때 반드시 실행해야하는 코드가 있는경우 기술하는 블럭
 즉 try문으로 진입되지 않으면 finally절은 실행되지 않는다
 1) try~catch: 예외를 직접 처리할때
 2) try~catch_finally : 예외를 직접 처리후 실행할 문장이 있을때
 3) try~finally: 예외 외부로 던지고 예외발생과 상관없이 실행할 문장 있을때
 */

public class Ex05Finally
{
	static void runtime() throws NumberFormatException {
		Integer.parseInt("백");
	}
	
	static void tryCatchFinally() {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("나이를 입력하세요:");
		int age = Integer.MAX_VALUE;
		try {
			age = scan.nextInt(); //<- 30살
			System.out.println("당신은 5년후 "+ (age+5) +"살 입니다");
			//try구문에서 return을 만나도 finally 구문은 실행된다
			return;
		}
		catch(InputMismatchException e) {
			//예외 발생되도 finally 구문은 실행된다
			System.out.println("나이는 숫자만 쓰세요");
		}
		finally {
			System.out.println("항상 실행되는 finally절 입니다");
			//프로그램 자체가 종료된다
			
			/*
			 try문안에서 exit(0)를 실행하게되면 프로그램 자체가 종료되며 finnaly구문은 실행되지않는다
			 */
			System.exit(0);
		}
	}
	public static void main(String[] args)
	{
	try {
		runtime();
	}
	catch(NumberFormatException e) {
		e.printStackTrace();
	}
	
	tryCatchFinally();
	System.out.println("메인메소드 끝");
	}
}
