import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main1041 = new Main();
        main1041.doIt();
    }

    class Dice {
        int[] diceNum = new int[6];

        public Dice(int[] diceNum) {
            this.diceNum = diceNum;
        }

        public int minFiveSide() {
            int[] temp = Arrays.copyOf(diceNum, 6);
            int minAdd = 0;
            Arrays.sort(temp);
            for (int i = 0; i < 5; i++) {
                minAdd += temp[i];
            }
            return minAdd;
        }

        public int minThreeSide() {
            int[] temp = Arrays.copyOf(diceNum, 6);
            int minAdd = Integer.MAX_VALUE;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (j != i && j != oppositeSide(i)) {
                        for (int k = 0; k < 6; k++) {
                            if (k != i && k != j && k != oppositeSide(i) && k != oppositeSide(j))
                                if (minAdd > temp[i] + temp[j] + temp[k]) {
                                    minAdd = temp[i] + temp[j] + temp[k];
                                }
                        }
                    }
                }
            }
            return minAdd;
        }

        public int minTwoSide() {
            int[] temp = Arrays.copyOf(diceNum, 6);
            int minAdd = Integer.MAX_VALUE;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if (i != j && j != oppositeSide(i)) {
                        if (minAdd > temp[i] + temp[j]) {
                            minAdd = temp[i] + temp[j];
                        }
                    }
                }
            }
            return minAdd;
        }

        public int minOneSide() {
            int[] temp = Arrays.copyOf(diceNum, 6);
            Arrays.sort(temp);
            return temp[0];
        }

        public int oppositeSide(int side) {
            int oppositeSide = 0;
            if (side == 0) {
                oppositeSide = 5;
            } else if (side == 1) {
                oppositeSide = 4;
            } else if (side == 2) {
                oppositeSide = 3;
            } else if (side == 3) {
                oppositeSide = 2;
            } else if (side == 4) {
                oppositeSide = 1;
            } else if (side == 5) {
                oppositeSide = 0;
            }
            return oppositeSide;
        }
    }

    void doIt() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(bufferedReader.readLine());
        int[] diceNum = new int[6];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 6; i++) {
            diceNum[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        long answer = 0L;
        Dice dice = new Dice(diceNum);

        if (N == 1) {
            answer = dice.minFiveSide();
        } else if (N == 2) {
            answer =  4 * dice.minThreeSide() + 4 * dice.minTwoSide();
        } else {
            answer = ((N - 1) * (N - 2) * 4 + (N - 2) * (N - 2)) * dice.minOneSide() + ((4 * (N - 2)) + (N - 1) * 4) * dice.minTwoSide() + 4 * dice.minThreeSide();
        }
        System.out.println(answer);
    }
}
