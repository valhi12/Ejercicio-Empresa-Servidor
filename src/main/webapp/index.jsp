<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<h2>Menu de opciones</h2>
<p>Los empleados de nuestra base de datos son: </p>
<p>
    <a href="EmpleadoController?opcion=findAllEmpleados">
        Mostrar listado de empleados
    </a><br>

    <a href="EmpleadoController?opcion=mostrarSalarioEmpleados">
        Mostrar salarios de empleados por DNI
    </a><br>

    <a href="EmpleadoController?opcion=modificarDatosEmpleados">
        Mostrar salarios de empleados por cualquier campo
    </a><br>
</p>

</body>
</html>
