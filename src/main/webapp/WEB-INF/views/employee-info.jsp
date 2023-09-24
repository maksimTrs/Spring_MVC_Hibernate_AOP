<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>New Employee Form</title>
</head>
<body>
    <h1>New Employee Form:</h1>

    <form:form action="saveEmployee" modelAttribute="newEmployee">

        <form:hidden path="id"/>

        Name <form:input path="name"/>
        <form:errors path="name"/>
        <br><br>
        Surname <form:input path="surname"/>
        <br><br>
        Department <form:input path="department"/>
        <form:errors path="department"/>
        <br><br>
        Salary <form:input path="salary"/>
        <form:errors path="salary"/>
        <br><br>

        <br><br>
        <input type="submit" value="Save Employee">
    </form:form>
</body>
</html>