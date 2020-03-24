package quiz_gameexcption;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
/*
 컬렉션 set에 저장된 객체를 이름으로 검색하자. 해당 정보가 있으면 해당 어벤져스의 정보를 출력하고 없으면 "해당 영웅은 없어요ㅜㅜ" 라는 메시지 출력해야 한다. 
 검색 부분은 Iterator를 통해 구현하도록 한다. set계열의 컬렉션은 기본적으로 중복저장을 허용하지 않는다. 그러나 아래와 같이 새롭게 
 정의한 클래스에 대해서는 equals(), hashCode() 메소드를 적절히 오버라이딩 처리해야 중복을 제거할 수 있다. 
 메소드 오버라이딩을 통해 hero4 는 입력되지 않도록 Avengers 클래스를 업데이트 하시오.

 */
class Avengers {
	String name;
	String heroName;
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((heroName == null) ? 0 : heroName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((weapon == null) ? 0 : weapon.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		//형변환
		Avengers avengers = (Avengers)obj;
		if(avengers.name.equals(this.name) &&
				avengers.heroName.equals(this.heroName)) {
			return true;
		}
		else {
			return false;
		}
	}

	String weapon;

	public Avengers(String name, String heroName, String weapon) {
		super();
		this.name = name;
		this.heroName = heroName;
		this.weapon = weapon;
	}

	@Override
	public String toString() {
		return "Avengers [본명=" + name + ", 닉네임=" + heroName + ", "
				+ "능력=" + weapon +"]";
		
	@Override
	public int hashCode() {
			//객체 고유한값(참조값)을 int형으로 반환하는메소드
		int hc1 = name.hashCode();
		int hc1 = heroName.hashCode();
		int hc1 = weapon.hashCode();
		System.out.println(hc1+" "+hc2+" "+hc3);
		int result = hc1 + hc2 + hc3;
		return result;
	}

public class QuHashSet {

	public static void main(String[] args) {

		HashSet<Avengers> set = new HashSet<Avengers>();

		Avengers hero1 = new Avengers("토니스타크", "아이언맨", "Mark-48 수트");
		Avengers hero2 = new Avengers("스티브로져스", "캡틴아메리카", "비브라늄 방패");
		Avengers hero3 = new Avengers("브루스배너", "헐크", "강한피부&점프");
		Avengers hero4 = new Avengers("토니스타크", "아이언맨", "Mark-48 수트");
		
		set.add(hero1);
		set.add(hero2);
		set.add(hero3);
		set.add(hero4);		 

		
		
		System.out.println("[최초 전체 정보출력]");
		for(Avengers av : set)
		{
			System.out.println(av.toString());			
		}
		
		//이름검색
		Scanner sc = new Scanner(System.in);
		System.out.print("검색이름:");
		String searchName = sc.nextLine();
		boolean searchFlag = false;//검색결과유무확인
		
		Iterator<Avengers> itr = set.iterator();
		while(itr.hasNext()) {
			Avengers avengers = itr.next();
			if(searchName.equals(avengers.name)) {
				//검색결과 있다면 플레그변경
				searchFlag = true;
				//toString()메소드 오버라이딩했으며 객체즉시출력가능
				System.out.println(avengers);
			}
		}
		
		if(searchFlag == true) {
			System.out.println("요청한정보 찾았다");
		}
		else {
			System.out.println("해당영웅 없음");
		}	
	}
}

