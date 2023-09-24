<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employees Details</title>
</head>
<body>
    <h1>Employees Details:</h1>
    <br><br>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Department</th>
            <th>Salary</th>
            <th>Operations</th>
        </tr>
        <c:forEach items="${allEmployees}" var="employee">

            <c:url var="updateButton" value="updateEmployee">
                <c:param name="empId" value="${employee.id}"/>
            </c:url>
            <c:url var="deleteButton" value="deleteEmployee">
                <c:param name="empId" value="${employee.id}"/>
            </c:url>

            <tr>
                <td>${employee.name}</td>
                <td>${employee.surname}</td>
                <td>${employee.department}</td>
                <td>${employee.salary}</td>
                <td>
                     <input type="button" value="Update" onclick="window.location.href='${updateButton}'" />
                     <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'" />
                </td>

            </tr>
        </c:forEach>
    </table>

    <br><br>
    <input type="button" value="Add Employee" onclick="window.location.href='addNewEmployee'" />

    <br><br>
    <br><br>
    <iframe src="https://giphy.com/embed/JiC9wpHt3LhMNSlNAa" width="480" height="204" frameBorder="0"
    class="giphy-embed" allowFullScreen></iframe><p>
    <a href="https://giphy.com/gifs/imaginedragons-spooky-bones-imagine-dragons-JiC9wpHt3LhMNSlNAa">via GIPHY</a></p>

</body>
</html>
