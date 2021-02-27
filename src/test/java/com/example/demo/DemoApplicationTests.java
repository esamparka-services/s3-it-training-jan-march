package com.example.demo;

import com.example.demo.model.Palindrome;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void myFirstUnitTest() {
        Palindrome palindrome = new Palindrome();
        palindrome.setString("sandeep");
        StringBuffer reversedStringBuffer = new StringBuffer();
        for (int x = palindrome.getString().length() - 1; x >= 0; x--) {
            char reversedChar = (palindrome.getString().charAt(x));
            reversedStringBuffer.append(reversedChar);
        }
        System.out.println(reversedStringBuffer);

    }

    @Test
    public void testVar() {
        int actual = 0;
        try {
            actual = test1(11);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(20, actual);
    }

    private int test1(int x) throws Exception {
        if (x == 10) {
            throw new Exception();
        }
        return 10 + 10;
    }

}
