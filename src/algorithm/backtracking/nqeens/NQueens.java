package algorithm.backtracking.nqeens;

public class NQueens {
    private int[] queens;   // 여왕 체스 배열
    private int N; // 여왕 수

    public NQueens(int N) {
        this.N = N;
        queens = new int[N];    // 숫자 만큼 여왕 배열 생성
    }

    public void placeNQueens() {
        if (placeQeeen(0)) {
            printQueens();
        } else {
            System.out.println("솔루션이 없습니다....");
        }
    }

    private boolean placeQeeen(int col) {
        if (col == N) {
            return true;    // 모든 여왕이 배치되었을 때
        }

        for (int row = 0; row < N; row++) {
            if (canPlace(row, col)) {
                queens[col] = row;  // 여왕을 배치
                if (placeQeeen(col + 1)) {   // 다음 열로 이동
                    return true;    // 적절한 위치 찾음
                }
                // 유효한 배치를 찾을 수 없으면 현재 퀸의 배치를 취소하고 뒤로 돌아감(백트래킹)
            }
        }
        return false;   // 현재 열에 대한 유효한 배치를 찾을 수 없음
    }

    private boolean canPlace(int row, int col) {
        for (int i = 0; i < col; i++) {
            if (queens[i] == row || Math.abs(queens[i] - row) == Math.abs(i - col)) {
                return false;   // 여왕을 배치할 수 없음
            }
        }
        return true;    // 이 위치에 여왕을 배치할 수 있음
    }

    private void printQueens() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (queens[i] == j) {
                    System.out.print(" Q ");
                } else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
    }
}
