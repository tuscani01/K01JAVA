package ex20io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class E08StringWriter
{

	public static void main(String[] args)
	{
	try {
		/*
		 문자열 저장하기 위한 출력스트림 생성
		 문자열 입력은 버퍼링 따라 성능차이가 크다
		 버퍼필터 스트림을 추가적으로 연결해 사용
		 */
		BufferedWriter out = new BufferedWriter(new FileWriter("src/ex20io/string.txt"));
		);
		
		/*
		 write()메소드 통해 문자열 파일에 저장한다
		 이때 개행(줄바꿈)은 newLine()메소드 통해 삽입되며 각OS별로 개행문자가 다르다
		 */
		out.write("난kosmo에서 공부");
		out.newLine();
		out.write("수료후꼭 취업하겟다);
		out.newLine();
		
		out.close();
		System.out.println("입력완료");
	}
	catch(FileNotFoundException e) {	
		System.out.println("파일없음");
	}
	catch(IOException e) {
		System.out.println("IO오류");
	}
	}
}
