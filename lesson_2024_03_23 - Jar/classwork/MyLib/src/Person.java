public class Person {

    //// Поля класса
    String name;
    String surname;
    int age;

    //// Конструкторы класса
    public Person() { }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    //// Геттеры + Сеттеры
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    //// Override
    @Override
    public String toString() { return name + " " + surname + " " + age; }
}
