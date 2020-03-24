package quiz_gameexcption;

import java.util.InputMismatchException;
class WrongNumberException extends Exception {
	public WrongNumberException() {
		super("[예외발생]1~3사이 숫자 입력");
	}
}

public class RockPaperScissorsGame
{

	public static void main(String[] args)
	{
		try {
			rpsGameStart();
		}
		catch (WrongNumberException e) {
			//개발자 정의한 예외클래스의 에러메세지 출력
			System.out.println(e.getMessage());
		}
	}

}
