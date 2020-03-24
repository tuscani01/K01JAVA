package quiz_gameexcption;

import java.util.Scanner;

/*
 문제1) QuArrayList.java 
사용자로부터 이름을 입력받아 그 이름으로 검색해서 인덱스 위치(indexOf사용)를 
알아내서 해당 인덱스로 그 객체를 삭제하고 삭제된 객체의 정보(이름,나이,학번)를 출력하여라.
 */

public class QuArrayList
{


public static void main(String[] args) {
	
	//ArrayList<Student> list = new ArrayList<Student>();
	LinkedList<Student> list = new LinkedList<Student>();
	
	//저장할 객체 생성
	Student st1 = new Student("가길동", 10, "2018");
	Student st2 = new Student("나길동", 20, "2017");
	Student st3 = new Student("다길동", 30, "2016");
	Student st4 = new Student("마길동", 40, "2015");
	
	//객체 추가(컬렉션에 저장)
	list.add(st1);
	list.add(st2);
	list.add(st3);
	list.add(st4);
		
	//1.검색할 이름을 입력받음
		Scanner sc = new Scanner(System.in);
		System.out.print("검색이름:");
		String searchName = sc.nextLine();
		
		
	//2.확장for문으로 컬렉션 전체를 접근
		int index = -1; //인덱스 0이상이며 초기값-1로 지정
		for(Student st : list) {
			System.out.println("객체이름:"+ st.getName());
		
			if(st.getName().equals(searchName)) {
			//객체참조값통해 List내 index값 얻어옴
			list.indexOf(st);
			//해당객체찾으면즉시루프탈출
			break;
			
			
		}

	//3.검색결과 유/무에 따라 
	//검색결과 있을때…검색된 데이터 삭제
	
if(index == -1) {
	//검색결과 없을때...검색결과가 없다고 출력
	System.out.println("\n검색결과없음");
}
else {
	//검색결과있을때 검색된 데이터삭제
	System.out.println("\n검색결과있다");
	System.out.println("삭제객체 정보출력");
	/*
	 인덱스통해 컬렉션 저장된 객체삭제하면 해당 객체 반환하게 되며
	 객체 정보 출력할수있다
	 */

	list.remove(index).showInfo();
}
	//4.전체정보 출력
	System.out.println("전체정보출력");
	for(Student st : list) {
		System.out.println(st.getInfo());
	}
}


	}

}
