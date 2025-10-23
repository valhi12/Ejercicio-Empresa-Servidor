<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="main-container">
    <div class="container">
        <div class="main-content">
            <h1>Nuestros Empleados</h1>
            <table class="empleados-table">
                <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Sexo</th>
                    <th>Dni</th>
                    <th>Categoria</th>
                    <th>Anyos</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <td><c:out value="${item.nombre}" /></td>
                        <td><c:out value="${item.sexo}" /></td>
                        <td><c:out value="${item.dni}" /></td>
                        <td><c:out value="${item.categoria}" /></td>
                        <td><c:out value="${item.anyos}" /> euros</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
