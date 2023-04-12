import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public  static void main(String[] args) throws IOException {
        HashMap<String, Integer> attendanceBook = new HashMap<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        StringBuilder S = new StringBuilder(stringTokenizer.nextToken());
        StringBuilder E = new StringBuilder(stringTokenizer.nextToken());
        StringBuilder Q = new StringBuilder(stringTokenizer.nextToken());

        S.deleteCharAt(2);
        E.deleteCharAt(2);
        Q.deleteCharAt(2);

        int SInt = Integer.parseInt(String.valueOf(S));
        int EInt = Integer.parseInt(String.valueOf(E));
        int QInt = Integer.parseInt(String.valueOf(Q));
        String enterString="";
        String[] enterArray;
        //Arrays.stream(tmp).forEach(System.out::println);
        while ((enterString=bufferedReader.readLine())!=null){
            enterArray = enterString.split(" ");
            //Arrays.stream(enterArray).forEach(x->System.out.print(x));
            StringBuilder temp = new StringBuilder(enterArray[0]);
            temp.deleteCharAt(2);
            int time = Integer.parseInt(temp.toString());
            if (time <= SInt) {
                attendanceBook.put(enterArray[1],1);
            } else if (EInt<= time&& time<=QInt&&attendanceBook.containsKey(enterArray[1])) {
                attendanceBook.put(enterArray[1], 2);
            }
        }
        long answer = attendanceBook.values().stream().filter(x -> x >= 2).count();
        System.out.println(answer);
    }
}
