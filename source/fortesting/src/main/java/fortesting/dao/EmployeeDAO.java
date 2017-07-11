package fortesting.dao;

import org.springframework.stereotype.Repository;

import fortesting.dao.model.Employee;
import fortesting.hibernate.transaction.HibernateUtil;

@Repository
public class EmployeeDAO {
    public Employee getEmployee(String id) {
        return HibernateUtil.getSessionFactory().getCurrentSession().get(Employee.class, id);
    }
}
