<%@ page import="entity.Departments" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*"%>
<%@ page import="entity.Employees" %>
<%@ page errorPage="errorPage.jsp"%>
<html>
<head>
    <title>Employees</title>
</head>
<body>
    <%
        Departments department = (Departments) request.getAttribute("department");
        List<Employees> employees = (List<Employees>) request.getAttribute("employees");
    %>
<h1>Here is list of workers of Deparment №<%=department.getDepartmentId()%> - <%=department.getDepartmentName()%></h1>
<table align="center" width="80%">
    <tr>
        <th>Employee ID</th>
        <th>Surname</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone Number</th>
        <th>Hire Date</th>
    </tr>
    <%
        for(Employees emp: employees)
        {
            %>
             <tr>
                <td align="center"><%=emp.getEmployeeId()%></td>
                <td align="center"><%=emp.getFirstName()%></td>
                <td align="center"><%=emp.getLastName()%></td>
                <td align="center"><%=emp.getEmail()%></td>
                <td align="center"><%=emp.getPhoneNumber()%></td>
                <td align="center"><%=emp.getHireDate()%></td>
             </tr>
            <%
        }
    %>
    <tr>
        <td align="center"><a href="Departments">Go to departments list</a></td>
    </tr>
</table>

</body>
</html>
