package ch01;

import java.io.*;
import java.util.StringTokenizer;

public class FastReader {
  private BufferedReader br;
  private StringTokenizer st;

  public FastReader(String fileName) throws IOException {
    br = new BufferedReader(new FileReader(fileName));
  }

  public FastReader(InputStream is) throws IOException {
    br = new BufferedReader(new InputStreamReader(is));
  }

  public String next() throws IOException {
    while (st == null || !st.hasMoreTokens()) {
      String line = br.readLine(); // null이면 EOF
      if(line == null) return null; // EOF
      st = new StringTokenizer(line); // 공백 기준 토큰 분리
    }
    return st.nextToken();
  }

  public int nextInt() throws IOException {
    String s = next();
    if(s == null)
      throw new IOException("입력이 부족합니다.");
    return Integer.parseInt(s); // 숫자료 변경해서 반환
  }
}
