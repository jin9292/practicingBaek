import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.doIt();
    }

    public void doIt() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        long answer = 0;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            priorityQueue.add(Long.parseLong(stringTokenizer.nextToken()));
        }
        for (int i = 0; i < m; i++) {
            Long min1 = priorityQueue.poll();
            Long min2 = priorityQueue.poll();
            Long temp = min1 + min2;

            priorityQueue.add(temp);
            priorityQueue.add(temp);

        }
        while (!priorityQueue.isEmpty()) {
            answer += priorityQueue.poll();
        }

        System.out.println(answer);
    }
}
