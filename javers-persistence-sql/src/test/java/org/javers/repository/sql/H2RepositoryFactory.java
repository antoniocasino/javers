package org.javers.repository.sql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author bartosz.walacik
 */
public class H2RepositoryFactory {

    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_CONNECTION = "jdbc:h2:~/test";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    public static JaversSqlRepository create() {
        try {
            Connection conn = getDBConnection();
            return SqlRepositoryBuilder.sqlRepository().
                    withConnectionProvider(new ConnectionProvider() {
                                public Connection getConnection() throws SQLException {
                                    return conn;
                                }
                            }).
                            withDialect(DialectName.H2)
                    //      .build() todo: run build the first time to create tables
                            .build().withSchemaManager(new CustomSchemaManager());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
                    DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
