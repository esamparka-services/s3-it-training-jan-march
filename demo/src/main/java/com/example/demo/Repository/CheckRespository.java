package com.example.demo.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class CheckRespository implements ICheckRepository {
    @Override
    public String findReverse(String s) {
       StringBuilder str = new StringBuilder(s);
       String reverse = str.reverse().toString();
       return  reverse;
    }

    @Override
    public boolean isPalindrome(String s) {
        String reverse = findReverse(s);
        if(reverse.equals(s)){
            return  true;
        }else {
            return false;
        }
    }
}
