//@interface Description {
//    String author();
//    String date();
//    String lastModify() default "unknown";
//    int currentRevision();
//    String lastModifyBy();
//    String[] reviewers();
//}

//@Description(author = "Ivanov", date = "01.06.2010", lastModify = "15.10.2012", lastModifyBy = "Petrov", reviewers = {"Sidorov", "Vasechkin"}, currentRevision = 2)

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@interface MyGetMapping {
    String path();
}

//@MyGetMapping("/welcome")
class Person {
    @MyGetMapping("/welcome")
            public String welcome() {
        return "Hi!";
    }
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
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}