package if_condition;

import java.util.Scanner;

public class CheckIfPalindrome {

    public static void main(String[] args) {
        boolean isPalindrome = true;


        Scanner scr = new Scanner(System.in);

        System.out.println("Enter the word");
        String word = scr.next();


        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != word.charAt(word.length()-(i+1))){
                isPalindrome = false;
                break;
            }
        }
        if(isPalindrome == true){
            System.out.println(word + " is a palindrome");
        } else{
            System.out.println(word + " is not a palindrome");
        }


    }


}
