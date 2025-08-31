package Lambda.basic;

// 함수형 인터페이스 타입의 매개변수사용과 반환 타입 사용
// 람다식을 함수를 통해 전달하고 반환하는 예제
public class LambdaEx4 {

    public static void execute(MyFunction2 f) { // 매개변수 타입이 MyFunction2인 메서드
		    f.run();	// 받은 함수형 인터페이스의 추상 메서드 호출
	}

    public static MyFunction2 getMyFunction() { // 반환 타입이 MyFunction2인 메서드
//        MyFunction2 f = () -> System.out.println("f3.run()"); // 람다식을 만들어서 반환
//        return f;
        return () -> System.out.println("f3.run()"); // 람다식을 반환
    }

    public static void main(String[] args) {
        MyFunction2 f1 = () -> System.out.println("f1.run()");	// 람다식을 만들어서 참조변수에 대입

        MyFunction2 f2 = new MyFunction2() {
            @Override
            public void run() {
                System.out.println("f2.run()");
            }
        };

        MyFunction2 f3 = getMyFunction(); // 반환 타입이 MyFunction2인 메서드 호출

        f1.run();
        f2.run();
        f3.run();

        execute(f1);	// 매개변수 타입이 MyFunction2인 메서드 호출
        execute(() -> System.out.println("run()"));	// 람다식을 매개변수로 전달
    }
}
