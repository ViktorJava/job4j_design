package ru.job4j.jdbc.phonebook;

import ru.job4j.jdbc.ConnectionDemo;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 08.05.2021
 */
public class SimpleJDBCRunner implements AutoCloseable {
    private Connection connection;
    private final Properties properties;

    public SimpleJDBCRunner(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        ClassLoader classLoader = ConnectionDemo.class.getClassLoader();
        try {
            properties.load(classLoader.getResourceAsStream("pb.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String url = properties.getProperty("url");
        String password = properties.getProperty("password");
        String login = properties.getProperty("login");
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException throwables) {
            System.out.println("Неверный логин или пароль.");
        }
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("Select*From phonebook");
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        SimpleJDBCRunner simpleJDBCRunner = new SimpleJDBCRunner(new Properties());

    }
}
