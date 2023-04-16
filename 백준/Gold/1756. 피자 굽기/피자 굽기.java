import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
* 1) [0, 현재 가능한 최대높이, 현재 가능한 최대높이,현재 가능한 최대높이 ...] 로 오븐  배열을 받아온다.
* (ex) 주어진 문제의 경우 : 5543322
*
* 2) 오븐 배열의 가장 뒤에서 부터 피자 도우가 들어갈 수 있는 위치까지 가장 뒤를 나타내는 bottom을 줄여나간다.
*
* 3) 위 작업을 모든 피자 도우를 받아 올 때까지 반복한다. 다만 bottom이 -1이 될 경우 도우를 넣는 것이 불가능하므로 break
* 
* 4) 마지막 도우의 높이이므로 bottom+1을 출력
* */

public class Main {
//    public int findPlace(int pizzaSize, int start, int end, int[] oven, int[] pizza) {
//        while (start <= end) {
//            int mid = (start + end) / 2;
//            if (oven[mid] > pizzaSize) {
//                start = mid;
//            } else if (oven[mid] == pizzaSize) {
//
//            } else {
//                end = mid-1;
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int D = Integer.parseInt(stringTokenizer.nextToken());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int[] oven = new int[D+1];
        int[] pizza = new int[N];
        int max = Integer.MAX_VALUE;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        //oven
        for (int i = 1; i <= D; i++) {
            int temp = Integer.parseInt(stringTokenizer.nextToken());
            oven[i] = Math.min(max, temp);
            max = oven[i];
        }
        //Arrays.stream(oven).forEach(System.out::print);
        //pizza
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int bottom = D;
        for (int i = 0; i < N; i++) {
            int currentPizza = Integer.parseInt(stringTokenizer.nextToken());
            while (bottom >= 0 && currentPizza > oven[bottom--]);
            if (bottom == -1) {
                break;
            }
            //System.out.println("bottom = " + bottom);
        }

        System.out.println((bottom+1));
    }
}
