package ex19;

class Increment
{
	int num=0;
	
	//1.동기화처리가 안된 메소드: 결과 비정상
//	public void increment() {
//		num++;
//	}
	
	//2.동기화방법1: 동기화메소드
	//==>메소드 전체를 동기화한다
//	public synchronized void increment() {
//		num++;
//	}
	
	/*
	 3.동기화방법2: 동기화블럭
	 ==>메소드내 필요한 코드만 블럭으로 지정하는방법
	 */
	public void increment() {
		synchronized(this) {
			num++;
		}
	}
	
	/*
	 -synchronized 선언으로 정확한결과 나왔지만 코드 실행 시간이 엄청나게 증가한다
	 -즉 동기화는 성능감소 초래하며 필요부분에만 동기화처리 하는것이 좋다
	 -동기화 메소드보다 동기화블럭이 기본적으로 좋은 성능을 낸다
	 */
	public int getNum() {
		return num;
	}
}
class IncThread extends Thread
{
	Increment inc;
	
	public IncThread(Increment inc)
	{
		this.inc = inc;
		
	}
	public void run() {
		for(int i=1 ; i<=10000 ; i++) {
			for(int j=1 ; j<=10000 ; j++) {
			inc.increment();
		}
	}
}

public class Ex05Sync2Longtime
{

	public static void main(String[] args)
	{
		Increment inc = new Increment();
		IncThread it1 = new IncThread(inc);
		IncThread it2 = new IncThread(inc);
		IncThread it3 = new IncThread(inc);
			it1.start();
			it2.start();
			it3.start();
			try {
				it1.join();
				it2.join();
				it3.join();
			}
		catch (InterruptedException e) {}
		System.out.println("결과:"+ inc.getNum());
	}
}
