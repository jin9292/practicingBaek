import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        Main main11497 = new Main();
        main11497.doIt();
    }

    public void doIt() throws IOException {
        List<Integer> answer = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            int maxDiff = 0;
            int N = Integer.parseInt(bufferedReader.readLine());
            List<Integer> logArray = new ArrayList<>();
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            while (stringTokenizer.hasMoreTokens()) {
                logArray.add(Integer.parseInt(stringTokenizer.nextToken()));
            }

            logArray.sort((s1,s2) -> s1-s2);
            List<Integer> sortedLogArray = logArray;
            /*List<Integer> sortedLogArray = logArray.stream().sorted(Integer::compare).toList();
            * .toList()는 자바 17 이후
            * */
            int[] answerArray = new int[sortedLogArray.size()];
            /*List<Integer> answerArray = new ArrayList<>(sortedLogArray.size()); -> 크기만을 정하는 것 같음
            * 크기 지정이 안되는 이유는?
            * */
            for (int j = 0; j < sortedLogArray.size(); j++) {
                if (j % 2 == 0) {
                    answerArray[j/2] = sortedLogArray.get(j);
                } else {
                    answerArray[sortedLogArray.size() -1- j/2] = sortedLogArray.get(j);
                }
            }

            for (int j = 0; j < answerArray.length; j++) {
                int abs = Math.abs(answerArray[j] - answerArray[(j + 1) % answerArray.length]);
                if (abs > maxDiff) {
                    maxDiff = abs;
                }
            }
            answer.add(maxDiff);
        }
        answer.forEach(System.out::println);
    }
}
