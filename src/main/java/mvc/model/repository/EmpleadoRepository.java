package mvc.model.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import mvc.excepciones.RepositoryException;
import mvc.model.entify.Empleado;

public class EmpleadoRepository {
    private static final String SELECT_ALL = "SELECT * FROM empleado";

    public static List<Empleado> findAllEmpleados() throws RepositoryException {
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = stm.executeQuery();

            List<Empleado> list = new ArrayList<>();

            while (rs.next()) {
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                Character sexo = rs.getString("sexo").toCharArray()[0];
                Integer categoria = rs.getInt("categoria");
                Integer anyos = rs.getInt("anyos");
                Integer años_trabajados = rs.getInt("años_trabajados");
                list.add(new Empleado(nombre, sexo, dni, categoria, anyos));
            }

            return list;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
