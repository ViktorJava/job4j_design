package ru.job4j.jdbc.phonebook;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Пример подключения к Postgres db через JDBC.
 * Пример обработки запроса базы данных.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 08.05.2021
 */
public class SimpleJDBCRunner {
    private final Connection connection;

    public SimpleJDBCRunner() throws Exception {
        connection = SimpleJDBCRunner.initConnection();
    }

    /**
     * Метод читает ресурсный файл конфигурации Properties,
     * возвращает соединение с базой данных.
     *
     * @return Connection
     * @throws Exception Possible Exception.
     */
    private static Connection initConnection() throws Exception {
        Properties properties = new Properties();
        ClassLoader classLoader = SimpleJDBCRunner.class.getClassLoader();
        properties.load(classLoader.getResourceAsStream("pb.properties"));
        String url = properties.getProperty("url");
        return DriverManager.getConnection(url, properties);
    }

    /**
     * Метод создаёт конфигурацию типа Properties,
     * возвращает соединение с базой данных.
     * Метод демонстрирует один из способов работы с объектом типа Properties.
     *
     * @return Connection.
     * @throws SQLException Possible Exception.
     */

    private static Connection initConnection2() throws SQLException {
        Properties properties = new Properties();
        properties.put("user", "postgres");
        properties.put("password", "0000");
        properties.put("autoReconnect", "true");
        properties.put("characterEncoding", "UTF-8");
        properties.put("useUnicode", "true");
        String url = "jdbc:postgresql://localhost:5432/testphones";
        return DriverManager.getConnection(url, properties);
    }

    public static void main(String[] args) throws Exception {
        SimpleJDBCRunner simpleJDBCRunner = new SimpleJDBCRunner();
        try (Statement statement = simpleJDBCRunner.connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM phonebook")
        ) {
            ArrayList<Abonent> lst = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(1);
                int phone = rs.getInt(3);
                String name = rs.getString(2);
                lst.add(new Abonent(id, phone, name));
            }
            if (lst.size() > 0) {
                System.out.println(lst);
            } else {
                System.out.println("Not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
