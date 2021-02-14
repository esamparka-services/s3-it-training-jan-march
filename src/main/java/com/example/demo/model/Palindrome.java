package com.example.demo.model;

public class Palindrome {
    private String string;
    private String reversedString;
    private boolean palindrome;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getReversedString() {
        return reversedString;
    }

    public void setReversedString(String reversedString) {
        this.reversedString = reversedString;
    }

    public boolean isPalindrome() {
        return palindrome;
    }

    public void setPalindrome(boolean palindrome) {
        this.palindrome = palindrome;
    }
}
