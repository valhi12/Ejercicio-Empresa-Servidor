<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>Mostrar salarios al filtrar por DNI</h1>

<form action="EmpleadoController?opcion=mostrarSalarioEmpleados" method="POST">
    <div>
        <label for="dni">Introduce tu DNI: </label>
        <input type="text" id="dni" name="dni" required>
    </div>

    <button type="submit">Buscar</button>
</form>
<br>

<c:if test="${salario != null}">
    <div>
        El sueldo de este empleado es <c:out value="${salario}"/> euros
    </div>
</c:if>

<%@ include file="footer.jsp"%>

