package com.example.demo.palindrome;



import org.springframework.stereotype.Service;


@Service
public class Driver {

    public PalindromeCheck findPalindrome(PalindromeCheck palindromeCheck) {
        String givenWord = palindromeCheck.getWord();
        int j = givenWord.length();
        givenWord = givenWord.toLowerCase();
        int i = 0;
        j = j - 1;

        while (j > i) {
            char front = givenWord.charAt(i++);
            char back = givenWord.charAt(j--);
            if (front != back) {
                palindromeCheck.setResult("The Given Word is Not Palindrome");
            }else
            palindromeCheck.setResult("The Given Word is Palindrome");
        }

        return palindromeCheck;
    }

//        for (i = 0; i < j; i++, j--) {
//
//            if (givenWord.charAt(i) != givenWord.charAt(j)) {
//                palindromeCheck.setResult("Given Word is Not Palindrome  ");
//            }else if(givenWord.charAt(i) == givenWord.charAt(j))
//            palindromeCheck.setResult("The Given Word is Not Palindrome");
//        }
//
//        return palindromeCheck;
//    }
}

