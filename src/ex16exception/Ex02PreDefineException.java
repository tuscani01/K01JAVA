package ex16exception;

import java.sql.Date;
import java.util.Scanner;

/*
 2]런타임에러
 -컴파일시 체크가 안되고 실행시에만 발생되는 에러
 -RuntimeException 클래스 계열로 NullPointerException이 대표적 하위클래스
 -main메소드에서 무시하기위해 throws 하더라도 오류가 발생되며 반드시 예외처리 해줘야한다
 -예외발생시 JVM은 해당 예외클래스 인스턴스화해서 프로그램쪽으로 전달하게되고 try~catch에서 받은후 처리
 */
public class Ex02PreDefineException
{
	//참조변수 선언만하고 객체생성은 되지 않은상태
	static Date toDay;

	public static void main(String[] args)
	{
		
		/*
		 1] ArrayIndexOutOfBoundsException
		 :배열의 크기를 벗어난 인덱스를 사용할때 발생되는 예외
		 */
		System.out.println("### ArrayIndexOutOfBoundsException ###");
		int[] intArr = new int[2];
		//try {
			intArr[0] = 100;
			System.out.println("0번방은:"+ intArr[0]);
			intArr[1] = 200;
			System.out.println("1번방은:"+ intArr[1]);
			
			intArr[2] = 300;
			/*
			 예외가 발생하는 지점, 예외객체가 던져지며 아래문장 실행되지않음
			 catch블럭으로 바로 넘어감
			 */
			
			System.out.println("앗이방은?"+ intArr[2]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("예외가 발생");
			/*
			 getMessage() : 예외에대한 간략한 메세지만 표시
			 printStackTrace(); 예외가 발생할때 에러메세지를 그대로 콘솔에 출력해줌
			 개발시 훨씬더 사용빈도 높음
			 */
			System.out.println("예외메세지:"+ e.getMessage());
			e.printStackTrace();
		}
		System.out.println("0번방 재출력:"+ intArr[0]);
		System.out.println("==ArrayIndexOutOfBoundsException발생 후==");
		/*
		 2] NumberFormatException
		 :숫자형식 문자열 int로 변환하는 경우 해당 문자열이 숫자형식 아니면 발생되는 예외
		 */
		System.out.println("### NumberFormatException ###");
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("나이를 입력:");
			String strAge = sc.nextLine(); //<= "10살"형태로 입력
			int ageAfter10 = Integer.parseInt(strAge) + 10; //예외발생
			System.out.println("당신의 10년후나이는:"+ ageAfter10);
		}
		catch(NumberFormatException e) {
			System.out.println("나이는 숫자로만 입력해야한다");
			System.out.println("예외메세지:"+ e.getMessage());
			e.printStackTrace();
		}
		
		/*
		 3] InputMismatchException : 숫자를 입력해야 되는데 문자열을 입력할때 발생되는 예외
		 
		 */
		System.out.println("### InputMismatchException ###");
		try {
			System.out.print("나이 입력하세요:");
			int intAge = sc.nextInt();
			int ageAfter10 = intAge + 10;
			System.out.println("당신의 10년후 나이는:"+ ageAfter10);
		}
		catch(InputMismatchException e) {
			System.out.println("나이를 문자형태로 입력하면 안됨");
			System.out.println("예외메세지:"+e.getMessage());
			e.printStackTrace();
		}	
		/*
		 4] NullPointerException
		 :인스턴스 변수에 참조값없는 상태에서 호출하면 발생되는예외 즉 참조변수만 생성되고
		 참조할 객체가 없는 상태에서 사용했을때 발생하게된다
		 */
		System.out.println("### NullPointerException ###");
		System.out.println("toDay="+ toDay);
		/*
		 toDay참조변수가 가지고있는 null값을 toString()메소드를 통해 String형태로
		 변환되어 출력된다 예외는 발생하지 않았음
		 */
		try {
			System.out.println(toDay.getTime());
			/*
			참조변수 참조할 객체가 없는 상태 해당 메소드 호출할수 없어 예외 발생
			 */
		}
		catch(NullPointerException e) {
			System.out.println("toDay 참조변수는 null입니다");
			System.out.println("예외메세지:"+ e.getMessage());
		}
		/*
		 5] ArithmeticException
		 :수학적 계산이 불가능한 경우 발생되는 예외
		 */
		
		System.out.println("### ArithmeticException ###");
		int result = 10;
		try {
			result = result / 0;
			System.out.println("결과는:"+ result);
		}
		catch(ArithmeticException e) {
			System.out.println("0으로 나눌수 없다");
			System.out.println("예외메세지:"+ e.getMessage());
		}
		/*
		 6] ClassCastException
		 객체 형변환 불가능한 경우 발생되는 에외
		 */
		Object object = new Object();
		try {
			String strObject = (String)object;
		}
		catch(ClassCastException e) {
			System.out.println("형변환 할수없다");
			System.out.println(e);
			System.out.println(e.getMessage());
		e.printStackTrace(); //개발시 가장 많이 쓴다
	}
		System.out.println("==ClassCastException발생후==");
		
}//myClassCast




String str = "형변환되나요?";
boolean castFlag = myClassCast(str);
if(castFlag==true) {
	System.out.println("됩니다용.");
}
else{
	System.out.println("안됩니다용");
}

		
}//main end

/*
 String 객체가 매개변수로 전달되며 Object로 형변환되기 때문에 여기서는 상속관계가 확인되어 true를 반환한다
 */
public static boolean myClassCast(Object str) {		
	if(str instanceof String){
		return true;
	}
	else{
		return false;
	}



