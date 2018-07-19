package fortesting.dao;

import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import fortesting.dao.model.Employee;
import fortesting.dao.model.Income;

@Repository
public class IncomeDAO {
    @Resource
    private SessionFactory sessionFactory;
    
    public Income getIncome(String id) {
        return sessionFactory.getCurrentSession().get(Income.class, id);
    }
    
    public Set<Income> getIncomes(String id) {
        // TODO it seems unnecessary (wired)
        // FIXME the order is wrong, use ASEC ?? or indicate the Set category ??
        return sessionFactory.getCurrentSession().get(Employee.class, id).getIncomes();
    }
}
