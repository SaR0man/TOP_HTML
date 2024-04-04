
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            System.out.println("Success connect");
            String url = "jdbc:mysql://localhost:3306/academytop";
            String password = "qwerty";
            String username = "root";

            String createQuery = """
                        create table Person (
                        id int primary key auto_increment,
                        name varchar(20),
                        surname varchar(20),
                        age int
                        );
                        """;

            String insertQuery = """
                    insert into Person(name, surname, age)
                    VALUES
                    ('John', 'Kennedy', 40),
                    ('Frank', 'Sinatra', 45),
                    ('Mickle', 'Jackson', 35);
                    """;

            String deleteQuery = """
                    DELETE FROM Person
                    WHERE age < 40;
                    """;

            try(Connection connection = DriverManager.getConnection(url,username, password);) {
                Statement statement = connection.createStatement();

                /*
                Пояснения к statement.xxxxxx():
                - statement.executeUpdate() - drop, create, delete, update, insert - возвращает количество затронутых строк
                - statement.executeQuery() - select - возвращает данные по запросу
                - statement.execute() - это универсальный (.executeUpdate() и .executeQuery()), но не возвращает детали, а только true или false
                */

//                statement.executeUpdate(createQuery);
//                System.out.println("Table Person was create success");
//                statement.executeUpdate(insertQuery);
//                System.out.println("Table Person was update");
                statement.executeUpdate(deleteQuery);
                System.out.println("was deleted");

            }
            System.out.println("Connect to database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}