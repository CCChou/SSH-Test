package fortesting.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fortesting.dao.model.Employee;

@Repository
public class EmployeeDAO {
    @Resource
    private SessionFactory sessionFactory;
    
    public Employee getEmployee(String id) {
        return sessionFactory.getCurrentSession().get(Employee.class, id);
    }
}
