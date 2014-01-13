import entity.Departments;
import entity.Employees;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Виктор on 1/13/14.
 */
public class EmployeeServlet extends HttpServlet {
    private String page = "employees.jsp";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MyBeanBean myBeanBean = new MyBeanBean();
        myBeanBean.buildBean();
        List<Employees> employees = myBeanBean.getEmployeesByDepartmentId(id);
        Departments department = myBeanBean.getDepartment(id);
        request.setAttribute("department", department);
        request.setAttribute("employees", employees);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        if (requestDispatcher!=null)
        {
            requestDispatcher.forward(request, response);
        }
    }
}
