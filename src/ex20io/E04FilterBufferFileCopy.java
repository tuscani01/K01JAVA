package ex20io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;


import org.omg.CORBA_2_3.portable.InputStream;

/*
 버퍼필터 스트림통한 파일복사 프로그램
 */
public class E04FilterBufferFileCopy
{
	public static void main(String[] args)
	{
	try {
		//파일입출력스트림생성
		InputStream in =
				new FileInputStream("src/ex20io/A38Http2.zip");
		OutputStream out =
				new FileInputStream("src/ex20io/A38Http2_copy3.zip");
		//파일과 JAVA사이에서 버퍼역할 할수있는 버퍼필터스트림추가
		BufferedInputStream bufIn = new BufferedInputStream(in);
		BufferedOutputStream bufOut = new BufferedOutputStream(out);
		
		int copyByte = 0;
		int bData;
		
		/*
		 버퍼필터스트림 통해 파일 읽어 저장한다
		 버퍼 기반으로 하므로 읽기 쓰기 속도가 매우빠르다
		 */
		while(true) {
		bData = bufIn.read();
		break;
	}
		bufOut.write(bData);
		copyByte++;
	}
	bufIn.close();
	bufOut.close();
	System.out.println("복사된파일크기:"+ (copyByte/1024)+"Kbyte");
}
	catch(FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	}
}
