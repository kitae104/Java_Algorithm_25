package Lambda.basic;

@FunctionalInterface			// 함수형 인터페이스는 단 하나의 추상 메소드만 가져아 함.
public interface MyFunction
{
	public abstract int max(int a, int b);
}
