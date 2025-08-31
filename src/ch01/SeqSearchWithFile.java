package ch01;

import java.io.IOException;

public class SeqSearchWithFile {
  public static void main(String[] args) throws IOException {
    FastReader fr = new FastReader("src\\ch01\\input.txt");

    int N = fr.nextInt();
    int X = fr.nextInt();
    int answer = -1;

    for(int i = 0; i < N; i++) {
      int num = fr.nextInt();
      if(num == X && answer == -1) {
        answer = i;
      }
    }

    System.out.println(answer);
  }
}
