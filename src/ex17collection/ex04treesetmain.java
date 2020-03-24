package ex17collection;

import java.util.Iterator;
import java.util.TreeSet;
/*
 TreeSet<T>컬렉션
 -트리라는자료구조 기반으로한 Set컬렉션이다
 -Set의 기본적 특성은동일하나 Tree알고리즘을 통해 정렬되어 저장된다 정렬 기준 개발자 직접정의
 -정렬 기준정하기위해 Comparable<T> 인터페이스 구현해야한다
 */
class MyString implements Comparable<MyString> {
	String str;
	public MyString(String str) {
		this.str = str;
	}
	//문자열길이 반환
	public int getLength() {
		return str.length();
	}
	/*
	 정렬기준위해 오버라이딩한 메소드 가나다와같은 사전순 만자열 길이 다양한 설정 가능
	 아래코드오름차순(작은->큰)정렬일때 사용 1,-1위치 바뀌면 내림차순
	 */
	@Override
	public int compareTo(MyString paramStr) {
		//정렬순서문자열기준
		if(getLength() > paramStr.getLength())
			return 1;
		else if(getLength() < paramStr.getLength())
			return -1;
		else
			return 0;
	}
	@Override
	public String toString() {
		return str;
	}
}

public class ex04treesetmain
{
	public static void main(String[] args)
	{
	TreeSet<Integer> tree1 = new TreeSet<Integer>();
	tree1.add(1);
	tree1.add(4);
	tree1.add(2);
	tree1.add(3);
	System.out.println(tree1.add(2));
	
	System.out.println("저장 데이터 수:"+ tree1.size()
	+"개"); //4개
	
	Iterator<Integer> itr1 = tree1.iterator();
	while(itr1.hasNext()) {
		System.out.println(itr1.next());
	}
	
	//*********************************************************************//
	
	TreeSet<MyString> tree2 = new TreeSet<MyString>();
	tree2.add(new MyString("Orange"));
	tree2.add(new MyString("Apple"));
	tree2.add(new MyString("moonjae"));
	tree2.add(new MyString("KOSMO61"));
	//문자열길이기준 오름차순 정렬된다
	Iterator<MyString> itr2 = tree2.iterator();
	while(itr2.hasNext()) {
		System.out.println(itr2.next());
		}
	}
}