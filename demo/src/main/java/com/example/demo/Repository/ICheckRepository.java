package com.example.demo.Repository;

import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface ICheckRepository {
    public String findReverse(String s);
    public boolean isPalindrome(String s);

}
