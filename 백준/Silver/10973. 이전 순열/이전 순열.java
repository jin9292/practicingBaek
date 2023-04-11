import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    //흠.... Array가 아니라 String으로 해서  subString을 이요하면 좀 편하려나??
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] array = new int[N];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            array[i] = Integer.parseInt(stringTokenizer.nextToken());
            i++;
        }
        int temp = array[N - 1];
        int index = 100000; //숫자가 커지는 index
        for (int j = N - 1; j >= 0; j--) {
            if (temp < array[j]) {
                index = j;
                break;
            } else {
                temp = array[j];
            }
        }
        Integer[] tmp = new Integer[0];
        if (index > 9999) {
            System.out.println("-1");
        } else {
            tmp = new Integer[N - index - 1];
            int tmpIndex = 0;
            int tmpSmallestDiff = 0;
            for (int j = index + 1; j < N; j++) {
                tmp[j - index - 1] = array[j];
            }
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] < array[index] && tmp[j] > tmpSmallestDiff) {
                    tmpIndex = j;
                }
            }
            temp = array[index];
            array[index] = tmp[tmpIndex];
            tmp[tmpIndex] = temp;
            Arrays.sort(tmp, (x,y) -> y - x);
            for (int j = index+1; j < array.length; j++) {
                array[j] = tmp[j - index - 1];
            }
            for (int s : array) {
                System.out.print(s+" ");
            }
        }


    }
}
