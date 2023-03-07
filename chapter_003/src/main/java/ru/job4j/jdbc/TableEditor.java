package ru.job4j.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class TableEditor implements AutoCloseable {
    private Connection connection;

    public TableEditor() {
        initConnection();
    }

    /**
     * Метод инициализации соединения с базой данных.
     */
    private void initConnection() {
        try {
            connection = getConnection();
        } catch (Exception e) {
            System.out.println("Неверный логин или пароль");
        }
    }

    /**
     * Метод регистрирует драйвер в системе и получает соединение с базой данных,
     * используя данные из проперти.
     *
     * @return Объект соединения с базой данных.
     * @throws Exception Исключения соединения с базой данных.
     */
    private Connection getConnection() throws Exception {
        ResourceBundle rb = ResourceBundle.getBundle("app");
        String url = rb.getString("db.url");
        String password = rb.getString("db.password");
        String login = rb.getString("db.login");
        String driver = rb.getString("db.driver");
        Class.forName(driver);
        return DriverManager.getConnection(url, login, password);
    }

    /**
     * Метод, создает пустую таблицу без столбцов с указанным именем;
     *
     * @param tableName Имя таблицы.
     *
     * @throws SQLException Метод может выбросить исключение SQLException.
     */
    public void createTable(String tableName) throws SQLException {
        String sql = String.format(
                "CREATE TABLE IF NOT EXISTS %s();",
                tableName
        );
        executeStatement(sql);
    }

    /**
     * Метод, удаляет таблицу по указанному имени;
     *
     * @param tableName Имя таблицы.
     *
     * @throws SQLException Метод может выбросить исключение SQLException.
     */
    public void dropTable(String tableName) throws SQLException {
        String sql = String.format(
                "DROP TABLE IF EXISTS %s;",
                tableName
        );
        executeStatement(sql);
    }

    /**
     * Метод добавляет столбец в таблицу;
     *
     * @param tableName  Имя таблицы.
     * @param columnName Имя столбца.
     * @param type       Тип столбца.
     * @throws SQLException Метод может выбросить исключение SQLException.
     */
    public void addColumn(String tableName, String columnName,
                          String type) throws SQLException {
        String sql = String.format(
                "ALTER TABLE %s ADD COLUMN %s %s;",
                tableName,
                columnName,
                type
        );
        executeStatement(sql);
    }

    /**
     * Метод, удаляет столбец из таблицы;
     *
     * @param tableName  Имя таблицы.
     * @param columnName Имя столбца.
     * @throws SQLException Метод может выбросить исключение SQLException.
     */
    public void dropColumn(String tableName, String columnName) throws SQLException {
        String sql = String.format(
                "ALTER TABLE %s DROP COLUMN %s;",
                tableName,
                columnName
        );
        executeStatement(sql);
    }

    /**
     * Метод переименовывает столбец.
     *
     * @param tableName     Имя таблицы.
     * @param columnName    Имя столбца.
     * @param newColumnName Новое имя столбца.
     * @throws SQLException Метод может выбросить SQLException.
     */
    public void renameColumn(String tableName, String columnName,
                             String newColumnName) throws SQLException {
        String sql = String.format(
                "ALTER TABLE %s RENAME COLUMN %s TO %s;",
                tableName,
                columnName,
                newColumnName
        );
        executeStatement(sql);
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null,
                null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    /**
     * Метод выполнения заявления.
     *
     * @param sql Запрос.
     */
    private void executeStatement(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws SQLException {
        TableEditor tableEditor = new TableEditor();
        System.out.println("Создание таблицы");
        tableEditor.createTable("test_table");

        System.out.println("Добавление столбца");
        tableEditor.addColumn("test_table", "id",
                "serial primary key");
        System.out.println(tableEditor.getScheme("test_table"));

        System.out.println("Переименование столбца");
        tableEditor.renameColumn("test_table", "id",
                "id_table");
        System.out.println(tableEditor.getScheme("test_table"));

        System.out.println("Удаление столбца");
        tableEditor.dropColumn("test_table", "id_table");
        System.out.println(tableEditor.getScheme("test_table"));

        System.out.println("Удаление таблицы");
        tableEditor.dropTable("test_table");
    }
}
