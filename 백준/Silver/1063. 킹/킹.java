import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class  Object{
        StringBuilder position;
        StringBuilder newPosition;

        public void move(){
            this.position = new StringBuilder(newPosition);
        }
        public void expectedNewPosition(StringBuilder direction){
            this.newPosition.setLength(0);
            //newPosition 초기화
            if (direction.length()>=2){
                if(direction.toString().equals("RT")){
                    newPosition.append((char)(position.charAt(0)+1));
                    newPosition.append((char)(position.charAt(1)+1));
                }
                else if (direction.toString().equals("LT")) {
                    newPosition.append((char)(position.charAt(0)-1));
                    newPosition.append((char)(position.charAt(1)+1));
                } else if (direction.toString().equals("RB")) {
                    newPosition.append((char)(position.charAt(0)+1));
                    newPosition.append((char)(position.charAt(1)-1));
                } else {
                    newPosition.append((char)(position.charAt(0)-1));
                    newPosition.append((char)(position.charAt(1)-1));
                }
            } else {
                if(direction.toString().equals("R")){
                    newPosition.append((char)(position.charAt(0)+1));
                    newPosition.append(position.charAt(1));
                } else if (direction.toString().equals("L")) {
                    newPosition.append((char)(position.charAt(0)-1));
                    newPosition.append(position.charAt(1));
                } else if (direction.toString().equals("B")) {
                    newPosition.append(position.charAt(0));
                    newPosition.append((char)(position.charAt(1)-1));
                } else {
                    newPosition.append(position.charAt(0));
                    newPosition.append((char) (position.charAt(1)+1));
                }
            }

        }
        public boolean checkOutline(){
            boolean result = false;
            if ((('1'<=this.newPosition.charAt(1)&&this.newPosition.charAt(1)<='8')&&'A'<=this.newPosition.charAt(0))&& (this.newPosition.charAt(0)<='H')){
                result = true;
            }
            return result;
        }
        public boolean crash(Object other){
            boolean result = false;
            if (this.newPosition.toString().equals(other.position.toString())){
                result = true;
            }
            return result;
        }

        public StringBuilder getPosition() {
            return position;
        }

        public void setPosition(StringBuilder position) {
            this.position = position;
        }

        public StringBuilder getNewPosition() {
            return newPosition;
        }

        public void setNewPosition(StringBuilder newPosition) {
            this.newPosition = newPosition;
        }
    }
    public static void main(String[] args)throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder direction;
        Object king = new Object();
        Object stone = new Object();

        king.setPosition(new StringBuilder(stringTokenizer.nextToken()));
        king.setNewPosition(new StringBuilder(king.getPosition()));
        stone.setPosition(new StringBuilder(stringTokenizer.nextToken()));
        stone.setNewPosition(new StringBuilder(stone.getPosition()));
        int totalMovement = Integer.parseInt(stringTokenizer.nextToken());

        while(totalMovement>0){
            direction = new StringBuilder(bufferedReader.readLine());
            king.expectedNewPosition(direction);
            if (king.crash(stone)){
                stone.expectedNewPosition(direction);
                if (stone.checkOutline()&& king.checkOutline()){
                    king.move();
                    stone.move();
                }
            } else {
                if (king.checkOutline()) {
                    king.move();
                }
            }
            totalMovement--;
        }
        System.out.println(king.position);
        System.out.println(stone.position);
    }
}

