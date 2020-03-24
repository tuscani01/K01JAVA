package ex13interface.figure;

//※ 인터페이스 하나당 하나의 자바파일 구성하는것 권장함

/*
 두개 인터페이스 동시 구현 여러개 구분할때 콤마로 구분
 */

//인자로 전달되는 도형 넓이 구하는 추상메소드
public class Triangle extends FigureData implements IFigure, IDrawable{
	
	public Triangle(int width, int height) {
		super(width, height);
	}
	/*
	 인터페이스 정의된 추상메소드 필수로 오버라이딩해야한다(non-Javadoc)
	 * @see ex13interface.figure.IDrawable#draw(java.lang.String)
	 */
	@Override
	public void draw(String figureName) {
		System.out.println(figureName +"을 그려봅니다");
	}
	@Override
	public void area(String figureName) {
		System.out.println(figureName +"의 면적은(가로*세로*0.5):"
				+ (width*height*0.5));
	}
}