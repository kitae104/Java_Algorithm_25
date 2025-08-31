package ch07;

import java.util.Scanner;

/**
 * <pre>
 * 배낭 빈틈없이 채우기 알고리즘 
 * </pre>
 *	
 * @author	: 김기태
 * @Date  	: 2021. 8. 29.
 * @Version	:
 */
public class FractionalKnapsack2
{
	private int n;						// 물건들의 수
	private double weight[];			// 각 물건의 무게
	private double value[];				// 각 물건의 가치
	private double capacityKnapsack;	// 배낭의 용량
	private double[] unitValue;			// 단위 무게당 가치

	public void inputData()
	{
		n = 4;
		weight = new double[] {5, 15, 20, 30};
		value = new double[] {20, 90, 110, 150};
	    capacityKnapsack = 50;
	}

	/**
	 * <pre>
	 * 1. 개요 : 배낭에 담긴 물건들, 물건들의 무게의 합과 물건들의 가치의 합을 계산한 후 출력
	 * 2. 처리내용 : 
	 * </pre>
	 */
	public void fractionalKnapsack()
	{
		unitValue = new double[n];	// 단위 무게당 가치
		
		for (int i = 0; i < n; i++)
		{
			unitValue[i] = value[i] / weight[i];
		}
		
		double totalWeight = 0;		// 배낭에 담긴 물건들의 무게의 합을 0으로 초기화 
		double totalValue = 0;		// 배낭에 담긴 물건들의 가치의 합을 0으로 초기화
		
		// 단위 무게당 가치가 가장 큰 물건을 찾는다
        int item = getNextItem();
        
        System.out.println();
        
        // 배낭에 채울 물건들이 남아 있고 배낭이 채워지지 않은 동안 반복
        while((item != -1) && (totalWeight + weight[item] <= capacityKnapsack))
        {	
        	// 배낭에 물건 item의 전부를 넣는다
        	totalWeight += weight[item];
        	totalValue += value[item];
        	
        	System.out.println("물건 " + (item + 1) + "의 " + weight[item] + "을 배낭에 넣는다");
        	
        	unitValue[item] = 0;		// 물건 item을 배낭에 다음에 넣을 물건들의 목록에서 제거
        	item = getNextItem();		// 남아 있는 물건들중에서 단위 무게당 가치가 가장 큰 물건을 찾는다
        }
        
        // 배낭의 용량이 남아 있으면 배낭에 물건 item의 일부를 넣는다
        if(capacityKnapsack - totalWeight > 0)
        {
        	System.out.println("물건 " + (item + 1) + "의 " + (capacityKnapsack - totalWeight) + "을 배낭에 넣는다");
        	totalValue += (unitValue[item] * (capacityKnapsack -totalWeight));
        	totalWeight+= (capacityKnapsack - totalWeight);
        }
        
        System.out.println("\n총 가치 = " + totalValue + ", 총 무게 = " + totalWeight);
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 배낭에 다음에 넣을 물건의 인덱스를 찾는다.
	 * 2. 처리내용 : 
	 * </pre>
	 * @return
	 */
	public int getNextItem()
	{
		double highest = 0;
		int index = -1;
		
		// 남아 있는 물건들중 단위 무게당 가치가 가장 높은 물건의 지수를 찾는다
		for (int i = 0; i < value.length; ++i)
		{
			if(unitValue[i] > highest)
			{
				highest = unitValue[i];
				index = i;
			}
		}
		return index;
	}

	public static void main(String[] args)
	{
		FractionalKnapsack2 fks = new FractionalKnapsack2();
		fks.inputData();			// 정보 입력 받기 
		fks.fractionalKnapsack();	// 배낭 빈틈없이 채우기
	}

}
