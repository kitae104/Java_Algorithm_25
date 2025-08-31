package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SeqSearch {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int X = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int answer = -1;

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (num == X && answer == -1) {
        answer = i;
      }
    }

    System.out.println(answer);
  }
}
