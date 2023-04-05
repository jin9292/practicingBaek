import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args)throws Exception {
        boolean possible = true;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        HashMap<Character, Integer> countMap = new HashMap<>();
        StringBuilder answer = new StringBuilder("I'm Sorry Hansoo");
        StringBuilder statement = new StringBuilder(bufferedReader.readLine());

        for (int i = 0; i < statement.length(); ++i) {
            if(countMap.containsKey(statement.charAt(i))){
                count = countMap.get(statement.charAt(i))+1;
                //HashMap key 변경
                countMap.put(statement.charAt(i), count);
            } else {
                countMap.put(statement.charAt(i), 1);
            }
        }

        int oddCount=0;
        for (Integer odd : countMap.values()){
            oddCount += (odd%2);
            if (oddCount>1){
                possible = false;
            }
        }

        if (possible){
            //Character로 null 가능
            Character oddChar=null;
            //StringBuilder 초기화
            answer.setLength(0);
            //HashMap -> List
            ArrayList<Character> keyList = new ArrayList<>(countMap.keySet());
            //List 정렬
            keyList.sort(Comparator.naturalOrder());
            for (char key:keyList){
                if ((countMap.get(key)%2)==1){
                    oddChar = key;
                }
                int medium=countMap.get(key)/2;
                while (medium>0){
                    answer.append(key);
                    --medium;
                }
            }
            if (oddChar!=null){
                StringBuilder ans = new StringBuilder(answer.toString());
                ans.append(oddChar);
                //StringBuilder를 활용한 문자열의 reverse
                answer.reverse();
                ans.append(answer);
                System.out.println(ans);
            } else {
                StringBuilder ans = new StringBuilder(answer.toString());
                answer.reverse();
                ans.append(answer);
                System.out.println(ans);
            }
        } else {
            System.out.println(answer);
        }
    }
}
