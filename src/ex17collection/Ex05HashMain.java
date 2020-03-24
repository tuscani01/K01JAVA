package ex17collection;

import java.text.Collator;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


/*
 hashmap<k,v>
 :map<t>인터페이스 구현한 컬렉션클래스
 -key,value의쌍 객체저장한다
 -키값 중복될수없다 중복이면 덮어쓰기 처리된다
 -키값 검색하면 다른컬렉션보다 속도빠름
 */
public class Ex05HashMain
{

	public static void main(String[] args)
	{
		//Map컬렉션생성, key와value는 String형으로 선언
	HashMap<String, String> map = new HashMap<String, String>();
	/*
	객체저장:
	객체저장시 기존저장된 동일한 key값이 존재하면 이전객체가 반환된다 만약 처음이라면
	null값이 반환된다
	 */
	System.out.println("name이란키값으로 저장된 이전값:"+
			map.put("name", "홍길동")); //-->null반환됨
	
	int number = 20;
	
	//map.put("age", number); ///에러발생 value타입 맞지않아서
	map.put("age", String.valueOf(number));
	map.put("gender", "남자");
	map.put("address", "가산디지털");
	
	/*
	 3.객체
	 */
	System.out.println("저장객체수:"+ map.size());
	
	/*
	 4중복저장
	 :기존입력된 name이라는 key값이 있어 "홍길동"이 출력된다
	 그리고 기존의 값이 "최길동"으로 갱신된다
	 */
	System.out.println("name이란 키값저장된 이전값:"+
	 map.put("name", "최길")); //덮어쓰기처리
	System.out.println("키값중복저장후 객체수:"+ map.size()); //4개
	
	/*
	 5]출력
	 5-1키값 알고있을대 출력하기
	 :get(키값)으로 value출력
	 */
	System.out.println("키값알때:"+ map.get("name"));
	
	/*
	 5-2]키값 모를때
	 1. Set<T> keySet()메소드 호출 통해 키값들을 Set계열 컬렉션 형태로 가져온다
	 2. Map계열 처음부터확장 for문 사용하는것 불가능하다
	 3. 키값 얻어온후 확장for문을 통해 key값을 하나씩 출력한다
	 */
	Set<String> keys = map.keySet();
	System.out.println("[확장for문 적용]");
	for(String key : keys) {
		String value = map.get(key);
		System.out.println(String.format("%s:%s", key, value));
/*
 5-3]반복자통한 출력
:Iterator통해 반복할때도 keySet()으로 키값을 먼저 얻어온후 사용할수있다
 */
		System.out.println("[반복자사용]");
		Set<String> keys2 = map.keySet();
		Iterator<String> it = keys2.iterator();
		while(it.hasNext()) {
			String key1 = it.next(); //키값얻기
			String value2 = map.get(key); //밸류값 얻기
			System.out.println(String.format("%s:%s", key, value));
		}
		/*
		 5-4] Value값만 얻을때 : values()메소드 사용
		 */
		System.out.println("[value값만 출력]");
		Collection<String> values = map.values();
		for(String value1 : values) {
			System.out.println(value);
		}
		/*
		 6]존재유무판단
		 : 존재할경우 true를 반환한다
		 */
		System.out.println(map.containsKey("name") ?
				"name키값있다" : "name키값없다");
		System.out.println(map.containsKey("account") ?
				"account키값있다" : "account키값없다");
		System.out.println(map.containsKey("남자") ?
				"남자있다" : "남자없다");
		System.out.println(map.containsKey("여자") ?
				"여자있다" : "여자없다");
		/*
		 7]삭제
		 : key값통해 삭제하고, 삭제가 완료되면 해당 value가 반환된다
		 */
		System.out.println("삭제된개체:"+ map.remove("age"));
		System.out.println("[age키값 삭제후출력]");
		for(String key : keys) {
			System.out.println(String.format("%s:%s",
					key, map.get(key)));
		}
		//8]전체삭제: removeAll()은 없음
		map.clear();
		System.out.println("전체삭제후 객체수:"+ map.size());
		
		}
	}
}

