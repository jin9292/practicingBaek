import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        char[] inputArray = input.toCharArray();
        StringBuilder answer = new StringBuilder();
        char character;
        boolean isTag = false;
        StringBuilder stringBuilder = new StringBuilder(); //reverse할 문자열
        stringBuilder.setLength(0); //문자열 초기화
        for (int i = 0; i < inputArray.length; i++) {
            if ("<".equals(String.valueOf(inputArray[i]))) {
                isTag = true;  //태그 시작 표시
                stringBuilder.reverse();
                answer.append(stringBuilder);
            }

            if(isTag){ //tag임
                answer.append(inputArray[i]);
            } else  { //tag가 아님
                //주의할 점 : String과 Char을 equals method로 비교하기 위해 char -> String으로 변환 필요!
                if (" ".equals(String.valueOf(inputArray[i]))) { //" "이면 그 전까지의 문자열 뒤집고 공백을 더해서 answer에 추가
                    stringBuilder.reverse();
                    answer.append(stringBuilder+" ");
                    stringBuilder.setLength(0);
                } else  {   //문자열 뒤집기 위해 추가
                    stringBuilder.append(inputArray[i]);
                }
            }

            if (">".equals(String.valueOf(inputArray[i]))) {
                isTag = false;  //태그 닫힘
                stringBuilder.setLength(0); //문자열을 입력받이 뒤집기 위해 문자열 초기화
            }
        }
        if (stringBuilder != null) {    //남은 문자열 있다면 뒤집어서 문자열에 추기
            stringBuilder.reverse();
            answer.append(stringBuilder);
        }
        System.out.println(answer);
    }
}
