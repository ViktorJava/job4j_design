package ru.job4j.jdbc;

import java.sql.*;

/**
 * Класс, демонстрирует работу с БД через JDBC.
 *
 * @author ViktorJava (gipsyscrew@gmail.com)
 * @version 0.1
 * @since 06.05.2021
 */
public class StatementDemo {
    /**
     * Метод подключения к БД.
     *
     * @return Подключение к БД.
     * @throws ClassNotFoundException;
     */
    private static Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/temp_db";
        String login = "postgres";
        String password = "0000";
        return DriverManager.getConnection(url, login, password);
    }

    /**
     * Метод создания подключения к БД, объект создание запроса и
     * выполнение запроса (execute).
     *
     * @param args Аргументы.
     * @throws Exception Может выбросить исключение Exception.
     */
    public static void main(String[] args) throws Exception {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format("create table if not exists demo_table(%s, %s);",
                        "id serial primary key",
                        "name varchar(255)"
                );
                statement.execute(sql);
                System.out.println(getTableScheme(connection, "demo_table"));
            }
        }
    }

    /**
     * Метод проверки создания схемы.
     *
     * @param connection Подключение к БД.
     * @param tableName  Имя таблицы БД.
     * @return Схема таблицы.
     * @throws Exception Метод может выбросить исключение Exception.
     */
    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }
}
