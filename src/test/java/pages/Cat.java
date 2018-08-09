package pages;

public class Cat extends Animal{
    public Cat() {
    }
    public Cat(String catName) {
        setName(catName);
    }
    public void meow() {
        System.out.println(getName()+ " meow!");
    }
}
