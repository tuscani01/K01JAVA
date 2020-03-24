package ex20io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class E07FileReaderStream
{

	public static void main(String[] args)
	{
	try {
		//버퍼로 사용할크기가 10인 char형 배열생성
		char[] cbuf = new char[10];
		int readCnt;
		//txt파일 대상으로 문자입력 스트림생성
		Reader in = new FileReader("src/ex20io/alpha.txt");
		
		//배열 cbuf앞에서 최대10개문자 읽어 저장
		readCnt = in.read(cbuf, 0, 10);
		
		for(int i=0 ; i<readCnt ; i++) {
		System.out.println(cbuf[i]);
	}
		in.close();
	}
	catch(FileNotFoundException e) {
		e.printStackTrace();
		System.out.println("파일없음");
	}
	catch(IOException e) {
		System.out.println("IO오류발생");
	}
	}
}
