import javax.security.auth.login.AccountNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main1461 = new Main();
        main1461.doIt();
    }

    public void doIt() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        List<Integer> plusPosition = new ArrayList<>();
        List<Integer> minusPosition = new ArrayList<>();
        int minusNum = 0, minusMove = 0;
        int plusNum = 0, plusMove = 0;
        int answer = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            if (num < 0) {
                minusNum++;
                minusPosition.add(-num);
            } else if (num > 0) {
                plusNum++;
                plusPosition.add(num);
            }
        }
        minusPosition.sort((s1, s2) -> s2 - s1);
        plusPosition.sort((s1, s2) -> s2 - s1);
        boolean lastPosition;

        minusMove = minusNum / M;
        if (minusNum % M != 0) {
            minusMove++;
        }
        plusMove = plusNum / M;
        if (plusNum % M != 0) {
            plusMove++;
        }

        for (int i = 0; i < minusMove; i++) {
            if (i == 0) {
                answer += minusPosition.get(0);
            } else {
                answer += minusPosition.get(i * M) * 2;
            }
        }
        for (int i = 0; i < plusMove; i++) {
            if (i == 0) {
                answer += plusPosition.get(0);
            } else {
                answer += plusPosition.get(i * M) * 2;
            }
        }
        if (minusPosition.size() > 0 && plusPosition.size() > 0) {
            if (minusPosition.get(0) > plusPosition.get(0)) {
                answer += plusPosition.get(0);
            } else {
                answer += minusPosition.get(0);
            }
        }
        System.out.println( answer);
    }
}
