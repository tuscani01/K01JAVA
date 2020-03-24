package ex19;

class Sum{
	int num;
	public Sum() {
		num=0;
	}
	/*
	 매개변수n을 멤버변수 num에 누적해서 더함
	 */
	public void addNum(int n) {
		num += n;
	}
	public int getNum() {
		return num;
	}
}
/*
 Thread클래스 생성하는 두번째 방법
 : 다중상속 지원되지않으며 다른 클래스 상속받아야 한다면 Runnable인터페이스 구현해서
 쓰레드클래스 정의한다
 */
class AdderThread extends Sum implements Runnable {
	int start, end;
	public AdderThread(int s, int e) {
		start = s;
		end = e;
	}
	/*
	 멤버변수 start와 end만큼 반복하며 부모클래스의 addNum()메소드 호출해 누적합 구한다
	 */
	public void run() {
		for(int i=start ; i<=end ; i++) {
			//쓰레드동작확인위한 로그
			System.out.println("i="+ i);
			addNum(i);
		}
	}
}
public class Ex04Runnable
{

	public static void main(String[] args)
	{
		/*
		 Runnable인터페이스 구현한 클래스 인스턴스 대상으로 쓰레드 생성한다 해당 방법도 결국
		 Thread클래스 통해 스레드 생성한다
		 */
	AdderThread at1 = new AdderThread(1, 500);
	AdderThread at2 = new AdderThread(501, 1000);
	
	Thread thread1 = new Thread(at1);
	Thread thread2 = new Thread(at2);

	//2개 쓰레드생성
	thread1.start();
	thread2.start();
	
	try {
		/*
		 생성된쓰레드가 작업완료하기 기다리는 기능을 수행한다 즉 해당 쓰레드가 하나의 작업이 종료되기
		 기다렸다가 다음 스레드를 실행한다 쓰레드 동시접근 제한하는 기능 가지고있다
		 */
		thread1.join();
		thread2.join();
		
	}
	catch(InterruptedException e) {
		e.printStackTrace();
	}
	System.out.println("1~1000까지합:"+(at1.getNum()+at2.getNum()));
	}

}
