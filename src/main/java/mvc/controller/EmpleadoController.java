package mvc.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.excepciones.RepositoryException;
import mvc.model.entify.Empleado;
import mvc.model.entify.Empleado;
import mvc.model.service.EmpleadoService;
import mvc.model.service.EmpleadoService;

import java.io.IOException;
import java.util.List;


/*El patrón Model-View-Controller está presente porque el código separa las responsabilidades en tres partes. La clase EmpleadoController es el Controlador, que recibe la petición del usuario, decide qué hacer, y le pide ayuda al EmpleadoService para manejar los datos. Una vez que EmpleadoService le ha pasado los datos, el Controlador elige qué página web (Como findAllEmpleados.jsp) mostrar al usuario con los resultados. Mostrará la página que le indiquemos.*/


/*El patrón Front Controller está presente en el proyecto porque hay un solo punto de entrada para todas las acciones relacionadas con empleados. Es decir, en lugar de tener una clase para "findAllEmpleados", otra para "mostrarSalarioEmpleados" y otra para "modificarDatosEmpleados", la clase EmpleadoController centraliza todas estas peticiones (Gracias al @WebServlet). Usamos en el switch un parámetro llamado opcion para saber qué tarea en concreto debe realizar, simplificando el manejo de las peticiones web.*/

@WebServlet("/EmpleadoController")
public class EmpleadoController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmpleadoController() {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opcion = request.getParameter("opcion");
        RequestDispatcher rd = null;

        if (opcion == null || opcion.isEmpty()) {
            request.setAttribute("Error", "La opcion es incorrecta");
            rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        } else {
            switch (opcion) {
                case "findAllEmpleados":
                    findAllEmpleados(request, response);
                    break;
                case "mostrarSalarioEmpleados":
                    mostrarSalarioEmpleados(request, response);
                    break;
                case "modificarDatosEmpleados":
                    modificarDatosEmpleados(request, response);
                    break;

            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void findAllEmpleados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Empleado> list;
        try {
            list = EmpleadoService.findAll();
            request.setAttribute("list", list);
            RequestDispatcher rd = request.getRequestDispatcher("findAllEmpleados.jsp");
            rd.forward(request, response);
        } catch (RepositoryException re) {
            re.printStackTrace();
            request.setAttribute("Error", "Se ha producido un problema al intentar acceder al respositorio de datos");
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }

    private void mostrarSalarioEmpleados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dni = request.getParameter("dni");
        try {
            if (dni == null) {
                RequestDispatcher rd = request.getRequestDispatcher("mostrarSalarioDni.jsp");
                rd.forward(request, response);

            }else {
                Double empleado = EmpleadoService.findByDni(dni);

                if (empleado != null) {
                    request.setAttribute("salario", empleado);
                    RequestDispatcher rd = request.getRequestDispatcher("mostrarSalarioDni.jsp");
                    rd.forward(request, response);
                }else {
                    request.setAttribute("Error", "Se ha producido un problema al intentar acceder al respositorio de datos");
                    RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                }
            }

        } catch (RepositoryException re) {
            re.printStackTrace();
            request.setAttribute("Error", "Se ha producido un problema al intentar acceder al respositorio de datos");
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }

    }

    private void modificarDatosEmpleados(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String campoBusqueda = request.getParameter("campoBusqueda");
        String valorBusqueda = request.getParameter("valorBusqueda");

        try {
            if (campoBusqueda == null || campoBusqueda.isEmpty() || valorBusqueda == null || valorBusqueda.isEmpty()) {
                RequestDispatcher rd = request.getRequestDispatcher("mostrarSalario.jsp");
                rd.forward(request, response);
            }else{
                Double salario = EmpleadoService.findByField(campoBusqueda, valorBusqueda);
                        if(salario != null) {
                            request.setAttribute("salario", salario);
                            RequestDispatcher rd = request.getRequestDispatcher("mostrarSalario.jsp");
                            rd.forward(request, response);
                        }else{
                            request.setAttribute("Error", "Se ha producido un problema al intentar acceder al respositorio de datos");
                            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                        }
            }
        }catch (RepositoryException re){
            re.printStackTrace();
            request.setAttribute("Error", "Se ha producido un problema al intentar acceder al respositorio de datos");
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }
    }
}