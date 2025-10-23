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

//    public static Optional<Empleado> findById(Integer customerId) throws RepositoryException {
//        return EmpleadoRepository.findById();
//    }
//
//    public static void newCustomer(String name, String address, String website, Double creditLimit) throws RepositoryException {
//        Empleado e = new Empleado(nombre, sexo, dni, categoria, anyos);
//        EmpleadoRepository.newEmpleado(e);
//    }
//
//    public static void deleteEmpleadoById(Integer id) throws RepositoryException {
//        EmpleadoRepository.deleteCustomerById(id);
//    }
//
//    public static void updateEmpleadoById(int id, String name, String address, String website, Double creditLimit) throws RepositoryException {
//        EmpleadoRepository.updateCustomerById(id, name, address, website, creditLimit);
//    }
}
