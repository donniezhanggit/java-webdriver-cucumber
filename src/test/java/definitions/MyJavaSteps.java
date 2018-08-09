package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import pages.Cat;
import pages.Dog;

import java.util.Scanner;

public class MyJavaSteps {
    @Given("^I write Java code$")
    public void iWriteJavaCode() throws Throwable {

        String firstName = "Walter";
        String lastName = "White";
        String favoriteColor = "blue";
        String notFavoriteColor = "green";


        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(favoriteColor);
        System.out.println(favoriteColor.equals(notFavoriteColor));


        System.out.println("Hi, my name is " + firstName + " " + lastName + ", my favorite color is "
                + favoriteColor + " ");

        System.out.println(firstName);
    }

    @Given("^I type \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iTypeAnd(String var1, String var2) throws Throwable {

        System.out.print(var1 + " " + var2 + " ");
        System.out.print(var1.toUpperCase() + " " + var2.toUpperCase() + " ");
        System.out.print(var1.length() + " " + var2.length() + " ");
        System.out.print(var1.equals(var2) + " ");
        System.out.print(var1.equalsIgnoreCase(var2) + " ");
        System.out.print(var1.contentEquals(var2) + " ");


    }



    @Given("^I type (\\d+) into element with xpath \"([^\"]*)\"$")
    public void iTypeIntoElementWithXpath(int arg0, String arg1) throws Throwable {

  int num1;
  int num2;
  int sum;
  int difference;
  int quotient;
  int product;

  num1 = 31;
  num2 = 7;

sum = num1 + num2;
difference = num1 - num2;
quotient = num1 / num2;
product = num1 * num2;

        System.out.print(9/3 + " ");
System.out.print(9/3.3 + " ");
System.out.print(sum + " ");
System.out.print(difference + " ");
System.out.print(quotient + " ");
System.out.print(product + " ");


    }

    @Given("^I compare \"([^\"]*)\" and \"([^\"]*)\" strings$")
    public void iCompareAndStrings(String fantasy, String action) throws Throwable {

        if(fantasy.equalsIgnoreCase(action)){
            System.out.print("Fantasy are equal to action");
        } else  {
            System.out.print("Fantasy are not equal action");
        }
    }

    @Given("^I print url for \"([^\"]*)\" page$")
    public void iPrintUrlForPage(String site) throws Throwable {

if (site.equalsIgnoreCase("Amazon")){
    System.out.print("https://www.amazon.com/");
} else if (site.equalsIgnoreCase("Vk")) {
            System.out.print("https://vk.com/");
        } else if (site.equalsIgnoreCase("Google")) {
            System.out.print("https://www.google.com/");
    } else {
                System.out.print("Please type another site");
        }

}

    @Given("^I print arrays$")
    public void iPrintArrays() throws Throwable {

        int[] array1 = {5, 6, 87, 643};

        String[] groceryList = {"Milk", "Eggs", "Oranges", "Pear"};


        for ( int i = 0; i < groceryList.length; i++) {
            System.out.println(groceryList[i]);
            }

        System.out.println();

       for ( String i : groceryList) {
           System.out.println(i);
       }


    }

    @Given("^I create classes$")
    public void iCreateClasses() throws Throwable {
       Cat cat = new Cat("Barsik");
       cat.walk();
       cat.sleep();
       cat.eat("fish");
       cat.meow();

       Dog dog = new Dog();
       dog.walk();
       dog.sleep();
       dog.eat("bone");
       dog.bark();
    }
}


