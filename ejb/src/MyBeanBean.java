import entity.Departments;
import entity.Employees;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Locale;

/**
 * Created by Виктор on 1/13/14.
 */
@Stateless(name = "MyBeanEJB")
public class MyBeanBean {
    EntityManagerFactory efm;
    EntityManager em;

    public MyBeanBean() {
    }

    public void buildBean()
    {
        Locale.setDefault(Locale.ENGLISH);
        this.efm = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        this.em = efm.createEntityManager();
    }

    public List<Departments> getDepartments()
    {
        TypedQuery<Departments> query = em.createQuery("SELECT d FROM Departments d", Departments.class);
        List<Departments> departments = query.getResultList();
        return departments;
    }

    public List<Employees> getEmployeesByDepartmentId(int id)
    {
        Departments department = em.find(Departments.class, id);
        List<Employees> employees = (List<Employees>) department.getEmployeesesByDepartmentId();
        return employees;
    }

    public Departments getDepartment(int id)
    {
        Departments department = em.find(Departments.class, id);
        return department;
    }

}
