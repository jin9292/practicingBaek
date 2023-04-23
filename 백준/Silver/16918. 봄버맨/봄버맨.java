import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main16918 = new Main();
        main16918.doIt();
    }

    public void doIt() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int R = Integer.parseInt(stringTokenizer.nextToken());
        int C = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[][] answer = new int[R + 2][C + 2];
        int time = 0;

        for (int i = 0; i < R; i++) {
            String[] split = bufferedReader.readLine().split("");
            for (int j = 0; j < C; j++) {
                if (split[j].equals(".")) {
                    answer[i + 1][j + 1] = 0;
                } else {
                    answer[i + 1][j + 1] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            //폭탄을 지우기 위한 임시 폭탄 터진 위치 저장소
            int[][] tempArray = new int[R + 2][C + 2];
            //처음 1초는 아무것도 일어나지 않는다
            if (i == 0) {
                for (int j = 1; j < R + 1; j++) {
                    for (int k = 1; k < C + 1; k++) {
                        if (answer[j][k] != 0)
                            answer[j][k] += 1;
                    }
                }

//                for (int j = 1; j < R + 1; j++) {
//                    for (int k = 1; k < C + 1; k++) {
//                        System.out.print(answer[j][k]);
//                    }
//                    System.out.println();
//                }
                continue;
            }
            //1초가 지나가면 폭탄의 시간이 1씩 증가한다
            for (int j = 1; j < R + 1; j++) {
                for (int k = 1; k < C + 1; k++) {
                    if (answer[j][k] != 0)
                        answer[j][k] += 1;
                }
            }
            //짝수 시간에 봄버맨이 빈칸에 폭탄을 빈칸에 놓는다
            if (i % 2 == 1) {
                for (int j = 1; j < R + 1; j++) {
                    for (int k = 1; k < C + 1; k++) {
                        if (answer[j][k] == 0)
                            answer[j][k] = 1;
                    }
                }
            }
            //폭탄의 시간이 다 되었다면 터진다
            for (int j = 1; j < R + 1; j++) {
                for (int k = 1; k < C + 1; k++) {
                    if (answer[j][k] == 4) {
                        tempArray[j][k] = -1;
                        tempArray[j + 1][k] = -1;
                        tempArray[j - 1][k] = -1;
                        tempArray[j][k + 1] = -1;
                        tempArray[j][k - 1] = -1;
                    }
                }
            }
            for (int j = 1; j < R + 1; j++) {
                for (int k = 1; k < C + 1; k++) {
                    if (tempArray[j][k] == -1) {
                        answer[j][k] = 0;
                    }
                }
            }
//
//            for (int j = 1; j < R + 1; j++) {
//                for (int k = 1; k < C + 1; k++) {
//                    System.out.print(answer[j][k]);
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
        for (int i = 1; i < R + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                if (answer[i][j] == 0) {
                    System.out.print(".");
                } else {
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }
}
