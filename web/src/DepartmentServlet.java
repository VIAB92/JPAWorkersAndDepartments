import entity.Departments;
import entity.Employees;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Виктор on 1/13/14.
 */
public class DepartmentServlet extends javax.servlet.http.HttpServlet {
    String page = "index.jsp";
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        MyBeanBean beanBean = new MyBeanBean();
        beanBean.buildBean();
        List<Departments> departments = beanBean.getDepartments();
        request.setAttribute("departments", departments);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(page);
        if (requestDispatcher!=null)
        {
            requestDispatcher.forward(request, response);
        }
    }
}
