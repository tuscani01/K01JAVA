package ex09package;

import ex09package.kosmo.perimeter.Circle;
/*
 메인 클래스에서 다른 패키지 클래스 import하여 사용하면 해당 클래스 반드시 public으로 선언
 그렇지 않으면 "not visible" 에러가 발생
 */
public class CircleMain
{

	public static void main(String[] args)
	{
		//원의넓이: 클래스 사용위해 풀패키지 경로 사용함
		ex09package.kosmo.area.Circle circle1 =
				new ex09package.kosmo.area.Circle(6.5);
		
		System.out.println("반지름이6.5인원의넓이:"+ circle1.getArea());
		//원의둘레: import하여 해당클래스 문서에 포함시킨
		Circle circle2 = new Circle(4.5);
		System.out.println("반지름이4.5인원의둘레"+ circle2.getPerimeter());

	}

}
