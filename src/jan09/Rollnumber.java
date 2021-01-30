package jan09;

public class Rollnumber {

    public static void main(String[] args) {
        int roll;

        int MissingRollNumber = 6;
        for(roll = 1; roll <=10; roll++) {
           System.out.println(roll);
            if (roll == MissingRollNumber){
                break;
            }
        }
    }

}
