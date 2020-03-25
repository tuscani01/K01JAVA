package ex21jdbc.prepared;

import java.util.Scanner;

import ex21jdbc.connect.IConnectImpl;

public class InsertQuery extends IConnectImpl{
	
	public InsertQuery() {
		super("kosmo", "1234");
		
	}
	
	@Override
	public void execute() {
		try {
			
			//1.쿼리문준비 : 값 세팅이 필요한부분을 ?로 대체한다
			String query = "INSERT INTO members VALUES (?, ?, ?, ?)";
			
			//2.Prepared객체생성: 생성시 준비한 쿼리문 인자로 전달한다
			
			psmt = con.prepareStatement(query);
			
			//3. DB입력할 값 사용자로부터 입력받음
			Scanner scan = new Scanner(System.in);
			System.out.print("아이디:");
			String id = scan.nextLine();
			System.out.print("패스워드:");
			String pw = scan.nextLine();
			System.out.print("이름:");
			String name = scan.nextLine();
			
			//4.인파라미터 설정하기: ?의 순서대로 설정하고 DB라서 인덱스는 1부터 시작
			
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			
			
			//psmt.setString(4, "2017-11-23"); //날짜 문자열로 입력하는경우 
			/*
			 현재날짜 java에서 입력시 아래같은 변환과정 이루어진다
			 util패키지로 시간 가져와서 sql패키지 형태로 변환한다
			 이때 date형으로 입력되기때문에 setDate()메소드 사용해서 인파라미터를 설정해야한다
			 
	
			 */
			
			java.util.Date utilDate = new java.util.Date();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			psmt.setDate(4, sqlDate);
			
			/*
			 인파라미터 설정시 사용 메소드
			 쿼리문에 ?있는 부분 인덱스로 접근해서 설정한다
			 자료형 숫자면 setInt()
			 	 문자면 setString()
			 	 날짜면 setDate()를 사용한다
			 	 해당 메소드 사용시 '(싱글쿼테이션은 자동으로 입력된다
			 */
			
			//5.쿼리실행 위해 prepared 객체 실행
			int affected = psmt.executeUpdate();
			System.out.println(affected +"행이 입력되었따");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
			
		}
	}

	public static void main(String[] args)
	{
	new InsertQuery().execute();

	}

}
