package ch07;

import java.util.Scanner;

/**
 * <pre>
 * 거스름돈 주기(탐욕기법)
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 25.
 * @Version	:
 */
public class CoinChange
{
	/**
	 * <pre>
	 * 1. 개요 : 거스름 돈에 포함된 동전의 수를 반환하는 메소드 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param numCoin
	 * @param numCoin
	 * @return
	 */
	public int calcCoin(int[] coinValue, int[] numCoin)
	{
		System.out.print("금액 입력 : ");
		Scanner sc = new Scanner(System.in);
		int change = sc.nextInt();						// 남은 거스름돈
		System.out.println(change + "원의 거스름 돈은 다음과 같다. ");
		
		int count = 0;
		int i = 0; 
		while(change > 0)		// 거스름 돈이 남아 있는 동안  수행 
		{
			numCoin[i] = change / coinValue[i];
			count += numCoin[i];
			
			change = change % coinValue[i];		// 
			
			if(numCoin[i] > 0)					// 해당 값이 0보다 크면 출력 
			{
				System.out.println(coinValue[i] + "원짜리 동전 " + numCoin[i] + "개");
			}
			i++;
		}
		
		sc.close();
		return count;
	}
	
	public static void main(String[] args)
	{
		CoinChange cc = new CoinChange();

		// 동전들의 액면가 배열
		int[] coinValue = { 500, 100, 50, 10, 5, 1 };
		int i; 								// 동전들의 액면가 배열 지수
		int[] numCoin = new int[6]; 		// 거스름돈에 포함되는 각 동전의 수 배열
		
		int count = 0; 						// 거스름돈에 포함되는 동전들의 수
				
		count = cc.calcCoin(coinValue, numCoin);
		
		System.out.println ("\n거스름돈에 포함되는 동전들의 수: " + count);

	}

}
