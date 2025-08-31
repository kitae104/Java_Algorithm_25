package QnA;

public class Mystery
{

	public static void main(String[] args)
	{
		int i = mystery(1);
		System.out.println(i);
	}

	private static int mystery(int n)
	{
		int r = 0;
		for (int i = 1; i <= n-1; i++)
		{
			for (int j = i+1; j <= n; j++)
			{
				r = r + 1;
			}
		}
			
		return r;
	}

}
