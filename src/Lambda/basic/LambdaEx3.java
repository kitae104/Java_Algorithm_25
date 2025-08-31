package Lambda.basic;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 익명 객체를 람다식으로 대체 (1.3 함수형 인터페이스)
public class LambdaEx3 {
    public static void main(String[] args) {
        // 문자열 리스트 직접 생성하기 (Java 9부터 지원)
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        List<Integer> list2 = Arrays.asList(111, 222, 333, 444);

        // 기존의 방식 (익명 내부 클래스)
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });
        System.out.println(list);

        // 람다식(함수형 인터페이스 사용)
        Collections.sort(list2, (s1, s2) -> s2.compareTo(s1));
        System.out.println(list2);

    }
}
