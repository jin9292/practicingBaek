import java.io.*;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int availableStudentNum = Integer.parseInt(stringTokenizer.nextToken());
        int totalLength = Integer.parseInt(stringTokenizer.nextToken());
        //contains method의 속도 차이 ArrayLsit : O(n) / LinkedHashSet : O(1)
        //LinkedHashSet과 HashSet의 차이 -> LinkedHashSet은 순서를 가지고 저장
        LinkedHashSet<String> studentNumberList = new LinkedHashSet<>();
        String studentNumber;

        for(;totalLength>0;--totalLength){
            studentNumber = bufferedReader.readLine();
            if (!studentNumberList.contains(studentNumber)) {
                studentNumberList.add(studentNumber);
            } else {
                studentNumberList.remove(studentNumber);
                studentNumberList.add(studentNumber);
            }
        }

        //HashSet의 순회 방법
        Iterator iterator = studentNumberList.iterator();
        while(iterator.hasNext() && availableStudentNum >0 ){
            //속도 향상
            //System.out.println(studentNumberList.get(index - availableStudentNum));
            bufferedWriter.write(iterator.next() + "\n");
            --availableStudentNum;
        }
        bufferedWriter.flush();
        bufferedReader.close();
        bufferedWriter.close();
    }
}

