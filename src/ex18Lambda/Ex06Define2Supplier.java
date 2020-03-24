package ex18Lambda;

import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List
import java.util.
import java.util.

public class Ex06Define2Supplier
{
	public static List<Integer> makeRandomNum(Supplier<Integer> s, int
	cnt){
	
	List<Integer> li = new ArrayList<Integer>();
	for(int i=1 ; i<=cnt ; i++) {
		li.add(s.get());
	}
	return li;
	}
	public static void main(String[] args)
	{/*
		Interface Supplier<T> {
			Object get();
	}*/
		//get()메소드를 오버라이딩한람다식 난수생성해서 반환함
	Supplier<Integer> sup = () -> {
		Random random = new Random();
		return random.nextInt(100);
	};
	int rNum = sup.get(); /*get()메소드 반환하는 Integer객체를 Auto Unboxing해서 int형 변수에 저장함 */
	
	System.out.println("생성된난수="+ rNum);
		//10개난수 생성 list로반환받음
	List<Integer> list = makeRandomNum(sup, 10);
	System.out.println("##print문 출력1");
	
		System.out.println(list);
		
		System.out.println("##foreach문 출력2");
		for(Integer i : list) {
			System.out.printf("%d ", i);
		}
		System.out.println();
		System.out.println("###이터레이터출력3");
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() +" ");
		}
	}
}
