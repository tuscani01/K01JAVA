package ex19;

/*
 스레드 우선순위
 setPriority(우선순위): 쓰레드우선순위 지정할때사용
 getPriority(): 스레드 우선순위변환할때사용
 */
class MessageSendingThread extends Thread
{
	String message;
	
	public MessageSendingThread(String str) {
		message = str;
	}
	//생성자2:멤버변수,우선순위초기화
	public MessageSendingThread(String str, int pri) {
		message = str;
		setPriority(pri);
	}

public void run() {
	for(int i=1 ; i<=10000 ; i++) {
		//스레드이름과 우선순위반환
		System.out.println(message + i +"("+ getPriority() +")");
		
		/*
		 기본적 우선순위높은 스레드가 먼저 실ㅇ행되지만 sleep()메소드 사용하게되면
		 실행중 블럭상태로 전환되어 우선순위가 낮은 스레드도 가끔실행될수있는 상황이나온다
		 */
		try {
			//0.001초동안 블럭상태로만듬
			sleep(1);
		}
		catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		}
	}
}

public class Ex02Priority {
	public static void main(String[] args) {
		
		/*
		 1단계
		 : 우선순위를 별도 지정하지않은상태로 스레드 생성하면 동일한 우선순위 5를 부여받게된다
		 이때 cpu가 알아서 작업을 분배한다
		 */
		MessageSendingThread tr1 = new MessageSendingThread("첫번째");
		MessageSendingThread tr2 = new MessageSendingThread("두번째");
		MessageSendingThread tr3 = new MessageSendingThread("세번째");
		
		/*
		 2단계
		 : 우선순위부여위해 Thread클래스에 static타입 상수를 사용한다
		 ※ 우선순위 높다고 먼저실행되지않는다
		 전체적 확률이 높아지며 먼저 실행될 가능성이 높아진다
		 */
//		
//		MessageSendingThread tr1 =
//				new MessageSendingThread("첫번째", Thread.MAX_PRIORITY);
//		MessageSendingThread tr2 =
//				new MessageSendingThread("두번째", Thread.NORM_PRIORITY);
//		MessageSendingThread tr3 =
//				new MessageSendingThread("세번째", Thread.MIN_PRIORITY);
		/*
		 3단계
		 : static상수 대신 정수사용해도 무방하다
		 */
		MessageSendingThread tr1 =
				new MessageSendingThread("첫번째", 10);
		MessageSendingThread tr2 =
				new MessageSendingThread("두번째", 5);
		MessageSendingThread tr3 =
				new MessageSendingThread("세번째", 1);
		
		tr1.start();
		tr2.start();
		tr3.start();
	}
}
