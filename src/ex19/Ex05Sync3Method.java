package ex19;

/*
 동기화메소드
 : 여러 스레드의해 호출되는 공유메소드 동기화하여 여러 쓰레드 동시에 접근하지 못하도록 lock 거는것말한다
 */
class MethodSyncClass
{
	//공유메소드 동기화처리함
	synchronized void increase(int seed, int inc) 
	{
	for(int i=1 ; i<=10 ; i++) {
		seed += inc;
		System.out.println(
				String.format("쓰레드명:%s, 씨드값:%d"
						, Thread.currentThread().getName()
						, seed)
						);
		/*
		 메소드 자체 동기화 처리되어 쓰레드 실행중 sleep()을 만나도 다른쓰레드 접근 불가능
		 */
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {}
		
	}

	}
}
class MethodSyncThread extends Thread
{
	MethodSyncClass msc; //공유객체
	int seed, inc;
	public MethodSyncThread(String threadName,
			MethodSyncClass msc, int seed, int inc) {
		
		super(threadName); //쓰레드 이름지정
		this.msc = msc;
		this.seed = seed;
		this.inc = inc;
	}
		@Override
		public void run() {
			msc.increase(seed, inc);
		
	}
}

public class Ex05Sync3Method
{

	public static void main(String[] args)
	{
		//공유메소드 가진 클래스 인스턴스화
		MethodSyncClass msc = new MethodSyncClass();
		
		MethodSyncThread t1 =
				new MethodSyncThread("1st쓰레드", msc, 10, 2);
		MethodSyncThread t2 =
				new MethodSyncThread("2nd쓰레드", msc, 10, 5);
		t1.start();
		t2.start();
		
	}

}
