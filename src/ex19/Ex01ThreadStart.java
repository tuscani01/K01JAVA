package ex19;

/*
 Thread(스레드)
 -스레드생성 Thread클래스 상속받는것부터 시작한다
 -해당방법은 쓰레드생성할 클래스가 다른 클래스 상속받지 않아도될때 사용하는 방식이다
 -만약 다른 클래스 상속받아야한다면 JAVA는 다중상속이 불가능하며 Runnable 인터페이스 구현하는방법 사용
 */

class ShowThread extends Thread
{
	String threadName;
	public ShowThread(String name) {
		threadName = name;
	}
	/*
	 run()메소드 쓰레드main()메소드에 해당한다
	Thread클래스 run()메소드 오버라이딩한것이며 해당 메소드직접 호출하면 안되고
	start()메소드 통해 간접적으로 호출해야한다
	만약 직접 호출하면 단순한 실행만 될뿐 쓰레드가 생성되지 않으며 주의해야한다
	 */
	@Override
	public void run() {
		for(int i=1 ; i<=100 ; i++) {
			System.out.println("안녕["+threadName+"]이다");
			try {
				/*
				 thread클래스 static메소드로 실행 흐름을 주어진 시간만큼 block상태로
				 전환시켜준다
				 1000이 1초고 아래는 0.01초만큼 block시킨다
				 */
				sleep(10);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
public class Ex01ThreadStart
{

	public static void main(String[] args)
	{
		ShowThread st1 = new ShowThread("쓰레드1st");
		ShowThread st2 = new ShowThread("Thread2nd");
		//쓰레드객체통한 생성(실행)
		st1.start();
		st2.start();
		
		//run()통해 호출가능 쓰레드 생성X
		//st1.run();
		//st2.run();
		
	}
}
