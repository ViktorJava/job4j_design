package ru.job4j.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Пример подключения к Postgres db через JDBC.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.2
 * @since 04.05.2021
 */
public class ConnectionDemo {
    /**
     * ClassLoader служит для получения пути к папке resources.
     *
     * @param args Аргументы запуска программы.
     * @throws ClassNotFoundException Может выбросить исключение ClassNotFoundException.
     * @throws SQLException           Может выбросить исключение SQLException.
     * @throws IOException            Может выбросить исключение IOException.
     */
    public static void main(String[] args) throws
            ClassNotFoundException, SQLException, IOException {
        Properties properties = new Properties();
        ClassLoader classLoader = ConnectionDemo.class.getClassLoader();
        properties.load(classLoader.getResourceAsStream("app.properties"));

        String url = properties.getProperty("db.url");
        String login = properties.getProperty("db.login");
        String password = properties.getProperty("db.password");
        String driver = properties.getProperty("db.driver");

        Class.forName(driver);
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
