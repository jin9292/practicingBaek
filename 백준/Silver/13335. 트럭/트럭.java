import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
while(총 건넌 트럭 수가 n일 때 까지){
    if(다리의 끝에 트럭이 있어서 한 칸만 움직이면 들어오는 경우) {
        한 칸 전진으로 들어온 트럭 수 ++
        하중을 들어온 트럭 무게만큼 감소
    }

    한 칸씩 앞으로

    건너지 않은 트럭이 남아있거고 그 트럭의 무게를 하중이 견딜 수 있다면 다리로 전진
}
print answer
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int w = Integer.parseInt(stringTokenizer.nextToken());
        int L = Integer.parseInt(stringTokenizer.nextToken());
        int[] bridgeArray = new int[w]; //무게를 기록한 다리 배열
        int answer = 0;
        //linkedList를 활용한 Queue 생성
        Queue<Integer> truckWaitingArray = new LinkedList<>();
        int crossedTruckNum = 0;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        //truckWaitingArray 초기화
        for (int i = 0; i < n; i++) {
            truckWaitingArray.offer(Integer.parseInt(stringTokenizer.nextToken()));
        }
        //truckWaitingArray.stream().forEach(System.out::print);

        while (crossedTruckNum != n) {
            //트럭이 들어옴
            if (bridgeArray[0] != 0) {
                crossedTruckNum++;
                L += bridgeArray[0];
            }
            //한 칸씩 전진
            //흠 linkedList를 사용하면 더 빠를지도?!?!?!?
            for (int i = 0; i < w - 1; i++) {
                bridgeArray[i] = bridgeArray[i + 1];
            }
            bridgeArray[w - 1]=0; //마지막은 0으로

            //건너지 않은 트럭이 남아있거고 그 트럭의 무게를 하중이 견딜 수 있다면 다리로 전진
            if (!truckWaitingArray.isEmpty()&&L>=truckWaitingArray.peek()){
                bridgeArray[w - 1] = truckWaitingArray.poll();
                L -= bridgeArray[w - 1];
            }
            answer++;
        }
        System.out.println(answer);
    }
}
