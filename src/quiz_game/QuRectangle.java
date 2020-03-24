package quiz_game;

class Rectangle
{
	//멤버변수
	int width; //가로
	int height; //세로
	//인자생성자
	public Rectangle(int w , int h) {
		this.width = w;
		this.height = h;
	}
	public void ShowAreaInfo() {
	
		class Square extends Rectangle
		{
			//멤버변수: 확장없음
			/*
			 부모클래스에서 이미가로, 세로길이가 정의되어 있으며 추가적 멤버변수 정의 불필요
			 */
			
			//생성자
			/*
			 정사각형은 가로, 세로길이가 동일하며 인자값 1개로 부모멤버변수 2개 동시에 초기화
			 */
			public Square(int w) {
				super(w, w);
			}
			/*
			넓이구하는 공식 동일하나 부모닌 직사각형, 자식은 정사각형 면적 출력 하므로 오버라이딩 해야한다
			 */
			@Override
			public void ShowAreaInfo() {
				System.out.println("정사각형면적:"+ (width*height));
			}
		}
		
		
	}
	
   	int ulx, uly;//좌상단(upper left x, upper left y)
   	int lrx, lry;//우하단(lower right x, lower right y)
   	
   	//point클래스 기반 원(circle) 클래스 표현하기
   	class Circle{
   		int radian; //반지름
   		Point center;
   		
   		//생성자
   		/*
   		 반지름 표현하는 radian과 중심좌표 표현한 Point객체생성 Point 객체 생성 위해서 2개 인자가 필요
   		 */
   		
   		public Circle(int x, int y, int r) {
   			radian = r;
   			center = new Point(x, y);
   		}
   		public void ShowCircleInfo() {
   			System.out.println("반지름:"+ radian);
   			/*
   			 원의중심좌표 정보출력, 상속관계 아니며 객체 이용해서 멤버메소드 호출한다
   			 */
   			center.showPointInfo();
   			
   			class Ring{
   				//멤버변수
   				Circle innerCircle;//안쪽원
   				Circle outerCircle;//바깥쪽원
   				
   				/*
   				 멤버변수 2개인 circle클래스 객체 생성
   				 */
   				public Ring(int inX, int inY, int inR,
   						int outX, int outY, int outR) {
   					innerCircle = new Circle(inX, inY, inR);
   					outerCircle = new Circle(outX, outY, outR);
   				}
   				
   				/*
   				 링의 정보 출력위해 2개의 원이 멤버메소드를 호출
   				 */
   				public void showRingInfo() {
   					System.out.println("안쪽원");
   					innerCircle.ShowCircleInfo();
   					System.out.println("바깥쪽원");
   					outerCircle.ShowCircleInfo();
   				}
   			}
   		}
   		
   	//생성자
   	public Rectangle(int ulx, int uly, int lrx, int lry) {
   		/* 
		좌표값이 정상범위안에 있는지 판단하여 초기화한다.
		*/
   	}   	   	
   	public void showArea()
   	{
   		/* 사각형의 넓이를 구하는 메소드 정의 */
   	}  	
}

class QuRectangle
{
   	public static void main(String[] args)
   	{
		//여기부터
     		Rectangle rec = new Rectangle();
     		rec.ulx=22;
     		rec.uly=22;
     		rec.lrx=10;
     		rec.lry=10;
		//여기까지는 정보은닉후 실행되지 않게 해야한다....

		//아래 생성자로만 객체생성후 초기화 되도록 처리한다...
		Rectangle rec1 = new Rectangle(1,1,10,10);
		rec1.showArea();
		
		Rectangle rec2 = new Rectangle(-2,-2,101,101);
		rec2.showArea();
		
		Rectangle rec3 = new Rectangle(10,10,1,1);
		rec3.showArea();
   	}
}




















public class QuRectangle
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
