package ex13interface;

import java.util.Scanner;

interface Week {
	int MON=1, TUE=2, WED=3, THU=4, FRI=5, SAT=6, SUN=7	
}

public class E04InterfaceConstant
{

	public static void main(String[] args)
	{
		System.out.println("오늘의 요일선택");
		System.out.println("1.월요일 ~ 7.일요일");
		System.out.print("선택(정수입력): ");
		
		Scanner sc = new Scanner(System.in);
		int sel = sc.nextInt();
		
		switch(sel)
		{
		case Week.MON:
			System.out.println("주간회의 있다");
			break;
		case Week.TUE:
			System.out.println("프로젝트 기획회의가있습니다");
			break;
		case Week.WED:
			System.out.println("프로젝트 기획회의가있습니다");
			break;
		case Week.THU:
			System.out.println("프로젝트 기획회의가있습니다");
			break;
		case Week.FRI:
			System.out.println("프로젝트 기획회의가있습니다");
			break;
		case Week.SAT:
			System.out.println("프로젝트 기획회의가있습니다");
			break;
		case Week.SUN:
			System.out.println("프로젝트 기획회의가있습니다");
			break;
		}
	}
}
