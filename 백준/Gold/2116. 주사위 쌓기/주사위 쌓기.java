import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.doIt();
    }

    public void doIt() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int diceNum = Integer.parseInt(bufferedReader.readLine());
        int[][] dice = new int[diceNum][6];
        int answer = 0;
        for (int i = 0; i < diceNum; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for (int i = 0; i < 6; i++) {
            int totalAddNum = 0;
            int bottomIndex = i;
            for (int j = 0; j < diceNum; j++) {
                int topIndex = getTopIndex(bottomIndex);
                int maxNum = 0;
                for (int k = 0; k < 6; k++) {
                    if (k != bottomIndex && k != topIndex && dice[j][k] > maxNum) {
                        maxNum = dice[j][k];
                    }
                }
//                System.out.print("bottomIndex = " + bottomIndex);
//                System.out.print("/ topIndex = " + topIndex);
//                System.out.print("/ maxNum = " + maxNum);
//                System.out.println();
                bottomIndex = getNextBottomIndex(dice[j][topIndex], j, diceNum, dice);
                totalAddNum += maxNum;
            }
            if (totalAddNum > answer) {
                answer = totalAddNum;
            }
//            System.out.println("totalAddNum = " + totalAddNum);
        }
        System.out.println(answer);
    }

    public int getTopIndex(int index) {
        int topIndex = 0;
        switch (index) {
            case 0:
                topIndex = 5;
                break;
            case 1:
                topIndex = 3;
                break;
            case 2:
                topIndex = 4;
                break;
            case 3:
                topIndex = 1;
                break;
            case 4:
                topIndex = 2;
                break;
            case 5:
                topIndex = 0;
                break;
        }
        return topIndex;
    }

    public int getNextBottomIndex(int topNum, int currentDiceNum, int diceNum, int[][] dice) {
        int nextDiceBttomINdex = 0;
        if (currentDiceNum < diceNum-1) {
            for (int i = 0; i < 6; i++) {
                if (dice[currentDiceNum + 1][i] == topNum) {
                    nextDiceBttomINdex = i;
                }
            }
        }
        return nextDiceBttomINdex;
    }
}
