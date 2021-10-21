package ru.job4j.jdbc.statement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Класс отработки навыков работы с классом PreparedStatement.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 11.05.2021
 */
public class PrepareStatementDemo {
    private Connection connection;

    public PrepareStatementDemo() throws Exception {
        initConnection();
    }

    private void initConnection() throws Exception {
        ResourceBundle rb = ResourceBundle.getBundle("app");
        String url = rb.getString("db.url");
        String password = rb.getString("db.password");
        String login = rb.getString("db.login");
        String driver = rb.getString("db.driver");
        Class.forName(driver);
        connection = DriverManager.getConnection(url, login, password);
    }

    /**
     * Метод вставки данных типа City, в таблицу.
     *
     * @param city Объект типа City.
     * @return Объект типа City.
     */
    public City insert(City city) {
        try (PreparedStatement statement =
                     connection.prepareStatement(
                             "insert into cities(name, population) values (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    city.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return city;
    }

    /**
     * Обновление в таблице, данных типа City.
     *
     * @param city Объект типа City.
     * @return true в случае удачи, иначе false.
     */
    public boolean update(City city) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement(
                             "update cities set name = ?, population = ? where id = ?")) {
            statement.setString(1, city.getName());
            statement.setInt(2, city.getPopulation());
            statement.setInt(3, city.getId());
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Удаление в таблице, данных типа City.
     *
     * @param id Идентификатор записи.
     * @return true в случае удачи, иначе false.
     */
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("delete from cities where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Выборка всех данных в таблице.
     *
     * @return Список данных типа City.
     */
    public List<City> findAll() {
        List<City> cities = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from cities")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    cities.add(new City(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("population")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cities;
    }

    public static void main(String[] args) throws Exception {
        PrepareStatementDemo prepareStatementDemo = new PrepareStatementDemo();
        System.out.println(prepareStatementDemo
                .insert(new City(1, "Kiev", 76000)));
        prepareStatementDemo.update(new City(1, "Moscow", 176000));
        List<City> ci = new ArrayList<>(prepareStatementDemo.findAll());
        ci.forEach(System.out::println);
    }
}
