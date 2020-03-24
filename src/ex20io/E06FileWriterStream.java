package ex20io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class E06FileWriterStream
{

	public static void main(String[] args)
	{
	try {
		/*
		 자바는 유니코드 기반으로 문자를 저장한다
		 아래는 문자스트림을 기반으로 해당OS에 인코딩방식에 맞춰 문자를 텍스트파일에 저장하게된다
		 
		 */
		char ch1 = 'A';
		char ch2 = 'Z';
		/*
		 alpha.txt파일 대상으로 문자출력 스트림생성한다
		 만약 파일 존재안하면 새롭게 생성
		 */
		Writer out = new FileWriter("src/ex20io/alpha.txt");
		
		out.write(ch1);
		out.write(ch2);
		out.close(); //스트림종료
		
	}
	catch(IOException e) {
		System.out.println("문자스트림작업중 오류발생");
		e.printStackTrace();
	}
	System.out.println("프로그램종료");
	}

}
