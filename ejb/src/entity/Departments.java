package entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Виктор on 1/13/14.
 */
@Entity
public class Departments {
    private int departmentId;
    private String departmentName;
    private Integer managerId;
    private Collection<Employees> employeesesByDepartmentId;

    @Id
    @Column(name = "DEPARTMENT_ID", nullable = false, insertable = true, updatable = true, length = 4, precision = 0)
    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Basic
    @Column(name = "DEPARTMENT_NAME", nullable = false, insertable = true, updatable = true, length = 30, precision = 0)
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Basic
    @Column(name = "MANAGER_ID", nullable = true, insertable = true, updatable = true, length = 6, precision = 0)
    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Departments that = (Departments) o;

        if (departmentId != that.departmentId) return false;
        if (departmentName != null ? !departmentName.equals(that.departmentName) : that.departmentName != null)
            return false;
        if (managerId != null ? !managerId.equals(that.managerId) : that.managerId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = departmentId;
        result = 31 * result + (departmentName != null ? departmentName.hashCode() : 0);
        result = 31 * result + (managerId != null ? managerId.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "departmentsByDepartmentId")
    public Collection<Employees> getEmployeesesByDepartmentId() {
        return employeesesByDepartmentId;
    }

    public void setEmployeesesByDepartmentId(Collection<Employees> employeesesByDepartmentId) {
        this.employeesesByDepartmentId = employeesesByDepartmentId;
    }
}
