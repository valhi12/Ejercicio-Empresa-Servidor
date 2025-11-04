<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Mostrar salarios al filtrar por cualquier campo</h1>

<form action="EmpleadoController?opcion=modificarDatosEmpleados" method="POST">
    <div>
        <label for="campoBusqueda">Buscar por: </label>
        <select id="campoBusqueda" name="campoBusqueda" required>
            <option value="">Selecciona un campo</option>
            <option value="dni">DNI</option>>
            <option value="nombre">Nombre</option>>
            <option value="sexo">Sexo</option>>
            <option value="categoria">Categoria</option>>
            <option value="anyos">Años</option>>
        </select>
    </div>

    <div>
        <label for="valorBusqueda">Valor a buscar:</label>
        <input type="text" id="valorBusqueda" name="valorBusqueda"
               value="<c:out value="${valorBuscado}"/>" required>
    </div>

    <c:if test="${salario != null}">
        <div>
            El sueldo de este empleado es <c:out value="${salario}"/> euros
        </div>
    </c:if>

    <button type="submit">Buscar</button><br>

    <%@ include file="footer.jsp"%>
</form>
<br>