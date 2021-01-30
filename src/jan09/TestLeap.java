package jan09;

public class TestLeap {
    public static void main(String[] args) {
        int year = 1996;
        if (year % 4 == 0) {
            System.out.println("Leap Year");
        } else if (year % 100 != 0) {
            System.out.println("Leap Year");
        } else if (year % 400 == 0) {
            System.out.println("Leap Year");
        }else{
            System.out.println("Not a Leap Year");
        }
    }

}
