package ch02;

/**
 * <pre>
 * 빈도들의 누계 계산 
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 9. 11.
 * @Version	:
 */
public class ComputeCumulativeSum
{
	/**
	 * <pre>
	 * 1. 개요 : 빈도들의 누계를 계산한다. 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param FREQ 시험 등급들의 빈도 배열 
	 * @return CUME 누계 빈도들의 배열 
	 */
	public int[] computeCumulativeSum2(int[] FREQ)
	{
		int n = FREQ.length;
		int[] CUME = new int[n];
		
		CUME[0] = FREQ[0];
		
		for (int i = 1; i < n; i++)
		{
			CUME[i] = CUME[i-1] + FREQ[i];
		}
		
		return CUME;
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 빈도들의 누계를 계산한다. 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param FREQ 시험 등급들의 빈도 배열 
	 * @return CUME 누계 빈도들의 배열 
	 */
	public int[] computeCumulativeSum1(int[] FREQ)
	{
		int n = FREQ.length;
		int[] CUME = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			int sum = 0; 
			for (int j = 0; j <= i; j++)
			{
				sum = sum + FREQ[j];
			}
			CUME[i] = sum;
		}
		return CUME;
	}
	
	public static void main(String[] args)
	{
		ComputeCumulativeSum ccs = new ComputeCumulativeSum();
		int[] FREQ = {1, 0, 7, 5, 4};	// 시험에서 등급 i를 받은 핛애들의 수를 저장 
		int[] CUME;						// 등급 i 이하의 등급을 받은 학생들의 수를 저장
		
		// 알고리즘 2		
		CUME = ccs.computeCumulativeSum2(FREQ);
		
		System.out.print("배열 CUME1 : ");

		for (int i = 0; i < CUME.length; i++)
		{
			System.out.print(CUME[i] + "\t");
		}
		System.out.println();
		
		// 알고리즘 1
		CUME = ccs.computeCumulativeSum1(FREQ);
		
		System.out.print("배열 CUME2 : ");

		for (int i = 0; i < CUME.length; i++)
		{
			System.out.print(CUME[i] + "\t");
		}
		System.out.println();
	}
	
}
