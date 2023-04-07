import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        int receivedBox = Integer.parseInt(stringTokenizer.nextToken());
        int[][] map = new int[N][M];
        int minHeight=500, maxHeight=0;
        int minimumTime=500*500*256*2, answerHeight=0;
        //initialize Map, minHeight, maxHeight
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (minHeight>=map[i][j])
                    minHeight = map[i][j];
                if (maxHeight <= map[i][j]) {
                    maxHeight = map[i][j];
                }
            }
        }

        //일정 높이를 기준으로 얻은 박스, 사용한 박스, 박스가 부족한지 여부를 체크
        for (int boxHeight = minHeight; boxHeight <= maxHeight; boxHeight++) {
            int time = 0, obtainedBox = 0, usedBox = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > boxHeight) {
                        time += 2 * (map[i][j] - boxHeight);
                        obtainedBox+=map[i][j] - boxHeight;
                    } else if (map[i][j] <= boxHeight) {
                        time += (boxHeight-map[i][j]);
                        usedBox-=boxHeight-map[i][j];
                    }
                }
            }
            // 박스가 모자르지 않게 평지를 만들었으므로 가능한 높이
            if ((obtainedBox + usedBox + receivedBox >= 0) && (minimumTime >= time)) {
                minimumTime = time;
                answerHeight = boxHeight;
            }
        }

        System.out.print(minimumTime + " " + answerHeight);
    }
}
