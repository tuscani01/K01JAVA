package common;

public class Student extends Person {
	public String stNumber;
}
{
	public Student(String name, int age, String stNumber)
	{
		super(name, age);
		this.stNumber = stNumber;
	}
	
		//객체 정보 반환용메소드
		@Override
		public String getInfo() {
			return super.getInfo() +", 학번:"+ stNumber;
		}
		//객체정보 출력용메소드
		@Override
		public void showInfo() {
			System.out.println("학생의정보");
			System.out.println(getInfo());
			
		}
		@Override
		public boolean equals(Object obj) {
			Person comparePerson = (Person)obj;
			
			//자동호출되는지 확인
			System.out.println("오버라이딩한 equals()메소드호출");
			if(comparePerson.age==this.age && comparePerson.name.equals(this.name)) {
				return true;
			}
			else {
				return false;
			}
			
	}
}
