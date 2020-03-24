package ex17collection;

//오렌지 표현한 클래스
class Orange {
	int sugar;
	public Orange(int sugar) {
		this.sugar=sugar;
	}
	public void showInfo() {
		System.out.println("오렌지 당도"+ sugar +"입니다");
	}
}
//오렌지 전용박스: Orange객체만 저장할수있는 클래스
class OrangeBox{
	Orange item;
	public void store(Orange item) {
		this.item = item;
	}
	public Orange pullOut() {
		return item;
	}
}
//과일상자: Object기반으로 모든객체 저장할수있는 클래스
class FruitBox{
	Object item;
	public FruitBox(Object item) {
		this.item = item;
	}
	public void store(Orange item) {
		this.item = item;
	}
	public Object pullOut() {
		return item;
	}
}
public class Ex01GenericBasic {
	
	public static void main(String[] args) {
		/*
		 OrangeBox에 Orange객체를 생성해서 저장후 정보출력
		 */
		OrangeBox oBox1 = new OrangeBox();
		Orange orange1 = new Orange(10); //당도10인 오렌지
		oBox1.store(orange1);
		orange1 = oBox1.pullOut();
		orange1.showInfo();
		
		/*
		 상자1은 오렌지전용박스라 다른과일(객체)를 저장할수 없다 컴파일 에러 발생하며
		 실행자체 불가능하다
		 -> 자료형에는 안전하지만 구현에는 불편함이 따른다
		 다른객체를 저장하기위해서 또다른 Box클래스를 생성해야 한다
		 */
		
		/*
		oBox1.store("당도20오렌지"); <-컴파일에러
		Orange orange2 = oBox1.pullOut();
		orange2.showInfo();
		*/
		
		/*
		 Object를 기반으로 한FuritBox는 구현에 편리하지만 코드레벨에서 컴파일 에러가
		 발생하지 않으며 오류를 찾아내기가 훨씬 더 힘들다 자료형에는 안전하지 못한 코드가 된다
		 */
		FruitBox fBox1 = new FruitBox(new Orange(20));
		Orange orange3 = (Orange)fBox1.pullOut();
		orange3.showInfo();
		
		FruitBox fBox2 = new FruitBox("당도30오렌지");
		Orange orange4 = (Orange)fBox2.pullOut();  //<-런타임에러(예외발생)
		orange4.showInfo();
		
	}
}














public class Ex01GenericBasic
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
