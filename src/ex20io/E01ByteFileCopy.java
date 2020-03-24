package ex20io;

import java.io.*;


/*
 스트림(Stream)
 : IO모델의 핵심개념이라 할수있는스트림은 '데이터흐름','데이터흐름형성해주는 통로'다
 입력(input)스트림과 출력(output)스트림으로 나눌수있다
 */
public class E01ByteFileCopy
{
/*
 IO관련작업 많은부분 예외처리가 필요함 예외보단 throws하는거 try~catch로 예외처리
 해주는것을 권장한다 예외 무시하게되면 문제가 생겼을때 적절한 조치 취하기 힘들기 때문이다
 */
	public static void main(String[] args)
	{
	InputStream in = null;
	OutputStream out = null;
	int copyByte = 0;
	try {
		//원본파일 읽어오기위한 입력스트림생성
		in = new FileInputStream("src/ex20io/A38Http2.zip");
		
		//복사본 만들기위한 출력스트림
		out = new FileOutputStream("src/ex20io/A38Http2_copy.zip");
		int bData; //원본에서 1byte를 읽어 저장하기위한변수
		
		while(true) {
			//원본파일 1byte씩 읽어옴
			bData = in.read();
			
			if(bData==-1) {
				//파일 끝까지 읽으면 -1을 반환하며 탈출
				break;
			}
			//읽어온 데이터 복사본에입력
			out.write(bData);
			copyByte++;
			System.out.println("복사된 kbyte크기:"+(copyByte/1024));
		}
	}
	catch(FileNotFoundException e) {
		System.out.println("파일 존재하지않습다");
	}
	catch(IOException e) {
		System.out.println("파일스트림 생성 오류발생");
	}
	finally {
		try {
			//입출력완료되면 생성 스트림 닫아준다
			in.close();
			out.close();
			
		//System.out.println("복사된 kbyte크기:"+(copyByte/1024));
		}
		catch(IOException e) {
			System.out.println("파일스트림닫기오류");
			}
		}
	}
}
