import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int peopleNum = Integer.parseInt(bufferedReader.readLine());
        int[] taller = new int[peopleNum];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < peopleNum; i++) {
            taller[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] answer = new int[peopleNum];
        //O(n^2)
        for (int i = 0; i < peopleNum; i++) {
            int tallerCount = 0, index=0;
            while(!(tallerCount==taller[i]&&answer[index]==0)){
                if (answer[index]==0)
                    tallerCount++;
                index++;
            }
            answer[index] = i + 1;
        }
        //아래보다 출력 속도를 높이기 위해 StringBuilder를 활용하는 것이 효율적
        for (int i = 0; i < peopleNum; i++) {
            System.out.print(answer[i]+" ");
        }
    }
}
