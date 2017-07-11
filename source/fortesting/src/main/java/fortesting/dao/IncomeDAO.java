package fortesting.dao;

import java.util.Set;

import org.springframework.stereotype.Repository;

import fortesting.dao.model.Employee;
import fortesting.dao.model.Income;
import fortesting.hibernate.transaction.HibernateUtil;

@Repository
public class IncomeDAO {
    public Income getIncome(String id) {
        return HibernateUtil.getSessionFactory().getCurrentSession().get(Income.class, id);
    }
    
    public Set<Income> getIncomes(String id) {
        // TODO it seems unnecessary (wired)
        // FIXME the order is wrong, use ASEC ?? or indicate the Set category ??
        return HibernateUtil.getSessionFactory().getCurrentSession().get(Employee.class, id).getIncomes();
    }
}
