package ca.myseneca.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DbUtilities provides functionality to read property file,
 * get connection for database, print sql exception
 */
public class DbUtilities {
    private Properties dbProps;

    public DbUtilities()
            throws IOException {
        super();
        this.setProperties("database.properties");
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                System.err.println("SQLState: "
                        + ((SQLException) e).getSQLState());
                System.err.println("Error Code: "
                        + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    private void setProperties(String fileName) throws IOException {
        this.dbProps = new Properties();
        FileInputStream fis = new FileInputStream(fileName);
        dbProps.load(fis);
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {

        String driver = dbProps.getProperty("DB_DRIVER");

        //ability to use oci or thin
        String urlString = dbProps.getProperty("USE_OCI").equals("1")
                ? dbProps.getProperty("DB_URL_OCI")
                : dbProps.getProperty("DB_URL_THIN");

        Class.forName(driver);
        Connection conn = DriverManager.getConnection(urlString,
                this.dbProps.getProperty("DB_USERNAME"), this.dbProps.getProperty("DB_PASSWORD"));
        return conn;
    }
}
