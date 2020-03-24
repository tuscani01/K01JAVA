package ex20io;

import java.io.FileWriter;
import java.io.PrintWriter;

public class E10PrintWriterStream
{

	public static void main(String[] args)
	{
	PrintWriter out = new PrintWriter(new FileWriter("src/ex20io/printf.txt"));
	
	out.printf("제나이는 %d살 입니다", 9)
	out.println("");
	
	out.println("저는기타치는걸 좋아해요");
	out.print("노래부를때 행복");
	out.close();
	
	System.out.println("printf.txt가 생서되었다")
	
	}

}
