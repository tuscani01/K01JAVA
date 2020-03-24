package ex10accessModifier.sub;

public class QuRectangle
{

	public static void main(String[] args)
	{
		

		class Rectangle
		{
			//멤버변수
		   	private int ulx, uly;//좌상단(upper left x, upper left y)
		   	private int lrx, lry;//우하단(lower right x, lower right y)
		   	//좌표값이 정상인지 판단하기위한 멤버변수추가
		   	private boolean isTrue = true;
		   	//기본생성자
		   	public Rectangle()
			{
				
		   		
		   		
			}
		   	
		   	//인자생성자
		   	public Rectangle(int ulx, int uly, int lrx, int lry) {
		   		/* 
				좌표값이 정상범위안에 있는지 판단하여 초기화한다.
				*/
		   		 if(isRange(ulx)==false || isRange(uly)==false ) {
		   			 System.out.println("좌상단 좌표범위가 잘못되었다");
		   			 isTure = false;
		   		 }
		   			 if(isRange(lrx)==false || isRange(uly)==false ) {
		   				System.out.println("우하단 좌표범위가 잘못되었다");
		   				isTure = false;
		   		 }
		   			 
		   			 //좌측좌표와 우측좌표가뒤바뀐경우 오류로 처리
		   			 if(ulx>=lrx || uly>=lry) {
		   				System.out.println("좌/우측 좌표지정이 잘못되었다");
		   				isTure = false;
		   			 }
		   			 //멤버변수초기화
		   			 this.ulx = ulx;
		   			 this.uly = uly;
		   			 this.lrx = lrx;
		   			 this.lry = lry;
		   		
		   	}   
		   	//인자로전달된 좌표값이 정상범위안에 있는지판단
		   	public boolean isRange(int point){		
		   		if(point<0 || point>100)
		   			return false; //0과 100의범위를 벗어나면 좌표오류
		   		else
		   			return true;
		   	
		   	}
		   	public void showArea()
		   	{
		   		/* 사각형의 넓이를 구하는 메소드 정의 */
		   		if(isTrue==false) {
		   			System.out.println("좌표값오류로 넓이계산이 불가함");
		   			return;
		   		}
		   		//좌표값구하여 넓이계산
		   		int xLength = lrx - ulx;
		   		int xLength = lrx - uly;
		   		System.out.println("사각형 넓이"+ (xLength*yLength));
		   	}  	
		}

		class QuRectangle
		{
		   	public static void main(String[] args)
		   	{
				//여기부터
//		     		Rectangle rec = new Rectangle();
//		     		rec.ulx=22;
//		     		rec.uly=22;
//		     		rec.lrx=10;
//		     		rec.lry=10;
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

		
	}

}
