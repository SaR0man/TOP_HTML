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

//import java.lang.annotation.*;
//
//@Target(ElementType.PARAMETER)
//@Retention(RetentionPolicy.SOURCE)
//@interface MyGetMapping {
//    String welcome();
//}

//@MyGetMapping(path = "/welcome")
//class Person {
//    String name;
//    String surname;
//    int age;
//
//    public Person() {
//    }
//
//    public Person(String name, String surname, int age) {
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    @Deprecated()
//    //    @MyGetMapping(path = "/welcome")
//    public String welcome() { return "Hi!"; }
//}

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Repeatable(Mammals.class)
@interface Mammal {
    String sound();
    int color()default 0xFFFFFF;
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Mammals {
    Mammal[] value();
}
@Deprecated
@Mammal(sound = "meow", color = 0x128128)
@Mammal(sound = "mieaou!", color = 0xFEDCBA)
class Cat {

}

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Class catClass = cat.getClass();
        Annotation[] annotations = catClass.getAnnotations();
        for (Annotation annotation : annotations) {
//            System.out.println(annotation.annotationType().getSimpleName());
            if (annotation instanceof Mammals) {
                Mammals mammals = (Mammals) annotation;
                for (Mammal mammal : mammals.value()) {
                    mammal = (Mammal) mammal;
                        System.out.println("Котик издает звук: " + mammal.sound());
                        System.out.println("Котик имеет цвет : " + mammal.color());
                }
            }
        }
    }
}