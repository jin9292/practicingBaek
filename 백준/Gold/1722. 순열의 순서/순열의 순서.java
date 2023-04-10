import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int type = Integer.parseInt(stringTokenizer.nextToken());

        //정답이 되는 순열을 저장하거나 주어진 순열을 저장하기 위한 배열
        int[] possibleArray = new int[N];
        //1!->20!을 저장하기 위한 배열
        long[] arr = new long[N + 1];
        //사용된 숫자는 순열에서 다시 사용되지 않으므로 그것을 표시하기 위한 배열 / false로 초기화
        boolean[] used = new boolean[N + 1];
        //arr 초기화
        arr[0] = 1L;
        for (int i = 1; i < N+1; i++) {
            arr[i] = arr[i - 1] * i;
        }

        if (type == 1) {
            long answer = 1L;
            long num = Long.parseLong(stringTokenizer.nextToken());

            for (int i = 0; i < N; i++) {
                for (int j = 1; j < N+1; j++) {
                    if (!used[j]) {
                        if (arr[N - i - 1] < num) {
                            num -= arr[N - i - 1];
                        } else {
                            used[j] = true;
                            possibleArray[i] = j;
                            break;
                        }
                    }
                } //for문 end
            } //for문 end

            //출력
            for (int i = 0; i < possibleArray.length; i++) {
                System.out.print(possibleArray[i]+" ");
            }

        } else {
            //12345는 0번쨰가 아닌 1번째이므로 1에서부터 시작
            long answer=1L;
            //입력
            for (int i = 0; i < N; i++) {
                possibleArray[i] = Integer.parseInt(stringTokenizer.nextToken());
            }

            for(int i=0; i<N; i++) {
                for(int j=1; j<possibleArray[i]; j++) {
                    if(!used[j])
                        answer += arr[N-i-1];
                }//for문 end
                used[possibleArray[i]]=true;
            }//for문 end
            System.out.println(answer);
        }
    }
}

