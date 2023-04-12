import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int count(char check) {
        if (check == '.') {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int R = Integer.parseInt(stringTokenizer.nextToken());
        int C = Integer.parseInt(stringTokenizer.nextToken());
        char[][] map = new char[R + 2][C + 2];  //지도 복사
        char[][] afterFiftyYear = new char[R][C];

        //intializing map with sea with outline
        for (int i = 0; i < R + 2; i++) {
            for (int j = 0; j < C + 2; j++) {
                map[i][j] = '.';
            }
        }//end of for

        for (int i = 1; i < R+1; i++) {
            StringBuilder mapX;
            mapX = new StringBuilder(bufferedReader.readLine());
            for (int j = 1; j < C+1; j++) {
                map[i][j] = mapX.charAt(j-1);
            }
        }//end of for

        for (int i = 1; i < R+1; i++) {
            for (int j = 1; j < C+1; j++) {
                if (i == 1) {
                    if (j == 1) {
                        if (map[i + 1][j] == '.' || map[i][j + 1] == '.') {
                            afterFiftyYear[i-1][j-1] = '.';
                        } else {
                            afterFiftyYear[i-1][j-1] = map[i][j];
                        }
                    } else if (j == C) {
                        if (map[i + 1][j] == '.' || map[i][j - 1] == '.') {
                            afterFiftyYear[i-1][j-1] = '.';
                        } else {
                            afterFiftyYear[i-1][j-1] = map[i][j];
                        }
                    } else {
                        if (count(map[i + 1][j]) + count(map[i][j + 1]) + count(map[i][j - 1]) >= 2) {
                            afterFiftyYear[i-1][j-1] = '.';
                        } else {
                            afterFiftyYear[i-1][j-1] = map[i][j];
                        }
                    }
                } else if (i == R) {
                    if (j == 1) {
                        if (map[i - 1][j] == '.' || map[i][j + 1] == '.') {
                            afterFiftyYear[i-1][j-1] = '.';
                        } else {
                            afterFiftyYear[i-1][j-1] = map[i][j];
                        }
                    } else if (j == C ) {
                        if (map[i - 1][j] == '.' || map[i][j - 1] == '.') {
                            afterFiftyYear[i-1][j-1] = '.';
                        } else {
                            afterFiftyYear[i-1][j-1] = map[i][j];
                        }
                    } else {
                        if (count(map[i - 1][j]) + count(map[i][j - 1]) + count(map[i][j + 1]) >= 2) {
                            afterFiftyYear[i-1][j-1] = '.';
                        } else {
                            afterFiftyYear[i-1][j-1] = map[i][j];
                        }
                    }
                } else {
                    if (j == 1) {
                        if (count(map[i - 1][j]) + count(map[i + 1][j]) + count(map[i][j + 1]) >= 2) {
                            afterFiftyYear[i-1][j-1] = '.';
                        } else {
                            afterFiftyYear[i-1][j-1] = map[i][j];
                        }
                    } else if (j == C) {
                        if (count(map[i - 1][j]) + count(map[i + 1][j]) + count(map[i][j - 1]) >= 2) {
                            afterFiftyYear[i-1][j-1] = '.';
                        } else {
                            afterFiftyYear[i-1][j-1] = map[i][j];
                        }
                    } else {
                        if (count(map[i - 1][j]) + count(map[i + 1][j]) + count(map[i][j - 1]) + count(map[i][j + 1]) >= 3) {
                            afterFiftyYear[i-1][j-1] = '.';
                        } else {
                            afterFiftyYear[i-1][j-1] = map[i][j];
                        }
                    }
                }
            }
        }//end of for

        int maxX = Integer.MIN_VALUE, minX = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE, minY = Integer.MAX_VALUE;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (afterFiftyYear[i][j] == 'X') {
                    if (maxX < j) {
                        maxX = j;
                    }
                    if (minX > j) {
                        minX = j;
                    }
                    if (maxY < i) {
                        maxY = i;
                    }
                    if (minY > i) {
                        minY = i;
                    }
                }
            }
        }//end of for

        for (int i = minY; i <= maxY; i++) {
            for (int j = minX; j <= maxX; j++) {
                System.out.print(afterFiftyYear[i][j]);
            }
            System.out.println();
        }//end of for
    }
}
