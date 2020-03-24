package ex18Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import ex08class.Human;

/*
 Function
 -매개변수와 리턴값 둘다 가진applyXXX()계열의 추상메소드를 가지고있음
 -위 메소드는매개값,리턴값으로 타입변환(매핑)하는 역할을한다
 */
public class Ex06Define4function
{
	public static void main(String[] args)
	{
		/*
		interface Function<T,E> {
		E apply(T);
		}
		*/
		//문자열 매개변수 받아 길이반환하는 람다식
		//String형의 인자를받아서 Integer형의 반환값을 가짐
		Function<String, Integer> func = (String s) -> {
			return s.length();
		};
		System.out.println("============================");
		
		Human p1 = new Human("케이윌", "남", 80);
		Human p2 = new Human("에일리", "여", 88);
		Human p3 = new Human("임재범", "남", 97);
		Human p4 = new Human("아이유", "여", 90);
		List<Human> list = Arrays.asList(p1, p2, p3, p4);
		//Human객체를 매개값으로받아서 점수반환하는 람다식
		
		Function<Human, Integer> getFunction = (human h) -> {
			return h.getScore(); //Human객체 score값변환
		};
		int score = getFunction.apply(p1);
		System.out.println("p1점수:"+ score);
		
		System.out.println("###list저장된 객체점수출력");
		for(Human h : list) {
			System.out.println(h.getName() + "의점수 : "+ getFunction.apply(h));
		}
	}
}
