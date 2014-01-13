<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*"%>
<%@ page import="entity.Departments" %>
<%@ page errorPage="errorPage.jsp"%>
<html>
  <head>
    <title>Departments</title>
  </head>
  <body>
  <table align='center' width="80%" border="1">
      <tr>
          <th colspan="3">Here you can see list of our departments</th>
      </tr>
      <tr>
          <th>Department ID</th>
          <th>Department Name</th>
          <th>Eployees</th>
      </tr>
      <%
          List<Departments> departments = (List<Departments>)request.getAttribute("departments");
          for(Departments dep : departments)
          {
      %>
      <tr>
          <td align="center"><%=dep.getDepartmentId()%></td>
          <td align="center"><%=dep.getDepartmentName()%></td>
          <form action="Employees" method="get">
              <input type="hidden" value="<%=dep.getDepartmentId()%>" name="id" id="id"/>
              <td align="center"><input type="submit" value="View employees"/></td>
          </form>
      </tr>
      <%
          }
      %>

  </table>

  </body>
</html>
