import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int x = Integer.parseInt(stringTokenizer.nextToken());
        int y = Integer.parseInt(stringTokenizer.nextToken());
        int marketNum = Integer.parseInt(bufferedReader.readLine());
        int[][] marketPlace = new int[marketNum][2];    //가게들이 위치한 곳을 2차원 배열로 표현
        for (int i = 0; i < marketNum; i++) { //가게들의 위치 배열에 저장
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            marketPlace[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            marketPlace[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] place = new int[2]; //경비원의 초기 위치 저장
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        place[0] = Integer.parseInt(stringTokenizer.nextToken());
        place[1] = Integer.parseInt(stringTokenizer.nextToken());

        int answer = 0;
        for (int i = 0; i < marketNum; i++) {
            if (place[0] == 1) {
                if (marketPlace[i][0] == 1) {
                    answer += Math.abs(place[1] - marketPlace[i][1]);
                } else if (marketPlace[i][0] == 3) {
                    answer += place[1] + (marketPlace[i][1]);
                } else if (marketPlace[i][0] == 2) {
                    answer += Math.min(place[1] + marketPlace[i][1], 2 * x - (place[1] + marketPlace[i][1])) + y;
                } else if (marketPlace[i][0] == 4) {
                    answer += x - place[1] + marketPlace[i][1];
                }
            } else if (place[0] == 3) {
                if (marketPlace[i][0] == 1) {
                    answer += place[1] + marketPlace[i][1];
                } else if (marketPlace[i][0] == 3) {
                    answer += Math.abs(place[1] - marketPlace[i][1]);
                } else if (marketPlace[i][0] == 2) {
                    answer += y-place[1] + marketPlace[i][1];
                    System.out.println("place = " + (y-place[1]));
                    System.out.println("marketPlace = " + marketPlace[i][1]);
                } else if (marketPlace[i][0] == 4) {
                    answer += Math.min(place[1] + marketPlace[i][1], 2 * y - (place[1] + marketPlace[i][1])) + x;
                }
            } else if (place[0] == 2) {
                if (marketPlace[i][0] == 1) {
                    answer += Math.min(place[1] + marketPlace[i][1], 2 * x - (place[1] + marketPlace[i][1])) +y;
                } else if (marketPlace[i][0] == 3) {
                    answer += y+place[1] - marketPlace[i][1];
                } else if (marketPlace[i][0] == 2) {
                    answer += Math.abs(place[1] - marketPlace[i][1]);
                } else if (marketPlace[i][0] == 4) {
                    answer += (x - place[1]) + (y-marketPlace[i][1]);
                }
            } else if (place[0] == 4) {
                if (marketPlace[i][0] == 1) {
                    answer += (x - marketPlace[i][1]) + place[1];
                } else if (marketPlace[i][0] == 3) {
                    answer += Math.min(place[1] + marketPlace[i][1], 2 * y - place[1] - marketPlace[i][1]) + x;
                } else if (marketPlace[i][0] == 2) {
                    answer += (x - marketPlace[i][1]) + (y-place[1]);
                } else if (marketPlace[i][0] == 4) {
                    answer += Math.abs(place[1] - marketPlace[i][1]);
                }
            }
            //System.out.println("answer = " + answer);
        }
        System.out.println(answer);
    }
}
