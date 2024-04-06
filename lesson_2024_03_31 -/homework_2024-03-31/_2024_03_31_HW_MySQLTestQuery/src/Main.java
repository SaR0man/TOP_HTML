import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            String url = "jdbc:mysql://localhost:3306/CompanyStaff";
            String password = "qwerty";
            String username = "root";

            //// создадим таблицу с данными о сотрудниках компании
            String createQuery = """
                    CREATE TABLE Staff (
                    ID INT PRIMARY KEY AUTO_INCREMENT,
                    Name VARCHAR(20),
                    Surname VARCHAR(20),
                    Position VARCHAR(20),
                    Salary INT
                    );
                        """;

            //// заполним таблицу данными сотрудников компании
            String insertQuery = """
                    INSERT INTO Staff (Name, Surname, Position, Salary) VALUES
                    ('John', 'Doe', 'Manager', 60000),
                    ('Jane', 'Smith', 'Sales Associate', 45000),
                    ('Michael', 'Johnson', 'Software Engineer', 75000),
                    ('Emily', 'Williams', 'HR Specialist', 50000),
                    ('David', 'Brown', 'Financial Analyst', 65000);
                    """;

            //// выведем весь штат компании
            String selectQuery = """
                    SELECT * FROM Staff
                    """;

            //// увеличим зарплату кадровика до 55к
            String updateQuery = """
                    UPDATE Staff
                    SET Salary = 55000
                    WHERE Position = 'HR Specialist';
                    """;

            //// удалим из таблицы записи, где з/п менее 55к
            String deleteQuery = """
                    DELETE FROM Staff
                    WHERE Salary < 55000;
                    """;

            try(Connection connection = DriverManager.getConnection(url,username, password);) {
                Statement statement = connection.createStatement();

                statement.executeUpdate(createQuery);
                System.out.println("** Table Staff was create success!");

                int insertRow = statement.executeUpdate(insertQuery);
                System.out.println("** " + insertRow + " rows were added.");

                ResultSet resultSet = statement.executeQuery(selectQuery);
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String name = resultSet.getString("Name");
                    String surname = resultSet.getString("Surname");
                    String position = resultSet.getString("Position");
                    int salary = resultSet.getInt("Salary");
                    System.out.println("  " + id + ") " + name + " " + surname + ", " + position + ", " + salary + ".");
                }

                int changeRow = statement.executeUpdate(updateQuery);
                System.out.println("** " + changeRow + " rows were updated.");

                int affectRow = statement.executeUpdate(deleteQuery);
                System.out.println("** " + affectRow + " rows were affected.");

                resultSet = statement.executeQuery(selectQuery);
                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String name = resultSet.getString("Name");
                    String surname = resultSet.getString("Surname");
                    String position = resultSet.getString("Position");
                    int salary = resultSet.getInt("Salary");
                    System.out.println("  " + id + ") " + name + " " + surname + ", " + position + ", " + salary + ".");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}