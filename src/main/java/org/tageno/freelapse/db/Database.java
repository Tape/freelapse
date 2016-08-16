package org.tageno.freelapse.db;

import org.tageno.freelapse.util.CLI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class Database {
    /**
     * The database connection.
     */
    private static Connection _connection;

    /**
     * Connect to the database. For more information on connection properties:
     * https://jdbc.postgresql.org/documentation/94/connect.html
     *
     * @return True if the connection succeeds, false if not.
     */
    public static boolean connect() {
        final Properties props = new Properties();
        props.setProperty("user", CLI.get("u", "postgres"));
        props.setProperty("password", CLI.get("p", "postgres"));

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException $e) {
            // TODO: Log the fact the PostgreSQL driver was not found.
            return false;
        }

        try {
            _connection = DriverManager.getConnection("jdbc:postgresql://localhost/freelapse", props);
            return true;
        } catch (SQLException $e) {
            // TODO: Log this exception.
            return false;
        }
    }

    /**
     * Disconnect from the database.
     *
     * @return True if the connection successfully closes, false if not.
     */
    public static boolean disconnect() {
        try {
            _connection.close();
            return true;
        } catch (SQLException $e) {
            // TODO: Log this exception.
            return false;
        }
    }
}
