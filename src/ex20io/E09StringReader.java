package ex20io;

import java.io.BufferedReader;
import java.io.FileReader;

public class E09StringReader
{

	public static void main(String[] args)
	{
	try {
		BufferedReader in = new BufferedReader(new FileReader("src/ex20io/string.txt")
				);
		String str;
				while(true) {
					/*
					  개행(줄바꿈) 등장전 데이터 한번에 읽어온다
					  즉 한줄씩 읽게된다
					 */
				str = in.readLine();
				
				if(str==null) {
					break;
				}
				
				/*
				 입력시 newLine()을 통해 개행정보가 입력 읽은 문자열에선 개행정보 존재하지 않아
				 따라서 개행하려면 println()을 사용해야한다 개행정보는 문자열 라인별 구분하는 용도로 사용
				 */
				System.out.println(str);
				}
				in.close();
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}

	}

}
