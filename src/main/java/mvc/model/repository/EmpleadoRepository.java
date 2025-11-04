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
                list.add(new Empleado(nombre, sexo, dni, categoria, anyos));
            }

            return list;

        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    public static Double findByDni(String dni) throws RepositoryException {

        final String salarios = "SELECT sueldo FROM nomina WHERE dni = ?";

        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(salarios);
            stm.setString(1, dni);
            ResultSet rs = stm.executeQuery();
            Double salario = null;

            if (rs.next()) {
                salario = rs.getDouble("sueldo");
            }

            return salario;

        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    public static Double findByField(String fieldName, String fieldValue) throws RepositoryException{

        final String salarios = "SELECT n.sueldo FROM nomina n JOIN empleado e ON n.dni = e.dni WHERE e." + fieldName + " = ?";

        try{
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(salarios);
            stm.setString(1, fieldValue);
            ResultSet rs = stm.executeQuery();
            Double salario = null;

            if (rs.next()) {
                salario = rs.getDouble("sueldo");
            }

            return salario;
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage());
        }
    }
}
