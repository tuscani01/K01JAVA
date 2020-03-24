package ex13interface.figure;

public class FigureData
{
	int width, height;
	
	public FigureData(int width, int height) {
		this.width = width;
		this.height = height;
		
		package ex13interface.figure;
		
		public class Circle implements IFigure, IDrawable {
			
			int radius;
			public Circle(int radius) {
				this.radius = radius;
			}
			@Override
			public void draw(String figureName) {
				System.out.println(figureName +"을 그립니다");
			}
			@Override
			public void area(String figureName) {
				System.out.println(figureName +"의 면적(가로*세로):"+
			width*height);
			}
		}
		
		
		
		
		
		
		
		
		
	}
}
