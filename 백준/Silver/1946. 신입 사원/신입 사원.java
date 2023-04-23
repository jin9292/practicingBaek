import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main1946 = new Main();
        main1946.doIt();
    }

    public void doIt() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < T; i++) {
            int answer=0;
            int N = Integer.parseInt(bufferedReader.readLine());
            List<Student> studentList = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                studentList.add(new Student(Integer.parseInt(stringTokenizer.nextToken()), Integer.parseInt(stringTokenizer.nextToken())));
            }
            studentList.sort((s1,s2)->s1.getPaperRank()- s2.getPaperRank());
            int minInterviewRank = studentList.get(0).getInterviewRank();
            for (int j = 0; j < N; j++) {
                if (studentList.get(j).getInterviewRank() <= minInterviewRank) {
                    answer++;
                    minInterviewRank = studentList.get(j).getInterviewRank();
                }
            }
            System.out.println(answer);
        }
    }

    class Student {
        int paperRank = 0;
        int interviewRank = 0;

        public Student(int paperRank, int interviewRank) {
            this.paperRank = paperRank;
            this.interviewRank = interviewRank;
        }

        public int getPaperRank() {
            return paperRank;
        }

        public void setPaperRank(int paperRank) {
            this.paperRank = paperRank;
        }

        public int getInterviewRank() {
            return interviewRank;
        }

        public void setInterviewRank(int interviewRank) {
            this.interviewRank = interviewRank;
        }
    }

}
