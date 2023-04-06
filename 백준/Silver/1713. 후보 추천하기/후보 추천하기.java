import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;
        int frameNum = Integer.parseInt(bufferedReader.readLine());
        int totalLikeNum = Integer.parseInt(bufferedReader.readLine());

        int[] likeStudentNum = new int[totalLikeNum];
        LinkedList<Integer> frameStudentNum = new LinkedList<>();
        LinkedList<Integer> frameStudentLikeNum = new LinkedList<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < totalLikeNum; i++) {
            int num = Integer.parseInt(stringTokenizer.nextToken());
            //교체 X and 이미 frame에 이름이 있는 경우
            if (frameStudentNum.contains(num)) {
                int index = frameStudentNum.indexOf(num);
                frameStudentLikeNum.set(index,frameStudentLikeNum.get(index)+1);
            }
            //교체 X and 이름이 없는 경우
            else if (frameStudentNum.size()<frameNum) {
                frameStudentNum.add(num);
                frameStudentLikeNum.add(1);
            }
            //frame이 가득 차서 교체 O
            else if (frameStudentNum.size()==frameNum) {
                int min = Collections.min(frameStudentLikeNum);
                int index = frameStudentLikeNum.indexOf(min);
                frameStudentLikeNum.remove(index);
                frameStudentNum.remove(index);

                frameStudentNum.add(num);
                frameStudentLikeNum.add(1);
            }
        }
        frameStudentNum.sort(Comparator.naturalOrder());
        for (int i = 0; i < frameStudentNum.size(); i++) {
            System.out.print(frameStudentNum.get(i)+" ");
        }
    }
}
