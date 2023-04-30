import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main1092 = new Main();
        main1092.doIt();
    }

    public void doIt() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        List<Integer> crane = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            crane.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        int M = Integer.parseInt(bufferedReader.readLine());
        List<Integer> boxes = new ArrayList<>(M);
        int answer = 0;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        crane.sort((s1, s2) -> s2 - s1);
        boxes.sort((s1, s2) -> s2 - s1);

        if (boxes.get(0) > crane.get(0)) {
            answer = -1;
        } else {
            while (!boxes.isEmpty()) {
                //아래 식을 stream으로 못할까?
                int availableBoxIndex = 0;
                for (int i = 0; i < N; ) {
                    if (availableBoxIndex == boxes.size()) {
                        break;
                    } else if (crane.get(i) >= boxes.get(availableBoxIndex)) {
                        boxes.remove(availableBoxIndex);
                        i++;
                    } else {
                        availableBoxIndex++;
                    }
                }
//            String a = Arrays.toString(visited);
//            System.out.println("a = " + a);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
