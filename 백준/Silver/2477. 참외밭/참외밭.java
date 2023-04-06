import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public  static void  main(String agrs[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        int direction, maxLength = 0, maxLengthIndex = 0;
        int[] farmSize = new int[6];
        for (int i = 0; i < 6; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            direction = Integer.parseInt(stringTokenizer.nextToken());
            farmSize[i] = Integer.parseInt(stringTokenizer.nextToken());
            if (maxLength < farmSize[i]) {
                maxLength = farmSize[i];
                maxLengthIndex = i;
            }
        }

        int largeLength, smallLength, leftIndex, rightIndex, smallLengthIndex, answer;
        leftIndex = (maxLengthIndex + 1) % 6;
        rightIndex = (maxLengthIndex + 6-1) % 6;

        if (farmSize[leftIndex] > farmSize[rightIndex]) {
            largeLength = farmSize[leftIndex];
            smallLength = farmSize[rightIndex];
            smallLengthIndex = (rightIndex + 6-1) % 6;
        } else {
            largeLength = farmSize[rightIndex];
            smallLength = farmSize[leftIndex];
            smallLengthIndex = (leftIndex + 1) % 6;
        }
        answer = num * ((maxLength * largeLength) - (largeLength - smallLength) * farmSize[smallLengthIndex]);
        System.out.println(answer);
    }
}
