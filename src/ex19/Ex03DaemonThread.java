package ex19;

/*
 쓰레드 구현하지 않은클래스
 
 :하나의클래스 작업끝날때 다음 클래스 작업 진행가능 즉 동시 작업 진행할수없다
 
 */
class NotThread
{
	String title;
	public NotThread(String title) {
		this.title = title;
	}
	void notThreadMethod() {
		for(int i=1 ; i<=10 ; i++) {
			System.out.println(
				String.format("%s]i=%d", title, i)
			);
		}
	}
}
/*
 독립스레드
 :메인스레드, working쓰레드(개발자정의한쓰레드)를 말한다 메인쓰레드가 종료되어도 계속실행되고
 dead상태가 되어야 실행이 종료되는 쓰레드를말한다 해당 쓰레드 실행하게되면 main메소드가 종료된 이후에도
 실행되는걸 볼수있다
 */
class YesThread extends Thread
{
	public YesThread() {}
	
	/*
	 Thread클래스 생성자 호출할때 전달하는 매개변수통해 해당 쓰레드 이름지정가능
	 지정된 이름 getName()메소드 통해 반환
	 */
	
	public YesThread(String threadName) {
		super(threadName);
	}
void threadMethod() throws InterruptedException{
	for(int i=1 ; i<=10 ; i++) {
		System.out.println(
				String.format("%s]i=%d", getName(), i)
				);
				sleep(2000); //2초에 1번씩 block상태가된다
	}
}
@Override
public void run() {
	try {
		threadMethod();
	}
	catch(InterruptedException e) {}
	}
}
/*
 종속스레드
 : 모든독립스레드가 종료시 자동으로 종료되는 쓰레드를뜻한다 주로 프로그램 보조역할 배경음악,로그자동저장
 등 을 처리한다 프로그램종료될때 자동종료되며 주로 무한루프로 구성된다 setDaemon(true)메소드로 설정가능
 */
class DaemonThread extends Thread
{
	@Override
	public void run() {
		while(true) {
			System.out.println(
					String.format("[스레드명:%s]jazz가흘러, getName()));",
							getName())
					);
					try {
						sleep(3000);
						System.out.println("3초마다 자동저장");
					}
					catch(InterruptedException e) {
						System.out.println("자동저장 오류발생");
					}
		}
	}
}

public class Ex03DaemonThread
{

	public static void main(String[] args)
	{
	/*
	 스레드 구현하지않은 클래스 작업
	 */
		NotThread nt1 = new NotThread("첫번째 클래스");
		nt1.notThreadMethod();
		
		NotThread nt2 = new NotThread("두번째 클래스");
		nt2.notThreadMethod();
		/*
		 독립쓰레드 실행
		 */
		YesThread yt1 = new YesThread("1st 스레드");
		yt1.setName("첫번째스레드"); //스레드이름지정 2번째방법
		yt1.start(); //스레드 객체를 Runnable상태로 만들어준다
		
		YesThread yt2 = new YesThread();
		/*
		 스레드생성시 이름지정하지않으면 JVM이 자동으로 이름부여
		 */
		yt2.setPriority(Thread.MAX_PRIORITY);
		yt2.start();
		/*
		 데몬쓰레드 실행
		 */
		DaemonThread dt = new DaemonThread();
		dt.setName("데몬스레드");
		dt.setDaemon(true); //독립스레드를 데몬스레드로 만들어줌
		dt.start();
		
		System.out.println("현재활성화된 스레드수"+
				Thread.activeCount());
		System.out.println("현재실행중 스레드명"+
				Thread.currentThread().getName());
		System.out.println("메인함수 우선순위:"+
				Thread.currentThread().getPriority());
		System.out.println("메인함수종료");
		
	}
}
