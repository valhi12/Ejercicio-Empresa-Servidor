package mvc.model.repository;

import mvc.excepciones.RepositoryException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

    private static final String CONN_URL = "jdbc:mysql://localhost:3306/gestionnominas2";


    private static Connection conn = null;


    public static Connection getConnection() throws RepositoryException {
        try {
            if (conn == null) {
                Class.forName("org.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(CONN_URL);
            }
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    private DBUtils() {
    }



    private static boolean customerTableIsEmpty(Connection conn) throws SQLException {
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT COUNT(*) FROM CUSTOMERS");
        if(rs!=null && rs.next()) {
            int count = rs.getInt(1);
            return count == 0;
        }
        return true;
    }

    public static void closeConnection() throws RepositoryException {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    public static void close(Statement st) throws RepositoryException {
        try {
            if (st != null)
                st.close();
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    public static void close(ResultSet rs) throws RepositoryException {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage());
        }
    }
}