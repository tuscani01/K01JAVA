package ex20io;

/*
 1byte씩 읽어서 저장하는것보다 1024byte씩 읽을수있는 버퍼(Buffer)를 이용해 복사 속도가 빠르다
 스트림 혹은 네트워크 통해 파일 전송할때 버퍼 사용하는 이유는 바로 이런속도차 때문이다
 */
public class E02ByteBufferfilecopy
{

	public static void main(String[] args)
	{
	try {
		InputStream in =
				new FileInputStream("src/ex20io/A38Http2.zip");
		OutputStream out =
				new FileOutputStream("src/ex20io/A38Http2_copy2.zip");
		
		int copyByte = 0;
		int readLen ;
		
		/*
		 1kbyte씩 읽어 저장하기위한 버퍼생성
		 */
		byte buffer[] = new byte[1024];
		
		while(true) {
			//1kbyte씩 파일읽어옴
			readLen = in.read(buffer);
			if(readLen==-1) {
				break;
			}
			/*
			 읽어온내용을 파일에 입력함 버퍼에 저장된 데이터 인덱스 0의 위치에서 readLen의 크기만큼 전송한다
			 */
			out.write(buffer, 0, readLen);
			copyByte += readLen;
	}
		if(in!=null) in.close();
		if(out!=null) out.close();
		
		System.out.println("복사된파일크기:"+ copyByte +"byte");
		System.out.println("복사된파일크기:"+ (copyByte/1024) +"Kbyte");
		System.out.println("복사된파일크기:"+ (copyByte/1024*1024)) +"Mbyte");
	}
	catch(FileNotFoundException e) {
		System.out.println("파일이없다");
	}
	catch(IOException e)
	System.out.println("IO작업중 예외가 발생되었다");
		
	catch(Exception e)
	System.out.println("알수없는 예외가 발생되었다");
	}
	}
}
