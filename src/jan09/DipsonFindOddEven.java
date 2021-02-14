package jan09;

public class DipsonFindOddEven {
    int number;
    String result;


    @GetMapping("/findOddEven")
    String find_Odd_Even() {
        number = 5;


        if (number % 2 == 0) {
            result = "It is even number";

        }
        else {
            result = "It is odd number";


        }
        return number + "." + result;
}}
