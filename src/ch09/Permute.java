package ch09;

/**
 * 순열 구하기
 * 
 * @author 김기태
 *
 */
public class Permute
{

	/**
	 * <A[k], A[k+1], . . . , A[N-1]>의 모든 순열을 생성한 후 출력한다
	 * 
	 * @param A
	 * @param k
	 * @param N
	 */
	public void permute(int[] A, int k, int N)
	{

		if (k == N) // 모든 것을 만든 경우
		{
			for (int i = 0; i < N; i++)
			{ // 생성된 순열을 출력한다
				System.out.print(A[i] + " ");
			}
			System.out.println();
			return;
		}

		// A[k]를 i로 정하기 전에 가능한지 확인한다
		for (int i = 1; i <= N; i++)
		{
			if (promising(A, k, i)) // A[k]를 i로 정하는 것이 가능한 경우
			{
				A[k] = i;
				permute(A, k + 1, N); // <A[k+1], A[k+2], . . . , A[N-1]>의 모든 순열을 생성한다
			}
		}
	}

	/**
	 * A[k]를 i로 정하는 것이 가능한지 확인한다
	 * 
	 * @param A
	 * @param k
	 * @param i
	 * @return
	 */
	public boolean promising(int[] A, int k, int i)
	{
		boolean flag = true;
		int j = 0;

		// i가 A[0..k-1]내의 한 요소와 같으면 A[k]를 i로 정할 수 없다고 알려 준다.
		// 그렇지 않으면 A[k]를 i로 정할 수 있다고 알려 준다.
		while (j < k && flag)
		{
			if (i == A[j])
			{
				flag = false;
			}
			j++;
		}

		return flag;
	}

	public static void main(String[] args)
	{

		Permute p = new Permute();

		int N = 3;
		int[] A = new int[N];

		System.out.println("생성된 순열\n");

		// <A[0], A[1], . . . , A[N-1]>의 모든 순열을 생성한 후 출력한다
		p.permute(A, 0, N);
	}

}
