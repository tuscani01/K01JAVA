package ex15usefulClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class E05DateCalendarX
{
	static Date date;
	
	static String myDateFormat(Calendar cal) {
		
		//메소드 이름만으로 기능유추하기 어렵다
		date = cal.getTime(); //메소드명 time인데 반환형 date이다
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
		
	}

	public static void main(String[] args)
	{
		/*
		 날짜 하나 표현하기위해 3개 클래스 사용 번거롭고, 생성비용이 비싸다
		 */
		Calendar cal = Calendar.getInstance();
		System.out.println("현재날짜 : "+ myDateFormat(cal));
		
		cal.add(Calendar.DATE, 1);
		System.out.println("내일날짜 : "+ myDateFormat(cal));
		
		//애매한 상수가 많이존재
		Calendar cal2 = Calendar.getInstance();
		cal2.add(Calendar.MONDAY, 1);
		System.out.println("월요일 하루더함 : "+
		myDateFormat(cal2));
		
		//월 표현 상수가 실제월과 -1차이가 난다
		System.out.println("JANUARY는 1월인데 : "+ Calendar.JANUARY);
		System.out.println("DECEMBER가 11월인가? : "+
		Calendar.DECEMBER);
	}

}
