package ex15usefulClass;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class E05LocalDateTimeo
{

	public static void main(String[] args)
	{
		//현재 시간 정보를 다음 //파일 마지막에서 확인
	Instant start = Instant.now();
	//오늘날짜
	LocalDate nowDate = LocalDate.now();
	System.out.println("오늘날짜 : "+ nowDate);
	//특정날짜 2012년 4월3일
	LocalDate ofDate = LocalDate.of(2012, 4, 3);
	System.out.println("생년월일 :"+ ofDate);
	
	//현재날짜와 시간
	LocalDateTime nowDateTime = LocalDateTime.now();
	System.out.println("지금이순간 : "+ nowDateTime);
	
	//특정날짜와 시간
	LocalDateTime nowDateTime = LocalDateTime.of(2012, 4 3, 4, 58,
			32);
	System.out.println("생년월일 시간 : "+ ofDateTime);
	
	
	DateTimeFormatter Formatter = 
			DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	String dateStr =
			LocalDate.now().atStartOfDay().format(formatter);
	System.out.println("금일자정: "+ dateStr);
	
	LocalDateTime tomorrow = nowDateTime.plusDays(1);
	System.out.println("내일 : "+ tomorrow);
	
	LocalDateTime day3Later =
			LocalDateTime.now().plusDays(3).with(LocalTime.NOON);
	System.out.println("3일후 12시 : "+ day3Later);
	
	System.out.println("2시간 10분후 : "+
	nowDateTime.plusHours(2).plusMinutes(10));
	
	LocalDateTime nowSunday = 
	LocalDateTime.now().with(TemporalAdjusters
			.next(DayOfWeek.SUNDAY));
	System.out.println("가장가까운 다음 일요일 : "+ nowSunday); 
			LocalDate fourthSunday = LocalDate.of(2020, 3,
					1).with(TemporalAdjusters.dayOfWeekInMonth(4, 
							DayOfWeek.SUNDAY));
			System.out.println("2018 3월기준, 네번째일요일 : "+
							fourthSunday);
			LocalDate first12Sunday = LocalDate.of(2020, 3, 1).with(TemporalAdjusters.firstInMonth(DayOfWeek.SUNDAY));
			System.out.println("2020년 3월기준, 첫번째일요일 : "
					first12Sunday);
			
			LocalDate xmas = LocalDate.of(LocalDate.now().getYear(), 12,
					25);
			Period left = Period.between(nowDate, xmas);
			System.out.println("X-mas까지 앞으로 "+ left.getMonths() +"개월 "
					+ left.getDays() +"일");
			Instant end = Instant.now();
			Duration duration = Duration.between(start, end);
			System.out.println("클래스 실행시간확인(두시간차) : "+
			duration.toMillis());
			
	System.out.println(nowDate.getMonth());
	}

}
