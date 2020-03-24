package ex17collection;

import java.util.HashSet;
import java.util.Iterator;

import common.Teacher;

/*
 hashset컬렉션: set계열 인터페이스 구현한 컬렉션으로
 -객체 순서없이저장
 -객체 중복저장 허용X
 단 기본클래스아닌 새롭게 정의한 클래스라면 hashCode,equals메소드 적절히 오버라이딩해야한다
 -List가 배열 성격이면 set은 집합성격
 */

public class Ex04Hashset1
{

	public static void main(String[] args)
	{
	/*
	 1]set컬렉션 생성
	 */
		HashSet<Object> set = new HashSet<Object>();
		//2]다양한객체생성
		String strObject1 = "JAVA";
		String strObject2 = new String("KOSMO61기");
		Date dateObject = new Date();
		int number = 100; // <-- integer 인스턴스로저장됨
		Teacher teacher = new Teacher("김봉두", 55, "체육");
			/*
			 3]객체저장
			 :add()메소드 통해 객체가 정상적으로 저장되면 true를 반환한다	
			 */
		System.out.println(set.add(strObject1)); //true반환
		set.add(strObject2);
		set.add(dateObject);
		set.add(number); // <-- new Integer(number)
		set.add(teacher);
		/*
		 4]저장된객체수 얻기
		 */
		System.out.println("[중복저장전 객체수]:"+ set.size()); //5개
		
		/*
		 5-1] 기본클래스형 객체중복저장
		 :기본클래스 별도 오버라이딩 없이 중복이제거된다 아래 경우 false가 반환된다
		 */
	System.out.println(set.add(strObject2) ? "저장성공":"저장실패");
	System.out.println("[중복(String)저장후 객체수]:"+set.size()); //5개
	
	/*
	 5-2]개발자가 정의한 객체중복저장
	 :직접 정의한 클래스는 hashcode, equals메소드 오버라이딩 하지 않으면 중복저장 허용된다
	 아래 경우 저장에 성공해 true가 반환된다
	 */
	Teacher teacher2 = new Teacher("김봉두", 55, "체육");
	System.out.println(set.add(teacher2) ? "성공" : "실패"); //성공
	System.out.println("[중복(teacher2)저장후 객체수]:"+set.size());
	
	/*
	 6] 저장된객체출력
	 :순서없이 저장되며 출력도 순서를 지정할수없다
	 */
	Iterator itr = set.iterator();
	while(itr.hasNext()) {
		Object object = itr.next();
		
		if(object instanceof String) {
			System.out.println("String타입:"+ object);
		}
		else if(object instanceof Date) {
			System.out.println("Date타입:"+ object);
		}
		else if(object instanceof Integer) {
			System.out.println("Integer타입:"+ object);
		}
		else if(object instanceof Teacher) {
			System.out.println("Teacher타입:"+ ((Teacher)object).getInfo());
		}
		else {
			System.out.println("넌뭐냐");
		}
	}

	//1-7]]검색
	System.out.println(set.contains(strObject1) ?
			"strObject1있다" : "strObject1없다");
	System.out.println(set.contains("java") ?
			"java있다" : "java없다");
	
	//1-8]삭제
	System.out.println(set.remove(strObject2) ?
			"strObject2삭제성공" : "strObject2삭제실패");
	System.out.println(set.remove("android") ?
			"android삭제성공" : "android삭제실패");
	System.out.println("[삭제후 개체수]"+ set.size());
	//1-9]전체삭제
	//set.clear();
	System.out.println("전체삭제:"+ set.removeAll(set));
	System.out.println("전체삭제후 객체수:"+ set.size()));
	}
}
