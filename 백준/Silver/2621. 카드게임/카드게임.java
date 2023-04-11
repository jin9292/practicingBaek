import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int[] colorArray = new int[4]; //RBYG 순서로 얻는 카드를 표시하는 배열 생성
        int[] numberArray = new int[9];  //1 ~ 9까디 획득한 숫자를 표시
        boolean sameFiveColor = false;
        boolean fiveStraightNum = false;
        boolean twoTwinNum = false; //숫자가 같은 경우가 두번!
        int largestNum = 0;
        int largestNumIndex = 0;
        int answer = 0;
        for (int i = 0; i < 5; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String colorIndex = stringTokenizer.nextToken();
            Integer numberIndex = Integer.parseInt(stringTokenizer.nextToken());
            switch (colorIndex) {
                case "R":
                    colorArray[0]++;
                    break;
                case "B":
                    colorArray[1]++;
                    break;
                case "Y":
                    colorArray[2]++;
                    break;
                case "G":
                    colorArray[3]++;
                    break;
            }
            numberArray[numberIndex - 1]++;
        }
        //다섯 카드 모두 색이 같은 경우 true
        for (int i = 0; i < colorArray.length; i++) {
            if (colorArray[i] == 5) {
                sameFiveColor = true;
                break;
            }
        }
        //System.out.println("sameFiveColor = " + sameFiveColor);
        //다섯장의 카드 중 가장 큰 숫자를 입력
        for (int i = 8; i >= 0; i--) {
            if (numberArray[i] != 0) {
                largestNum = i+1;
                largestNumIndex = i;
                break;
            }
        }
        //System.out.println("largestNumIndex = " + largestNumIndex);
        //다섯장의 카드가 연속된 숫자일 경우 확인
        if (largestNumIndex>=4&&numberArray[largestNumIndex]==1&&numberArray[largestNumIndex-1]==1
                &&numberArray[largestNumIndex-2]==1&&numberArray[largestNumIndex-3]==1&&numberArray[largestNumIndex-4]==1){
            fiveStraightNum = true;
        }
        //System.out.println("fiveStraightNum = " + fiveStraightNum);

        //숫자가 같은 카드가 두 장이 두번
        int j = 0, twinLargestNum = 0, twinSmallNum=100;
        for (int i = 0; i < numberArray.length; i++) {
            if (numberArray[i]==2) {
                j++;
                if (i > twinLargestNum) {
                    twinLargestNum = i;
                }
                if (i < twinSmallNum) {
                    twinSmallNum = i;
                }
            }
            if (j == 2) {
                twoTwinNum = true;
            }
        }
        twinSmallNum++;
        twinLargestNum++;

        //점수 로직 구현
        if (sameFiveColor&&fiveStraightNum) { //다섯 카드 모두 색이 같고 스트레이트인 경우
            answer += 900 + largestNum;
        } else if (Arrays.stream(numberArray).anyMatch(x -> x==4)) {
            //4장의 숫자가 같은 경우  사실 조건문에서 stream을 쓰고 index로 따로 for문을 돌리는건 시간 낭비이지만 stream 써보고 싶었음
            for (int i = 8; i >= 0; i--) {
                if (numberArray[i] == 4) {
                    answer += 800+i+1;
                    break;
                }
            }
        } else if (Arrays.stream(numberArray).anyMatch(x -> x == 3) && Arrays.stream(numberArray).anyMatch(x -> x == 2)) {
            //3개인 번호가 있으며 2개인 번호도 있는 경우
            for (int i = 8; i >= 0; i--) {
                if (numberArray[i] == 3) {
                    answer += 700+(i+1)*10;
                } else if (numberArray[i] == 2) {
                    answer += i+1;
                }
            }
        } else if (sameFiveColor) {//색이 모두 다섯개 같은 경우
            answer += 600 + largestNum;
        } else if (fiveStraightNum) { //스트레이트인 경우
            answer += 500 + largestNum;
        } else if (Arrays.stream(numberArray).anyMatch(x -> x == 3)) {
            for (int i = 8; i >= 0; i--) {
                if (numberArray[i] == 3) {
                    answer += 400+i+1;
                }
            }
        } else if (twoTwinNum) {
            answer += 300 + twinLargestNum * 10 + twinSmallNum;
        } else if (Arrays.stream(numberArray).anyMatch(x->x==2)) {
            for (int i = 0; i < numberArray.length; i++) {
                if (numberArray[i] == 2) {
                    answer += 200 + i + 1;
                }
            }
        } else {
            answer += 100 + largestNum;
        } //end of 조건
        System.out.println(answer);
    }
}
