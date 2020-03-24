package ex13interface.figure;

import

public static void main(String[] args) {
	
	//부모인터페이스 참조변수로 자식객체참조
	IFigure figure = new Circle(30);
	
	//오버라이딩 되어 별도 형변환없이 즉시호출가능
	figure.area("원");
	
	//자식객체 접근하기 위해 다운캐스팅후 메소드호출
	((Circle)figure).draw("나도원");
	
	
	IFigure fig1 = new Rectangle(100, 90);
	fig1.area("사각형");
	((Rectangle)fig1).draw("사각형");
	
	IDrawable draw = new Triangle(100, 90);
	fig1.area("사각형");
	((Rectangle)fig1).draw("사각형");
	
	IDrawable draw = new Triangle(100, 90);
	fig1.area("삼각형");
	((Triangle)draw).draw("삼각형");
	
	Circle circle = new Circle(40);
	circle.area("원");
	circle.draw("나도원");
	}
}