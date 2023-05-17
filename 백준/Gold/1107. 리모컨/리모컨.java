import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        Main main1107 = new Main();
        main1107.doIt();
    }

    public void doIt() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        int[] brokeButton = new int[10];
        int answer = Math.abs(N-100);

        if(M>0) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            while (stringTokenizer.hasMoreTokens()) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                brokeButton[num] = 1;
            }
        }
        //System.out.println(Arrays.toString(brokeButton));

        for (int i = 0; i <= 999999; i++) {
            String num = String.valueOf(i);
            boolean possibleNum = true;

            for (int j = 0; j < num.length(); j++) {
                if (brokeButton[Integer.parseInt(String.valueOf(num.charAt(j)))]==1){  //너무 더러우니 꺼내서 새로운 변수를 사용
                    possibleNum = false;
                    break;
                }
            }
            if (possibleNum){
                int temp = Math.abs(i - N) + num.length();
                answer = Math.min(temp, answer);
            }

        }
        System.out.println(answer);

    }
}
