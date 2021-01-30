package jan09;

import com.sun.deploy.security.SelectableSecurityManager;

public class LeapYear {

    public static void main(String[] args){
        //Year to be checked
        int year = 2001;
        boolean leap = false;
        //Year is leap if it is divided by 4
        if (year % 4 == 0) {
            //If year can be exactly divided by 100 then it is not leap year
            if (year % 100 == 0) {

                if (year % 400 == 0) {
                    leap = true;}
                    else
                        leap = false;

            }
     else
         // year is leap year as it is not exactly divided by 100
    leap = true;
        }
        else
            leap = false;
        if (leap) {
            System.out.println(year + "is a leap year");
        }
            else
            System.out.println(year + "is not a leap year");


    }

}
