package ex20io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;

public class E03FilterDataStream
{

	public static void main(String[] args)
	{
		//생성된파일 경로설정
		String src = "src/ex20io/FilterDataStream.bin";
		
		try {
			//파일생성 위한 output파일스트림생성
			OutputStream out = new FileOutputStream(src);
			//파일스트림내용 조합할 필터스트림 생성
			DataOutputStream filterOut = new DataOutputStream(out);
			
			/*
			 위 생성한 출력스트림에 필터스트림까지 추가연결해 write()메소드 통해 숫자데이터 전송한다
			 해당 데이터 바이트단위로 분리해서 총4혹은 8byte로 전송하게된다
			 */
			filterOut.writeInt(123);
			filterOut.writeDouble(12.34);
			filterOut.writeInt(456);
			filterOut.writeInt(56.78);
			
			/*
			 파일내용 읽어오기 위해서 입력스트림과 필터입력스트림 연결한다 필터스트림 통해 byte단위가 아닌 int,double과 같은
			 기본자료형의 단위로 데이터 읽어올수있게된다
			 */
			DataInputStream filterIn =
					new DataInputStream(new FileInputStream(src));
			
			int num1 = filterIn.readInt(); //정수 읽어옴
			double dNum1 = filterIn.readDouble(); //실수읽어옴
			int num2 = filterIn.readInt();
			double dNum2 = filterIn.readDouble();
			
			System.out.println("num1="+ num1);
			System.out.println("dNum1="+ dNum1);
			System.out.println("num2="+ num2);
			System.out.println("dNum2="+ dNum2);
			
			//스트림 소멸
			if(filterOut!=null) filterOut.close();
			if(filterIn!=null) filterIn.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("해당파일없음");
		}
		catch(IOException e) {
			System.out.println("IO오류발생");
		}
	}
}