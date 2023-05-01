import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main5430 = new Main();
        main5430.doIt();
    }

    public void doIt() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        int n;
        StringBuilder p;
        StringTokenizer stringTokenizer;
        Deque<Integer> array = new ArrayDeque<>();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < T; i++) {
            answer.setLength(0);
            boolean direction = true;
            p = new StringBuilder(bufferedReader.readLine());
            n = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), "[],");
            for (int j = 0; j < n; j++) {
                array.add(Integer.parseInt(stringTokenizer.nextToken()));
            }
            while (p.length() != 0) {
                //자바 11에서 컴파일 에러남 -> p.toString.isEmpty, 이것도 안되네?!?!
                if (n == 0 && p.charAt(0) == 'D') {
                    answer.append("error");
                    break;
                }
                if (p.charAt(0) == 'R') {
                    direction = !direction;
                } else {
                    if (direction) {
                        array.pollFirst();
                    } else {
                        array.pollLast();
                    }
                    n--;
                }
                p.deleteCharAt(0);
            }

            if (answer.length() == 0 && array.size() > 0) {
                if (direction) {
                    answer.append("[");
                    int arraySize = array.size();
                    for (int j = 0; j < arraySize; j++) {
                        answer.append(array.pollFirst());
                        answer.append(",");
                    }
                    answer.replace(answer.length() - 1, answer.length(), "]");
                } else {
                    answer.append("[");
                    int arraySize = array.size();
                    for (int j = 0; j < arraySize; j++) {
                        answer.append(array.pollLast());
                        answer.append(",");
                    }
                    answer.replace(answer.length() - 1, answer.length(), "]");
                }
            } else if (answer.length() ==0 && array.size()==0){
                answer.append("[]");
            }
            bufferedWriter.write(answer + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}
