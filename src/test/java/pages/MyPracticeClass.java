package pages;

import java.util.Scanner;

public class MyPracticeClass {
    public MyPracticeClass() {
    }

    public void checkEligibility() {
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter your age");
        int age = sc.nextInt();
        if(age>=18){
            System.out.println("You are eligible to vote.");
        } else {
            System.out.println("You are not eligible to vote.");
        }
    }
}
