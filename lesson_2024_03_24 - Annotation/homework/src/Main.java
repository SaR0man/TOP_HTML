import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Audit {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Cacheable {
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

    private Map<String, Object> cache = new HashMap<>();

    public void clearCache() {
        cache.clear();
    }

    @Cacheable
    public int calculate(int yearsInFirstHome, int yearsInNewHome) {
        String key = yearsInFirstHome + "+" + yearsInNewHome;
//        System.out.println("key: " + key);
        if (cache.containsKey(key)) {
            System.out.println("Result from cache: " + cache.get(key));
            return (int) cache.get(key);
        } else {
            int totalYears = yearsInFirstHome + yearsInNewHome;
            cache.put(key, totalYears);
            System.out.println("Total years lived by the cat in both homes calculated: " + totalYears);
            return totalYears;
        }
    }
}

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Cat cat = new Cat();
        Class catClass = cat.getClass();  // Получение объекта класса Class для объекта cat (для работы рефлексии)
        Method[] methods = catClass.getMethods();  // Получение массива методов, имеющихся в классе Cat (через рефлексию)
        for (Method method : methods) {  // перебираем все методы класса Cat
            Annotation[] annotations = method.getAnnotations();  // Получение массива аннотаций для текущего метода
            for (Annotation annotation : annotations) {  // цикл для перебора всех аннотаций текущего метода

                //// логика для аннотации Audit
                if (annotation instanceof Audit) {
                    System.out.println("*** Method with @Audit annotation found: \"" + method.getName() + "\"");
                    System.out.print("*** Method arguments: ");
                    for (Class<?> parameterType : method.getParameterTypes()) {  // перебираем все типы параметров текущего метода
                        System.out.print("\"" + parameterType.getName() + "\", ");
                    }
                    System.out.println();
                }

                //// логика для аннотации Cacheable
                if (annotation instanceof Cacheable) {
                    System.out.println("*** Method with @Cacheable annotation found: \"" + method.getName() + "\"");
                    System.out.println("Calling method with different parameters to demonstrate caching:");
                    cat.clearCache(); // очищаем кэш перед началом демонстрации

                    // Вызываем метод calculate с разными аргументами
                    cat.calculate(2, 3); // первый вызов
                    cat.calculate(2, 4); // второй вызов с другими параметрами
                    cat.calculate(2, 3); // третий вызов с теми же параметрами, чтобы показать, что результат уже закеширован
                    cat.calculate(3, 4); // четвертый вызов с новыми параметрами

                    System.out.println();
                }
            }
        }
    }
}
