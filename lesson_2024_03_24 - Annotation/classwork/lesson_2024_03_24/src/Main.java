//@interface Description {
//    String author();
//    String date();
//    String lastModify() default "unknown";
//    String lastModifyBy(); // default "unknown"
//    String[] reviewers();
//    int currentRevision(); // default 1
//}
//
//@Description(
//        author = "Ivanov",
//        date = "01.06.2010",
//        lastModify = "",
//        lastModifyBy = "",
//        reviewers = {"Petrov", "Vasechkin"},
//        currentRevision = 2
//)

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@interface MyGetMapping {
    String welcome();
}

//@MyGetMapping(path = "/welcome")
class Person {
    String name;
    String surname;
    int age;

    public Person() {
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    @MyGetMapping(path = "/welcome")
    public String welcome(@MyGetMapping(path = "/welcome") String something) { return "Hi!"; }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}