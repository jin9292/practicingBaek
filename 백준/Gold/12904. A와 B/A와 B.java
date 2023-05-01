import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException{
        Main main12904 = new Main();
        main12904.doIt();
    }

    public void doIt() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String S = bufferedReader.readLine();
        StringBuilder T = new StringBuilder(bufferedReader.readLine());

        while(S.length()!=T.length()){
            if (T.charAt(T.length() - 1) == 'A') {
                T.deleteCharAt(T.length() - 1);
            } else {
                T.deleteCharAt(T.length() - 1);
                T.reverse();
            }
        }
        if (S.contentEquals(T)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
