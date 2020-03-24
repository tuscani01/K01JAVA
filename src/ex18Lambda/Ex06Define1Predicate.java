package ex18Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
/*
 java에서 제공하는 기본함수형인터페이스로 다음같은 종류가있다
 큰차이점이라면 매개변수유무,리턴값유무
 
 Consumer : 매개변수있고 리턴값없음
 Supplier : 매개변수없음 리턴값있고
 Fnction : 매개변수,리턴값있고
 Predicate : 매개변수있고 리턴boolean값으로 반환함
 
 */
import ex08class.Human;

public class Ex06Define1Predicate
{
	/*
	 Interface A {
	 boolean test(Object obj);
	 }
	 */
	public static void main(String[] args)
	{
		/*
		 interface Predicate<E> {
		 	boolean test(T t);
		 	}
		 	: 전달된 인자 대상으로true, false판단할때
		 	사용하는 추상메소드정의하고있다
		 */
	Human p1 = new Human("케이윌", "남", 80);
	Human p2 = new Human("에일리", "여", 84);
	/*
	 Predicate<Human> 인터페이스구현하여 정의한 람다식 test()추상메소드 오버라이딩
	 */
	Predicate<Human> pre = (Human h) -> {
		//성별이 남자일때 true를 반환함
		return h.getGender().equals("남");
	};
	System.out.println("p.test(p1) => "+ pre.test(p1));
	System.out.println("p.test(p2) => "+ pre.test(p2));
	System.out.println("================================");
	
	{
		Human p3 = new Human("임재범", "남", 97);
		Human p4 = new Human("아이유")
	
				//일반적 배열 list컬렉션 변경해주는 메소드
		List<Human> list1 = Arrays.asList(p1, p2, p3, p4);
		
		//람다식 자체 매개변수로전달
		//첫번째호출: 매개변수 객체가 남자일때 true를 반환하는 람다식전달
		
		doble maleAvg = avg(a -> a.getGender().equals("남"), list1);
		System.out.println("남자평균:"+ maleAvg);
		
		//두번째호출: 매개변수 객체가 여자일때 true를 반환하는 람다식전달
		double femaleAvg = avg(a -> a.getGender().equals("남"), list1);
		System.out.println("여자평균:"+ femaleAvg);
	
		System.out.println("=========================")
	}////end ofmain
	List<Integer> list = Arrays.asList(1, 3, 5, 7, 9, 11, 12, 14);
	
	int total;
	total = sum((Integer n) -> n%2 == 0 , list);
	System.out.println("짝수합:"+ total);
	
	total = sum((Integer n) -> n%2 != 0 , list);
	System.out.println("홀수합:"+ total);
	}
	
	public static int sum(Predicate<Integer> p, List<Integer> list) {
		
		int sum = 0;
		for(int a : list) {
			if(p.test(a)) {
				sum += a;
			}
		}
	return sum;
	}
	
	
	
	/*
	 매개변수 성별 판단하는 람다식과 list컬렉션을 전달받아 평균값 반환하는 메소드
	 */
	
	public static double avg(Predicate<Human> ph, List<Human> li) {
		int pCount = 0; //전달된 객체의성별에따라 인원수를 카운트
		int tCount = 0; //점수 누적해서 더해 총점 저장하기위한변수
		for(Human h : li) { //li컬렉션 크기만큼 반복
			/*
			 첫번째 호출에서 남자일때 true를 반환한다 즉 남자 점수가 카운트
			 두번째 호출은 여자
			 */
		}
			if(ph.test(h)==true) {
				pCount++; //인원수증가
				tCount += h.getScore(); //점수합산
			}
		}
		return (double)tCount / pCount; //평균값 계산후 반환
	}//// end of avg
}///end of class