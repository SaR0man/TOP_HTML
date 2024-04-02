import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Audit {
}

class Cat {
    @Audit
    public void makeSound() {
        System.out.println("Meow");
    }

    public void eat(String food) {
        System.out.println("Eating " + food);
    }

    @Audit
    public void sleep(int duration, String place) {
        System.out.println("Sleeping for " + duration + " hours in " + place);
    }
}

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Cat cat = new Cat();
        Class catClass = cat.getClass();  // Получение объекта класса Class для объекта cat (для работы рефлексии)
        Method[] methods = catClass.getMethods();  // Получение массива методов, имеющихся в классе Cat (через рефлексию)
        for (Method method : methods) {  // перебираем все методы класса
            Annotation[] annotations = method.getAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation instanceof Audit) {
                    System.out.println("*** Method with @Audit annotation found: \"" + method.getName() + "\"");
                    System.out.print("*** Method arguments: ");
                    for (Class<?> parameterType : method.getParameterTypes()) {
                        System.out.print("\"" + parameterType.getName() + "\", ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
