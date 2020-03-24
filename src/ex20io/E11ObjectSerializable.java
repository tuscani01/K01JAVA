package ex20io;

import java.io.FileInputStream;
/*
 직렬화: Circle클래스 입출력 대상으로 파일저장하기위해서 Serializable인터페이스 구현해 정의한다
 인스턴스가 파일 형태로 저장되는것을 "직렬화"라고 한다
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Circle implements Serializable
{
	int xPos, yPos;
	double radian;
	public Circle(int x, int y, double r) {
		xPos = x;
		yPos = y;
		radian = r;
	}
	public void showCircleInfo() {
		System.out.printf("좌표[%d,%d]", xPos, yPos);
		System.out.println("반지름:"+ radian);
		
	}
}

public class E11ObjectSerializable
{

	public static void main(String[] args)
	{
	try {
		//인스턴스파일 저장위한 스트림생성
		ObjectOutputStream out =
				new ObjectOutputStream(new FileOutputStream("src/ex20io/circle.obj"));
			//인스턴스 파일에 저장
						out.writeObject(new Circle(1,1,2.4));
						out.writeObject(new Circle(2,2,4.8));
						out.writeObject(new String("String타입 오브젝트"));
						/*
						 JAVA에서제공하는 기본클래스는 별도처리없이 직렬화가 가능하다
						 */
						
						out.close();
						/*
						 인스턴스복원(역직렬화) 스트림 생성
						 readObject()메소드 통해 복원
						 */
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/ex20io/circle.obj")
				);
		//저장된 순서대로 인스턴스복원
				Circle c1 = (Circle)in.readObject();		
				Circle c2 = (Circle)in.readObject();		
						String message = (String)in.readObject();
						in.close();
						
						c1.showCircleInfo();
						c2.showCircleInfo();
						System.out.println("String오브젝트:"+ message);
	}
	catch(ClassNotFoundException e) {
		System.out.println("클래스없음");
	}
	catch(FileNotFoundException e) {
		System.out.println("파일없음");
	}
	catch(IOException e) {
		System.out.println("없음");
	}
	}
}
