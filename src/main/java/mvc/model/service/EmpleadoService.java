package mvc.model.service;

import java.util.List;
import java.util.Optional;

import mvc.model.entify.Empleado;
import mvc.excepciones.RepositoryException;
import mvc.model.repository.EmpleadoRepository;

public class EmpleadoService {

    public static List<Empleado> findAll() throws RepositoryException {
        return EmpleadoRepository.findAllEmpleados();
    }

    public static Double findByDni(String dni) throws RepositoryException {
        return EmpleadoRepository.findByDni(dni);
    }

    public static Double findByField(String fieldName, String fieldValue) throws RepositoryException{
        return EmpleadoRepository.findByField(fieldName, fieldValue);
    }
}
