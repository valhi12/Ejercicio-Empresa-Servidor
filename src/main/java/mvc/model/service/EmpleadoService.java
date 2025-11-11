package mvc.model.service;

import java.util.List;
import java.util.Optional;

import mvc.model.entify.Empleado;
import mvc.excepciones.RepositoryException;
import mvc.model.repository.EmpleadoRepository;

public class EmpleadoService {

    /*El patrón Facade se implementa en la clase EmpleadoService ya que proporciona una interfaz unificada. Específicamente, este servicio actúa para ocultar la complejidad del código. En lugar de que el EmpleadoController necesite conocer y depender (Para acceder a datos) de clases como EmpleadoRepository, o manejar las excepciones tales como SQLException (Que está especificada en RepositoryException).El patrón Facade ofrece métodos más limpios. Esos metodos en mi código son: findAll(), findByDni() o findByField. Este patrón es muy importante ya que consigue que el Controlador no tenga múltiples dependencias, lo que permite mejorar la cohesión interna y la mantenibilidad del código.*/

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
