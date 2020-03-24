package ex06array;
/*
 * Call by value(값에 의한 호출)
 * 메소드 호출과 관련된 개념으로 매개변수를 통해 값을 전달할때
 * 메모리의 "복사"를 통해 값이 전달된다
 * 그래서 다른 메소드(지역)에서 값의 변경이 있더리도 호출한
 * 메소드의 값에는 전혀 영항을 미치지 않는다
 * 
 * 메모리적 관점에서 보면 스택영역만 사용하는 케이스로
 * main과 호출된 메소드는 서로 다른 지역이므로 서로에게
 * 영향을 미치지 않는 것이 특징이다.
 */

 

public class E02ArrayAndMethod
{

	public static void main(String[] args)
	{
		/*
		 * 배열의 선언과 동시에 초기화. 요소의 객수에 의해 크기결정된
		 */
		int[] arr = { 1, 2, 3, 4, 5 };
		//배열 변수만 선언한 상태로 아직 참조하는 배열이 없음
		int[] ref;
		
		System.out.println("초기화 직후 출력");
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		/*
		 * 배열명을 매개변수로 전달하는 것은 배열의 참조값(주소값)을 전달하는 것이다.
		 * 정수의 경우에는 해당값이 그대로 전달된다. 
		 */


		ref = addAllArray(arr, 7);
		/*
		 * addAllArray() 메소드에서 반환하는 값은 처음에 전달했던 배열의 주소값이므로, 
		 * 결과적으로 ref도 동일한 배열을 참조하게 된다. 
		 */


		System.out.println("arr="+ arr);
		System.out.println("ref="+ ref);
		/*
		 * arr과 ref는 동일한 참조값을 가지게 되었으므로 출력결과는
		 * 동일하게 나온다
		 */
		System.out.println("메소드 호출후 출력");
		for (int i = 0; i < ref.length; i++)
		{
			System.out.print(ref[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
	}

	static int[] addAllArray(int[] ar, int addVal)
	{
		for (int i = 0; i < ar.length; i++)
		{
			ar[i] += addVal;
		}
		return ar;
	}

}
