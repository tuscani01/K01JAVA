package ex18Lambda;


public class human
{
	String name;
	String gender;
	int score;
	//생성자
	public Human(String name, String gender, int score) {
		this.name = name;
		this.gender = gender;
		this.score = score;
	}
	//게터세터
	public String getName() {
		return name;
	}
	
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public int getScore()
	{
		return score;
	}
	public void setScore(int score)
	{
		this.score = score;
	}
	public void setName(String name)
	{
		this.name = name;
	}

	}

}
