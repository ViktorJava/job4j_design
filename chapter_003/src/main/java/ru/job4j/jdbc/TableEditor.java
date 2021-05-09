package ru.job4j.jdbc;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private final Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        //ClassLoader для получения пути к папке resources.
        ClassLoader classLoader = ConnectionDemo.class.getClassLoader();
        try {
            properties.load(classLoader.getResourceAsStream("app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //try {
        //    Регистрация драйвера в системе.
        //    Class.forName("org.postgresql.Driver");
        //} catch (ClassNotFoundException e) {
        //    e.printStackTrace();
        //}
        String url = properties.getProperty("url");
        String password = properties.getProperty("password");
        String login = properties.getProperty("login");
        try {
            connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException throwables) {
            System.out.println("Неверный логин или пароль.");
        }
    }

    /**
     * Метод, создает пустую таблицу без столбцов с указанным именем;
     *
     * @param tableName Имя таблицы.
     */
    public void createTable(String tableName) {
    }

    /**
     * Метод, удаляет таблицу по указанному имени;
     *
     * @param tableName Имя таблицы.
     */
    public void dropTable(String tableName) {
    }

    /**
     * Метод добавляет столбец в таблицу;
     *
     * @param tableName  Имя таблицы.
     * @param columnName Имя столбца.
     * @param type       Тип столбца.
     */
    public void addColumn(String tableName, String columnName, String type) {
    }

    /**
     * Метод, удаляет столбец из таблицы;
     *
     * @param tableName  Имя таблицы.
     * @param columnName Имя столбца.
     */
    public void dropColumn(String tableName, String columnName) {
    }

    /**
     * Метод переименовывает столбец.
     *
     * @param tableName     Имя таблицы.
     * @param columnName    Имя столбца.
     * @param newColumnName Новое имя столбца.
     */
    public void renameColumn(String tableName, String columnName, String newColumnName) {
    }

    public String getScheme(String tableName) throws SQLException {
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

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) {
        TableEditor tableEditor = new TableEditor(new Properties());

    }
}
