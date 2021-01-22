package 백준온라인저지;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b14891_구현_톱니바퀴 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        wheels = new Wheel[5];

        for (int i = 0; i < 4; i++) {
            wheels[i+1] = new Wheel(i+1, br.readLine());
        }

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String[] ND = br.readLine().split(" ");

            int num = Integer.parseInt(ND[0]);
            int dir = Integer.parseInt(ND[1]);

            turn(num, dir);

            for(int j =1; j<=4; j++){
                System.out.println(wheels[j].toString());
            }
        }

        int s = getScore();
        System.out.print(s);
    }

    private static Wheel[] wheels;

    private static int getScore(){
        int sum =0;
        for(int i=1; i<=4; i++){
            sum += wheels[i].getScore();
        }
        return sum;
    }

    private static void turn(int wheelNum, int dir) {
        wheels[wheelNum].turn(dir);

        // turn right wheels
        int wheelRight = wheels[wheelNum].getRight();
        int turnDir = dir * -1;
        for (int index = wheelNum + 1; index <= 4; index++) {
            if (wheels[index].isLeft(wheelRight)) {
                break;
            }
            wheels[index].turn(turnDir);
            turnDir *= -1;
            wheelRight = wheels[index].getRight();
        }

        // turn left wheels
        int wheelLeft = wheels[wheelNum].getLeft();
        turnDir = dir * -1;
        for (int index = wheelNum - 1; index > 0; index--) {
            if (wheels[index].isRight(wheelLeft)) {
                break;
            }
            wheels[index].turn(turnDir);
            turnDir *= -1;
            wheelLeft = wheels[index].getLeft();
        }
    }


    static class Wheel {
        private int num;
        private int[] nums = new int[8];

        public Wheel(int num, String line) {
            this.num = num;
            String[] characters = line.split("");
            for (int i = 0; i < 8; i++) {
                nums[i] = Integer.parseInt(characters[i]);
            }
        }

        public boolean isRight(int n) {
            return nums[2] == n;
        }

        public int getRight() {
            return nums[2];
        }

        public boolean isLeft(int n) {
            return nums[6] == n;
        }

        public int getLeft() {
            return nums[6];
        }

        public void turn(int dir) {
            if (dir == 1) {
                turnRight();
            } else {
                turnLeft();
            }
        }

        public void turnRight() {
            int temp = nums[7];

            for (int i = 0; i < 7; i++) {
                nums[i + 1] = nums[i];
            }

            nums[0] = temp;
        }

        public void turnLeft() {
            int temp = nums[0];

            for (int i = 1; i < 8; i++) {
                nums[i - 1] = nums[i];
            }

            nums[7] = temp;
        }

        public int getScore() {
            return (int) (nums[0] * Math.pow(2, (this.num) - 1));
        }

        @Override
        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(int i =0; i<8; i++){
                sb.append(nums[i]);
            }
            return sb.toString();
        }

    }
}
