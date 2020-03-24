package ex17collection;

import java.util.ArrayList;

/*
 ArrayList: List계열의 컬렉션으로
 -데이터 중복저장 허용
 -데이터 저장순서 보장
 -대이터 접근할때 iterator() 혹은 get()를 이용한다
 -Array라는 이름처럼 배열의 특성을 가지고 있어 인덱스를 통한 저장및 접근이 가능하다
 */
public class Ex03Arraylist1
{

	public static void main(String[] args)
	{
	/*
	 List<E> 인터페이스계열의 컬렉션
	 :ArrayList<T>와 같은 컬렉션은 제네릭을 기반으로 하지만 아래와같이 <T>부분을 생략하면 모든객체 저장할수있다
	 즉 <Object>로 선언한것과 동일하다
	 */
	ArrayList list = new ArrayList();
	
	/*
	 1-1]객체저장: add()메소드
	 add(객체): 순차적으로 저장하면서 인덱스는 0부터 자동으로 부여한다
	 add(인덱스,객체): 인덱스 직접부여해 객체를 저장한다 인덱스 건너뛸시 예외가 발생된다
	 size(): 컬렉션 저장된 객체 개수 반환한다
	 배열 크기와 동일하다고 생각하면된다
	 */
	list.add("소녀시대"); //인덱스0
	list.add("빅뱅"); //인덱스0
	list.add("트와이스"); //인덱스0
	list.add(3, "원더걸스"); //인덱스0
	//list.add("여자아이들"); //에러발생 인덱스 건너뛸수X
	list.add(list.size(),"오마이걸"); // <--4번 인덱스 입력됨
	list.add(list.size(),"걸스데이"); //에러발생
	System.out.println("중복저장전객체수:"+ list.size());
	
	/*
	 1-2]중복저장
	 : List는 배열 속성 가지며 중복저장 허용
	 add()메소드 입력 성공한경우 true를 반환
	 */
	System.out.println(list.add("트와이스") ? "중복저장"
			: "중복저장안됨");
	System.out.println("중복 저장후 객체수:"+ list.size());
	/*
	 1-3]리스트컬렉션 출력하기(for,확장for문)
	 */
	System.out.println("\n[일반for문 사용]");
	for(int i=0 ; i<list.size() ; i++) {
		System.out.print(list.get(i) +" ");
	}
		System.out.println("\\n[확장for문 사용]\"");
		for(Object obj : list) {
			System.out.print(obj +" ");
		}
			/*
			 iterrator사용법
			 -컬렉션 저장된 내용 Iterator에게 알려주기위해
			 객체 생성
			 -hasNext()메소드 반환할 객체가 있는지 검사하고
			 next()메소드로 해당 객체 반환한다
			 -만약 반환객체 없다면 false를 반환한다
			 */
			System.out.println("\n[반복자(Iterator) 사용]");
			Iterator itr = list.iterator();
			while(itr.hasNext()) {
				System.out.print(itr.next() + " ");
			}
			System.out.println("\n========================\n");
			/*
			 1-4덮어쓰기
			 set(인덱스,객체) : 특정 인덱스 저장된 데이터를 덮어쓰게되며 기존자료는 삭제된다
			 */
			list.set(4, "오마이걸>덮어쓰기");
			for(Object obj : list) {
				System.out.print(obj +" ");
			}
			System.out.println("\n========================\n");
			/*
			 1-5끼우기
			 add(삽입할인덱스,객체): 해당 인덱스에 넣고 기존데이터 뒤로 밀린다
			 */
			list.add(4, "블랙핑크>끼워넣기");
			for(Object obj : list) {
				System.out.print(obj +" ");
			}
			System.out.println("\n========================\n");
			/*
			 1-6 포함여부확인
			 contains(객체명): 찾고자하는 객체 있는경우 true를 반환한다
			 */
			System.out.println(list.contains("빅뱅") ? "빅뱅 있음" :
				"빅뱅 없음");
			System.out.println(list.contains("블랙핑크") ? "블랙핑크 있음" :
					"블랙핑크 없음");
			
			/*
			 1-7 삭제방법1
			 방법1: 인덱스로 삭제하기
			 remove(인덱스): 인덱스 통해서 삭제 진행한후 삭제가 완료되면 해당 객체 반환한다 삭제후에 인덱스가 자동으로 재부여된다
			 */
			Object obj = list.remove(2);
			System.out.println("삭제된객체:"+ obj);
			
			//방법2: indexOf()메소드로 인덱스 찾아삭제
			int index = list.indexOf("빅뱅");
			System.out.println("빅뱅의 index="+ index);
			list.remove(index);
			
			//방법3: 인스턴스 참조값(주소)값 통해 삭제
			System.out.println(list.remove("방탄소년") ? "삭제성공"
					:"삭제실패");
			list.remove("오마이걸")
			System.out.println("삭제후출력");
			for(Object ob : list) {
				System.out.print(ob +" ");
			}
			System.out.println();
			/*
			 1-8전체삭제
			 */
			list.removeAll(list); //빙밥1
			list.clear();
			System.out.println("전체삭제후 객체수:"+ list.size());
	}
}
