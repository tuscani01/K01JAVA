package ex17collection;

import java.util.Iterator;
import java.util.LinkedList;

import common.Student;

public class ex03arraylist2
{

	public static void main(String[] args)
	{
		//list계열 컬렉션 생성시 타입매개변수 Student형으로 선언함
		//LinkedList<Student> list2 = new LinkedList<Student>();
		ArrayList<Student> list2 = new ArrayList<Student>();
		
		//개발자정의한 인스턴스 생성(외부패키지)
		Student st1 = new Student("정우성", 10, "2018");
		Student st2 = new Student("원빈", 20, "2017");
		Student st3 = new Student("장동건", 30, "2016");
		Student st4 = new Student("공유", 40, "2015");
		
		//컬렉션에 인스턴스추가
		list2.add(st1); //인덱스0
		list2.add(st2); 
		list2.add(st3); 
		list2.add(st4); //인덱스3
		list2.add(st2); //객체 중복저장 List컬렉션은 중복허용됨
		
		System.out.println("[중복저장후]");
		for(Student st : list2) {
			st.showInfo();
		}
		
		/*
		 인스턴스삭제: 인덱스가 아닌 객체 참조값통해 삭제하는 경우 중복된값 있으면
		 앞에있는 객체하나만 삭제된다
		 */
		list2.remove(st2);
		System.out.println("[중복저장 객체 삭제후]");
		for(Student st : list2) {
			st.showInfo();
		}
		
		System.out.println("[반복자사용]");
		Iterator<Student> it2 = list2.iterator();
		while(it2.hasNext()) {
			/*Student student = it2.next();
			student.showInfo(); */
			/*
			 위와 동일 next()메소드 통해 객체 가져와 showInfo()메소드로 객체 내용출력
			 */
			
			it2.next().showInfo(); //<-한줄로 고쳐 쓸수도있다
		}
		//list계열컬렉션 인덱스 접근가능
		System.out.println("[일반for문사용]");
		for(int i=0 ; i<list2.size() ; i++) {
			/*
			 리스트컬렉션 인덱스 접근할때 get()메소드 사용
			 */
			list2.get(i).showInfo();
		}
		System.out.println("[확장for문사용]");
		for(Student st : list2) {
		st.showInfo();
		}
		
		//인덱스통ㅇ한삭제: 삭제성공시 해당객체 반환된다
		System.out.println("삭제된객체이름:"+ 
				list2.remove(2).name);
		//인스턴스 참조값 통한삭제 : 삭제성공시 boolean값이 반환된다
		list2.remove(st1);
		
		System.out.println("[인스턴스삭제후]");
		for(Student st : list2) {
			st.showInfo();
		}
	}
}
