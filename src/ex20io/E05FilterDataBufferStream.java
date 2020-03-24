package ex20io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutionException;

/*
 파일 정수/실수 같은 데이터 저장하는 필터스트림과 버퍼링 제공하는 필터스트림까지 추가적 연결 파일생성 하는 프로그램
 */

public class E05FilterDataBufferStream
{

	public static void main(String[] args)
	{
		String src= "src/ex20io/dataBufferStream.bin";
		
		try {
			//1.파일생성위한 출력 파일 스트림생성
			
			OutputStream out = new FileOutputStream(src);
			
			//2버퍼 사용 위한 필터스트림생성
			BufferedOutputStream bufFilterOut =
					new BufferedOutputStream(out);
			//3.파일 기본자료형 데이터 저장하기 위한 필터스트림
			DataOutputStream dataFilterOut =
					new DataOutputStream(bufFilterOut);
			
			dataFilterOut.writeInt(555);
			dataFilterOut.writeDouble(55.55);
			dataFilterOut.writeInt(999);
			dataFilterOut.writeDouble(99.99);
			
			dataFilterOut.close();
			//3개스트림 한번에생성
			DataInputStream dataFilterIn =
			new DataInputStream(new BufferedInputStream(new FileInputStream(src)
			)
				);
			//각각데이터
			int intNum1 = dataFilterIn.readInt();
			double dblNum1 = dataFilterIn.readDouble();
			int intNum2 = dataFilterIn.readInt();
			double dblNum2 = dataFilterIn.readDouble();
			
			dataFilterIn.close();
			
			System.out.printf("저장된정수 %d, %d\n",intNum1, intNum2);
			System.out.printf("저장된정수 %.2f, %.2f%n",dblNum1, dblNum2);
		}
		catch(Exception e) {
			System.out.println("IO예외발생");
			e.printStackTrace();
		}
	}
}
